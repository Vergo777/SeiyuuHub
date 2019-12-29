package moe.vergo.SeiyuuHub.controller;

import moe.vergo.SeiyuuHub.dl.season.SeasonService;
import moe.vergo.SeiyuuHub.dl.seiyuu.Seiyuu;
import moe.vergo.SeiyuuHub.dl.seiyuu.SeiyuuRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class SeiyuuHubController {
    private final SeiyuuRepository seiyuuRepository;
    private final SeasonService seasonService;

    public SeiyuuHubController(SeiyuuRepository seiyuuRepository, SeasonService seasonService) {
        this.seiyuuRepository = seiyuuRepository;
        this.seasonService = seasonService;
    }

    @RequestMapping("/seiyuu/{id}")
    public Seiyuu getSeiyuuDetails(@PathVariable int id) {
        return seiyuuRepository.getSeiyuuDetails(id);
    }

    @RequestMapping("/season/newRun")
    public boolean newSeasonRun(@RequestParam("year") int year, @RequestParam("season") String season) {
        return seasonService.fetchSeasonInfo(year, season);
    }
}
