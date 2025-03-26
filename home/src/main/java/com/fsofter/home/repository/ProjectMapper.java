package com.fsofter.home.repository;

import com.fsofter.home.model.Project;
import org.apache.ibatis.annotations.*;

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
       COALESCE(#{keyword}, '') = '' OR p.project_id = #{keyword} 
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

//    @Insert("""
//        INSERT INTO projects (project_nm, dept_id, difficulty, ins_tm, upd_tm, version)
//        VALUES (#{projectNm}, #{deptId}, #{difficulty}, NOW(), NOW(), 1)
//    """)
//    @Options(useGeneratedKeys = true, keyProperty = "project.projectId")
//    void insertProject(Project project);
    @Insert("""
    INSERT INTO projects (project_nm, dept_id, difficulty, ins_tm)
    VALUES (#{project.projectNm}, #{project.deptId}, #{project.difficulty}, NOW())
""")
    @Options(useGeneratedKeys = true, keyProperty = "project.projectId")
    void insertProject(@Param("project") Project project);

    @Update("""
    UPDATE projects 
    SET project_nm = #{project.projectNm}, 
        dept_id = #{project.deptId}, 
        difficulty = #{project.difficulty}, 
        upd_tm = NOW(), 
        version = version + 1
    WHERE project_id = #{project.projectId}
""")
    void updateProject(@Param("project") Project project);


    @Delete("DELETE FROM projects WHERE project_id = #{projectId}")
    void deleteProject(@Param("projectId") int projectId);


    @Select("SELECT p.project_id, p.project_nm, p.dept_id, p.difficulty, p.ins_tm, p.upd_tm, p.version, d.dept_nm " +
            "FROM projects p LEFT JOIN departments d ON p.dept_id = d.dept_id " +
            "WHERE p.project_id = #{projectId}")
    @Results({
            @Result(property = "projectId", column = "project_id"),
            @Result(property = "projectNm", column = "project_nm"),
            @Result(property = "deptId", column = "dept_id"),
            @Result(property = "difficulty", column = "difficulty"),
            @Result(property = "insTm", column = "ins_tm"),
            @Result(property = "updTm", column = "upd_tm"),
            @Result(property = "version", column = "version"),
            @Result(property = "deptName", column = "dept_nm") // Mapping dept_nm từ bảng departments
    })
    Project findById(@Param("projectId") int projectId);
}
