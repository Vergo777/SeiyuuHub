package moe.vergo.SeiyuuHub.controller;

import moe.vergo.SeiyuuHub.dl.Seiyuu;
import moe.vergo.SeiyuuHub.dl.SeiyuuRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeiyuuHubController {
    private final SeiyuuRepository seiyuuRepository;

    public SeiyuuHubController(SeiyuuRepository seiyuuRepository) {
        this.seiyuuRepository = seiyuuRepository;
    }

    @RequestMapping("/seiyuu/{id}")
    public Seiyuu getSeiyuuDetails(@PathVariable int id) {
        return seiyuuRepository.getSeiyuuDetails(id);
    }
}
