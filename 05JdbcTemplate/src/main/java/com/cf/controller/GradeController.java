package com.cf.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cf.bean.Grade;
import com.cf.service.GradeService;

@RestController
@RequestMapping("/grade")
public class GradeController {
	
	@Resource
	private GradeService gradeService;
	
	@RequestMapping("/selectByGradeNm")
	public Grade selectByGradeNm(String gradeNm){
		System.out.println("GradeController.selectByGradeNm()");
		return gradeService.selectByGradeNm(gradeNm);
	}
	
	@RequestMapping("/findAll")
	public List<Grade> findAll(){
		System.out.println("GradeController.findAll()");
		return gradeService.findAll();
	}
	
	@RequestMapping("/create")
	public Grade create(Grade grade) {
		System.out.println("GradeController.create()");
		return gradeService.create(grade);
	}
	
	@RequestMapping("/update")
	public void update(Grade grade) {
		System.out.println("GradeController.update()");
		gradeService.update(grade);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer id) {
		System.out.println("GradeController.delete()");
		gradeService.delete(id);
	}
}
