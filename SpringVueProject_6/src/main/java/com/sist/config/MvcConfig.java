
package com.sist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 자동 메모리 할당 
@EnableWebMvc
@ImportResource(value= {
		"classpath:application-context.xml",
		"classpath:application-datasource.xml"
})
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
