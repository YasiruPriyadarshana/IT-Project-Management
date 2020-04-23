package Handler;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	
	
	public String read() throws IOException {
		String fileName = "D:\\uploaded_files\\temp.txt";
		 File file = new File(fileName);
	        FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        System.out.println("Read text file using BufferedReader");
	        while((line = br.readLine()) != null){
	            //process the line
	            System.out.println(line);
	        }
	        //close resources
	        br.close();
	        fr.close();
        return line;
    }
	  
}
