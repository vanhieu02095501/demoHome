package com.fsofter.home.converter;

import com.fsofter.home.dto.ProjectDTO;
import com.fsofter.home.model.Department;
import com.fsofter.home.model.Project;
import com.fsofter.home.repository.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverter {

    @Autowired
    private DepartmentMapper departmentMapper;
    public ProjectDTO convertToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setProjectId(project.getProjectId());
        dto.setProjectNm(project.getProjectNm());
        dto.setDeptId(project.getDeptId());
        dto.setDifficulty(project.getDifficulty());
        dto.setInsTm(project.getInsTm());
        dto.setUpdTm(project.getUpdTm());
        dto.setVersion(project.getVersion());



        Department dept = departmentMapper.findById(project.getDeptId());
        if (dept != null) {
            dto.setDeptName(dept.getDeptNm());
        }

        return dto;
    }

}
