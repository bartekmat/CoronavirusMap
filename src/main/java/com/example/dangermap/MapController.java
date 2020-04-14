package com.example.dangermap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {

//    @RequestMapping(method = RequestMethod.GET)
//    public String getMap(Model model, @RequestParam String x, @RequestParam String y){
//        model.addAttribute("x",x);
//        model.addAttribute("y",y);
//        return "map";
//    }

    private DataRepo dataRepo;

    public MapController(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @GetMapping
    public String getMap(Model model){
        model.addAttribute("pointList", dataRepo.getPointList());
        return "map";
    }
}
