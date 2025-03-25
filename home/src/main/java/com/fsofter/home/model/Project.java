package com.fsofter.home.model;

import lombok.*;

import java.time.LocalDate;



public class Project {
    private Integer projectId;
    private String projectNm;
    private Integer deptId;
    private String difficulty;
    private LocalDate insTm;
    private LocalDate updTm;
    private Integer version;

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
}
