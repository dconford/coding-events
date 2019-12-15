package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    //lives @ events/index
    @GetMapping
    public String displayAllEvents (Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("StrangeLoop");
//        events.add("Apple WWDC");
//        events.add("SpringOne Platform");
//        events.add("Geek Gala 2020");
//        events.add("MoonShot Awards 2020");
        model.addAttribute("events", events);
        return "events/index";
    }

    //lives@ events/create
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName) {

        if (!events.contains(eventName) || (eventName.equals(" "))) {
            events.add(eventName);
        }

        return "redirect:";
    }
}
