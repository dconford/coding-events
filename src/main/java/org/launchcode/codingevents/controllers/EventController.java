package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    //lives @ events/index
    @GetMapping
    public String displayAllEvents (Model model) {
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //lives@ events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute(new Event());
        model.addAttribute("eventTypes", EventType.values());
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent) {
            EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @GetMapping("delete/{eventId}")
    public String deleteEvent(Model model, @PathVariable int eventId) {
        EventData.remove(eventId);
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit")
    public String renderEditEventForm(Model model) {
        model.addAttribute("title", "Edit Events");
        model.addAttribute("events", EventData.getAll());
    return "events/edit_step_2";
    }

    @GetMapping("/edit/{eventId}")
    public String renderEditEventForm(Model model, @PathVariable int eventId) {
            EventData.getById(eventId);
            model.addAttribute("title", "Edit Event");
            model.addAttribute("events", EventData.getById(eventId));
        return "events/edit";
    }
//    public String processEditForm(int eventId, String name, String description) {
//        // controller code will go here
//    }
    @PostMapping("edit")
    public String editEvent(Integer eventId, String name, String description) {
            EventData.getById(eventId).setName(name);
            EventData.getById(eventId).setDescription(description);

        return "redirect:";
    }

    @PostMapping("edit_step_2")
    public String renderEditStep2(@RequestParam int[] eventId) {
        return "events/edit/{eventId}";
    }
}
