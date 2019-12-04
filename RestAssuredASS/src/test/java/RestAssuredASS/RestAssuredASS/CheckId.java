package RestAssuredASS.RestAssuredASS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;

public class CheckId {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = "";
			while (null != (str = br.readLine())) {
			System.out.println(str);
			}
			} catch (Exception ex) {

			StringBuffer idvalue=new StringBuffer();
			JSONArray obj_JSONArray=new JSONArray();
			for (int i=0;i<obj_JSONArray.size();i++);

	}

}
}