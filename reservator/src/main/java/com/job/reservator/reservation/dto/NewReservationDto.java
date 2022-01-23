package com.job.reservator.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewReservationDto {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reservedFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reservedTo;

    private Long tenantId;
    private Long propertyId;
}
