package com.fsofter.home.repository;

import com.fsofter.home.model.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("""
    SELECT 
        p.project_id AS projectId, 
        p.project_nm AS projectNm, 
        p.dept_id AS deptId, 
        p.difficulty AS difficulty, 
        p.ins_tm AS insTm, 
        p.upd_tm AS updTm, 
        p.version AS version, 
        d.dept_nm AS deptName
    FROM projects p
    LEFT JOIN departments d ON p.dept_id = d.dept_id
    WHERE (
        #{keyword} IS NULL OR p.project_id = #{keyword} 
        OR p.project_nm LIKE CONCAT('%', #{keyword}, '%')
        OR d.dept_nm LIKE CONCAT('%', #{keyword}, '%')
        OR p.difficulty = #{keyword}
    )
    ORDER BY p.ins_tm DESC
    LIMIT #{limit} OFFSET #{offset}
""")
    List<Project> searchProjects(@Param("keyword") String keyword,
                                 @Param("limit") int limit,
                                 @Param("offset") int offset);


    @Select("""
        SELECT COUNT(*) FROM projects p
        LEFT JOIN departments d ON p.dept_id = d.dept_id
        WHERE (
            #{keyword} IS NULL OR p.project_id = #{keyword} 
            OR p.project_nm LIKE CONCAT('%', #{keyword}, '%')
            OR d.dept_nm LIKE CONCAT('%', #{keyword}, '%')
            OR p.difficulty = #{keyword}
        )
    """)
    int countProjects(@Param("keyword") String keyword);

}
