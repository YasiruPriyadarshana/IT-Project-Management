package Complexity.ControlStructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ComplexityMeasureCs {

    public final String PLUS = "+";
    public final String PUBLIC = "public";
    public final String SYSTEM = "System";
    public final String CLASS = "class";

    int Wtcs = 0;
    int NC = 0;
    int Ccspps = 0;
    int Ccs = 0;
    
    public ComplexityMeasureCs() {
		
   	}
    
    // Wtcs = Weight due to control structure type
    //  NC = Number of conditions in the control structure
    public int[] calculateWTCSandNC(String fileContent) {
    	int ifCount = 0;
    	int forCount = 0;
    	int whileCont = 0;
    	int doCount = 0;
    	int switchCount = 0;
    	int caseCount = 0;
    	int NCcount = 0;
    	int[] ar;
		ar=new int [2];
		
		
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(fileContent);
		
		while (matcher.find()) {
//		    System.out.println(matcher.group());
		    switch (matcher.group().toString()) {
    		case "if":
    			ifCount += 1;
    			break;
    		case "for":
    			forCount += 1;
    			break;
    		case "while":
    			whileCont += 1;
    			break;
    		case "do":
    			doCount += 1;
    			break;
    		case "switch":
    			switchCount +=1;
    			break;
    		case "case":
    			caseCount +=1;
    			break;
    		default :
    			
		    }
		}
//        	A conditional control structure such as an ‘if’ or ‘else-if’ condition - 2
//        	An iterative control structure such as a ‘for’, ‘while’, or ‘do-while’ loop - 3
//        	The ‘switch’ statement in a ‘switch-case’ control structure- 2
//        	Each ‘case’ statement in a ‘switch-case’ control structure- 1
    		int wtcs = (ifCount*2 + forCount*3 + (whileCont-doCount)*3 + doCount *3 + switchCount*2 + caseCount*1 );
    		int nc = (ifCount + forCount + (whileCont-doCount) + doCount + switchCount + caseCount );
    		
    		ar[0]=wtcs;
    		ar[1]=nc;
    		System.out.println("if : "+ifCount+"for: "+forCount+"while:  "+whileCont+"switch:   "+switchCount+"case:   "+caseCount);
    		System.out.println("wtcs : "+wtcs);
    		System.out.println("nc : "+nc);
		
		
		
		/*
    	String[] wordsArray = fileContent.split(" ");
    	for (int wordIndex = 0; wordIndex < wordsArray.length; wordIndex++) {
    		switch (wordsArray[wordIndex]) {
    		case "if":
    			ifCount += 1;
    			break;
    		case "for":
    			forCount += 1;
    			break;
    		case "while":
    			whileCont += 1;
    			break;
    		case "do":
    			doCount += 1;
    			break;
    		case "switch":
    			switchCount +=1;
    			break;
    		case "case":
    			caseCount +=1;
    			break;
    		default :
    			
    		}
//        	A conditional control structure such as an ‘if’ or ‘else-if’ condition - 2
//        	An iterative control structure such as a ‘for’, ‘while’, or ‘do-while’ loop - 3
//        	The ‘switch’ statement in a ‘switch-case’ control structure- 2
//        	Each ‘case’ statement in a ‘switch-case’ control structure- 1
    		int wtcs = (ifCount*2 + forCount*3 + (whileCont-doCount)*3 + doCount *3 + switchCount*2 + caseCount*1 );
    		int nc = (ifCount + forCount + (whileCont-doCount) + doCount + switchCount + caseCount );
    		
    		ar[0]=wtcs;
    		ar[1]=nc;
    		 
    	}*/

    	return ar;
    }
    

    //  Ccspps = Ccs value of the program statement in the immediate outer level of the current nesting level. 
    //Hence, always the value of Ccspps would be zero for control structures which reside at the first nesting level or outer most nesting level.
    public int calculateCCSPPS(String fileString) {
    	String[] wordsArray = fileString.split(" ");
    	int forcount=0;
    	int brack1=0;
    	int brack2=0;
    	int Ccspps=0;
    	for (int wordIndex = 0; wordIndex < wordsArray.length; wordIndex++) {
//    		System.out.println(""+wordsArray[wordIndex]);
    		String partWord = "for";
        	String pattern = "\\b"+partWord+"\\b";
            Pattern p=Pattern.compile(pattern);
            Matcher m=p.matcher(wordsArray[wordIndex]);
            if(wordsArray[wordIndex].contains("{")) {
    			brack1+=1;
    		}
    		if(wordsArray[wordIndex].contains("}")) {
    			brack2+=1;
    		}
            while (m.find()) {
//            	System.out.println("for : "+m.group().toString());
            	if(m.group().toString().equals("for")) {
            		forcount+=1;
            		if(forcount>=2) {
            			if(brack1!=brack2) {
            				Ccspps=3;
            			}else {
            				brack1=0;
            				brack2=0;
            			}
            		}
                    
            	}
            }
    	}
    	System.out.println("Ccspps " + Ccspps);
    	return Ccspps;
    }
    
    //  Ccs = Complexity of a program statement with a control structure
    //Ccs = (Wtcs * NC) + Ccspps
    public int calculateCCS(String fileString) {
    	int [] wtcsNc = calculateWTCSandNC(fileString);
    	return ((wtcsNc[0] * wtcsNc[1]) + calculateCCSPPS(fileString));
    }




    

	public int complexity() {
        return (Wtcs * NC) + Ccspps;
    }

   

  

    public void measureComplexity() throws IOException {
	       System.out.println("Came here");
    	String fileName = "D:\\uploaded_files\\temp.txt";
		 File file = new File(fileName);
	        FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        
	        StringBuilder fullcode = new StringBuilder();        
	        
//	        System.out.println("Read text file using BufferedReader");
	        while((line = br.readLine()) != null){
	            //process the line 
	        	fullcode.append(line);
	        }
	        //close resources
	        br.close();
	        fr.close();
	        String finalString = fullcode.toString();
//	        System.out.println(finalString);
	       int ccs=  calculateCCS(finalString);
	       System.out.println("css " + ccs);
	       
    }
		
    
}
