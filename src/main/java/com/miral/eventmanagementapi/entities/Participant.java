package com.miral.eventmanagementapi.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Participant extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)

    private String email;
    private boolean checkedIn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false)
    private Event event;


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Long getResourceId(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id,((Participant)obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
