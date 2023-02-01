package com.eomcs.net;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalcClient {
  public static void main(String[] args) throws Exception {
    try (
        Scanner keyScan = new Scanner(System.in);

        System.out.println("클라이언트 실행중...");

        Socket socket = new Socket("127.0.0.1", 8888);
        System.out.println("서버에 연결되었음!");

        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())); {
          receiveResponse(in); // 서버의 인사말을 받기

          while (true) {
            String input = prompt(keyboardScanner);
            if (input == null) {
              continue;

              sendRequest(out, input); // 서버에 요청을 보내기
              receiveResponse(in); // 서버의 실행 결과를 받기
            } catch (Exception e) {
              e.printStackTrace();
            }
          }


          static String prompt(Scanner keyboardScanner) {
            System.out.print("계산식> ");
            String input = keyboardScanner.nextLine();

            if (input.split(" ").length != 3) { // 사용자가 입력한 값을 검증
              System.out.println("입력 형식이 올바르지 않습니다. 예) 23 + 5");
              return null;
            }
            return input;
          }

          static void sendRequest(PrintStream out, String message) throws Exception {
            out.println(message);
            out.flush();
          }

          static void receiveResponse(BufferedReader in) throws Exception {
            while (true) {
              String input = in.readLine();
              if (input.length() == 0) {
                // 빈 줄을 읽었다면 읽기를 끝낸다.
                break;
              }
              System.out.println(input);
            }
          }
        }
