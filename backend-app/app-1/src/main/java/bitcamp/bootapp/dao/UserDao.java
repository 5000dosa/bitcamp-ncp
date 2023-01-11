package bitcamp.bootapp.dao;

import java.util.Arrays;
import bitcamp.bootapp.vo.User;

public class UserDao {
  private static final int SIZE = 100;

  private int no; // User 식별 번호
  private int count;
  private User[] Users = new User[SIZE];

  public void insert(User user) {
    user.setNo(++no);
    this.Users[this.count++] = user;
  }

  public User[] findAll() {
    // 배열의 값 복제
    //    Board[] arr = new Board[this.count];
    //    for (int i = 0; i < this.count; i++) {
    //      arr[i] = this.boards[i];
    //    }
    //    return arr;

    // 위와 같다!
    return Arrays.copyOf(Users, count);
  }

  public User findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.Users[i].getNo() == no) {
        return this.Users[i];
      }
    }
    return null;
  }

  public void update(User user) {
    this.Users[this.indexOf(user)] = user;
  }

  public void delete(User user) {
    for (int i = this.indexOf(user) + 1; i < this.count; i++) {
      this.Users[i - 1] = this.Users[i];
    }
    this.Users[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  private int indexOf(User u) {
    for (int i = 0; i < this.count; i++) {
      if (this.Users[i].getNo() == u.getNo()) {
        return i;
      }
    }
    return -1;
  }
}







