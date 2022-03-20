package com.alshekh.JavaExcercises.SimpleExercises;

public class CustomInteger
{
  public static void main(String[] args)
  {

    MyInteger myint1 = new MyInteger("1241224");
    MyInteger myint2 = new MyInteger("35488");

    System.out.println("Num1: " + myint1.getInt());

    System.out.println("Num2: " + myint1.getInt());

    System.out.println("esitMi: " +  myint1.esitMi(myint2));

    System.out.println("esitDegilmi: " +  myint1.esitDegilmi(myint2));

    System.out.println("buyukMu: " +  myint1.buyukMu(myint2));

    System.out.println("kucukMu: " +  myint1.kucukMu(myint2));

    System.out.println("kucukEsitmi: " +  myint1.kucukEsitmi(myint2));

    System.out.println("sifirMi: " +  myint1.sifirMi());
  }
}

class MyInteger
{
  private int[] integer;

  public MyInteger(String string)
  {
    if(!this.areAllDigits(string)) {
      System.out.println("there Chars not allowed");
      return;
    }

    if(string.length() > 40) {
      System.out.println("the limit is 40");
      return;
    }

    this.parseString(string);
  }

  private void parseString(String str)
  {
    this.integer = new int[str.length()];

    for (int i = 0; i < str.length(); i++)
    {
      this.integer[i] = ((int) str.charAt(i)) - 48;
    }
  }

  private boolean areAllDigits(String str)
  {
    for (int i = 0; i < str.length(); i++)
    {
      if((int) str.charAt(i)  < 48 || (int) str.charAt(i) > 57){
        return false;
      }
    }

    return true;
  }

  public int[] getInteger()
  {
    return integer;
  }

  public int getInt()
  {
    int result = 0;
    int position  = 1;
    for (int i = integer.length - 1; i >= 0; i--)
    {
      result += position * integer[i];
      position = position * 10;
    }

    return result;
  }

  public boolean esitMi(MyInteger myInt)
  {
    return myInt.getInt() == this.getInt();
  }

  public boolean esitDegilmi(MyInteger myInt)
  {
    return myInt.getInt() != this.getInt();
  }

  public boolean buyukMu(MyInteger myInt)
  {
    return myInt.getInt() > this.getInt();
  }

  public boolean kucukMu(MyInteger myInt)
  {
    return myInt.getInt() < this.getInt();
  }

  public boolean kucukEsitmi(MyInteger myInt)
  {
    return myInt.getInt() <= this.getInt();
  }

  public boolean sifirMi()
  {
    return  this.getInt() == 0;
  }
}
