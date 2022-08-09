package com.aciel.reggie.service.impl;

import com.aciel.reggie.entity.Employee;
import com.aciel.reggie.mapper.EmployeeMapper;
import com.aciel.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
