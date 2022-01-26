package com.job.reservator.reservation;

import com.job.reservator.property.PropertyService;
import com.job.reservator.tenant.TenantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTests {


    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private TenantService tenantService;
    @Mock
    private PropertyService propertyService;
    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        reservationService = new ReservationService(reservationRepository, tenantService, propertyService);
    }


    @Test
    public void ShouldReturnAllReservationsOfTenant() {

        // given
        Reservation reservation = new Reservation(1L, LocalDateTime.now(), LocalDateTime.now(), null, null);
        List<Reservation> list = new ArrayList<>();
        list.add(reservation);
        //when
        when(reservationService.getAllReservationsOfTenant(1L)).thenReturn(list);
        //then
        Assertions.assertEquals(1, reservationService.getAllReservationsOfTenant(1L).size());
    }

    @Test
    public void ServiceShouldCallRepositoryForFindAllByPropertyId() {
        //when
        reservationService.getAllReservationForProperty(1L);
        //then
        verify(reservationRepository).findAllByPropertyId(1L);

    }


}
