package lwuij21112;

import java.io.FileReader;

import org.json.simple.JSONARRAY;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReadLWUIJ2 {
		public static void main(String[] args) {
			try(FileReader reader = new FileReader("orarendLWUIJ2.json")){
				JSONParser jsonParser();
				JSONObject = (JSONObject)jsonParser.parse(reader);
				
				JSONObject root = (JSONObject) jsonObject.get("LWUIJ2_orarend");
				JSONArray km = (JSONArray) root.get("ora");
				
				System.out.println("Órarend Mérnökinformatika 2024\n");
				
				for(int i=0; i<km.size(); i++) {
					JSONObject lesson = (JSONObject) km.get(i);
					JSONObject time = (JSONObject) lesson.get("idopont");
					System.out.println("Tárgy: " + lesson.get("targy"));
					System.out.println("Időpont: " + time.get("nap")+" "+time.get("tol")+"-"+time.get("ig"));
					System.out.println("Helyszín: "+lesson.get("helyszin"));
					System.out.println("Oktató: "+lesson.get("oktato"));
					System.out.println("Szak: "+lesson.get("szak")+ "\n");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

}
