package com.food.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Addrees {
           
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private Long id;


}
