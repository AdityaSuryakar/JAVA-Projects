package com.dkte;
//inherited or sub-class
class LabStaff extends Staff {
    private double salary;
    public LabStaff(int id, String name, double salary) throws StaffException 
    {
        super(id, name);
        if (salary <= 0) 
        {
            throw new StaffException("Lab staff: salary should be greater than zero ");
        }
        this.salary = salary;
    }
    public double getSalary() 
    {
        return salary;
    }
    public void display() 
    {
        System.out.println("LabStaff [ID:"+id+",Name:"+name+",Salary:"+salary+"]");
    }
}

