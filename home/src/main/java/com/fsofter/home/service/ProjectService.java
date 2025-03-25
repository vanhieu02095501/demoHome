package com.fsofter.home.service;


import com.fsofter.home.converter.ProjectConverter;
import com.fsofter.home.dto.ProjectDTO;
import com.fsofter.home.model.Project;
import com.fsofter.home.repository.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectConverter projectConverter;

    public List<ProjectDTO> searchProjects(String keyword, int page, int size) {
        int offset = Math.max(0, (page - 1) * size);
        List<Project> projects = projectMapper.searchProjects(keyword, size, offset);

        List<ProjectDTO> results = projects.stream()
                .map(projectConverter::convertToDTO)
                .collect(Collectors.toList());

        return results;
    }

    public int countProjects(String keyword, int pageSize) {
        int totalRecords = projectMapper.countProjects(keyword);
        return (int) Math.ceil((double) totalRecords / pageSize);
    }

}
