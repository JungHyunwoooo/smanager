package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo; // board_no
	private String writer;
	private String title;
	private String content;
	private int viewCnt;
	private Date writeDate;
}
