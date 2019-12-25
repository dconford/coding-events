package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
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
    public String renderCreateEventForm(){
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
    public String renderEditEventForm() {
 //           EventData.getById(id);
//            model.addAttribute("title", "Edit Event");
//            model.addAttribute("events", EventData.getById(id));


//        Use an EventData method to find the event object with the given eventId.
//                Put the event object in the model with .addAttribute().
//                Return the appropriate template string.
        //Or keep @RequestMapping(value="/{studentID}", and @PathVariable Integer studentID values same


        return "events/edit";
    }

    @PostMapping("edit")
    public String editEvent(@RequestParam int id) {
            EventData.getById(id);
        return "events/edit_step_2";
    }

    @GetMapping("edit_step_2")
    public String renderEditStep2(Model model) {
        return "1";
    }
}
