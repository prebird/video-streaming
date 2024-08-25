package org.prebird.videostreaming;

import java.io.FileNotFoundException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/resource")
@RestController
public class ResourceController {
  @GetMapping("/videos/{name}")
  public ResponseEntity<Resource> getVideo(@PathVariable String name, HttpServletRequest request) throws FileNotFoundException {
    LogUtils.logHeader(request);

    String location = String.format("/Users/yonggyujeong/myFolder/down/%s", name);
    FileSystemResource video = new FileSystemResource(location);

    if (!video.exists()) {
      throw new FileNotFoundException("Video file not found");
    }

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_TYPE, "video/mp4")  // 비디오 MIME 타입 지정
        .body(video);
  }
}
