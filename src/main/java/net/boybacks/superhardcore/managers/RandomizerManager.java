package net.boybacks.superhardcore.managers;

import java.util.ArrayList;

public class RandomizerManager {

  public static boolean randomizer(int percent) {
    int maxNumber = 1000; // 100.0%
    ArrayList<Integer> numberList = new ArrayList<>();
    for (int i = 0; i < percent; i++) {
      int number = (int)(Math.random() * maxNumber + 1);
      if (numberList.contains(number)) {
        i--;
      }
      else {
        numberList.add(number);
      }
    }
    int number = (int)(Math.random() * maxNumber + 1);
    if (numberList.contains(number)) {
      return true;
    }
    else {
      return false;
    }
  }
}
