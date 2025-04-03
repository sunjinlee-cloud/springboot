package com.simple.basic.memo.service;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.mapper.MemoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("memoService")
//@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService {

    @Autowired
    MemoMapper memoMapper;


    @Override
    public int memoWrite(MemoVO vo) {
        int result = memoMapper.memoWrite(vo);
        return result;
    }

    @Override
    public ArrayList<MemoVO> getList() {
        ArrayList<MemoVO> list = new ArrayList<>();
        list = memoMapper.getList();
        return list;
    }


}
