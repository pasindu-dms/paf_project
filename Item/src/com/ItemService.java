package com;

import model.Item; 

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 


//For JSON
import com.google.gson.*; 


//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/Item")

public class ItemService {
	
	Item itemObj = new Item();
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteItem(String itemData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(itemData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <itemID>
	 String itemID = doc.select("itemID").text(); 
	 String output = itemObj.deleteItem(itemID); 
	return output; 
	}

}
