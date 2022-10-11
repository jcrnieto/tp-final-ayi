package com.ayi.tp.rest.serv.app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_invoice")
     private Long idDescription;

     @Column(name="description_invoice")
     private String descriptionInvoice;

     @Column(name="total")
     private Double total;

     @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn(name = "client_fk", referencedColumnName = "id_client")
     private Client client;
}
