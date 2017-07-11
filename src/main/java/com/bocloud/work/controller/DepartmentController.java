package com.bocloud.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bocloud.work.entity.Department;
import com.bocloud.work.service.IDepartmentService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private IDepartmentService departmentService;

	@RequestMapping("/test")
	@ResponseBody
	public Department test() {
		Department d = departmentService.selectById(1);
		return d;
	}
}
