package com.job.reservator.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.job.reservator.property.Property;
import com.job.reservator.tenant.Tenant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reservedFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime reservedTo;


    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    @ManyToOne
    private Tenant tenant;


    @JoinColumn(name = "property_id", referencedColumnName = "id")
    @ManyToOne
    private Property property;
}
