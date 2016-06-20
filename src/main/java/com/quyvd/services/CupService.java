package com.quyvd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quyvd.dao.CondimentDAO;

@Service
public class CupService {

	@Autowired
	private CondimentDAO condimentDAO;

	public String convertIdToName(String ids) {
		String[] id = ids.split(", ");
		String result = null;
		for(int i=0;i<id.length;i++) {
			String s = condimentDAO.getNameByID(Integer.parseInt(id[i]));
			if (result.equals(null)) result = result + s;
			else result = result + ", " + s;
		}
		return result;
	}
}
