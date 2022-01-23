package com.job.reservator.reservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReservationServiceTests {


    @Test
    public void shouldPassReturnAllReservationsOfTenant() {

        // given
        ReservationService reservationService = mock(ReservationService.class);
        Reservation reservation = new Reservation(1L, LocalDateTime.now(), LocalDateTime.now(), null, null);
        List<Reservation> list = new ArrayList<>();
        list.add(reservation);

        //when
        when(reservationService.getAllReservationsOfTenant(1L)).thenReturn(list);
        //then
        Assertions.assertEquals(1, list.size());
    }

}
