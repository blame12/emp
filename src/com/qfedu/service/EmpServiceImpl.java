package com.qfedu.service;

import com.qfedu.dao.EmpDao;
import com.qfedu.dao.EmpDaoImpl;
import com.qfedu.entity.Emp;

import java.util.List;

public class EmpServiceImpl implements EmpService{
    private final EmpDao empDao = new EmpDaoImpl();
    @Override
    public List<Emp> showAllEmp(Integer page,Integer pageSizee) {
        return empDao.selectAll(page,pageSizee);
    }

    @Override
    public long selectCount() {
        return empDao.selectCount();
    }

    @Override
    public int removeEmp(Integer id) {
        return empDao.delete(id);
    }

    @Override
    public int modifyEmp(Emp emp) {
        return empDao.update(emp);
    }

    @Override
    public Emp showEmp(Integer id) {
        return empDao.select(id);
    }

    @Override
    public int insert(Emp emp) {
        return empDao.insert(emp);
    }
}
