package com.example.first_spring.vo;

import lombok.Data;

@Data
public class EmpVO extends DeptVO {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;
	private int comm;
	private int sal;
}
