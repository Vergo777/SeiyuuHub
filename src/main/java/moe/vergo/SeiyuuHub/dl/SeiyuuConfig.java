package moe.vergo.SeiyuuHub.dl;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SeiyuuConfig {

    @Bean
    public SeiyuuRepository seiyuuRepository(RestTemplate restTemplate) {
        return new MalSeiyuuRepository(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.rootUri("https://api.jikan.moe/v3/person").build();
    }
}
