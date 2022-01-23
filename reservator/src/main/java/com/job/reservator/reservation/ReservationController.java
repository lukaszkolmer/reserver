package com.job.reservator.reservation;

import com.job.reservator.reservation.dto.NewReservationDto;
import com.job.reservator.reservation.dto.UpdateReservationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/reservations")
    public Reservation addNewReservation(@RequestBody NewReservationDto reservation) {
        return reservationService.addNewReservation(reservation);
    }
    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody UpdateReservationDto updateReservationDto){
        return reservationService.updateReservation(updateReservationDto);
    }

    @GetMapping("/reservations/tenant/{id}")
    public List<Reservation> getAllReservationsOfTenant(@PathVariable Long id) {
        return reservationService.getAllReservationsOfTenant(id);
    }

    @GetMapping("/reservations/property/{id}")
    public List<Reservation> getAllReservationsOfProperty(@PathVariable Long id) {
        return reservationService.getAllReservationForProperty(id);
    }

}
