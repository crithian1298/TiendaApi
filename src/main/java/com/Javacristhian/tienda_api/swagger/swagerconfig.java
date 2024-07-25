package com.Javacristhian.tienda_api.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
@EnableWebMvc

public class swagerconfig  {                                 
	    @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .apiInfo(getApiInfo())
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();
	         
	    
	}

		private ApiInfo getApiInfo() {
			return new ApiInfo("Order service API","Order Service API Description","1.0","",
					new Contact("Cristhian Alberto Salcedo Aguado","cristhiam.1298@gmail.com",""),
					"LICENSE","LICENSE URL",Collections.emptyList());
		}
		
		
}
