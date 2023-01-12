package bitcamp.bootapp.dao;

import java.util.Arrays;
import bitcamp.bootapp.vo.Management;

public class ManagementDao {
  private static final int SIZE = 100;

  private int no;
  private int count;
  private Management[] management = new Management[SIZE];

  public void insert(Management management) {
    management.setNo(++no);
    this.management[this.count++] = management;
  }

  public Management[] findAll() {
    return Arrays.copyOf(management, count);
  }

  public Management findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.management[i].getNo() == no) {
        return this.management[i];
      }
    }
    return null;
  }

  public void update(Management management) {
    this.management[this.indexOf(management)] = management;
  }

  public void delete(Management management) {
    for (int i = this.indexOf(management) + 1; i < this.count; i++) {
      this.management[i - 1] = this.management[i];
    }
    this.management[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  private int indexOf(Management b) {
    for (int i = 0; i < this.count; i++) {
      if (this.management[i].getNo() == b.getNo()) {
        return i;
      }
    }
    return -1;
  }
}







