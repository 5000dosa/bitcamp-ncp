package bitcamp.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.google.gson.Gson;
import bitcamp.myapp.Dao.DaoException;
import bitcamp.myapp.vo.Student;

public class JdbcStudentDao implements StudentDao {


  @Override
  public void insert(Student s) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      String sql = String.format("insert into app_student(name, tel, pst_no, bas_addr, det_addr, working, gender, level)"
          +" values('%s', '%s', '%s','%s','%s','%d','%s','%d')",
          s.getName(),
          s.getTel(),
          s.getPostNo(),
          s.getBasicAddress(),
          s.getDetailAddress(),
          s.isWorking(),
          s.getGender(),
          s.getLevel()
          );
      stmt.executeUpdate(sql);
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public Student[] findAll() {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "student", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select Student_id, name, tel, created_date, pst_no, bas_addr, work, gender, leverl "
                + "from app_student order by student_id desc")) {
      ArrayList<Student> list = new ArrayList<>();
      while (rs.next()) {
        Student s = new Student();
        s.setNo(rs.getInt("board_id"));
        s.setTel(rs.getString("tel"));
        s.setCreatedDate(rs.getString("created_date"));
        s.setPostNo(rs.getString("pst_no"));
        s.set

      }
    }

  } catch (Exception e) {
    throw new DaoException(e);
  }

  @Override
  public Student findByNo(int no) {
    return new Gson().fromJson(daoStub.fetch("student", "findByNo", no), Student.class);
  }

  @Override
  public void update(Student b) {
    daoStub.fetch("student", "update", b);
  }

  @Override
  public boolean delete(Student b) {
    daoStub.fetch("student", "delete", b);
    return true;
  }
}























