package edu.home.hibernate.app1;

import java.io.Serializable;

public class Student
        implements Serializable {

    private static final long serialVersionUID = 1L;
    private int sno;
    private String sname;
    private String email;
    private long mobile;

    public Student() { // default constructor
    }

    // Generate one pair of setter and getter methods
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
