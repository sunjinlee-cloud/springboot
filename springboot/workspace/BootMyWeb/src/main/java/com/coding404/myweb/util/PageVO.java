package com.coding404.myweb.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageVO {
    //페이지네이션을 계산하기 위한 클래스
    private int start; //시작페이지 번호
    private int end; //끝페이지 번호
    private boolean prev; //이전버튼 활성화 여부
    private boolean next; //다음버튼 활성화 여부
    private int page; //현재 조회하고 있는 페이지 번호 - criteria와 연관
    private int amount; //현재 조회하는 페이지의 데이터 양
    private int total; //전체 게시글 수
    private int realEnd; //맨 마지막페이지에서의 실제 끝번호 값

    private Criteria cri;
    private List<Integer> pageList = new ArrayList<>();
    //화면에서 start 부터 end까지 계산된 결과를 담아놓기 위한 번호리스트(타임리프의 향상된 for문)

    private int pageCount = 10;//화면에 그려지는 페이지네이션 개수

    //생성시 criteria 객체와 총 게시글 수가 꼭 필요하다.
    public PageVO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;
        this.page = cri.getPage();
        this.amount = cri.getAmount();

        //페이지 끝번호 계산
        this.end = (int)Math.ceil(this.page/(double)this.pageCount)*pageCount;
        //페이지 시작번호 계산 : 끝페이지번호 - 페이지네이션 개수
        this.start = this.end - this.pageCount +1;

        //실제 끝번호 계산
        //데이터가 165개일때 실제 끝번호가 17
        //(int)Math.ceil(총 게시글 수/현재조회하는 데이터 개수)
        this.realEnd = (int)Math.ceil(this.total/(double)this.amount);
        //실제 마지막번호를 다시 계산
        //데이터가 165개일때
        //1~10페이지 조회시 end값은 10, realEnd = 17
        //11~20페이지 조회시 end값은 20, realEnd = 17
        if (this.end > this.realEnd) {this.end = this.realEnd;
        }
        //이전 버튼 활성화 여부
        this.prev = this.start > 1;
        this.next = this.realEnd > this.end;
        //페이지리스트 초기화
        for(int i = start; i<=end; i++) {
            pageList.add(i);
        }
    }


}
