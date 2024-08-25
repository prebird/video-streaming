package org.prebird.videostreaming;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogUtils {
  public static void logHeader(HttpServletRequest request) {
    log.info("---headers---");
    List<String> headerNames = Collections.list(request.getHeaderNames());

    for (String headerName : headerNames) {
      log.info(headerName + ": " + request.getHeader(headerName));
    }
  }
}
