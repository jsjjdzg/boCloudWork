package com.bocloud.work.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bocloud.work.entity.Department;
import com.bocloud.work.mapper.DepartmentMapper;
import com.bocloud.work.service.IDepartmentService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author DZG
 * @since 2017-07-11
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
}
