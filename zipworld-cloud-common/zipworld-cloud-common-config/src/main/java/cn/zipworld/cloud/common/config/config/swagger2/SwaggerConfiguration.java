package cn.zipworld.cloud.common.config.config.swagger2;

import io.swagger.models.Path;
import io.swagger.models.Swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 开启swagger相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    class SortedSwagger extends Swagger {
        @Override
        public Map<String, Path> getPaths() {
            return paths;
        }
    }

//    @Bean
//    public Docket adminApi() {
//        //return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//        docket.enable(true).groupName("admin");
//        docket.apiInfo(apiInfo())
//                .select()
//                //扫描api的包名配置
//                .apis(RequestHandlerSelectors.basePackage("com.mycloud.service"))
//                .paths(PathSelectors.regex(".*/admin/.*")).build();
//        return docket;
//    }

    @Bean
    public Docket newsApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("token").description("用户token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数



        //return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(true);
        docket.apiInfo(apiInfo())
                .select()
                //扫描api的包名配置
                .apis(RequestHandlerSelectors.basePackage("cn.zipworld"))
                .paths(PathSelectors.any())
                //.paths(PathSelectors.regex("!(.*/admin/.*)"))
                .build()
                .globalOperationParameters(pars);
//                .apiDescriptionOrdering(new Ordering<ApiDescription>() {
//                    @Override
//                    public int compare(ApiDescription apiDescription, ApiDescription t1) {
//                        return apiDescription.getOperations().get(0).getMethod().toString()
//                                .compareToIgnoreCase(t1.getOperations().get(0).getMethod().toString());
//
//                    }
//                });
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("压缩世界erp系统api").description("压缩世界erp系统api")
                .termsOfServiceUrl("https://erpopen.zipworld.cn").contact("gcy")
                .license("压缩世界 Licence Version 1.0").licenseUrl("#").version("1.0").build();
    }

}

