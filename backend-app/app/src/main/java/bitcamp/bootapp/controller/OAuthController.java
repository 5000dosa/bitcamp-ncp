package bitcamp.bootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

  /**
   * 카카오 callback
   * [GET] /oauth/kakao/callback
   */
  @ResponseBody
  @GetMapping("/kakao")
  public void kakaoCallback(@RequestParam String code) {
    System.out.println(code);
  }
}
