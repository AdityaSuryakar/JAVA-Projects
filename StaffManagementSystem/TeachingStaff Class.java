package com.dkte;

//inherited class or sub-class.
class TeachingStaff extends Staff 
{
    private int noOfHours;
    private double chargesPerHour;

    public TeachingStaff(int id, String name, int noOfHours, double chargesPerHour) throws StaffException{
        super(id, name);
        if(noOfHours<=0 || chargesPerHour<=0) 
        {
            throw new StaffException("teaching staff:hours and charges per hour should be greater than zero");
        }
        this.noOfHours=noOfHours;
        this.chargesPerHour=chargesPerHour;
    }

    public int getNoOfHours() 
    {
        return noOfHours;
    }
    public void display() 
    {
        System.out.println("TeachingStaff[ID:"+id+",Name:"+name+
                ", Hours:"+noOfHours+",Charges per hour:"+chargesPerHour+"]");
    }
}
	


