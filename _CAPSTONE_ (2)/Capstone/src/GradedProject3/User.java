package GradedProject3;

public class User {
	private String userName;
	private String password;
	private String emailId;
	private int superCoin;
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(String username, String pass, String emailid, int supercoin) {
		super();
		 userName = username;
		 password = pass;
		 emailId = emailid;
		superCoin = superCoin;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getSuperCoin() {
		return superCoin;
	}


	public void setSuperCoin(int superCoin) {
		this.superCoin = superCoin;
	}


 	
	 
}


