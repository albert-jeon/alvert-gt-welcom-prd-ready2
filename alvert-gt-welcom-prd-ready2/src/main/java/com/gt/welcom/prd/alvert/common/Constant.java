package com.gt.welcom.prd.alvert.common;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
public class Constant {
	private static Constant constant;

	private JSONArray alliance = new JSONArray();

	public static Constant getInstance() {
        if (constant == null) {
            synchronized (Constant.class) {
                if (constant == null) {
                	constant = new Constant();
                }
            }
        }
        return constant;
    }

	public JSONArray getAlliance(){ return  this.alliance;}

	private Constant(){
		setAlliance();
	}

	private void setAlliance(){
		this.alliance = new JSONArray(this.readFile("alliance/alliance").toString());
	}

	private StringBuilder readFile(String filePath){
		StringBuilder stringBuilder = new StringBuilder();
	    try{
	    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filePath)),1024);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            stringBuilder.append(line).append('\n');
	        }
	        bufferedReader.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	    return stringBuilder;
	}
}
