package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.UserVO;

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
		List<EmpVO> list = empmapper.getSal(jobName, sal);
		int comm = 500;
		int rows = 0;
		for(int i=0; i<list.size(); ++i) {
			int empComm = list.get(i).getComm();
			int sum = empComm+comm;
			list.get(i).setComm(sum);
			EmpVO vo = list.get(i);
			rows += empmapper.updateEmp(vo);
		}
		if(rows>0) {
			return empmapper.getSal(jobName, sal);
		}
		return null;
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
		List<EmpVO> list = new ArrayList<EmpVO>();
		list = empmapper.getMonth12(month);
		for(int i=0; i<list.size(); ++i) {
			if(list.get(i).getSal() > max) {
				max = list.get(i).getSal();
				if(i > 0) {
					list.remove(i-1);
					i--;
				}
			}
		}
		return list;
	}
	public List<EmpVO> getJobList(String jobName){
		return empmapper.getJob(jobName);
	}
	@Transactional(rollbackFor = {Exception.class})
	public int setEmp(EmpVO empVO) {
		//emp에 없는 부서번호를 찾아서 해당 부서 번호로 insert 되었는지 리턴
//		EmpVO empVO = empmapper.selectDeptNo();
//		int deptNo = empVO.getDeptno();
//		vo.setDeptno(deptNo);
		
		//1.insert 해야 함
		int rows = empmapper.insertEmp(empVO);//몇행 insert 되었는지 리턴
		return rows;
	}
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empNo) {
		
//		List<EmpVO> list = empmapper.getEmpList();
//		for(int i=0; i<list.size(); ++i) {
////			EmpVO vo = list.get(i);
//			if(list.get(i).getSal()< 3000 && list.get(i).getEmpno() == empNo) {
//				return 0;
//			}
//		}
		int rows = empmapper.deleteEmp(empNo);//몇행 delete 되었는지 리턴
		return rows;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpUpdateCount(EmpVO vo) {		
		int rows = empmapper.updateEmp(vo);//몇행 update 되었는지 리턴
//		UserVO user = null;
//		String name = user.getName();
//		System.out.println(name);
		return rows;
	}
	public int getCountName(String serch) {
		return empmapper.countName(serch);
	}
	public List<EmpVO> getEmpIsMgrList(String isMgr){
		return empmapper.selectEmpMgr(isMgr);
	}
	public EmpVO getNumberList(int empno) {
		List<EmpVO> list = empmapper.getEmpList();
		
		
		return empmapper.getNumber(empno);
	}
	public int getEmpUpdateCount(EmpVO vo, int empNo) {
		vo.setEmpno(empNo);
		return empmapper.updateEmpJobSal(vo);
	}
	public int getUpdateSalCount(int empno) {
		//comm이 0이거나 null이면
		EmpVO vo = empmapper.selectEmpCommSal(empno);
		int comm = vo.getComm();
		if(comm == 0) {
			int bonus = 500;
			int sal =vo.getSal();
			vo.setSal(sal+ bonus);
			//update로직 추가
			return empmapper.updateEmpSal(vo);
		}
		return 0;
	}
}
