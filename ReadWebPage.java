
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadWebPage {

	public static void search(String webURL, String word) throws IOException {
		
		// print the full url
		System.out.println(webURL + word);
		
		// create full url object
		URL url = new URL(webURL + word);
        	InputStream is =  url.openStream();
		
		// create buffered stream
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(is));

		// read buffered stream line by line and output to console
		String line;
		while ((line = buffRead.readLine()) != null) 
			System.out.println(line);
		
	}
    public static void main(String[] args) throws IOException {
		
	// if input is not null
	if(args.length != 0)
		search("http://www.thesaurus.com/browse/", args[0]);
        
    }

}
