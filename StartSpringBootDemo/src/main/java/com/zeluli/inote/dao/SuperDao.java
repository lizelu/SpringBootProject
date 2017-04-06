package com.zeluli.inote.dao;

import java.util.HashMap;
import java.util.Map;

public class SuperDao {
	protected Map<String, Object> responseBody = new HashMap<String, Object>();
	public SuperDao() {
		this.responseBody.put("result", "SUCCESS");
		this.responseBody.put("errorMessage", "");
	}
}
