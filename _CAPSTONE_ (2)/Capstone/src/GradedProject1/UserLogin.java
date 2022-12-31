package GradedProject1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import GradedProject3.Product;
 import GradedProject3.User;
 public class UserLogin {									//Users Login Class
	 Scanner sc = new Scanner(System.in);
		Product p1 = new Product();
		User user = new User();
		int i;

		
	public void register() throws ClassNotFoundException, SQLException {		//Method register for Customers
				
		String url = "jdbc:mysql://localhost:3306/ProductDetails";				//Url of Database
		String username = "root";												//DataBase Username
		String password = "root";												//Database Password
				
		Connection con = DriverManager.getConnection(url,username,password);
				
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
					
		 	Statement st = con.createStatement();
			ResultSet rs;
			PreparedStatement ps;
					
			System.out.println("Register Here !!!!");							//Registration
				
			System.out.println("Enter Username :");
			user.setUserName(sc.next());
			System.out.println("Enter Email Id :");
			user.setEmailId(sc.next());
			System.out.println("Enter Password :");
			user.setPassword(sc.next());
			user.setSuperCoin(100);
				
			String qry = "insert into user(username,emailId,password,superCoins)values(?,?,?,?)"; 
			ps = con.prepareStatement(qry);										//Query to store Registration Details in DataBase
				
				
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getEmailId());
			ps.setString(3,user.getPassword()); 
			ps.setInt(4,user.getSuperCoin());
			int i =ps.executeUpdate();
				
		}
		catch(SQLException s) {
					
			 s.printStackTrace();

		}
				
		if(i != 1) {
			
			System.out.println("Registration Successful!!!!!");

			System.out.println("Congraulation !!!! You recived 100 SuperCoin Bonus**** ");
		}else {
			
			System.out.println("Registration Unsuccessful!!!!");
		}
			
	}
				
				
				 
			 
				
		public void adminLogin() throws Exception {					//
				
			String username = "admin";
			String password = "admin";
			String email= "admin";
				
			System.out.println("Admin Login Here !!!!");
			System.out.println("Admin Credientiles are Set as username ='admin', emailId= 'admin',password = 'admin'");
			System.out.println("Enter the Username : ");
			username = sc.next();
				
			System.out.println("Enter Email Id :");
			email = sc.next();
			
			System.out.println("Enter the Password : ");
			password = sc.next();
				
				 
			if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
				
				StoreInformation si = new StoreInformation();
				int ch ;
								
				do {
					   
					System.out.println("#### Store Management System #####");
					System.out.println("1.Add the Products ");
					System.out.println("2.Display All Products ");	
					System.out.println("3.Search Product ");						
					System.out.println("4.Display Product by category ");						
					System.out.println("5.Search Product by Name And View Details ");
					System.out.println("6.Delete Product");
					System.out.println("7.Total Amount Spent ");
					System.out.println("8.Display Profit ");
					System.out.println("0.Exit");
					
					System.out.println("Enter ur choice :");
					ch = sc.nextInt();
								
									
					switch(ch) {
									
						case 1: 
							si.addProduct();
							break;
									
						case 2:
							si.dispAllProducts();
							break;
					
						case 3:
							si.searchProdById();
							break;
									
						case 4:
							si.searchByCategory();
							break;

						case 5:
							si.searchByName();
							break;
						
						case 6:
							si.delProduct();
							break;
									
						case 7:
							si.totalMoneySpent();
							break;
							
						case 8:
							si.totalProfit();
							break;
										
						case 0:
							System.out.println("Program Exit!!!");
							break;
										
						default:
							System.out.println("Wrong Choice Enetred.... Try Again ");
								
					}
				}while(ch != 0);
				
			}
							
			
	}
					

		
	public void customerLogin() throws Exception{
				 
			//String s1,s2;
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
			Class.forName("com.mysql.cj.jdbc.Driver");
							 
			System.out.println("Customer Login Here !!!!");
	 		System.out.println("Enter the Username : ");
			String Username = sc.next();
			System.out.println("Enter Email Id :");
			String EmailId= sc.next();
			System.out.println("Enter the Password : ");
			String Password = sc.next();
			
			String s="select * from user where username =? & password=?";
			//s1 = "Select * from user where username='"+Username+"' AND password='"+Password+"'";
			//s2 = "select * form user where password ="+ Password;
			
			//Statement st = con.createStatement();
			//PreparedStatement ps = con.prepareStatement(s1);
			PreparedStatement p= con.prepareStatement(s);
			p.setString(1, Username);
	        p.setString(2, Password);
	        
	        ResultSet rs=p.executeQuery();
			//ResultSet rs = st.executeQuery(s1);
			//ResultSet rs1 = st.executeQuery(s2);
						
			//String username = null;
		//	String password = null;
			 				
			//Statement st1 = con.createStatement();
			   // ResultSet rs = st1.executeQuery(s1);
			    
			   
				/*while(rs.next())
				{		
					 
					 String username = rs.getString(1);
					user.setUserName(username);
					String emailId = rs.getString(2);
					user.setEmailId(emailId);
					 
					String password = rs.getString(3);
					user.setPassword(password);
					int superCoin = rs.getInt(4);
					user.setSuperCoin(superCoin);
				      
					int i = 1;
				}
				
				if(Username.equals(user.getUserName()) && Password.equals(user.getPassword())) {*/
			    if(rs!=null) {		
					UserDataImp u1 = new UserDataImp();
					int ch1;
						
					do {
						System.out.println("----------------------------------------");
						System.out.println("****** Welcome To Store ********");
						System.out.println("----------------------------------------");
						System.out.println("1.Display All Products ");
						System.out.println("2.Filter for category ");	
						System.out.println("3.Filter for Price ");						
						System.out.println("0.Exit ");						
						ch1 = sc.nextInt();
									
						switch(ch1) {
										
							case 1:
								 u1.dispAllProducts();
								break;
									
							case 2:
								//	u1.filterByCatergory();
								break;
										
							case 3:
								//u1.filterByPrice();
								break;
										
							case 0:
								System.out.println("Program Exit!!!");
								break;
									
							default:
								System.out.println("Wrong Choice Enetred.... Try Again ");
									
							}
						}while(ch1 != 0);

					}
					else {
					
						System.out.println("----- Enter Valid Credientles -----");
						
						}
						
			}
			
		
				
			
	}
		
		