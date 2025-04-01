package com.simple.basic.controller;

import com.simple.basic.command.SimpleVO;
import com.simple.basic.command.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
@RequestMapping("/view")
public class ThymeleafController {

    @GetMapping("/ex01")
    public String ex01() {
        return "view/ex01"; //template 밑에 띄우고 싶은 하위경로
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {

        ArrayList<TestVO> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            TestVO testVO = TestVO.builder().name("name"+i).pw("pw"+1).id("id"+i).address("어딘가").salary(2000+i*100).hireDate(LocalDateTime.now()).build();
            list.add(testVO);
        }
        model.addAttribute("list", list);
        return "view/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model) {

        ArrayList<TestVO> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            TestVO testVO = TestVO.builder().name("name"+i).pw("pw"+1).id("id"+i).address("어딘가").salary(2000+i*100).hireDate(LocalDateTime.now()).build();
            list.add(testVO);
        }
        model.addAttribute("list", list);
        return "view/ex03";
    }

    @GetMapping("/result")
    public String result() {
        return "view/result";
    }

    @GetMapping("/result2/{address}/{value}")
    public String result2(@PathVariable("address") String address,
                          @PathVariable("value") String value) {
        System.out.println(address + " " + value);
        return "view/result";
    }

    @GetMapping("/ex04")
    public String ex04(Model model) {
        TestVO vo = new TestVO();
        vo.setId("anna");
        vo.setName("anna");
        vo.setAddress("강남구");
        vo.setHireDate(LocalDateTime.now());
        model.addAttribute("vo", vo);

        return "view/ex04";
    }

    @GetMapping("/ex05")
    public String ex05(){
        return "view/ex05";
    }

    @GetMapping("/ex06")
    public String ex06(){
        return "view/ex06";
    }

    @GetMapping("/quiz01")
    public String quiz01(Model model){
        SimpleVO vo = new SimpleVO();
        vo.setName("anna");
        vo.setNo(54321);
        vo.setRegDate(LocalDateTime.now());
        model.addAttribute("vo", vo);
        return "view/quiz01";
    }

    @GetMapping("/quiz01_result")
    public String quiz01_result(@RequestParam("no") int no,
                                @RequestParam("name") String name,
                                Model model){
        SimpleVO vo = new SimpleVO();
        vo.setNo(no);
        vo.setName(name);
        model.addAttribute("vo", vo);
        return "view/quiz01_result";
    }

//    @GetMapping("quiz01_result/{no}/{name}")
//    public String quiz01_result(@PathVariable("no") int no,
//                                @PathVariable("name") String name,
//                                Model model){
//        System.out.println(no + " " + name);
//        SimpleVO vo = new SimpleVO();
//        vo.setNo(no);
//        vo.setName(name);
//        model.addAttribute("vo", vo);
//        return "view/quiz01_result";
//    }

}
