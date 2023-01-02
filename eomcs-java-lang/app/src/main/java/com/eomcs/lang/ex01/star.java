package com.eomcs.lang.ex01;

import java.util.Scanner;

class star {
  public static void main(String[] args) {
    Scanner KeyScan = new Scanner(System.in);
    System.out.println("밑변의 길이?");
    int len = KeyScan.nextInt();
    KeyScan.close();

    int starLen = 1;
    while (starLen <= len) {
      int spaceCnt = 1;
      int spaceLen = (len - starLen) / 2;
      while (spaceCnt <= spaceLen) {
        System.out.print(" ");
        spaceCnt++;
      }

      int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
      }

      System.out.println();
      starLen += 2;
    }

  }
}