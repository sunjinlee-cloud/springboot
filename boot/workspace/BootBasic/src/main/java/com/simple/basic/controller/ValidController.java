package com.simple.basic.controller;

import com.simple.basic.command.DemoVO;
import com.simple.basic.command.ValidVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/valid")
public class ValidController {

    @GetMapping("/view")
    public String view() {
        return "valid/view";
    }

    @PostMapping("/joinForm")
    public String joinForm(@Valid @ModelAttribute("vo") ValidVO vo, BindingResult bResult, Model model) {
        //유효성검사를 실패한 목록들을 bindingResult 에 담아준다.

//        if(bResult.hasErrors()) {//유효성검사에 실패하면 true
//            List<FieldError> list = bResult.getFieldErrors(); //에러목록
//            for(FieldError err : list) {
//                System.out.println(err.getField()); //유효성 검사 실패한 필드명이 보임
//                System.out.println(err.getDefaultMessage());
//                model.addAttribute("valid_"+err.getField(), err.getDefaultMessage());
//            }
//            return "valid/view";
//        }

        if(bResult.hasErrors()) {
            return "valid/view";
        }

        return "redirect:/valid/result";
    }

    @GetMapping("/result")
    public String result() {
        return "valid/result";
    }

    @GetMapping("/quiz01")
    public String quiz01() {
        return "valid/quiz01";
    }

    @PostMapping("/quizForm")
    public String quizForm(@Valid @ModelAttribute("vo") DemoVO vo, BindingResult bResult, Model model) {

        if(bResult.hasErrors()) {
            return "valid/quiz01";
        }
        return "redirect:/valid/quiz01_result";
    }

    @GetMapping("/quiz01_result")
    public String quiz01_result() {
        return "valid/quiz01_result";
    }

}
