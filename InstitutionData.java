package miniproject;

public class InstitutionData {
	
	private String userId;
	private String password;
	public InstitutionData() 
	{
		
	}
	public InstitutionData(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "[userId=" + userId + ", password=" + password + "]";
	}
	
	

}
