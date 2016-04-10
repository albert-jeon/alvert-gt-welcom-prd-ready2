package com.gt.welcom.prd.alvert.common;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONObject;
public class Constant {
	private static Constant constant;
	
	private final String STORE_FOLDER_NAME = "stores";
	private final String[] STORE_FILE_NAMES = new String[]{
			 "01. 던킨도너츠(삼성탕정점)"
//			,"02. 배스킨라빈스(탕정삼성전자점)"
//			,"03. 도미노피자(탕정삼성점)"
//			,"05.01_소통카페 지텐션"
//			,"05.02소통카페_카페웰레인보우(7라인)"
//			,"05.03소통카페_카페웰레인보우(블루홀)"
//			,"05.04소통카페_8옥타브 (모듈동)"
//			,"05.05소통카페_8옥타브 (8라인)"
//			,"99. 제휴처 매장"
	};
	
	private final String ITEM_FOLDER_NAME = "items";
	private final String[] ITEM_FILE_NAMES = new String[]{
			 "01. 던킨도너츠(삼성탕정점)"
			,"02. 배스킨라빈스(탕정삼성전자점)"
			,"03. 도미노피자(탕정삼성점)"
			,"04. BBQ치킨(삼성전자탕정점)"
			,"05. 국대떡볶이 아산탕정점"
			,"06. W버거 아산탕정점"
			,"07. 오브제스킨케어"
			,"08. 클라라네일아트"
			,"09. 아티제 탕정점"
			,"10. 나누나누 사진관"
			,"11. 서초플라워샵"
			,"12. 골드라인"
			,"13. 오븐에빠진닭 탕정점"
			,"14.소통카페"
	};
	
	private final String ALLIANCE_FILE_NAME = "alliance/alliance";
	private final String UNION_FILE_NAME = "union/05.유니온_등록"; 
	private final String UNION_STORE_FILE_NAME = "union/05.유니온_등록"; 
	
	private JSONArray alliance = new JSONArray();
	private JSONArray stores = new JSONArray();
	private JSONArray items = new JSONArray();
	
	private JSONObject union = new JSONObject();
	private JSONObject union_store = new JSONObject();

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

	public JSONArray getAlliance(){ return  this.alliance; }
	public JSONArray getStores(){ return  this.stores; }
	public JSONArray getItems(){ return items;}
	public JSONObject getUnion() { return union; }
	public JSONObject getUnionStore() { return union_store; }
	

	private Constant(){
		//this.setAlliance();
		this.setStores();
		//this.setItems();
		//this.setUnion();
		//this.setUnionStore();
	}
	
	private void setAlliance(){
		this.alliance = new JSONArray(this.readFile(ALLIANCE_FILE_NAME).toString());
	}
	
	private void setStores(){
		for (String fileName : STORE_FILE_NAMES) {
			System.out.println(new JSONObject(this.readFile(STORE_FOLDER_NAME+"/"+fileName)));
			//stores.put(new JSONObject(this.readFile(STORE_FOLDER_NAME+"/"+fileName)));
		}
	}
	
	private void setItems(){
		for (String fileName : ITEM_FILE_NAMES) {
			items.put(new JSONObject(this.readFile(ITEM_FOLDER_NAME+"/"+fileName)));
		}
	}
	
	private void setUnion(){
		this.union = new JSONObject(this.readFile(UNION_FILE_NAME).toString());
	}
	
	private void setUnionStore(){
		this.union_store = new JSONObject(this.readFile(UNION_STORE_FILE_NAME).toString());
	}

	private StringBuilder readFile(String filePath){
		StringBuilder stringBuilder = new StringBuilder();
	    try{
	    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filePath)),1024);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	        	System.out.println(line);
	            stringBuilder.append(line).append('\n');
	        }
	        bufferedReader.close();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	    return stringBuilder;
	}
}
