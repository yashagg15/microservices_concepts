package com.project.springrestfulmicroservice.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="User_V2")
public class User_V2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name = "age")
    private long age;

    @Column(name="details")
    private String details;

}
