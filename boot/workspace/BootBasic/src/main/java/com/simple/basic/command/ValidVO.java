package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidVO {

    /*
    * @not null : vo에 null 값 안 들어감 - int에는 적용이 안됨. Integer, long 등에 적용
    * @not empty: null, 공백도 안됨. Array, map, String  등에 적용
    * @not black : null, blank, whitespace 다 안됨.
    *
    * @Pattern : 정규표현식으로
    * @Email
    * @Size
    * */


    @NotBlank(message = "이름은 필수입니다")
    private String name;

    @NotNull(message = "급여는 필수입니다")
    private Integer salary;

    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "휴대폰 번호는 010-0000-0000 형식으로 입력해 주세요")
    private String phone;

    @NotEmpty(message = "이메일은 필수입니다")
    private String email;



}
