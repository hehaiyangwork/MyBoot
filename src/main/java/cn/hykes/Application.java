package cn.hykes;

import cn.hykes.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import java.util.HashSet;

/**
 * @EnableAutoConfiguration 让 Spring Boot 根据应用所声明的依赖来对 Spring 框架进行自动配置
 * @CompoentScan 告知Spring扫描指定的包来初始化Spring Bean，这能够确保我们声明的Bean能够被发现。可填value值(packagePath)，如果不加必须保证所有的程序在一个包中，不然会出现404.
 */

//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public CityDao cityDao;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBanner(new SampleBanner());
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.cityDao.selectCityById(1));
    }
}