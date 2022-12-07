 package com.pms.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;


@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pms.demo"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo()
    {
       return new ApiInfoBuilder()
    		   .title("Product-Spring Boot Swagger Configuration")
    		   .description("Swagger Configuration for application")
    		   .version("2.7.0")
    		   //.license("Apache 9.0")
    		   //.licenseUrl("https://www.apache.org/licenses/LICENSE-9.0")
    		   .build();
    }
    //for Swagger api doc generation
    // http://localhost:8091/v2/api-docs
}