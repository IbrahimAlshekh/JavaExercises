package com.alshekh.JavaExcercises.AnalogHourAngle;

import java.time.LocalTime;

public class Clock {
  private int hour;
  private int minute;
  private int angle;
  public Clock() {
    this.aciyiBul();
  }
  private void aciyiBul() {
    LocalTime date = LocalTime.now();
    this.hour = date.getHour();
    if(this.hour > 12) {
      this.hour = this.hour - 12;
    }
    this.minute = date.getMinute();
    this.angle = Math.abs((this.minute * 6) - (this.hour * 30));
  }
  public void aciyiYazdir(){
    System.out.println("Saat: " + this.hour + ":" + this.minute);
    System.out.println(this.angle);
  }
}