package com.alshekh.JavaExcercises.CircleCalculator;

public class ChildCircle extends Circle
{
  public double circleArea()
  {
    return (Math.PI * Math.pow(this.radius, 2));
  }
}
