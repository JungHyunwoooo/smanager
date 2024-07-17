package com.yedam.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data

public class StudentVO {
	private String stdNo; // std_no
	private String stdName; // std_name
	private String stdPhone;
	private String address;
	private String birthdate;
}
