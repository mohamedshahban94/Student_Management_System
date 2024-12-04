package miniproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InstitutionLogin {
	
	Scanner sc =new Scanner(System.in);
	ArrayList<InstitutionData> institutelist =new ArrayList<InstitutionData>(); 
	
	ArrayList<StudentData> studentlist = new ArrayList<StudentData>();
	
	public InstitutionLogin() 
	{
		institutelist.add(new InstitutionData("admin1","password1"));
		institutelist.add(new InstitutionData("admin2","password2"));
		
		HashMap<String,Integer> marks = new HashMap<String,Integer>(); 
		marks.put("English     ", 50);
		marks.put("Tamil       ", 80);
		marks.put("Mathematics ", 50);
		marks.put("Science     ", 75);
		marks.put("Social      ", 60);
		
		studentlist.add(new StudentData("2115","Mohamed shahban","01-10-2003",marks,1));
		studentlist.add(new StudentData("2116","Ram ","04-03-2003",marks,2));
	}

//	-----------------------Admin Register Method-------------------------------------------------
	
	public void register() 
	{
		
		System.out.print("  Create UserID : ");
		String newid= sc.next();
		System.out.print("  Create a password : ");
		String newpass= sc.next();
		boolean check = true;
		for(InstitutionData data : getdata()) 
		{
			if((data.getUserId().equals(newid)) ) 
			{
				check = false;
			}			
		}
		if(check == true) 
		{
			institutelist.add(new InstitutionData(newid,newpass));
			System.out.println("Successfully created\n");
			
		}
		else 
		{
			System.out.println("***Existing UserID create new ID***\n");
		}
	}
//	-------------Get arraylist method ---------------------------------------------------------------------------
	public ArrayList<InstitutionData> getdata()
	{
		return institutelist;
	}
	public ArrayList<StudentData> getstudentdata()
	{
		return studentlist;
	}
//	-----------------------Admin Login Method------------------------------------------------------------
	
	public void login()
	{
		System.out.print("  Enter UserID :");
		String givenid = sc.next();
		System.out.print("  Enter Password :");
		String givenpass =sc.next();
		boolean check =true;
		for(InstitutionData data : getdata()) 
		{
			if(data.getUserId().equals(givenid) && data.getPassword().equals(givenpass))
				{
				check =false;
				while(true) 
				{
					System.out.println("1---Add student data \n2--Update Student data\n3--Exit\n");
					int choice =0;
					try {choice=sc.nextInt();}catch(InputMismatchException e){System.out.println(e); sc.next(); System.out.println("Make Correct Choice: "); choice=sc.nextInt();}
					
					if(choice==1)
					{
						addstudent();
					}
					else if(choice==2)
					{
						updatestudent();
					}
					else if(choice==3) 
					{
						break;
					}
					else 
					{
						System.out.println("Invalid Input");
						break;
					}
					break;
				}
				}
		}
		if(check ==true) 
		{
			System.out.println("------Invalid input--------");
			
		}
	}
	

//	-----------------------add student Method------------------------------------------------------------
	
	public void addstudent() 
	{   int sem = 0;
		System.out.print("Add Register ID:");
		String r_id = sc.next();
		System.out.print("Add Name:");
		String name=sc.next();
		System.out.print("Add DOB:");
		String dob=sc.next();
		System.out.print("Add Semester:");
		try {sem=sc.nextInt();}catch(InputMismatchException e) 
		{System.out.println(e);
		sc.next();
		System.out.print("Add Semester:");
		sem = sc.nextInt();
		}
		
		
		HashMap<String,Integer> marks = new HashMap<String,Integer>(); 
		String subjects[]= {"English     ","Tamil       ","Mathematics ","Science     ","Social      "};
		String sub[]= {"English","Tamil","Mathematics","Science","Social"};
		for(int i=0;i<=4;i++) 
		{
			System.out.println("Enter "+ sub[i]+" Mark :");
			Integer val = sc.nextInt();
			marks.put(subjects[i],val);
		}
		boolean check =true;
		for(StudentData data : getstudentdata()) 
		{
			if(data.getRegisterID().equals(r_id)) 
			{
				check =false;
				break;
			}
		}
		if(check == true) 
		{
			studentlist.add(new StudentData(r_id,name,dob,marks,sem));
			System.out.println("----Added successfully----/n");
		}else 
		{
			System.out.println("***Existing RegisterID create new ID for student***\n");
		}
	}
//	-----------------------update student Method---------------------------------------------------
	public void updatestudent() 
	{	
		System.out.print("verify Register ID: ");
		String r_id = sc.next();	
		for(StudentData data : getstudentdata()) 
		{
			if(data.getRegisterID().equals(r_id)) 
			{
				while(true) 
				{
					System.out.println(" 1--Update Student Name");
					System.out.println(" 2--Updte Student DOB   ");
					System.out.println(" 3--Update Semester");
					System.out.println(" 4--Exit\n\n");
					int u_option = 0;
					try {u_option=sc.nextInt();}catch(InputMismatchException e){System.out.println(e); sc.next(); System.out.println("Make Correct Choice: "); u_option=sc.nextInt();}
					
					switch(u_option) 
					{
					case 1:
						System.out.print("Enter New Name: ");
						String newname = sc.nextLine();
						data.setName(newname);
						System.out.println("successfull updated...");
						break;
					case 2:
						System.out.print("Enter New Dob: ");
						String newdob = sc.next();
						data.setDob(newdob);
						System.out.println("successfull updated...");
						break;
					case 3:
						System.out.print("Enter New Semester: ");
						int newsem = sc.nextInt();
						data.setSem(newsem);
						System.out.println("successfull updated...");
						break;
					case 4:
						break;
					default:
						System.out.println("Invalid Input");
						break;
					}
					break;
				}
			}
		}
	}
//	-----------------------student Menu Method---------------------------------------------------
	public void studentmenu() 
	{ 
		System.out.println("\n|             ----- MENU -----                    |");
		System.out.println("|            1--Student Details                   |");
		System.out.println("|            2--Student Report                    |");
		System.out.println("|            3--Student Grade                     |");
		System.out.println("|            4--Exit                              |\n\n");

	}

//	----------------------- student report Method---------------------------------------------------

	public void studentreport(String givenr_id,String givendob) 
	{
		for(StudentData data : getstudentdata()) 
		{
			if(data.getRegisterID().equalsIgnoreCase(givenr_id) && data.getDob().equals(givendob)) 
			{	
				System.out.println("|=================================================|");
				System.out.println("|                 STUDENT REPORT                  |");
				System.out.println("|=================================================|");
				System.out.println("|                                                 |");
				System.out.println("|          Registeration ID : "+ data.getRegisterID());
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                                                 |");
				data.getMarksFormat();
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|\n\n");			
			}
		}
	}
//	----------------------- student details Method---------------------------------------------------
	public void studentdetails(String givenr_id,String givendob) {
		for(StudentData data : getstudentdata()) 
		{
			if(data.getRegisterID().equalsIgnoreCase(givenr_id) && data.getDob().equals(givendob)) 
			{	
				System.out.println("|=================================================|");
				System.out.println("|                 STUDENT REPORT                  |");
				System.out.println("|=================================================|");
				System.out.println("|                                                 |");
				System.out.println("|          Student Name : "+ data.getName());
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                                                 |");
				System.out.println("|          Registeration ID : "+ data.getRegisterID());
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                                                 |");
				System.out.println("|          Date-Of-Birth : "+ data.getDob());
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                                                 |");
				System.out.println("|          Current Semester : "+ data.getSem());
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");	
			}	
		}
	}
//	----------------------- student grade Method---------------------------------------------------
	public void studentgrade(String givenr_id,String givendob) {
	
		for(StudentData data : getstudentdata()) 
		{
			if(data.getRegisterID().equalsIgnoreCase(givenr_id) && data.getDob().equals(givendob)) 
			{	
				System.out.println("|=================================================|");
				System.out.println("|                 STUDENT GRADE                   |");
				System.out.println("|=================================================|");
				System.out.println("|                                                 |");
				System.out.println("|          Registeration ID : "+ data.getRegisterID());
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                                                 |");
				System.out.println("|          Total Average    : "+ data.getTotalMarks());
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                                                 |");
				System.out.println("|          OverAll Grade    : "+ data.getgrade((data.getTotalMarks()/5)));
				System.out.println("|                                                 |");
				System.out.println("|-------------------------------------------------|");

			}	
		}
	}
	
//	----------------------------------------------------------------------------------------------
	
}
