package com.job.reservator.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job.reservator.landlord.Landlord;
import com.job.reservator.reservation.Reservation;
import com.job.reservator.tenant.Tenant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private double area;
    private BigDecimal cost;

    @ManyToOne
    @JoinColumn(name = "landlord_id", referencedColumnName = "id")
    private Landlord landlord;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private Tenant tenant;

    @JsonIgnore
    @OneToMany(mappedBy = "property")
    private List<Reservation> reservations;

}
