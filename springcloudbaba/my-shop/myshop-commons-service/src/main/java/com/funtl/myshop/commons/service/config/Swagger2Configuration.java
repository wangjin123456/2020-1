package com.funtl.myshop.commons.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author tom
 * @date 2020/3/30 0030 16:41
 */
@Configuration
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
       return  new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.funtl.myshop.service"))
                .paths(PathSelectors.any())
               .build();
    }

    private ApiInfo apiInfo() {
        return  new ApiInfoBuilder()
                .title("MyShop API 文档")
                .description("MyShop API 网关接口。")
                .version("1.0.0")
                .build();
    }


}
