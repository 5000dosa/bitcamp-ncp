package com.eomcs.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcServer {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("서버 실행중....");

    ServerSocket serverSocket = new ServerSocket (8888);
    Socket socket = serverSocket.accept();

    System.out.println("클라이언트와 연결됨!");

    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out = new PrintStream(socket.getOutputStream());

    sendIntroMessage(out);

    while (true) {
      String request = in.readLine();
      String message = compute(request);
      sendResponse(out, message); // 클라리언트에게 응답한다.



    } catch (Exception e) {
      e.printStackTrace();
    }


    static String compute(String request) {
      String[] values = request.split(" ");

      int a = Integer.parseInt(values[0]);
      String op = values[1];
      int b = Integer.parseInt(values[2]);
      int result = 0;

      switch (op) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        default:
          return String.format("%s 연산자를 지원하지 않습니다.", op);
      }
      return String.format("결과는 %d %s %d = %d 입니다.", a, op, b, result);
    }

    static void sendResponse(PrintStream out, String message) {
      out.println(message);
      out.println();
      out.flush();
    }


    static void sendIntroMessage(PrintStream out) throws Exception {
      out.println("예) 23 + 7");
      out.println(); // 응답의 끝을 표시하는 빈 줄을 보낸다.
      out.flush();
    }
  }
