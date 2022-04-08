package monprojet.model;

import java.util.Date;

public class Employee {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hireDate;
    private int sal;
    private int com;
    private int deptno;

    public Employee(int empno, String ename, String job, int mgr, Date hireDate, int sal, int com, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.com = com;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getCom() {
        return com;
    }

    public void setCom(int com) {
        this.com = com;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("empno=").append(empno);
        sb.append(", ename='").append(ename).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", mgr=").append(mgr);
        sb.append(", hireDate=").append(hireDate);
        sb.append(", sal=").append(sal);
        sb.append(", com=").append(com);
        sb.append(", deptno=").append(deptno);
        sb.append('}');
        return sb.toString();
    }
}
