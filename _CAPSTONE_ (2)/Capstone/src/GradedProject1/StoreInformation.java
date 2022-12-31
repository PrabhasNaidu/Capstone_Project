package GradedProject1;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import GradedProject3.Product;
public class StoreInformation {
	
	Scanner sc = new Scanner(System.in);
	Product prod = new Product();
	int i= 0 ;
	 
	public void addProduct() throws Exception  {				//Add method. To add details in data base 
	
		Product prod = new Product();
		 
		System.out.println("-----Add Product-----");
			
		System.out.println("Enter Product ID :");
		prod.setProdId(sc.nextInt());
		System.out.println("Enter Product Name :");
		prod.setProdName(sc.next());
		System.out.println("Enter the Quantity :");
		prod.setAvailQuantity(sc.nextInt());
		//	System.out.println();
		System.out.println("Enter Product Category : ");
		prod.setCategory(sc.next());
		System.out.println("Enter Product Price :");
		prod.setBuyingprice(sc.nextInt());
		
		double sp = ((prod.getBuyingprice() *0.5)+ prod.getBuyingprice());
		prod.setSellingPrice(sp);
			
		try {	
		Class.forName("com.mysql.cj.jdbc.Driver");				// Register driver
	         
		Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
				 												// Connecting  Code with Database
		
	  
			Statement st = con.createStatement();				//Statement Creation
			ResultSet rs;
			PreparedStatement ps = null;
			
			String qry = "insert into products(prodId,prodName,sellingPrice,category, availQuantity,buyingPrice) values(?,?,?,?,?,?)";
																// Query to insert values in database
			ps = con.prepareStatement(qry);						
			
			
			ps.setInt(1,prod.getProdId());
			ps.setString(2,prod.getProdName());
			ps.setDouble(3,prod.getSellingPrice());
			ps.setString(4,prod.getCategory());
			ps.setInt(5,prod.getAvailQuantity());
			ps.setDouble(6,prod.getBuyingprice());
			i = ps.executeUpdate();
			
			
			}
			catch(SQLException s) {					//Handle Sql Exception 
				
				 s.printStackTrace();
				
			}
			
			 
			if(i != 0) {
			
				System.out.println("Product Added Successfully");
			}else {
				
				System.out.println("Product Not Added");
			}
	 
}
	
public void searchProdById() throws Exception {									// Search Product By Id

	System.out.println("Enter the Product Id to be searched:");
	int serId = sc.nextInt();
	

	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
    
	try { 
		
		
	String qry = "select * from products where prodId="+serId;				//Query to Fetch Data With Given ID
    
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(qry);
    
   
	while(rs.next())
	{		
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
		
		System.out.println("*****Product is Available*****");
		System.out.println("Product ID: "+prodId+"\tProduct Name: "+prodName+"\tSelling Price:"+sellingPrice+"\tCategory :"+category+"\tAvailable Quantity :"+availQuantity+"\tBuying Price :"+buyingPrice);       
		int i = 1;
	}
		
		rs.close();
		st.close();
		con.close();

	}
	catch(SQLException e) {		

		e.printStackTrace();
		
	}
	
	if(i != 1) {
		System.out.println("*****Products is Unavailable*****");
	}
	
}
	 
	 
public void searchByName()throws Exception {								//Search Product By Name

	System.out.println("Enetr the name of Product :");
	String pName = sc.next();
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
		    
	try { 
		
		
		String qry = "select * from products where prodName='"+pName+"'";				//Query to Fetch Data With Given ID
	    
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(qry);
	    
	   
		while(rs.next())
		{		
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
			
			System.out.println("*****Product is Available*****");
			System.out.println("Product ID: "+prodId+"\tProduct Name: "+prodName+"\tSelling Price:"+sellingPrice+"\tCategory :"+category+"\tAvailable Quantity :"+availQuantity+"\tBuying Price :"+buyingPrice);       
			int i = 1;
		}
			
			rs.close();
			st.close();
			con.close();

		}
		catch(SQLException e) {		

			e.printStackTrace();
			
		}
			 
}
	 
	 
	 
	 
public void searchByCategory()throws Exception {				//Get Product By Category
				
		
	System.out.println("Enter the Category(Grocery/Stationary/Toiletry/Vegetable)"); //Entering Category
	String serCategory = sc.next();
	
	Class.forName("com.mysql.cj.jdbc.Driver");
        
	Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
	try { 
		
		
		String qry = "Select * from products where category='"+serCategory+"'";				//Query to Fetch Data With Given ID
	    
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(qry);
	    
	   
		while(rs.next())
		{		
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
			
			System.out.println("*****Products is available*****");
			System.out.println("Product ID: "+prodId+"\tProduct Name: "+prodName+"\tSelling Price:"+sellingPrice+"\tCategory :"+category+"\tAvailable Quantity :"+availQuantity+"\tBuying Price :"+buyingPrice);       
			int i = 1;
		}
			
			rs.close();
			st.close();
			con.close();

		}
		catch(SQLException e) {		

			e.printStackTrace();
			
		}
		 
	if(i != 1) {
	
		System.out.println("*****Product Is Unavailable*****");
	 }

}



public void totalMoneySpent() throws Exception{
	
	double sum = 0.0;
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
        
		Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
		String qry = "select sum(buyingPrice) from product" ;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
	
		sum = rs.getDouble(6);

		System.out.println("Total Amount :" + sum);
		

		rs.close();
		st.close();
		con.close();
	}
	catch(SQLException e) {		
		e.printStackTrace();
	}
 
	
	
}

