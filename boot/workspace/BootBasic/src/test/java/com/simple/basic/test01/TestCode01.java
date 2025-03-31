package com.simple.basic.test01;

import com.simple.basic.command.TestBuilderVO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//Order 애너테이션과 함께 사용 / 순서 지정 시 사용됨
public class TestCode01 {

    //주의점 : 여러 테스트들 중 하나라도 실패하면 서버 빌드가 안됨.
    //그리고 테스트가 여러개면 순서가 보장되지 않음 -> 순서를 지정하고 싶을 시 @Order라는 애너테이션 사용


//    @Autowired
//    public ApplicationContext applicationContext;
//
//    @Test
//    @Order(2)
//    public void test01() {
//        System.out.println("테스트코드");
//        System.out.println("빈의 개수 : "+applicationContext.getBeanDefinitionCount());
//    }
//
//
//    @Test
//    @Order(1)
//    public void test02() {
//        System.out.println("테스트코드 2");
//
//    }


    //빌더패턴의 사용
    @Test
    public void test03() {
        TestBuilderVO vo =  TestBuilderVO.builder().age(100).name("nom").build();

        System.out.println(vo.toString());
    }


}
