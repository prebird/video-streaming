package org.prebird.videostreaming;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
  @GetMapping("/resource")
  public String videoResource(HttpServletResponse response, Model model) {
    // 쿠키는 동일 브라우저를 사용하면 공유되기 때문에 보안에 취약할 수 있다.
    Cookie cookie = new Cookie("Token", "12345");
    cookie.setHttpOnly(true); // 클라이언트 측에서 JavaScript로 접근할 수 없도록 설정
//    cookie.setSecure(true);   // HTTPS에서만 전송되도록 설정
    cookie.setPath("/resource");      // 쿠키가 적용될 경로 설정
    cookie.setMaxAge(7 * 24 * 60 * 60); // 쿠키의 유효 기간 설정 (1주일)
    response.addCookie(cookie);

    model.addAttribute("videoToken", "12345");
    return "video-resource";
  }

  @GetMapping("/stream")
  public String videoStream() {
    return "video-stream";
  }
}
