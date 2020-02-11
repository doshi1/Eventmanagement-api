package com.miral.eventmanagementapi.controllers;

import com.miral.eventmanagementapi.entities.Event;
import com.miral.eventmanagementapi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {
    private Event event;

    @Autowired
    private EventRepository eventRepository;

//    @PostMapping("/start/{id}")
//    public ResponseEntity<?> startEvent(@PathVariable() Long id) {
//
//        Event event = eventRepository.findById(id).get().isPresent();
//
//        if (event == null) {
//            throw new ResourceNotFoundException("Event with id " + id + " not found.");
//        }
//
//        event.setStarted(true);
//        this.eventRepository.save(event);
//
//        return ResponseEntity.ok("Event " + event.getName() + " has started");

//
//    @PostMapping("/start/{id}")
//    public ResponseEntity start(@PathVariable Long id) throws Exception {
//
//        //We will retrive the event from the eventRepository
//        Event event = eventRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
//        if(!event.isStarted()) {
//            throw new ResourceNotFoundException();
//        }
//        event.setStarted(true);
//        eventRepository.save(event);
//        return ResponseEntity.ok("Event "+event.getName()+" started");
//    }
//
//}


//    @PostMapping("/start/{id}")
//    public ResponseEntity start(@PathVariable long id) {
//        Optional<Event> event = Optional.of(eventRepository.findById(id).get());
//    }

    //    public ResponseEntity<?> start(@PathVariable Long id) {
//        Optional<Event> eventop = eventRepository.findById(id);
////        Optional<Event> event = Optional.of(eventRepository.findById(id).get());
//        if (eventop.isPresent()) {
//            event = eventop.get();
//        }else if(event == null){
//            throw new ResourceNotFoundException();
//        }else {
//
//            throw new ResourceNotFoundException();
//
//        }
//        event.setStarted(true);
//        eventRepository.save(event);
//
//        return ResponseEntity.ok(event.getName() + " has started");
//    }
    @PostMapping("/start/{id}")
    public ResponseEntity start(@PathVariable("id") Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) {
            throw new ResourceNotFoundException();
        }
        event.setStarted(true);
        eventRepository.save(event);

        return ResponseEntity.ok(event.getName() + " has started");
    }
}
