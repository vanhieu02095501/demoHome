package com.fsofter.home.dto;

import jakarta.validation.constraints.*;
import lombok.*;


public class DepartmentDTO {
    private Integer deptId;

    @NotBlank(message = "Department name is required")
    @Size(max = 20, message = "Department name must be at most 20 characters")
    private String deptNm;


    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }
}
