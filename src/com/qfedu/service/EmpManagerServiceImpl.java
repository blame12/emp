package com.qfedu.service;

import com.qfedu.dao.EmpManagerDao;
import com.qfedu.dao.EmpManagerDaoImpl;
import com.qfedu.entity.EmpManager;

public class EmpManagerServiceImpl implements EmpManagerService{
    private final EmpManagerDao empManagerDao = new EmpManagerDaoImpl();
    @Override
    public EmpManager login(String username, String password) {
        return empManagerDao.select(username, password);
    }
}
