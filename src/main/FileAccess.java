package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileAccess {
  /* FILE SETUP */
  
  // Constructor:
  public FileAccess() {}

  /* CSV METHODS */

  // Open CSV File:
  public static ArrayList<String[]> openCSV(String file) throws IOException {
    ArrayList<String[]> list = new ArrayList<String[]>();
    String line;
    BufferedReader br = new BufferedReader(new FileReader(file));

    while (br.readLine() != null) {
      line = br.readLine();
      String tokens[] = line.split(",");
      list.add(tokens);
    }
    
    br.close();
    return list;
  }

  // Write CSV File:
  public static void writeCSV(String file, int[][] position) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    for (int i = 0; i < position.length; i++) {
      String row[] = toStringArray(position[i]);
      String rowString = "";

      for (int j = 0; j < row.length; j++) {
        rowString += row[j];
        if (j != row.length-1) {
          rowString += ",";
        }
      }

      bw.write(rowString);
      bw.newLine();
    }
    bw.close();
  }

  /* CONVERSION METHODS */

  // String List to Position:
  public int[][] toPosition(ArrayList<String[]> list) {
    int position[][] = new int[list.size()][list.get(0).length];
    for (int i = 0; i < list.size(); i++) {
      String row[] = list.get(i);
      for (int j = 0; j < list.get(0).length; j++) {
        position[i][j] = Integer.parseInt(row[j]);
      }
    }
    return position;
  }

  // Int Array to String Array:
  private static String[] toStringArray(int array[]) {
    String result[] = new String[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = String.valueOf(array[i]);
    }
    return result;
  }
}
