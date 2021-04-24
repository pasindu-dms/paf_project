package com;

import model.User; 

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*; 

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/User") 

public class UserService {
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteItem(String IDData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(IDData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <ID>
	 String itemID = doc.select("ID").text(); 
	 String output = UserObj.deleteID(User); 
	return output; 
	}



}
