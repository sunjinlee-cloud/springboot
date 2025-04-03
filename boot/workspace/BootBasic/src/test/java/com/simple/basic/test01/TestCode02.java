package com.simple.basic.test01;

import com.simple.basic.memo.mapper.MemoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCode02 {

    //
    @Autowired
    private MemoMapper memoMapper;

    @Test
    public void testCode01() {
        System.out.println("현재시간 : "+memoMapper.getTime());
    }
}
