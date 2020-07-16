package edu.buet.cse.ch03.model;

import java.util.Objects;

public class Apple {
  private final Integer weight;
  private final String color;

  public Apple(Integer weight, String color) {
    this.weight = Objects.requireNonNull(weight);
    this.color = Objects.requireNonNull(color);
  }

  public Integer getWeight() {
    return weight;
  }

  public String getColor() {
    return color;
  }

  @Override
  public String toString() {
    return String.format("[weight: %d, color: %s]", weight, color);
  }
}
