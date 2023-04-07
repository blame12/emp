package com.qfedu.dao;

import com.qfedu.entity.EmpManager;
import com.qfedu.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmpManagerDaoImpl implements EmpManagerDao{
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    @Override
    public EmpManager select(String username,String password) {
        try {
            return queryRunner.query("select * from EmpManager where username=? and password=?", new BeanHandler<>(EmpManager.class), username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
