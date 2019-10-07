package com.amlane.webemployees;

import java.util.concurrent.atomic.AtomicLong;

public class Employee
{
    private static final AtomicLong counter = new AtomicLong(); // spring version of maxId
    // static = every child of this object shares this value
    // final = once initialized, don't allow it to change

    private long id;
    private String fname;
    private String lname;
    private double salary;
    private boolean has401k;
    private int companyID;
    private int healthPlanID;

    public Employee(String fname, String lname, double salary, boolean has401k, int companyID, int healthPlanID)
    {
        this.id = counter.incrementAndGet();
        // this is just like this.id = maxId++

        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.has401k = has401k;
        this.companyID = companyID;
        this.healthPlanID = healthPlanID;
    }

    public Employee(Employee toClone)
    {
        this.id = toClone.getId();
        // this is just like this.id = maxId++

        this.fname = toClone.getFname();
        this.lname = toClone.getLname();
        this.salary = toClone.getSalary();
        this.has401k = toClone.isHas401k();
        this.companyID = toClone.getCompanyID();
        this.healthPlanID = toClone.getHealthPlanID();
    }


    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public boolean isHas401k()
    {
        return has401k;
    }

    public void setHas401k(boolean has401k)
    {
        this.has401k = has401k;
    }

    public int getCompanyID()
    {
        return companyID;
    }

    public void setCompanyID(int companyID)
    {
        this.companyID = companyID;
    }

    public int getHealthPlanID()
    {
        return healthPlanID;
    }

    public void setHealthPlanID(int healthPlanID)
    {
        this.healthPlanID = healthPlanID;
    }

    @Override
    public String toString()
    {
        return "Employee{" + "id=" + id + ", fname='" + fname + '\'' + ", lname='" + lname + '\'' + ", salary=" + salary + ", has401k=" + has401k + ", companyID=" + companyID + ", healthPlanID=" + healthPlanID + '}';
    }
}
