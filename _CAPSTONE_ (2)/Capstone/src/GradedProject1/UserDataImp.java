package GradedProject1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
import GradedProject3.Product;
public class UserDataImp {
	Scanner sc = new Scanner(System.in);
	Product prod = new Product();
	StoreInformation s1 = new StoreInformation();
	
//All required methods for Customer
	
public void dispAllProducts() throws Exception{						//Displaying Product with Details
		
	try {
			
	
		Class.forName("com.mysql.cj.jdbc.Driver");
	        
		Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");

		String qry = "select * from products;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
				

		while(rs.next()) {		
						
			int prodId = rs.getInt(1);
						 
			prod.setProdId(prodId);
			String prodName = rs.getString(2);
			prod.setProdName(prodName);
			double sellingPrice = rs.getDouble(3);
			prod.setSellingPrice(sellingPrice);
			String category = rs.getString(4);
			prod.setCategory(category);
			int availQuantity = rs.getInt(5);
			prod.setAvailQuantity(availQuantity);
			double buyingPrice = rs.getDouble(6);
			prod.setBuyingprice(buyingPrice);
					
			System.out.println("Product ID: "+prodId+"\tProduct Name: "+prodName+"\tSelling Price:"+sellingPrice+"\tCategory :"+category+"\tAvailable Quantity :"+availQuantity+"\tBuying Price :"+buyingPrice);       
			
		}
					
		rs.close();
		st.close();
		con.close();
				
		}catch(SQLException s) {
				
			System.out.println(s);
			
		}	 
	
}


	
public void filterByCategory() throws ClassNotFoundException {
	
	System.out.println("Enter the product Category to be searched: ");
	String prodcategory=sc.next();    
	

	Class.forName("com.mysql.cj.jdbc.Driver");
     
	
		 
	try {

		Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
	Statement st = con.createStatement();
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	String qry = "select category from products where category="+ prodcategory;
	ps = con.prepareStatement(qry);
	
	List l1=new ArrayList();
	
	while(rs.next())
	{					
		String category= rs.getString(4);
		prod.setCategory(category);
		l1.add(category);
	    
	}

	Stream<Product>filtered_data= l1.stream().filter(s->((Product) s).getCategory().equals(prodcategory));
											filtered_data.forEach(
			p->System.out.println(p.toString())
			);
	



rs.close();
st.close();
con.close();
}
catch(SQLException e) {		
e.printStackTrace();
}

}
	
public void buyProduct() {
	
	System.out.println("******* START SHOPPING ******");
	
	
}
 
}


