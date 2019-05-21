/**
 * 
 */
package com.doodle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunil
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= { "com.doodle "})
public class SpringConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(webInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/**");
		registry.addInterceptor(restInterceptor()).addPathPatterns("/api/**");

		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Bean
	public WebInterceptor webInterceptor() {
		return new WebInterceptor();
	}

	@Bean
	public RESTInterceptor restInterceptor() {
		return new RESTInterceptor();
	}

}
