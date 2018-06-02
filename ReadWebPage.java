
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadWebPage {

	public static void search(String webURL, String word) throws IOException {
		
		System.out.println(webURL + word);
		
		URL url = new URL(webURL + word);
        InputStream is =  url.openStream();
		
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(is));

		String line;
		while ((line = buffRead.readLine()) != null) 
			System.out.println(line);
		
	}
    public static void main(String[] args) throws IOException {
		
		//URL url = new URL("http://www.thesaurus.com/misspelling?term=hel");
		//InputStream is =  url.openStream();
		
		if(args.length != 0)
		
			search("http://www.thesaurus.com/browse/", args[0]);
        
    }

}