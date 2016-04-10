package com.gt.welcom.prd.alvert.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.gt.welcom.prd.alvert.common.Constant;
import com.gt.welcom.prd.alvert.service.ItemsService;
@Service
public class ItemsServiceImpl implements ItemsService{

	@Override
	public void addItems() throws Exception {
		JSONArray jsonArray = Constant.getInstance().getItems();
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject)object;
			System.out.println(jsonObject);
		}
	}
	
}
