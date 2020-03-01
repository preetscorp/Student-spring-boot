package com.springboot.tryouts.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.springboot.tryouts.demo"))
				.build()
				.apiInfo(buildApiInfo());
	}
	
	public ApiInfo buildApiInfo() {
				return new ApiInfoBuilder().title("Student Management")
						.description("REST API documention for all Student Management Application")
						.version("1.0")
						.build();
	}
}
