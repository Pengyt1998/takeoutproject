package com.aciel.reggie.controller;

import cn.hutool.crypto.SecureUtil;
import com.aciel.reggie.common.UserContext;
import com.aciel.reggie.entity.Employee;
import com.aciel.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.aciel.reggie.common.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    // 登录
    @PostMapping("login")
    public R login(HttpServletRequest request, @RequestBody Employee employee){

        // 1. 查询数据库中是否有该用户
        Employee user = employeeService.getOne(new QueryWrapper<Employee>().eq("username", employee.getUsername()));
        if (user == null){
            return R.error("登录失败");
        }
        // 2. 判断密码是否 正确
        String password = SecureUtil.md5(employee.getPassword());
        if (!password.equals(user.getPassword())){
            return R.error("登录失败");
        }

        // 3. 判断用户是否被禁用
        if (user.getStatus() == 0){
            return R.error("登录失败");
        }
        // 4. 返回用户信息，并保存到session中
        request.getSession().setAttribute("employee", user);
        // 将数据写入到threadLocal中
        return R.success(user);
    }
    // 退出登录
    @PostMapping("/logout")
    public R logout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success(null);
    }

    /**
     * 添加员工
     * @return
     */
    @PostMapping
    public R addEmployee(HttpServletRequest request,@RequestBody Employee employee){
        // 1. 查询员工是否储存
        Employee one = employeeService.getOne(new QueryWrapper<Employee>().eq("username", employee));
        if (one != null){
            return  R.error( employee.getUsername() + "用户已经存在");
        }
        // 2. 填写创建用户信息，填写初始化密码
        Employee em = (Employee)request.getSession().getAttribute("employee");
        employee.setPassword(SecureUtil.md5("123456"));
//        employee.setCreateUser(em.getId());
//        employee.setUpdateUser(em.getId());
        // 3.存入到数据库
        employeeService.save(employee);
        return R.success("添加用户成功");
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R page(int page ,int pageSize , String name){
        log.info(UserContext.getUserId().toString());
        // 创建分页
        Page<Employee> pageInfo = new Page<>(page, pageSize);
        QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<>();
        // 添加排序条件
        employeeQueryWrapper.orderByDesc("create_time");
        if(name !=null){
            // 过滤条件
            employeeQueryWrapper.like("name", name);
        }
        // 执行查询
        employeeService.page(pageInfo, employeeQueryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 更改状态
     * @param employee
     * @return
     */
    @PutMapping
    public R changeStatus(@RequestBody Employee employee){
        employeeService.saveOrUpdate(employee);
        return R.success("更新成功");
    }

    /**
     * 根据id 获取员工
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        return R.success(employee);
    }
}
