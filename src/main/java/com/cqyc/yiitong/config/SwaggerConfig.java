package com.cqyc.yiitong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: cqyc
 * Description:
 * Created by cqyc on 19-10-8
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                   当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.cqyc.yiitong.controller"))
                .paths(PathSelectors.any()).build();

    }

    /**
     * 构建api文档的详细信息函数
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
                .title("swagger测试管理系统")
                //创建人
                .contact(new Contact("cqyc","http://www.baidu.com",""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}
