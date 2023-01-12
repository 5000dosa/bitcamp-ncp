package bitcamp.bootapp.vo;

// 회원 데이터를 담을 메모리를 설계한다.
public class Management {
  private int no;
  private String name;
  private String tel;
  private String email;
  private String background;
  private String university;
  private byte level;
  private String timecost;
  private String createdDate;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getBackground() {
    return background;
  }
  public void setBackground(String background) {
    this.background = background;
  }
  public String getUniversity() {
    return university;
  }
  public void setUniversity(String university) {
    this.university = university;
  }
  public byte getLevel() {
    return level;
  }
  public void setLevel(byte level) {
    this.level = level;
  }
  public String getTimecost() {
    return timecost;
  }
  public void setTimecost(String timecost) {
    this.timecost = timecost;
  }
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }
}
