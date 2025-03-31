package com.simple.basic.command;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor //기본생성자
@AllArgsConstructor //필드 다 들어가는 생성자
//@Getter
//@Setter
//@ToString //toString override
@Data // 게터, 세터, 투스트링 합침
public class TestVO {
    
    //단축키 alt+insert 
    
    private String id;
    private String pw;
    private String name;
    private int salary;
    private String address;
    private LocalDateTime hireDate;
    
    
    
}
