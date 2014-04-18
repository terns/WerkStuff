  import java.io.*;     
import java.util.*;     

public class thing {

public static void main(String [] args){     
	try {
		ArrayList<String> lines = new ArrayList<String>();


    	    BufferedReader in = new BufferedReader(new FileReader(args[0]));
    	    String line = in.readLine();{
    	    	int strike = 0;
    	    	int comment = 0;
    	    	int noedit = 0;
    	    	int monospace = 0;
    	    	while (line != null) {
    	    		if (line.contains("{{{#!")) {
         	            line = line.replace("{{{", "<!--");
         	            comment = 1;
        	    	 }
    	    		if (line.contains("{{{")) {
        	            line = line.replace("{{{", "<pre>");
        	            noedit = 1;
    	    		}
    	    		if (line.contains("`")) {
        	            if (monospace == 0){
    	    			line = line.replace("`", "<pre>");
        	            noedit = 1;
        	            monospace = 1;}
        	            else{
        	            line = line.replace("`", "</pre>");
            	        noedit = 0;
            	        monospace = 0;}	
        	            }
    	    		}
    	    		
    	    		if (line.contains("}}}")) {
        	        	if (comment == 0){
        	            line = line.replace("}}}", "</pre>");
        	            noedit = 0;
        	        	}
        	            else{
        	            line = line.replace("}}}", "-->");
        	            comment = 0;
        	            }	
        	            }
    	    	if (noedit == 1){
    	    	}
    	    	else{
    	    	if (line.contains("**")) {
    	            line = line.replace("**", "'''");
    	        }
    	    	if (line.contains("//")) {
    	            line = line.replace("//", "''");
    	        }
    	    	if (line.contains("--")) {
    	        	if (strike == 0){
    	            line = line.replace("--", "<strike>");
    	        	strike += 1;}
    	            else if (strike == 1){
    	            line = line.replace("--", "</strike>");
    	            strike -= 1;
    	            }	
    	            }
    	    	 
    	    	if (line.startsWith(" ")){
    	        	
    	        	if (line.startsWith("*", 1)){
    	        		line = line.replace(" *", "**");
    	        	  	}
    	        	else if (line.startsWith(" *", 1)){
    	        		line = line.replace("  *", "***");
    	        		}
    	        	else if (line.startsWith("  *", 1)){
    	        		line = line.replace("   *", "****");
    	        		}
    	        	else{
    	        		line = "<blockquote>" + line + "</blockquote>";
    	        	}
    	        	
    	    	}
    	        if (line.startsWith("=")) {
	        		line = "=" + line + "=";
	        			
	        	}
    	    	}
    	        lines.add(line);
    	        line = in.readLine();
    	    }
    	   

    	    
    	    in.close();
 
		    PrintWriter out = new PrintWriter(args[0] + ".new.txt");
		    for (String l : lines)
		        out.println(l + '\n');
		    out.close();
			

			
			System.out.println("Done");
    	    
    	    
    	}catch (IOException e)
    	{
    		e.printStackTrace();}
    
    	
                 
            } 
    }