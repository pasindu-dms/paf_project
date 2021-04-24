package model;

import java.sql.*; 


public class User {
	
	//A common method to connect to the DB
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usermanage", "root", ""); 
	 } 
	 catch (Exception e) 
	 {e.printStackTrace();} 
	 return con; 
	 } 
	public String insertUserDB(String ID, String Username, String Password , String phoneNumber, String Email, String Address) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for inserting."; } 
	 // create a prepared statement
	 String query = " insert into usermanage 
	 ('id','username','password','phonenumber','email','address')"
	 + " values (?, ?, ?, ?, ?,?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, username); 
	 preparedStmt.setString(3, password); 
	 preparedStmt.setDouble(4, phonenumber); 
	 preparedStmt.setString(5, email); 
	 preparedStmt.setString(6, addreess); 
	// execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while inserting the details."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	public String readItems() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>UserName</th><th>Password</th>" +
	 "<th>PhoneNumber</th>" + 
	 "<th>Email</th>" +
	 "<th>Address</th>" +
	 "<th>Update</th><th>Remove</th></tr>"; 
	 
	 String query = "select * from items"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String id = Integer.toString(rs.getInt("ID")); 
	 String username = rs.getString("UserName"); 
	 String password = rs.getString("Password"); 
	 String phonenumbe =rs.String(rs.getInt("phonenumbe")); 
	 String email = rs.getString("email"); 
	 String addreess = rs.getString("addreess");
	 // Add into the html table
	 output += "<tr><td>" + UserName + "</td>"; 
	 output += "<td>" + Password + "</td>"; 
	 output += "<td>" + phonenumbe + "</td>"; 
	 output += "<td>" + email + "</td>"; 
	 output += "<td>" + addreess + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' 
	 class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove' 
	 class='btn btn-danger'>"
	 + "<input name='itemID' type='hidden' value='" + ID 
	 + "'>" + "</form></td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the items."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	public String updateItem(String ID, String Username, String Password , String phoneNumber, String Email, String Address)
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for updating."; } 
	 // create a prepared statement
//	 String query = "UPDATE usermanage SET UserName=?,Password=?,PhoneNumber=?,Email=?,Address=? 
	 WHERE ID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, username); 
	 preparedStmt.setString(3, password); 
	 preparedStmt.setDouble(4, phonenumber); 
	 preparedStmt.setString(5, email); 
	 preparedStmt.setString(6, addreess);  
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Updated successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while updating the ID."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	public String deleteID(String ID) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for deleting."; } 
	 // create a prepared statement
	 String query = "delete from items where ID=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(ID)); 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Deleted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while deleting the ID."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 

}
