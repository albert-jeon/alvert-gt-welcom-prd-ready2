package com.gt.welcom.prd.alvert.service.impl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gt.welcom.prd.alvert.domain.Store;
import com.gt.welcom.prd.alvert.repository.StoreRepository;
import com.gt.welcom.prd.alvert.service.AllianceService;
@Service
public class AllianceServiceImpl implements AllianceService{
	@Autowired
	EntityManager entityManager;

	@Autowired
	StoreRepository storeRepository;

	@Override
	public void dealerToComapnyAllianceRequest() throws Exception {

	}

	@Override
	public Store findStoreByStoreName() throws Exception {
		TypedQuery<Store> query = entityManager.createQuery("select s from Store s where s.storeName = :storeName order by s.saveTime desc"
									, Store.class).setParameter("storeName", "소통카페");
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


}
