package miniproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		InstitutionLogin institute =new InstitutionLogin();
		boolean loop= true;
		while(loop) 
		{
		System.out.println("---------Welcome to Anna University Portal---------");
		System.out.println("1--Institution Login \n2--Student Login\n3--Exit"
				+ "");
		int option = 0;
		try {option=sc.nextInt();}catch(InputMismatchException e){System.out.println(e); sc.next(); System.out.println("Make Correct Choice: "); option=sc.nextInt();}
		
		switch(option) 
		{
		case 1:
			int i_option=0;
			System.out.println("  1--Login\n  2--Register");
			try {i_option=sc.nextInt();}catch(InputMismatchException e){System.out.println(e); sc.next(); System.out.println("Make Correct Choice: "); i_option=sc.nextInt();}
			
			if(i_option ==1) 
			{
				institute.login();
			}
			else if(i_option ==2) 
			{
				institute.register();
			}
			else 
			{
				System.out.println("Invalid Data! Try Again...\n");
			}
			break;
		case 2:
			System.out.print("\n  Enter Register-ID :");
			String givenr_id = sc.next();
			System.out.print("  Enter D-O-B:");
			String givendob =sc.next();
			boolean check = true;
			for(StudentData data : institute.getstudentdata()) 
			{
				if(data.getRegisterID().equalsIgnoreCase(givenr_id) && data.getDob().equals(givendob)) 
				{	
					check = false;
					while(true) 
					{
						institute.studentmenu();
						int s_option=sc.nextInt();
						if(s_option ==1) 
						{
							institute.studentdetails(givenr_id,givendob);
						}
						else if(s_option ==2) 
						{
							institute.studentreport(givenr_id,givendob);
							
						}
						else if(s_option ==3) 
						{
							institute.studentgrade(givenr_id,givendob);
						}
						else if(s_option ==4) 
						{
							break;
						}
						else 
						{
							System.out.println("Invalid Input\n");
						}
					}
				}
				
			}
				if(check ==true)
				{
					System.out.println("Invalid Data..Try Again...");
				}
			
			break;
		case 3:
			loop =false;
			break;
		default :
			System.out.println("Invalid Input");
			break;
		
		}
		
		}
		
	}

}
