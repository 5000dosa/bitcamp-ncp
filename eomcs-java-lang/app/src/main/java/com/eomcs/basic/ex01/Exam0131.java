// Object 클래스 - equals() 오버라이딩
package com.eomcs.basic.ex01;

import java.util.Objects;

public class Exam0131 {

  public static void main(String[] args) {
    My obj1 = new My();
    obj1.name = Messages.getString("Exam0131.0"); //$NON-NLS-1$
    obj1.age = 20;
    obj1.tel = Messages.getString("Exam0131.1"); //$NON-NLS-1$
    obj1.email = Messages.getString("Exam0131.2"); //$NON-NLS-1$
    obj1.gender = 1;
    obj1.working = false;

    My obj2 = new My();
    obj2.name = Messages.getString("Exam0131.3"); //$NON-NLS-1$
    obj2.age = 20;
    obj2.tel = Messages.getString("Exam0131.4"); //$NON-NLS-1$
    obj2.email = Messages.getString("Exam0131.5"); //$NON-NLS-1$
    obj2.gender = 1;
    obj2.working = false;

    System.out.println(obj1 == obj2);
    System.out.println(obj1.equals(obj2));

    // 결론!
    // => Object에서 상속 받은 것을 그대로 사용하면 equals()는 인스턴스가 같은지 비교한다.
    // => 인스턴스의 내용물이 같은지 비교하도록 만들고 싶다면 equals()을 오버라이딩 하라!
    // => String와 wrapper 클래스는 equals() 오버라이딩 하였다.
    // => StringBuffer 클래스는 equals()를 오버라이딩 하지 않았다.
  }

  static class My {
    String name;
    int age;
    String tel;
    String email;
    int gender;
    boolean working;
    @Override
    public int hashCode() {
      return Objects.hash(age, email, gender, name, tel, working);
    }
    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      My other = (My) obj;
      return age == other.age && Objects.equals(email, other.email) && gender == other.gender
          && Objects.equals(name, other.name) && Objects.equals(tel, other.tel)
          && working == other.working;
    }



  }

}







