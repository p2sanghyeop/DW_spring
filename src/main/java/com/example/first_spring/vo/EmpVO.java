package com.example.first_spring.vo;

import lombok.Data;

@Data
public class EmpVO extends DeptVO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
}
