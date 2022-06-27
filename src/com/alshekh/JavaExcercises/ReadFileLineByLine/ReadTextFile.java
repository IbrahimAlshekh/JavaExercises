package com.alshekh.JavaExcercises.ReadFileLineByLine;

import java.io.File;
import java.util.Scanner;

public class ReadTextFile
{
  public static void main(String[] args)
  {
    try
    {
      File file = new File("sinav.txt");
      Scanner fileScanner = new Scanner(file);
      while (fileScanner.hasNextLine())
      {
        String line = fileScanner.nextLine();
        System.out.print(line + " = ");
        String[] splitedLine = line.split(" ");
        int sum = 0;
        for (String s : splitedLine)
        {
          if (s.length() > 0) sum += Integer.parseInt(s);
        }
        System.out.println(sum);

      }
      fileScanner.close();
    } catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("The file dose not exists");
    }
  }

}
