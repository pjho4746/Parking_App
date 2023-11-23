package com.humax.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket restAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("groupName1")
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("com.humax.parking"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Humax Spring Boot REST API")
                .version("1.0.0")
                .description("휴맥스 API 명세서입니다.")
                .build();
    }

}
