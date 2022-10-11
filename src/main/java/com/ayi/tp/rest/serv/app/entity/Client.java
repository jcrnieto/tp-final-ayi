package com.ayi.tp.rest.serv.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id_client")
   private Long idClient;

   @Column(name="name", nullable = false, length = 50)
   private String name;

   @Column(name="last_name", nullable = false, length = 50)
   private String lastName;

   @Column(name="dni", nullable = false, length = 50)
   private String dni;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "details_fk", referencedColumnName = "id_client_detail")
   private DetailClient detailClient;

   /*@JoinTable(name= "client_directions", joinColumns = @JoinColumn(name ="id_client"),
   inverseJoinColumns = @JoinColumn(name = "id_direction"),
   uniqueConstraints = @UniqueConstraint(columnNames = {"id_direction"}))*/
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
   private List<Directions> directions;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
   private List<Invoice> invoice;
}