public void dispAllProducts() throws Exception{
	
	
	try {
		
			
		Class.forName("com.mysql.cj.jdbc.Driver");
        
		Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");

		String qry = "select * from products;";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry);
			

		while(rs.next()){		
					
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
			int i =1;
		}
				
		rs.close();
		st.close();
		con.close();
			
	}catch(SQLException s) {							//Catching SQL Exception
			
			 System.out.println(s);
	}	
	
	if(i != 1) {
		
		System.out.println("*****Products Are Unavailable*****");
	 }
}



 


public void delProduct() throws ClassNotFoundException {					//Deleting Any Particular Product
    
	
	 System.out.println("enter the Id to delete the product:");
	 int delProdId = sc.nextInt();
	
	 Class.forName("com.mysql.cj.jdbc.Driver");

	try{ 
       
		String qry = "delete from products where prodId=?";				//Query To delete Product from Database
    	Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
    	
    	
        PreparedStatement ps = con.prepareStatement(qry);
        ps.setInt(1, delProdId);
                                         
        int i = ps.executeUpdate();
        if (i > 0) {
            System.out.println("Product deleted successfully!");
        }
        else
            System.out.println("Failed to delete data..!");
        
        ps.close();
        con.close();
        
    }catch (SQLException e) {
        e.printStackTrace();
    }
}

		
		
		
	
	
	
public void totalProfit() {
 

	try{ 
       
		Class.forName("com.mysql.cj.jdbc.Driver");
        
		Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProductDetails","root","root");
		
		String qry1 = "select sum(buyingPrice),sum(sellingPrice) from products" ;
		//String qry2 = "select sum(sellingPrice) from product";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(qry1);
		//ResultSet rs2 = st.executeQuery(qry2);

		while(rs.next()) {
			
			

		 		 
		
		
		}
		
		double getSumBP = prod.getBuyingprice();
		double getSumSP =  prod.getSellingPrice();
		
		System.out.println("Total Profit :" + (getSumSP-getSumBP));
		
                                         
       
        rs.close();
       // rs2.close();
        con.close();
        
    }catch (SQLException | ClassNotFoundException e) {
        
    	e.printStackTrace();
    }
	
	
}

}