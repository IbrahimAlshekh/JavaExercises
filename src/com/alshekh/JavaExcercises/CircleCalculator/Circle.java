package com.alshekh.JavaExcercises.CircleCalculator;

public class Circle
{
  private int x;
  private int y;
  public int radius;

  public void setCircleValues(int x, int y, int radius){
    this.x = x;
    this.y = y;
    this.radius = radius;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public int getRadius(){
    return radius;
  }
  public boolean isInCircle(int a, int b){
    int d = (int)Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2));
    return d <= radius;
  }
}
