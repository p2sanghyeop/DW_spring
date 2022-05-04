package com.example.first_spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.controller.vo.UserVO;
import com.example.first_spring.service.MainService;

@RestController

public class ActorController {
	
	@Autowired
	private MainService service;
	
	//문제 1. 나이가 60 이하인 배우만 리턴하시오.
	@GetMapping("/actor/list")
	public List<UserVO> callList(HttpServletRequest reuqest){
		String ip = reuqest.getHeader("X-forwarded-For");
		if(ip == null) ip = reuqest.getRemoteAddr();
		System.out.println("ip-->"+ip);
		return service.getUserList();
	} 
	@GetMapping("/actor/age")
	public int callAge(){
		return service.getUserAgeMax();
	}
	@GetMapping("/actor")
	public UserVO callUser() {
		return service.getUser();
	}
	@GetMapping("/actor/count")
	public int callCount() {
		return service.getUserCount();
	}
	
}
