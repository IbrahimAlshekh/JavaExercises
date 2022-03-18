package com.alshekh.JavaExcercises.CSVParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class CSVParser
{
  public static final String CSV_SEPARATOR = ";";

  public static String CURRENT_PATH = System.getProperty("java.class.path") + File.separator + "com/alshekh/JavaExcercises/CSVParser" + File.separator;


  public static void main(String[] args)
  {
    // to avoid static keyword
    new CSVParser().run();
  }


  void run(){
    odev2();
    odev1();
  }

  /**
   * Exercise 1 Algorithm
   *  1. read the csv file
   *  2. check if file empty
   *  3. define new csv columns
   *  4. iterate over the ArrayList
   *    - for each round:
   *    1. skip header file
   *    2. get data and time by splitting the date_time column by " "
   *    3. assign the new value to the matching columns
   *  5. write the output
   *
   */
  public void odev1()
  {
    ArrayList<String[]> csv = readFile(CURRENT_PATH + "input.csv");

    if(csv == null) {
      System.out.println("File empty");
      return;
    }

    ArrayList<String[]> newCSV = new ArrayList<>();

    //new columns header
    String[] newHeadRow = {"Date", "Origin", "Departure Date", "Departure Time", "Destination", "Expected Finish Date", "Expected Finish Time", "Diagram Counter Expense"};

    newCSV.add(newHeadRow);

    for (String[] row: csv)
    {
      if(row[0].trim().equals("Date")) continue;
      String[] newRow = new String[newHeadRow.length];

      //datetime separated
      String[] startDate = row[9].split(" ");
      String[] endDate = row[9].split(" ");

      //assign row values
      newRow[0] = row[0];
      newRow[1] = row[7];
      newRow[2] = startDate[0];
      newRow[3] = startDate[1];
      newRow[4] = row[10];
      newRow[5] = endDate[0];
      newRow[6] = endDate[1];
      newRow[7] = row[14];

      newCSV.add(newRow);
    }

    writeFile(newCSV,CURRENT_PATH + "odev1_output.csv", false);
  }

  /**
   * Exercise 2 Algorithm:
   *  1. read the csv file.
   *  2. check if file empty.
   *  3. loop over the range groups [0-100, 100-200, 200-300, 300-400, 400-500].
   *    1. for each range group:
   *      1. In the first round:
   *        - Add csv HeaderRow to the ResultList.
   *        - Add non-Numeric "Diagram Counter Expense" to a NonNumericList.
   *      2. Add the row to a RangesList if "Diagram Counter Expense" is Numeric and in the range.
   *      2. sort the RangesList.
   *    3. Add the RangesList to the ResultList.
   *  4. sort the NonNumericList.
   *  5. Add the NonNumericList to the ResultList.
   *  6. write the output csv file.
   */
  public void odev2()
  {
    ArrayList<String[]> csv = readFile(CURRENT_PATH + "input.csv");

    ArrayList<String[]> results = new ArrayList<>();

    if(csv == null) {

      System.out.println("The File is empty");

      return;

    }

    ArrayList<String[]>  nonNumericList =  new ArrayList<>();

    for (int num = 0; num < 500; num += 100){

      ArrayList<String[]>  group =  new ArrayList<>();

      boolean isFirstRow = true;

      for (String[] row : csv){

        // first round
        if (num == 0){

          if (isFirstRow){

            results.add(row);

            isFirstRow = false;

          }

          if (!isNumeric(row[14])){

            nonNumericList.add(row);

          }

        }

        if (isNumeric(row[14]) && Double.parseDouble(row[14]) > num && Double.parseDouble(row[14]) < (num + 100)){

          group.add(row);

        }

      }

      // sort the List by column index 1
      group.sort(Comparator.comparing(o -> o[1]));

      results.addAll(group);

    }

    nonNumericList.sort(Comparator.comparing(o -> o[1]));

    results.addAll(nonNumericList);

    writeFile(results,CURRENT_PATH + "odev2_output.csv",false);

  }

  /**
   * A function to check if the given string ist castable to double
   *
   * @param strNum String
   * @return boolean
   */
  public boolean isNumeric(String strNum) {

    if (strNum == null) return false;

    try {

      double d = Double.parseDouble(strNum);

    } catch (NumberFormatException nfe) {

      return false;

    }

    return true;

  }

  /**
   * A function that reads a file csv file separated by ";" line by line
   * and stores the lines in an ArrayList as String array
   *
   * @param filePath String (the absolute path to the .csv files)
   *
   * @return ArrayList
   */
  public ArrayList<String[]> readFile(String filePath)
  {
    File file = new File(filePath);

    if(file.exists()){
      try
      {
        FileReader fileReader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        ArrayList<String[]> lienes = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {

          String[] lineArray = line.split(CSV_SEPARATOR);

          lienes.add(lineArray);
        }

        return lienes;

      } catch (IOException e)
      {
        e.printStackTrace();
      }

    }else {
      System.out.println("File could not be found in : " + filePath);
    }
    return null;
  }

  /**
   * A function to write the list of string Array in a .CSV file
   * the String array will be  written line by line and there element will separate with ";"
   *
   * the function uses the FileWriter class to write to the class
   *
   * @param data ArrayList (The list of String arrays)
   * @param outputPath String (the absolute output file path)
   * @param append boolean (append content to the given file)
   *
   */
  public void writeFile(ArrayList<String[]> data, String outputPath, boolean append )
  {
    try
    {
      FileWriter fileWriter = new FileWriter(outputPath,append);

      for (String[] row: data)
      {
        StringBuilder strLine = new StringBuilder();

        for (int i = 0; i < row.length; i++)
        {
          strLine.append(row[i]);

          //add new line at the end of the line
          strLine.append((i != row.length - 1) ? ";" : "\n");

        }

        fileWriter.write(strLine.toString());

        fileWriter.flush();

      }

      System.out.println("The File has been successfully written in: " + outputPath );

    } catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
