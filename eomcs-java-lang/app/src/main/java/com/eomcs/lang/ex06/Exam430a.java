package com.eomcs.lang.ex06;

// # 흐름 제어문 - for 중첩과 break
//
public class Exam430a {
  public static void main(String[] args) {
    int num = 10;

    // for 문의 중첩
    for (int i=num; i>0; i--) {
      for (int j=num-i; j>0; j--) {
        System.out.print(" ");
      }
      for (int j=i*2-1; j>0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}

