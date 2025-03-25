package com.fsofter.home.repository;

import com.fsofter.home.model.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM departments WHERE dept_id = #{deptId}")
    @Results({
            @Result(property = "deptId", column = "dept_id"),
            @Result(property = "deptNm", column = "dept_nm")
    })
    Department findById(@Param("deptId") Integer deptId);


    @Select("SELECT * FROM departments")
    @Results({
            @Result(property = "deptId", column = "dept_id"),
            @Result(property = "deptNm", column = "dept_nm")
    })
    List<Department> findAll();
}