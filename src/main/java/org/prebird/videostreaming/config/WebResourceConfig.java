package org.prebird.videostreaming.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebResourceConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/local-storage/**")
        .addResourceLocations("file:///Users/yonggyujeong/myFolder/down/"); // 서버 경로 바인딩
  }
}
