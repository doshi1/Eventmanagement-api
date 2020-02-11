package com.miral.eventmanagementapi.controllers;


import com.miral.eventmanagementapi.entities.Participant;
import com.miral.eventmanagementapi.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class CheckedOutController {

    @Autowired
    private ParticipantRepository participantRepository;
    @PostMapping("checkout/{id}")
    public ResponseEntity<PersistentEntityResource> CheckOut(@PathVariable Long id, PersistentEntityResourceAssembler assembler){
        Participant participant = this.participantRepository.findById(id).orElse(null);
        if(participant != null){
            if(!participant.isCheckedIn()){
                throw new AlreadyCheckedOutException();
            }
            participant.setCheckedIn(false);
            participantRepository.save(participant);
        }
        return ResponseEntity.ok(assembler.toFullResource(participant));
    }



}
//   <!-- public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
//
//        Participant participant = this.participantRepository.findById(id).orElse(null);
//        if (participant != null) {
//            if (participant.isCheckedIn()) {
//                throw new AlreadyCheckedInException();
//            }
//            participant.setCheckedIn(true);
//            participantRepository.save(participant);
//        }
//        return ResponseEntity.ok(assembler.toFullResource(participant));
//    } -->