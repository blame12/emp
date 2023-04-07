package com.qfedu.service;

import com.qfedu.entity.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> showAllEmp(Integer page,Integer pageSize);
    public long selectCount();
    public int removeEmp(Integer id);
    public int modifyEmp(Emp emp);
    public Emp showEmp(Integer id);
    public int insert(Emp emp);
}
