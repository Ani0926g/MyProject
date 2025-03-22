package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientsItem {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long  Id;



private String name;

 @ManyToOne
    @JoinColumn(name = "category_id") // 
    private IngredientsCategory category;  


@JsonIgnore
@ManyToOne
private Restaurant restaurant;

private boolean inStoke=true;


}


