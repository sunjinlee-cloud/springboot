package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemoVO {

    private Integer mno;

    @Size(min=5, message = "5글자 이상 입력해주세요")
    private String memo;

    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "010-0000-0000 형식으로 입력해 주세요")
    private String phone;

    @Pattern(regexp = "^[a-zA-Z0-9]{4}$", message = "비밀번호는 4자리입니다")
    private String pw;

    private char secret;

}
