package com.simple.basic.controller;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/memo")
//@RequiredArgsConstructor //메모컨트롤러 생성시 멤버변수들을 빈으로 만들어서 주입해준다.
public class MemoController {

    //멤버변수 주입
    @Autowired
    @Qualifier("memoService")
    private MemoService memoService;

    //롬복애너테이션으로 생성자 주입 - 반드시 final 붙여줘야 제대로 작동함
    //private final MemoService memoService;

    @GetMapping("/memoWrite")
    public String memoWrite () {
        return "memo/memoWrite";
    }

    @PostMapping("/memoForm")
    public String memoForm(@Valid @ModelAttribute("vo") MemoVO vo, BindingResult bResult, Model model) {
        if(bResult.hasErrors()) {
            return "memo/memoWrite";
        }

        int result = memoService.memoWrite(vo);
        if (result == 1) return "redirect:/memo/memoList";
        else return "memo/memoWrite";
    }

    @GetMapping("/memoList")
    public String memoList(Model model, MemoVO vo) {

        ArrayList<MemoVO> list = new ArrayList<>();
        list = memoService.getList();
        System.out.println(list.toString());
        model.addAttribute("list", list);

        return "memo/memoList";
    }

}
