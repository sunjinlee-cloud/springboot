package com.coding404.myweb.controller;

import com.coding404.myweb.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class TopicController {


    @Autowired
    @Qualifier("topicService")
    TopicService topicService;

    @GetMapping("/topicDetail")
    public String topicDetail() {
        return "topic/topicDetail";
    }

    @GetMapping("/topicListAll")
    public String topicListAll() {
        return "topic/topicListAll";
    }

    @GetMapping("/topicListMe")
    public String topicListMe() {
        return "topic/topicListMe";
    }

    @GetMapping("/topicModify")
    public String topicModify() {
        return "topic/topicModify";
    }

    @GetMapping("/topicReg")
    public String topicReg() {
        return "topic/topicReg";
    }

}
