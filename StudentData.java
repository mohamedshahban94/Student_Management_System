package miniproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class StudentData {
	
	private String registerID,name,dob;
	private int sem;
	private HashMap<String,Integer> marks;
	public StudentData(String registerID,String name, String dob, HashMap<String,Integer> marks,int sem) {
		
		this.registerID = registerID;
		this.name =name;
		this.dob = dob;
		this.marks= marks;
		this.sem =sem;
	}
	public StudentData(String registerID, String dob) {
		
		this.registerID = registerID;
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "StudentData [registerID=" + registerID + ", name=" + name + ", dob=" + dob + ", sem=" + sem + ", marks="
				+ marks + "]";
	}
//	-----------------------Setter method------------------------------------------
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setSem(int sem) {
		this.sem = sem;
		
	}
	
//	-----------------------Getter method------------------------------------------
	public String getRegisterID() {
		return registerID;
	}
	public String getDob() {
		return dob;
	}

	public HashMap<String, Integer> getMarks() {
		return marks;
	}
	
	public String getName() {
		return name;
	}
	public int getSem() {
		return sem;
	}
	public void getMarksFormat() 
	{
		for(Map.Entry<String, Integer> entry : marks.entrySet()) 
		{
			System.out.println("|             "+entry.getKey()+" : "+entry.getValue()+" : "+getgrade(entry.getValue()));
		}
	} 
	public int getTotalMarks() 
	{
		int total =0;
		for(Map.Entry<String, Integer> entry : marks.entrySet()) 
		{
			 total = total +entry.getValue();
		}
		return total;
		
	} 
//	-----------------------------Grade method-------------------------------------------
	public String getgrade(int findgrade) 
	{
		if(findgrade>90  && findgrade<=100) 
		{
			return "O";
		}
		else if(findgrade>80  && findgrade<=90) 
		{
			return "A";
		}
		else if(findgrade>70  && findgrade<=80)
		{
			return "B";
		}
		else if(findgrade>60  && findgrade<=70) 
		{
			return "C";
		}
		else if(findgrade>45  && findgrade<=60)
		{
			return "D";
		}
		else 
		{
			return "RA";
		}
		
	}

}
