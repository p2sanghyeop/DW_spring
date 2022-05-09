package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.first_spring.vo.DeptVO;

@Mapper
public interface DeptMapper {
	public List<DeptVO> getDeptList();
	public int insertDept(DeptVO deptVO);
	public int deleteDept(int deptNo);
	public int updateDept(DeptVO deptVO);
}
