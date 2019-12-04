package RestAssuredASS.RestAssuredASS;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	//private static final JSONArray studentobj = null;

	public static void main(String[] args) throws IOException, ParseException    {
		// TODO Auto-generated method stub
		String filename="C:\\eclipse-workspace\\RestAssuredASS\\src\\main\\resources\\file1.json";		
		JSONParser jsonParser = new JSONParser();
        
        FileReader reader = new FileReader(filename);
       
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        
        JSONObject jobject=(JSONObject)obj;
        
       //1.Find value of username   
        // getting firstName and lastName 
        String username = (String) jobject.get("username"); 
        String password = (String) jobject.get("password"); 
          
        System.out.println("The suername is"+username); 
        System.out.println("the password is"+password); 
        
	
        //2.Find values of all sessionid
        //find sessionid array
        JSONArray sessionid=(JSONArray)jobject.get("sessionid");
        Iterator i=sessionid.iterator();
        while (i.hasNext())
        	{
        	Long sessionids=(Long)i.next();
        	
        System.out.println("The sessionid is # "+sessionids); }
        
        //3.Find last value of sessionid
        Long Lastsessionid=(Long) sessionid.get(sessionid.size()-1);
        System.out.println("The sessionid is # "+Lastsessionid);
	
	//Contacts of all students
        
	 JSONArray studentsArray=(JSONArray)jobject.get("students");
	int Num=0;
	List<String> allContacts= new ArrayList<String>();
	
 	Iterator i2=studentsArray.iterator();
 	while(i2.hasNext()) {
  JSONObject stuobj=(JSONObject)i2.next();
  JSONArray Address=(JSONArray)stuobj.get("address");
  JSONArray contacts=(JSONArray)stuobj.get("contact");
  
  Iterator Allcontacts=contacts.iterator();
 	
  while(Allcontacts.hasNext()) {
	  String StudentCont=(String)Allcontacts.next();
	  System.out.println("The Contacts of Students are # "+StudentCont); 

  }
	 // List<String> Alladdress= new ArrayList<String>();  
	Iterator i3=Address.iterator();
	int addressNum=0;
	if(Num==0) {
	while(i3.hasNext()) {
		HashMap<String,String>addressvalues=(HashMap<String,String>)i3.next();
		if(addressNum==1){
		String Statename=(String)addressvalues.get("state");
	
		System.out.println("The Second state of 1st student # " +Statename);
	
	}
	System.out.println("The Address of the 1st student is #"+addressvalues);
	 addressNum++;
	 
	}
		
	}
	
 // if( Num==1) {
	//  JSONArray StunentMarks=(JSONArray)stuobj.get("marks");
	//  Iterator i5=StunentMarks.iterator();
	 
		
	  
	//  System.out.println("The Marks of  of the  student is #"+secondStunentMarks);
	
	  //i4=array values contact
	  Iterator i4= contacts.iterator();
	  int contactcount=0;
	  while(i4.hasNext()) {
		  
		  String contactlist=(String)i4.next();
		  if(contactcount==1) {
			  System.out.println("The  2nd stundent contact 2nd value is #"+contactlist);
			  
		  }
	  }
  }
  
	}
  
	}
 
	 
	 
	

