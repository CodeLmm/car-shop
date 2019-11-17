package cn.jzdy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:druid.properties","classpath:config/redis.properties"})
@MapperScan("cn.jzdy.dao")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
