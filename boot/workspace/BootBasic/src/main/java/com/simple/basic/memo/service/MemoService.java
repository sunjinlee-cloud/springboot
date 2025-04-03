package com.simple.basic.memo.service;

import com.simple.basic.command.MemoVO;

import java.util.ArrayList;

public interface MemoService {
    public int memoWrite(MemoVO vo);

    ArrayList<MemoVO> getList();
}
