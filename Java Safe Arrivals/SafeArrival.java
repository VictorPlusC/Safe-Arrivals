import java.io.BufferedReader;
import java.io.*;
import java.net.*;

public class SafeArrival {

	public static void main(String[] args) throws IOException {
		String theURL = "https://maps.googleapis.com/maps/api/directions/json?key=";
		String apiKey = "AIzaSyCzcL1raU5fiQkZQO83GMx10rd3Vxhnj8c";
		
		String origin = "288 Broadway Avenue Hamilton";
		String dest = "McMaster University";
		String mode = "driving";
		
		theURL += apiKey + "&origin=" + origin + "&destination=" + dest + "&mode=" + mode;
		theURL = theURL.replace(" ","%20");
		
		System.out.println(theURL);
		
		URL url = new URL(theURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		int status = con.getResponseCode();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				in.close();
		con.disconnect();
		System.out.println(content);
		
		String jsonString = "{\"stat\": { \"sdr\": \"aa:bb:cc:dd:ee:ff\", \"rcv\": \"aa:bb:cc:dd:ee:ff\", \"time\": \"UTC in millis\", \"type\": 1, \"subt\": 1, \"argv\": [{\"type\": 1, \"val\":\"stackoverflow\"}]}}";
        
	}

}
