package com.ayi.tp.rest.serv.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="detail_client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_client_detail")
    private Long idClientDetail;

    @Column(name="vip")
    private Boolean vip;

    @Column(name="points")
    private Integer points;

    @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private Client client;

}
