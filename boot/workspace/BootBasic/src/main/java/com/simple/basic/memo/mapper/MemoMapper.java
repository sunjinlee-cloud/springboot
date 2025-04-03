package com.simple.basic.memo.mapper;

import com.simple.basic.command.MemoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper //반드시 붙여줘야 함
public interface MemoMapper {
    //public String getTime();

    public int memoWrite(MemoVO vo);

    ArrayList<MemoVO> getList();
}
