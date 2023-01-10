package bitcamp.bootapp.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.UserDao;
import bitcamp.bootapp.vo.User;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500", "http://192.168.56.1:5500"})
@RestController
public class UserlistController {

  UserDao userDao = new UserDao();

  @PostMapping("/users")
  public Object addUser(
      @RequestParam(required = false) String title,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String gender,
      @RequestParam(required = false) String tel,
      @RequestParam(required = false) String content,
      @RequestParam(required = false) String basicaddress,
      @RequestParam(required = false) String password) {

    User u = new User();
    u.setTitle(title);
    u.setName(name);
    u.setGender(gender);
    u.setTel(tel);
    u.setContent(content);
    u.setBasicaddress(basicaddress);
    u.setPassword(password);
    u.setCreatedDate(new Date(System.currentTimeMillis()).toString());

    this.userDao.insert(u);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }


  @GetMapping("/users")
  public Object getUsers() {

    User[] users = this.userDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", users);

    return contentMap;
  }

  @GetMapping("/users/{userNo}")
  public Object getUser(@PathVariable int userNo) {

    User u = this.userDao.findByNo(userNo);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();

    if (u == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "해당 번호의 게시글이 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", u);
    }

    return contentMap;
  }

  @PutMapping("/users/{userNo}")
  public Object updateUser(
      @PathVariable int userNo,
      @RequestParam(required = false) String title,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String gender,
      @RequestParam(required = false) String tel,
      @RequestParam(required = false) String content,
      @RequestParam(required = false) String basicaddress,
      @RequestParam(required = false) String password) {

    Map<String,Object> contentMap = new HashMap<>();

    User old = this.userDao.findByNo(userNo);
    if (old == null || !old.getPassword().equals(password)) {
      contentMap.put("status", "failure");
      contentMap.put("data", "게시글이 없거나 암호가 맞지 않습니다.");
      return contentMap;
    }

    User u = new User();
    u.setNo(userNo);
    u.setTitle(title);
    u.setName(name);
    u.setGender(gender);
    u.setTel(tel);
    u.setContent(content);
    u.setBasicaddress(basicaddress);
    u.setPassword(password);
    u.setCreatedDate(old.getCreatedDate());
    u.setViewCount(old.getViewCount());

    this.userDao.update(u);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/users/{userNo}")
  public Object deleteUser(
      @PathVariable int userNo,
      @RequestParam String password) {

    User u = this.userDao.findByNo(userNo);

    // 응답 결과를 담을 맵 객체 준비
    Map<String,Object> contentMap = new HashMap<>();

    if (u == null || u.getPassword().equals(password)) {
      contentMap.put("status", "failure");
      contentMap.put("data", "해당 번호의 게시글이 없습니다.");

    } else {
      this.userDao.delete(u);
      contentMap.put("status", "success");
    }

    return contentMap;
  }
}
