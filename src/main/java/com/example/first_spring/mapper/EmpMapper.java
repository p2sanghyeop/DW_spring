package com.example.first_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.first_spring.vo.EmpVO;

@Mapper
public interface EmpMapper {
    //emp테이블 전체 사원조회
	public List<EmpVO> getEmpList();
	public EmpVO getEmp(int empNo);
	public List<EmpVO> getName();
	public List<EmpVO> getComm();
	public List<EmpVO> getHiredate();
	public List<EmpVO> getSal(@Param("jobName") String jobName, @Param("sal") int sal);
	public List<EmpVO> getOverSal(int sal);
	public List<EmpVO> getMgr();
	public List<EmpVO> getOverHiredate(String year);
	public List<EmpVO> getMonth12(String month);
	public List<EmpVO> getJob(String jobName);
	public int insertEmp(EmpVO empVO);//insert
	public int deleteEmp(int empNo);//delete
	public int updateEmp(EmpVO empVO);//update
	public EmpVO selectDeptNo();
	public int countName(String serch);
}
