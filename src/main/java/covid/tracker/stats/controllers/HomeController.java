package covid.tracker.stats.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import covid.tracker.stats.services.CoronaVirusDataServices;
import covid.tracker.stats.models.LocationStats;

@Controller
public class HomeController {
    @Autowired
    CoronaVirusDataServices coronaVirusDataServices;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = coronaVirusDataServices.getAllStats();
        int totalReportedCases=allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases=allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalReportedCases);
        model.addAttribute("totalNewCases", totalNewCases);


        return "home";
    }
    
}
