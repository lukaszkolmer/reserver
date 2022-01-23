package com.job.reservator.reservation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReservationDto {

    private Long oldReservationId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reservedFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reservedTo;
    @Nullable
    private Long newPropertyId;

}
