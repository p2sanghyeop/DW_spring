package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpService {
	@Autowired
	private EmpMapper empmapper;
	
	public List<EmpVO> getAllempList(){
		return empmapper.getEmpList();
	}
	public EmpVO getEmp(int empNo) {
		return empmapper.getEmp(empNo);
	}
	public List<EmpVO> getNameList(){
		return empmapper.getName();
	}
	public List<EmpVO> getCommList(){
		return empmapper.getComm();	
	}
	public List<EmpVO> getHiredateList(){
		return empmapper.getHiredate();
	}
	public List<EmpVO> getSalList(String jobName, int sal){
		if(jobName.equals("SALESMAN")) {
			return null;
		}
		return empmapper.getSal(jobName, sal);
	}
	public List<EmpVO> getOverSalList(int sal){
		return empmapper.getOverSal(sal);
	}
	public List<EmpVO> getMgrList(){
		return empmapper.getMgr();
	}
	public List<EmpVO> getOverHiredateList(String year){
		return empmapper.getOverHiredate(year);
	}
	public List<EmpVO> getMonth12List(String month){
		int max = 0;
		for(int i=0; i<empmapper.getMonth12(month).size(); ++i) {
			if(empmapper.getMonth12(month).get(i).getSal() > max) {
				max = empmapper.getMonth12(month).get(i).getSal();
				empmapper.getMonth12(month).remove(i);
			}
		}
		return empmapper.getMonth12(month);
	}
	public List<EmpVO> getJobList(String jobName){
		return empmapper.getJob(jobName);
	}
}
