package com.miral.eventmanagementapi.repositories;

import com.miral.eventmanagementapi.entities.Organizer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {
}
