package com.ayi.tp.rest.serv.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="directions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Directions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direction")
    private Long IdDirection;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "flat")
    private String flat;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "location")
    private String location;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_fk", referencedColumnName = "id_client")
    private Client client;



}