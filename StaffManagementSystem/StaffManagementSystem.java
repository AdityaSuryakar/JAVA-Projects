package com.dkte;

import java.util.Scanner;
public class StaffManagementSystem 
{
    static TeachingStaff[] teachingStaffs=new TeachingStaff[10];
    static LabStaff[] labStaffs=new LabStaff[10];
    static int tCount=0,lCount=0;

    public static void main(String[] args) 
    {
    	 Scanner sc=new Scanner(System.in);
         int choice;

         do{
        	 System.out.println("/n-------Staff Management System-----------");
        	 System.out.println("1)Add teaching staff:");
        	 System.out.println("2)Add lab staff:");
        	 System.out.println("3)Display all teaching staff:");
        	 System.out.println("4)Display all lab staff:");
        	 System.out.println("5)Find specific teaching staff");
        	 System.out.println("6)Find specific lab staff");
        	 System.out.println("7)display teaching staff who worked for highest hours");
        	 System.out.println("8)display lab staff who has lowest salary");
        	 System.out.println("enter the choice:");
        	 choice=sc.nextInt();
        	 try {
        		 switch(choice) 
        		 {
        		 case 1:  //1)add teaching staff
                     if(tCount<teachingStaffs.length) 
                     {
                         System.out.print("Enter id:");
                         int id=sc.nextInt();
                         sc.nextLine();
                         System.out.print("Enter name:");
                         String name=sc.nextLine();
                         System.out.print("Enter hours:");
                         int hours=sc.nextInt();
                         System.out.print("Enter charges per hour:");
                         double charges=sc.nextDouble();
                         teachingStaffs[tCount++] = new TeachingStaff(id,name,hours,charges);
                         System.out.println("Teaching staff added.");
                     } 
                     else 
                     {
                         System.out.println("teaching staff list is full.");
                     }
                     break;
        		 
        		 case 2:  //2)add lab staff
                   if (lCount<labStaffs.length) 
                   {
                       System.out.print("Enter ID: ");
                       int id=sc.nextInt();
                       sc.nextLine();
                       System.out.print("Enter Name: ");
                       String name=sc.nextLine();
                       System.out.print("Enter Salary: ");
                       double salary=sc.nextDouble();
                       labStaffs[lCount++] =new LabStaff(id, name,salary);
                       System.out.println("Lab staff added.");
                   } 
                   else 
                   {
                       System.out.println("the lab staff list is full.");
                   }
                   break;
        		 case 3:   //3)display teaching staff
                  for (int i = 0; i < tCount; i++) 
                  {
                       teachingStaffs[i].display();
                   }
                   break;
                 case 4:     //4)display lab staff
                   for (int i = 0; i < lCount; i++) 
                   {
                       labStaffs[i].display();
                   }
                   break; 
                 case 5:   //5)Find specific teaching staff
                     System.out.print("Enter teaching staff id : ");
                   int tid = sc.nextInt();
                   boolean foundT = false;
                   for (int i = 0; i < tCount; i++) 
                   {
                       if (teachingStaffs[i].id == tid) 
                       {
                           teachingStaffs[i].display();
                           foundT = true;
                           break;
                       }
                   }
                   if (!foundT) System.out.println("Teaching staff not found.");
                   break;
                 case 6:  //6)find specific lab staff
                   System.out.print("Enter lab staff ID to search: ");
                   int lid = sc.nextInt();
                   boolean foundL = false;
                   for(int i = 0; i < lCount; i++) 
                   {
                       if(labStaffs[i].id==lid) {
                           labStaffs[i].display();
                           foundL =true;
                           break;
                       }
                   }
                   if (!foundL) System.out.println("lab staff not found.");
                   break;
               case 7:  //7)display teaching staff who worked for highest hours.
                   if (tCount == 0) 
                   {
                       System.out.println("No teaching staff to evaluate.");
                   } else 
                   {
                       int maxIndex = 0;
                       for(int i = 1; i < tCount; i++) 
                       {
                           if(teachingStaffs[i].getNoOfHours() > teachingStaffs[maxIndex].getNoOfHours()) 
                           {
                               maxIndex = i;
                           }
                       }
                       System.out.println("Teaching staff with highest hours:");
                       teachingStaffs[maxIndex].display();
                   }
                   break;
               case 8: //8.lab staff who has lowest salary
                   if(lCount == 0) 
                   {
                       System.out.println("no lab staff to evaluate.");
                   } 
                   else 
                   {
                       int minIndex = 0;
                       for(int i = 1;i <lCount;i++) 
                       {
                           if(labStaffs[i].getSalary() < labStaffs[minIndex].getSalary()) 
                           {
                               minIndex = i;
                           }
                       }
                       System.out.println("Lab staff with lowest salary:");
                       labStaffs[minIndex].display();
                   }
                   break;
               case 0:
                   System.out.println("exit program.");
                   break;
               default:
                  System.out.println("invalid choice.");
           }
       } 
       catch(StaffException e) 
        {
           System.out.println("error:" + e.getMessage());
       }

   } while (choice != 0);

   sc.close();
 }
}
