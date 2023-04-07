package com.qfedu.dao;

import com.qfedu.entity.Emp;
import com.qfedu.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao{
    private final QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());
    @Override
    public List<Emp> selectAll(Integer page,Integer pageSize) {
        try {
            return queryRunner.query("select * from EMP limit ?,?", new BeanListHandler<>(Emp.class),page,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long selectCount() {
        try {
            return queryRunner.query("select count(id) from EMP",new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        try {
            return queryRunner.update("delete from EMP where id=?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Emp emp) {
        try {
            return queryRunner.update("update EMP set name=?,salary=?,age=? where id=?",emp.getName(),emp.getSalary(),
                    emp.getAge(),emp.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Emp select(Integer id) {
        try {
            return queryRunner.query("select * from EMP where id=?", new BeanHandler<>(Emp.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Emp emp) {
        try {
            return queryRunner.update("insert into EMP (name,salary,age) value (?,?,?)", emp.getName(),
                    emp.getSalary(),emp.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
