package com.eomcs.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("클라이언트 실행중...");

    Socket socket = new Socket("192.168.0.19", 8888);
    System.out.println("서버에 연결되었음!");

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    try {

      while (true) {
        System.out.printf("계산을 하시겠습니까? (y/n) ->");
        char check = keyScan.next().charAt(0);
        if (check == 'y') {

          System.out.print("값> ");
          int message = keyScan.nextInt();
          out.println(message);
          System.out.print("연산자>");
          char message2 = keyScan.next().charAt(0);
          out.println(message2);
          // if (message2 == 'n') {
          // break;
          // }
          System.out.print("값>");
          int message3 = keyScan.nextInt();
          out.println(message3);
          int response = in.nextInt();
          System.out.printf("답: %d\n", response);

        } else if (check == 'n') {
          System.out.println("계산기를 종료합니다.");
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("계산중 오류 발생");
    }
    out.close();
    in.close();
    socket.close();
    keyScan.close();
  }
}