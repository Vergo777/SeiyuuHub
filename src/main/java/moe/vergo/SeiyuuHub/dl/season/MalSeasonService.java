package moe.vergo.SeiyuuHub.dl.season;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MalSeasonService implements SeasonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MalSeasonService.class);

    private final SeasonRepository seasonRepository;
    private final JdbcSeasonRepository jdbcSeasonRepository;

    public MalSeasonService(SeasonRepository seasonRepository, JdbcSeasonRepository jdbcSeasonRepository) {
        this.seasonRepository = seasonRepository;
        this.jdbcSeasonRepository = jdbcSeasonRepository;
    }

    public boolean fetchSeasonInfo(int year, String season) {
        MalSeason malSeason = MalSeason.valueOf(season);
        LOGGER.info("Starting season run for year {} and season {}", year, season);
        int runId = startRun(year, malSeason);
        try {
            Season seasonDetails = seasonRepository.getSeasonAnime(year, malSeason);
            List<Anime> seasonAnime = seasonDetails.getAnime();

            jdbcSeasonRepository.insertAnimeForSeason(runId, seasonAnime);

            completeRun(runId);

            return true;
        } catch (Exception e) {
            LOGGER.error("Season run {} failed due to error {}", runId, e);
            failRun(runId);

            return false;
        }
    }

    public int startRun(int year, MalSeason season) {
        return jdbcSeasonRepository.insertNewSeasonRun(year, season);
    }

    private void failRun(int id) {
        jdbcSeasonRepository.updateRunStatusToFailed(id);
    }

    private void completeRun(int id) {
        jdbcSeasonRepository.updateRunStatusToSuccess(id);
    }
}
