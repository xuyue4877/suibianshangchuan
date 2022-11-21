package com.bjpn.bean;

import java.util.Objects;

public class Emp {
    private Integer empNo;
    private String empName;
    private String empJob;
    private String empPhoto;//头像
    private String empHiredate;//入职日期
    private Double empSal;
    private Integer deptNo;

    public Emp() {
    }

    public Emp(Integer empNo, String empName, String empJob, String empPhoto, String empHiredate, Double empSal, int deptNo) {
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.empPhoto = empPhoto;
        this.empHiredate = empHiredate;
        this.empSal = empSal;
        this.deptNo = deptNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpPhoto() {
        return empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }

    public String getEmpHiredate() {
        return empHiredate;
    }

    public void setEmpHiredate(String empHiredate) {
        this.empHiredate = empHiredate;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return deptNo == emp.deptNo &&
                Objects.equals(empNo, emp.empNo) &&
                Objects.equals(empName, emp.empName) &&
                Objects.equals(empJob, emp.empJob) &&
                Objects.equals(empPhoto, emp.empPhoto) &&
                Objects.equals(empHiredate, emp.empHiredate) &&
                Objects.equals(empSal, emp.empSal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, empName, empJob, empPhoto, empHiredate, empSal, deptNo);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", empJob='" + empJob + '\'' +
                ", empPhoto='" + empPhoto + '\'' +
                ", empHiredate='" + empHiredate + '\'' +
                ", empSal=" + empSal +
                ", deptNo=" + deptNo +
                '}';
    }
}
