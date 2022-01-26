package com.job.reservator.reservation;

import com.job.reservator.property.Property;
import com.job.reservator.property.PropertyService;
import com.job.reservator.reservation.dto.NewReservationDto;
import com.job.reservator.reservation.dto.UpdateReservationDto;
import com.job.reservator.tenant.Tenant;
import com.job.reservator.tenant.TenantService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TenantService tenantService;
    private final PropertyService propertyService;

    public ReservationService(ReservationRepository reservationRepository, TenantService tenantService, PropertyService propertyService) {
        this.reservationRepository = reservationRepository;
        this.tenantService = tenantService;
        this.propertyService = propertyService;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation addNewReservation(NewReservationDto reservation) {
        if (isDateValid(reservation)) {
            Reservation newReservation = new Reservation();
            newReservation.setReservedFrom(reservation.getReservedFrom());
            newReservation.setReservedTo(reservation.getReservedTo());
            newReservation.setProperty(propertyService.getPropertyOfId(reservation.getPropertyId()));
            newReservation.setTenant(tenantService.getTenantOfId(reservation.getTenantId()));
            reservationRepository.save(newReservation);

            return newReservation;
        } else throw new RuntimeException("Reservation date is incorrect");
    }

    //had busy weekend so sorry for not making failsafes for setting dates incorrectly, in the past etc
    public Reservation updateReservation(UpdateReservationDto updateReservationDto) {
        Reservation oldReservation = reservationRepository.findById(updateReservationDto.getOldReservationId()).orElseThrow();

        oldReservation.setReservedFrom(updateReservationDto.getReservedFrom());
        oldReservation.setReservedTo(updateReservationDto.getReservedTo());
        if (updateReservationDto.getNewPropertyId() != null) {
            oldReservation.setProperty(propertyService.getPropertyOfId(updateReservationDto.getNewPropertyId()));
        }
        return reservationRepository.save(oldReservation);
    }

    public List<Reservation> getAllReservationForProperty(Long id) {
        return reservationRepository.findAllByPropertyId(id);
    }

    public List<Reservation> getAllReservationsOfTenant(Long id) {
        return reservationRepository.findAllByTenantId(id);
    }

    public boolean isDateValid(NewReservationDto newReservationDto) {

        Property property = propertyService.getPropertyOfId(newReservationDto.getPropertyId());
        List<Reservation> reservations = property.getReservations();

        LocalDateTime from = newReservationDto.getReservedFrom();
        LocalDateTime to = newReservationDto.getReservedTo();
        boolean dateIsValid = true;
        for (Reservation reservation : reservations) {
            if (!reservation.getReservedFrom().isBefore(from) && !reservation.getReservedTo().isAfter(to)) {
                dateIsValid = false;
            }
        }
        return dateIsValid;
    }
}