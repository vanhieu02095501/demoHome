package com.fsofter.home.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;


public class ProjectDTO {

    private Integer projectId;

    @NotBlank(message = "Project name cannot be empty")
    @Size(max = 30, message = "Project name must be at most 30 characters")
    private String projectNm;

    @NotNull(message = "Department is required")
    private Integer deptId;

    @NotBlank(message = "Difficulty is required")
    @Size(min = 1, max = 1, message = "Difficulty must be a single character")
    private String difficulty;

    private LocalDate insTm; // Ngày tạo
    private LocalDate updTm; // Ngày cập nhật
    private Integer version; // Phiên bản

    private String deptName; // Tên phòng ban để hiển thị

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectNm() {
        return projectNm;
    }

    public void setProjectNm(String projectNm) {
        this.projectNm = projectNm;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public LocalDate getInsTm() {
        return insTm;
    }

    public void setInsTm(LocalDate insTm) {
        this.insTm = insTm;
    }

    public LocalDate getUpdTm() {
        return updTm;
    }

    public void setUpdTm(LocalDate updTm) {
        this.updTm = updTm;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
