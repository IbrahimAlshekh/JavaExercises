package CSVParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVParser
{
  public static final String CSV_SEPARATOR = ";";

  public static String CURRENT_PATH = System.getProperty("java.class.path") + File.separator + "CSVParser" + File.separator;


  public static void main(String[] args)
  {

    odev2();
    odev1();
  }

  public static boolean isNumeric(String strNum) {

    if (strNum == null) return false;

    try {

      double d = Double.parseDouble(strNum);

    } catch (NumberFormatException nfe) {

      return false;

    }

    return true;

  }

  /**
   *
   */
  public static void odev2()
  {

    ArrayList<String[]> csv = readFile(CURRENT_PATH + "input.csv");

    if(csv == null) {

      System.out.println("The File is empty");

      return;

    }

    String[] csvHeader = null;

    ArrayList<ArrayList<String[]>> groupList = new ArrayList<>();

    ArrayList<String[]>  nonNumericCells =  new ArrayList<>();

    for (int num = 0; num < 500; num += 100){

      ArrayList<String[]>  group =  new ArrayList<>();

      for (String[] row : csv){

        if (row[0].trim().equals("Date")){

          csvHeader = row;

          continue;

        }

        if (isNumeric(row[14]) && Double.parseDouble(row[14]) > num && Double.parseDouble(row[14]) < (num + 100)){

          group.add(row);

        } else if (num == 0 && !isNumeric(row[14])){

          nonNumericCells.add(row);

        }

      }

      groupList.add(sortList(group));

    }

    groupList.add(sortList(nonNumericCells));

    ArrayList<String[]> results = new ArrayList<>();

    results.add(csvHeader);

    for (ArrayList<String[]> sortedGroup: groupList){

      results.addAll(sortedGroup);

    }

    writeFile(results,CURRENT_PATH + "odev2_output.csv",false);

  }


  public static ArrayList<String[]>  sortList(ArrayList<String[]> csvList)
  {
    ArrayList<String[]> result = new ArrayList<>();

    String[] serviceIds = new String[csvList.size()];

    for (int i = 0; i < csvList.size(); i++){

      if(csvList.get(i)[0].trim().equals("Date"))  continue;

      serviceIds[i] = csvList.get(i)[1];

    }

    Arrays.sort(serviceIds);

    for (String serviceId: serviceIds){

      for (String[] row: csvList){

        if(row[1].equals(serviceId)){

          result.add(row);

          break;

        }

      }

    }

    return result;
  }

  /**
   * Function Algorithm
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
   *
   */
  public static void odev1()
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
   * A function that reads a file csv file separated by ";" line by line
   * and stores the lines in an ArrayList as String array
   *
   * @param filePath String (the absolute path to the .csv files)
   *
   * @return ArrayList
   */
  public static ArrayList<String[]> readFile(String filePath)
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
  public static void writeFile(ArrayList<String[]> data, String outputPath, boolean append )
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
