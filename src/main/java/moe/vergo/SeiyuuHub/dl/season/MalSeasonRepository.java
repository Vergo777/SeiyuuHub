package moe.vergo.SeiyuuHub.dl.season;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class MalSeasonRepository implements SeasonRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(MalSeasonRepository.class);

    private final RestTemplate restTemplate;

    public MalSeasonRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Season getSeasonAnime(int year, MalSeason season) {
        LOGGER.info("Fetching seasonal anime information for year {} and season {}", year, season);
        return restTemplate.getForObject("/" + year + "/" + season, Season.class);
    }
}
