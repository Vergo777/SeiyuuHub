package moe.vergo.SeiyuuHub.dl.season;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SeasonConfig {

    @Bean
    public SeasonService seasonService(SeasonRepository seasonRepository, JdbcSeasonRepository jdbcSeasonRepository) {
        return new MalSeasonService(seasonRepository, jdbcSeasonRepository);
    }

    @Bean
    public SeasonRepository seasonRepository(@Qualifier("seasonRestTemplate") RestTemplate restTemplate) {
        return new MalSeasonRepository(restTemplate);
    }

    @Bean("seasonRestTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.rootUri("https://api.jikan.moe/v3/season").build();
    }

    @Bean
    public JdbcSeasonRepository jdbcSeasonRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSeasonRepository(jdbcTemplate);
    }
}
