package GradedProject2;
import java.util.Scanner;
import GradedProject1.UserLogin;
public class MainApplication {
	public static void main(String[] args) throws Exception {
 		
		Scanner sc = new Scanner(System.in);
		int choice = 0,ch,ch1;
		UserLogin userLog = new UserLogin();
			
			do {
				System.out.println(" #### Select option:  ####");
				System.out.println("1. Admin");
				System.out.println("2. Customer");
				System.out.println("0. Logout");

				System.out.println("Enter ur choice :");

				ch=sc.nextInt();

				switch(ch){
				
				case 1:   
					
					do {
					System.out.println("***** Welcom Admin *****");
					
					System.out.println(" #### Select option:  ####");
					System.out.println("1. Login");
					System.out.println("0. Logout");
					ch=sc.nextInt();
					
					switch(ch) {
					
					case 1:
						//Amin login
						userLog.adminLogin();
						break;
					
					case 0:
						//Admin Logout
						System.out.print("You have logged out!!");
						break;
					
					default:  
						System.out.println("Invalid Input......");
					}					
					}while(ch != 0);
					break;
				
				case 2: 
					
					do {
						
					 
						System.out.println("***** Welcom Customer *****");
					
						System.out.println(" #### Select option:  ####");
						System.out.println("1. Register");
						System.out.println("2. Login");
						System.out.println("0. Logout");
						ch1=sc.nextInt();
					
					
						switch(ch1) {
					
						case 1:
							//Cus login
							userLog.register();
							break;
					
						case 2:
							userLog.customerLogin();
							//cus Login
							break;
					
						case 3:
							//Cus Logout
							System.out.print("You have logged out!!");
							break;
						
						default:  
							System.out.println("....Thanks for shopping...");
						}
					
					}while(ch1 != 0);
					
					break;
				
				case 0:  
					System.out.print("You have logged out!!");
					break;
				
				default:  
						System.out.println("....Thanks....");
					}
			}
			while(choice != 0);
		
		}
	}




