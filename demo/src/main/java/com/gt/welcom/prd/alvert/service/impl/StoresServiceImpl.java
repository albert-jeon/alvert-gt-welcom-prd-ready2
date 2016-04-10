package com.gt.welcom.prd.alvert.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.gt.welcom.prd.alvert.common.Constant;
import com.gt.welcom.prd.alvert.service.StoresService;
@Service
public class StoresServiceImpl implements StoresService{

	@Override
	public void addStores() throws Exception {
		JSONArray jsonArray =  Constant.getInstance().getStores();
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject)object;
			System.out.println(jsonObject);
		}
	}

}
