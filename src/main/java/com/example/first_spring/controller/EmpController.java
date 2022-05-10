package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	//emp 테이블에 insert
	//PostMapping : 중요한 정보를 보내거나 데이터를 많이 보낼때 post를 사용한다
	//@RequestBody가 파라미터로 넘어오는 VO를 클래스 대신 new 해줌
	@PostMapping("/emp")
	public int callEmpSet(@RequestBody EmpVO empVO) {
		System.out.println("사원 번호는 "+empVO.getEmpno());
		System.out.println("사원 이름은 "+empVO.getEname());
		System.out.println("사원 부서번호는 "+empVO.getDeptno());
		System.out.println("사원 급여는 "+empVO.getSal());
		System.out.println("사원 직업은 "+empVO.getJob());
		return empservice.setEmp(empVO);
	}
	
	//@deleteMapping : 자원 삭제시 사용
	@DeleteMapping("/emp/empno/{empNo}")
	public int callEmpRemove(@PathVariable("empNo")int empNo) {
		return empservice.getEmpRemoveCount(empNo);
	}
	
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO empVO) {
		return empservice.getEmpUpdateCount(empVO);
	}
	//쿼리스트링으로 getmapping
	//tier?region=kr
	//검색할때 많이 사용
	@GetMapping("/tier")
	public String callTier(@RequestParam("region") String region,@RequestParam("name") String name) {
		return region+","+name;
	}
	//borad?page=1pageSize=10&writer=현상원
	@GetMapping("/borad")
	public int callBorad(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("writer") String writer) {
		System.out.println("현재 페이지"+page);
		System.out.println("페이지 크기"+pageSize);
		System.out.println("작성자"+writer);
		return 0; 
	}
	@GetMapping("/emp/name/count")
	public int callName (@RequestParam("serch") String serch) {
		System.out.println(serch);
		return empservice.getCountName(serch);
	}
}