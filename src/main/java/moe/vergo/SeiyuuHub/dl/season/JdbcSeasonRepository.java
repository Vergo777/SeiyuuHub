package moe.vergo.SeiyuuHub.dl.season;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class JdbcSeasonRepository {
    private static final String INSERT_SEASON_RUN = "INSERT INTO SEASON (YEAR, NAME, STATUS) VALUES (?, ?, ?)";
    private static final String INSERT_SEASON_ANIME = "INSERT INTO ANIME (SEASON_ID, ID, TITLE, URL) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_RUN_STATUS = "UPDATE SEASON SET STATUS = ? WHERE ID = ?";

    private final JdbcTemplate jdbcTemplate;

    public JdbcSeasonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertNewSeasonRun(int year, MalSeason season) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SEASON_RUN, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, year);
            ps.setString(2, season.name());
            ps.setString(3, RunStatus.PROCESSING.name());
            return ps;
        }, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    public void updateRunStatusToSuccess(int id) {
        updateRunStatus(id, RunStatus.SUCCESS);
    }

    public void updateRunStatusToFailed(int id) {
        updateRunStatus(id, RunStatus.FAILED);
    }

    public void updateRunStatus(int id, RunStatus runStatus) {
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_RUN_STATUS);
            ps.setString(1, runStatus.name());
            ps.setInt(2, id);
            return ps;
        });
    }

    public void insertAnimeForSeason(int id, List<Anime> anime) {
        jdbcTemplate.batchUpdate(INSERT_SEASON_ANIME, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, id);
                ps.setInt(2, anime.get(i).getMalId());
                ps.setString(3, anime.get(i).getTitle());
                ps.setString(4, anime.get(i).getUrl());
            }

            @Override
            public int getBatchSize() {
                return anime.size();
            }
        });
    }
}
