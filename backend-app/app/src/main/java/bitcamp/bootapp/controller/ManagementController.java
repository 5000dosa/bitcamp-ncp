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
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.ManagementDao;
import bitcamp.bootapp.vo.Management;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
public class ManagementController {

  ManagementDao managementDao = new ManagementDao();

  @PostMapping("/managements")
  public Object addmanagement(
      Management management
      ) {

    management.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    this.managementDao.insert(management);

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }


  @GetMapping("/managements")
  public Object getmanagements() {

    Management[] managements = this.managementDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", managements);

    return contentMap;
  }


  @GetMapping("/managements/{managementNo}")
  public Object getmanagement(@PathVariable int managementNo) {

    Management b = this.managementDao.findByNo(managementNo);

    Map<String,Object> contentMap = new HashMap<>();

    if (b == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", b);
    }

    return contentMap;
  }

  @PutMapping("/managements/{no}")
  public Object updatemanagement(
      //@PathVariable int managementNo, // management 인스턴스로 직접 받을 수 있다.
      Management management) {

    Map<String,Object> contentMap = new HashMap<>();

    Management old = this.managementDao.findByNo(management.getNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");
      return contentMap;
    }

    management.setCreatedDate(old.getCreatedDate());

    this.managementDao.update(management);

    contentMap.put("status", "success");

    return contentMap;
  }

  @DeleteMapping("/managements/{managementNo}")
  public Object deletemanagement(
      // 낱개로 받을 때는 @PathVariable 애노테이션을 생략하면 안된다.
      @PathVariable int managementNo) {

    Management m = this.managementDao.findByNo(managementNo);

    Map<String,Object> contentMap = new HashMap<>();

    if (m == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "회원이 없습니다.");

    } else {
      this.managementDao.delete(m);
      contentMap.put("status", "success");
    }

    return contentMap;
  }
}
