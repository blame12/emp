package com.qfedu.dao;

import com.qfedu.entity.Emp;

import java.util.List;

public interface EmpDao {
    public List<Emp> selectAll(Integer page,Integer pageSize);
    public long selectCount();
    public int delete(Integer id);
    public int update(Emp emp);
    public Emp select(Integer id);
    public int insert(Emp emp);
}
