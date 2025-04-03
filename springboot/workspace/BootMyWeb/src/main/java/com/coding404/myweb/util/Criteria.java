package com.coding404.myweb.util;

import lombok.Data;

@Data
public class Criteria {

    //사용자가 조회하는 페이지의 번호와 데이터의 갯수를 가지고 있음.
    private int page;
    private int amount;

    public Criteria() {
        this(1,10) ;
    }

    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }

    //limit함수의 첫번째 매개변수에 넣을 값을 계산하는 메서드
    public int getPageStart() {
        return (page-1)*amount;
    }


}
