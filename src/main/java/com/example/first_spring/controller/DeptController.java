package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.DeptService;
import com.example.first_spring.vo.DeptVO;

@RestController
public class DeptController {
	@Autowired
	private DeptService deptservice;
	
	@GetMapping("/dept")
	public List<DeptVO> callDeptList(){
		return deptservice.getAllDetpList();
	}
	@PostMapping("/dept")
	public int callSetDept(@RequestBody DeptVO deptVO) {
		return deptservice.setDept(deptVO);
	}
	@DeleteMapping("/dept/deptno/{deptNo}")
	public int callDeptRemove(@PathVariable("deptNo")int deptNo) {
		return deptservice.getRemoveDept(deptNo);
	}
	@PatchMapping("/dept")
	public int callDeptUpgrade(@RequestBody DeptVO deptVO) {
		return deptservice.getUpdateDept(deptVO);
	}
}
