package org.prebird.videostreaming;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
  @GetMapping("/resource")
  public String videoResource() {
    return "video-resource";
  }

  @GetMapping("/stream")
  public String videoStream() {
    return "video-stream";
  }
}
