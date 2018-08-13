package com.cf.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.cf.bean.Grade;
import com.cf.dao.GradeDao;

@Service
public class GradeService {
	
	@Resource
	private GradeDao gradeDao;
	
	public Grade selectByGradeNm(String gradeNm){
		return gradeDao.selectByGradeNm(gradeNm);
	}
	
	public List<Grade> findAll(){
		return gradeDao.findAll();
	}
	
	public Grade create(Grade grade) {
		return gradeDao.create(grade);
	}
	
	public void update(Grade grade) {
		gradeDao.update(grade);
	}
	
	public void delete(Integer id) {
		gradeDao.delete(id);
	}
}
