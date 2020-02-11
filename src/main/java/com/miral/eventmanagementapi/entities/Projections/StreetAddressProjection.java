package com.miral.eventmanagementapi.entities.Projections;

import com.miral.eventmanagementapi.entities.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection( name = "virtualaddress",types = {Venue.class})
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2} ")
    String getVirtualStreetAddress();
}
