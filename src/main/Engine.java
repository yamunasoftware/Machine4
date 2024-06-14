package main;

import java.util.ArrayList;
import lib.ImageProcessing;
import lib.ImageProcessing.CONV_TYPE;

public class Engine {
  /* ENGINE SETUP */

  // Board Position:
  int position[][] = new int[6][7];
  
  // Constructor:
  public Engine() {}

  /* ENGINE METHODS */

  // Convolve Method:
  public int[] convolve() throws Exception {
    int kernel[][] = {
      {-1, 0, 1},
      {-1, 0, 1},
      {-1, 0, 1}
    };

    int output[][] = ImageProcessing.applyFilter(position, kernel, CONV_TYPE.SUM);
    ArrayList<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < output.length; i++) {
      for (int j = 0; j < output[0].length; j++) {
        list.add(output[i][j]);
      }
    }

    int features[] = new int[list.size()];
    for (int i = 0; i < features.length; i++) {
      features[i] = list.get(i);
    }

    return features;
  }
}
