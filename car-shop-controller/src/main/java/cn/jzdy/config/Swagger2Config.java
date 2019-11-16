package cn.jzdy.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 	swagger配置类111
 * Lujingdong
 * 2019年11月16日
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config implements WebMvcConfigurer {
	
	@Value("${server.port}")
	private String serverPort;
	/**
	 *
	 * 显示swagger-ui.html文档展示页，还必须注入swagger资源：
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("doc.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
		
	}

	/**
	 * 加载swagger2
	 * @return
	 */
	@Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //扫描指定的包生成接口文档
                .apis(RequestHandlerSelectors.basePackage("cn.kooun.controller"))
                .paths(PathSelectors.any())
                .build();
    }


	/**
	 * swaggerui页面数据配置
	 * 文档访问路径
	 * http://<ip>:<port>/v2/api-docs
	 * 原版视图访问路径
	 * http://<ip>:<port>/swagger-ui.html
	 * swagger-bootstrap-ui视图
	 * http://<ip>:<port>/doc.html
	 * @author chenwei
	 * @date 2019年6月28日 下午6:39:20
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("车你太美系统API文档")
				.description("车你太美有限公司@API"
						+ "<p>"
						+ "<font style='color:red'>"
						+ "如果需要获取业务数据的注释请在请求头中添加以下参数"
						+ "debug=1"
						+ "</font>"
						+ "</p>")
				.termsOfServiceUrl("http://127.0.0.1:"+ serverPort)
				.version("1.0")
				.build();
		
	}

}
