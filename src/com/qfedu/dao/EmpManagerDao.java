package com.qfedu.dao;

import com.qfedu.entity.EmpManager;

public interface EmpManagerDao {
    public EmpManager select(String username,String password);
}
