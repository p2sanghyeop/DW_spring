package com.example.first_spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

//getter,setter or data : getter, setter 함수를 자동으로 만들어줌
@Data
@AllArgsConstructor
public class UserVO {
	private String name;
	private int age;
	private String add;
}
