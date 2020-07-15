package edu.buet.cse.ch03.model;

import java.util.Objects;

public class Apple {
  private final int weight;
  private final String color;

  public Apple(int weight, String color) {
    this.weight = weight;
    this.color = Objects.requireNonNull(color);
  }

  public int getWeight() {
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
