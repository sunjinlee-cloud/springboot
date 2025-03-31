package com.simple.basic.command;

import lombok.Builder;
import lombok.ToString;
import org.thymeleaf.extras.java8time.util.TemporalSetUtils;

@ToString
@Builder
public class TestBuilderVO {

    //빌더 패턴 : 객체의 불변성을 위해 사용하는 문법

    //1. 멤버변수를 만듦
    private String name;
    private int age;


    /*
    //3. 외부클래스가 생성될 때 내부클래스인 Builder 를 매개변수로 받는다.
    private TestBuilderVO(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    //4. 외부에서 객체 생성을 요구할 때 builder 를 호출하도록 한다.
    public static Builder builder() {
        return new Builder();
    }

    //2.내부클래스를 만든다
    public static class Builder{
        private String name;
        private int age;

        //생성자 제한
        private Builder() {}

        //5.빌더클래스에서는 set 메서드만 생성하고 자신을 반환시킨다
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        //6.build 메서드 호출 시 3번 생상자를 통해 멤버변수를 외부에 저장시켜준다.
        public TestBuilderVO build() {
            return new TestBuilderVO(this);
        }

    } */

}
