package org.prebird.videostreaming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Slf4j
@RequestMapping("/stream")
@RestController
public class StreamingController {
  @GetMapping("/videos/{name}")
  public ResponseEntity<StreamingResponseBody> getVideo(@PathVariable String name, HttpServletRequest request)
      throws FileNotFoundException {
    LogUtils.logHeader(request);

    String location = String.format("/Users/yonggyujeong/myFolder/down/%s", name);
    File videoFile = new File(location);

    if (!videoFile.exists()) {
      throw new FileNotFoundException("Video file not found");
    }

    InputStream inputStream = new FileInputStream(videoFile);
    StreamingResponseBody stream = outputStream -> {
      byte[] buffer = new byte[4096];
      int bytesRead;
      try {
        while ((bytesRead = inputStream.read(buffer)) != -1) {
          outputStream.write(buffer, 0, bytesRead);
        }
      } finally {
        inputStream.close();
      }
    };

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
        .header(HttpHeaders.ACCEPT_RANGES, "bytes") // 비디오 구간 이동
        .header(HttpHeaders.CONTENT_LENGTH, Long.toString(videoFile.length()))
        .body(stream);
  }


}
