package moe.vergo.SeiyuuHub.dl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class MalSeiyuuRepository implements SeiyuuRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(MalSeiyuuRepository.class);

    private final RestTemplate restTemplate;

    public MalSeiyuuRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Seiyuu getSeiyuuDetails(int id) {
        LOGGER.info("Fetching information for seiyuu id {}", id);
        return restTemplate.getForObject("/" + id, Seiyuu.class);
    }
}
