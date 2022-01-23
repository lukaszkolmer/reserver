package com.job.reservator.reservation;

import com.job.reservator.property.Property;
import com.job.reservator.tenant.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByProperty(Property property);

    List<Reservation> findAllByTenant(Tenant tenant);


}
