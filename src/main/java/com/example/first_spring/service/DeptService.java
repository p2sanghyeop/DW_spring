package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.DeptMapper;
import com.example.first_spring.vo.DeptVO;

@Service
public class DeptService {
	@Autowired
	private DeptMapper deptmapper;
	
	public List<DeptVO> getAllDetpList(){
		return deptmapper.getDeptList();
	}
	public int setDept(DeptVO deptVO) {
		int rows = deptmapper.insertDept(deptVO);
		return rows;
	}
	public int getRemoveDept(int deptNo) {
		int rows = deptmapper.deleteDept(deptNo);
		return rows;
	}
	public int getUpdateDept(DeptVO deptVO) {
		int rows = deptmapper.updateDept(deptVO);
		return rows;
	}
	
}
