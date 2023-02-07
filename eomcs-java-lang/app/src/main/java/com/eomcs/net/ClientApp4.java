package com.eomcs.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp4 {
  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("클라이언트 실행");

    Socket socket =  new Socket("localhost", 8888);
    System.out.println("서버와 연결");

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    while (true) {
      System.out.printf("계산 하시겠습니까? (y/n) ->");
      char check = keyScan.next().charAt(0);
      if (check == 'y') {
        System.out.print("값>");
        int message = keyScan.nextInt();
        out.println(message);
        System.out.print("연산자>");
        char message2 = keyScan.next().charAt(0);
        out.println(message2);
        System.out.print("값>");
        int message3 = keyScan.nextInt();
        out.println(message3);
        int response = in.nextInt();
        System.out.printf("답 :%d\n", response);
      }else if(check == 'n') {
        System.out.println("계산을 종료합니다");
        break;
      }
    }
    out.close();
    in.close();
    socket.close();

    System.out.println("클라이언트 종료");
    keyScan.close();
  }
}
