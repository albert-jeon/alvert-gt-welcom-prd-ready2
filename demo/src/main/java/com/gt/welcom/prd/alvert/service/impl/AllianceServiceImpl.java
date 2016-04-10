package com.gt.welcom.prd.alvert.service.impl;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.welcom.prd.alvert.common.Constant;
import com.gt.welcom.prd.alvert.domain.Company;
import com.gt.welcom.prd.alvert.domain.Store;
import com.gt.welcom.prd.alvert.repository.StoreRepository;
import com.gt.welcom.prd.alvert.service.AllianceService;

@Service
public class AllianceServiceImpl implements AllianceService{
	@Autowired
	EntityManager entityManager;

	@Autowired
	StoreRepository storeRepository;
	
//	public static final String API_ADDPROPOSAL_URL = "http://stg-app.gtention.com//api/v1/proposals"; // 요청 URL
	public static final String API_ADDPROPOSAL_URL = "http://stg-app.gtention.com//api/v1/proposals"; // 요청 URL

	@SuppressWarnings("unused")
	@Override
	public void addAlliance() throws Exception {
		System.out.println(Constant.getInstance().getAlliance());
		JSONArray alliances = Constant.getInstance().getAlliance();
		JSONArray resultAlliances = new JSONArray();
		for (Object obj : alliances) {
			JSONObject json = (JSONObject) obj;


			String storeName = this.getStoreName(json);
			System.out.println("storeName : " +storeName);
			Store store = this.findStoreByStoreName(storeName);
			if(store == null) throw new RuntimeException("store is null");

			Company company = this.findStoreByCompanyName(this.getCompanyName(json));
			if(store == null) throw new RuntimeException("company is null");

			json.getJSONObject("store").put("storeId", store.getStoreId());
			json.getJSONObject("company").put("companyId", company.getCompanyId());


			resultAlliances.put(json);
		}
		System.out.println(resultAlliances);
	}

	private Store findStoreByStoreName(String storeName) throws Exception {
		TypedQuery<Store> query = entityManager.createQuery("select s from Store s where s.storeName = :storeName or s.storeName = :storeName2 order by s.saveTime desc"
									, Store.class).setParameter("storeName", storeName).setParameter("storeName2", storeName.replaceAll("\\s", ""));
	    query.setMaxResults(1);

	    return query.getSingleResult();
	}
	private Company findStoreByCompanyName(String name) throws Exception {
		TypedQuery<Company> query = entityManager.createQuery("select c from Company c where c.name = :name "
				, Company.class).setParameter("name", name);
		query.setMaxResults(1);
		return query.getSingleResult();
	}

	private String getStoreName(JSONObject json){
		String proposalName = json.getString("proposalName");
		String storeName = "";
		Pattern pattern = Pattern.compile("^\\[제안(.*)]\\s(.*)\\s웰컴");
		Matcher match = pattern.matcher(proposalName);
		if(match.find()){
			storeName = match.group(2);
		}
		return storeName;
	}
	private String getCompanyName(JSONObject json){
		String proposalName = json.getString("proposalName");
		String storeName = "";
		Pattern pattern = Pattern.compile("^\\[제안->(.*)]\\s(.*)\\s웰컴");
		Matcher match = pattern.matcher(proposalName);
		if(match.find()){
			storeName = match.group(1);
		}
		return storeName;
	}
	
	private void tryApiRequest(){
		StringBuilder queryUrl = new StringBuilder();
		 queryUrl.append(API_ADDPROPOSAL_URL);
		try {
			Document document = Jsoup.connect(queryUrl.toString()).post();
			String errorCode = document.select("error_code").text();
			if (null == errorCode || "".equals(errorCode)) {
				 
			}else{
				 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
