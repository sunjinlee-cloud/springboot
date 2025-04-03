package com.simple.basic.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DemoVO {

    @Pattern(regexp = "[a-zA-Z0-9]{8,}", message = "알파벳, 숫자 포함 8자리 이상입니다")
    private String id;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "알파벳, 숫자, 특수문자 포함 8자리 이상입니다")
    private String pw;

}
