package com.vet.main.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	//시작 인덱스번호
	private Long startRow;
			
	//가져올 갯수
	private Long lastRow;
			
	//검색할 컬럼명
	private String kind;
			
	//검색어
	private String search;
			
	private Long page;
			
	//한페이지에 보여질 data(row)의 갯수
	private Long perPage;
			
	//총 페이지의 갯수
	private Long totalPage;
		
	//시작번호
	private Long startNum;
			
	//끝번호
	private Long lastNum;
			
	//이전블럭활성화
	private boolean pre; //false -> 1번 block, true -> 1번 아님
			
	//다음블럭 활성화
	private boolean next; //false -> 마지막블럭, true -> 마지막블럭
			
	public void makePageNum(Long total) {
		//130 -> 13
		//131 ~ 139 -> 14
		//90 -> 9
		//91 ~ 99 -> 10
				
		//1. 전체 갯수로 전체페이지 수 구하기
		this.totalPage = total/this.getPerPage();
		if(total%this.getPerPage() != 0) {
			this.totalPage++;
		}
				
		//2. 전체 페이지수로 전체 block 수 구하기
		long perBlock = 5; // 한페이지에 출력할 번호의 갯수
				
		long totalBlock = this.totalPage / perBlock;
		if(this.totalPage%perBlock != 0) {
			totalBlock++;
		}
				
		//3. 현재 페이지번호로 블럭번호 구하기
		long curBlock = this.getPage() / perBlock; //현재 블럭번호
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
				
		//4. 현재 블럭번호의 시작번호와 끝번호 구하기
		// curBlock   startNum   lastNum
		// 1          1          5
		// 2          6          10
		// 3          11         15
		this.startNum = (curBlock - 1)*perBlock + 1;
		this.lastNum = curBlock * perBlock;
				
		//이전 블럭 활성화 여부
		if(curBlock > 1) {
			this.pre = true;
		}
				
		//다음 블럭 활성화 여부
		if(curBlock < totalBlock) {
			this.next = true;
		}
				
		//현재 블럭이 마지막 블럭일때 lastNum을 totalPage숫자로 대입
		//if(curBlock == totalBlock) {
		if(!this.next) {	
			this.lastNum = totalPage;
			}
		}

		public void makeRowNum() {
			this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
			this.lastRow = this.getPage() * this.getPerPage();
		}
			
		public Long getPage() {
			if(this.page == null) {  //1page
				this.page = 1L;
			}
			return page;
		}
			
		public Long getPerPage() {
			if(this.perPage == null) {  //게시글 10개
				this.perPage = 10L;
			}
			return perPage;
		}

		public Long getStartRow() {
			if(this.startRow == null || this.startRow < 0) {
				return 0L;
			}
			return this.startRow;
		}
			
		public Long getLastRow() {
			if(this.lastRow == null || this.lastRow < 0) {
				return 10L;
			}
			return this.lastRow;
		}
			
		public String getSearch() {
			if(this.search == null) {
				return "";
			}
			return this.search;
		}

}
