package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.EmpVO;

@RestController
public class EmpController {
	@Autowired
	private EmpService empservice;
	
	@GetMapping("/emp")
	public List<EmpVO> callEmpList(){
		return empservice.getAllempList();
	}
	//@PathVariable : {}로 들어온 값을 파라미터에 대입
	@GetMapping("/emp/no/{empNo}")//{}:파라미터로 넘기겠다
	public EmpVO callEmpno(@PathVariable("empNo")int empNo) {
		return empservice.getEmp(empNo);
//		 return empNo;
	}
	@GetMapping("/emp/name")
	public List<EmpVO> callName(){
		return empservice.getNameList();
	}
	@GetMapping("/emp/comm")
	public List<EmpVO> callComm(){
		return empservice.getCommList();
	}
	@GetMapping("/emp/hiredate")
	public List<EmpVO> callHiredate(){
		return empservice.getHiredateList();
	}
	@GetMapping("/emp/job/{jobName}/sal/{sal}")
	public List<EmpVO> callsal(@PathVariable("jobName")String jobName, @PathVariable("sal") int sal){
		return empservice.getSalList(jobName, sal);
	}
	@GetMapping("/emp/sal/{sal}")
	public List<EmpVO> callOverSal(@PathVariable("sal")int sal){
		return empservice.getOverSalList(sal);
	}
	@GetMapping("/emp/mgr")
	public List<EmpVO> callmgr(){
		return empservice.getMgrList();	
	}
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> callOverHiredate(@PathVariable("year")String year){
		return empservice.getOverHiredateList(year);
	}
	
	@GetMapping("/emp/hiredate/month/{month}")
	public List<EmpVO> callMonth12(@PathVariable("month")String month){
		return empservice.getMonth12List(month);
	}
	@GetMapping("/emp/job/{jobName}")
	public List<EmpVO> calljob(@PathVariable("jobName")String jobName){
		return empservice.getJobList(jobName);
	}
}
