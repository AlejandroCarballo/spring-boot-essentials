package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

  private final UUID id;
  @NotBlank
  private final String name;


  public Person(UUID id, String name) {
    this.id = id;
    this.name = name;
  }


  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
