package com.simple.basic.config;

import com.simple.basic.controller.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //이 클래스를 스프링의 자바설정파일로 쓴다
@PropertySource("classpath:/application-production.properties") //classpath: 리소스 아래를 가리킨
public class WebConfig implements WebMvcConfigurer {

    /*
    @Value("${server.port}") //application.properties 의 key 값을 가져다가 애너테이션 value 안에 넣어주면 값을 쓸 수 있음
    private String port;

    @Value("${my.example.port}")
    private String myPort;//application-production.properties 에서 참조

    @Autowired
    private ApplicationContext applicationContext; // IoC Container 처럼 동작하는 개체, 스프링이 컨텍스트파일을 하나 주입해 준다.

    @Bean //스프링이 이 메서드를 호출시켜서 반환되는 값을 bean 으로 등록시킨다. 이걸 컨트롤러가 autowired 를 통해서 이용 가능한 것
    public void myTest() {

        System.out.println("프로퍼티 파일의 port 값 : "+port);
        System.out.println("두번째 프로퍼티 파일의 port 값 : "+myPort);

        System.out.println("설정파일 동작함");
        System.out.println("빈의 개수: "+applicationContext.getBeanDefinitionCount());
        HomeController homeController = applicationContext.getBean(HomeController.class);
        System.out.println("ioc 컨테이너 안 컨트롤러 객체 : "+homeController);


    }

    @Bean
    public TestServiceImpl testServiceImpl() {
        return new TestServiceImpl();
    }
    */

    
}
