package com.bill;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class ConditionalService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final Log logger = LogFactory.getLog(this.getClass());


	public void load(List<Map<String, Long>> payload) {
		for(Map<String, Long> idMap : payload){
			this.jdbcTemplate.update("update PEOPLE set IS_INTEGRATED = true where id = ?", idMap.get("ID"));
		}
		logger.info("Service success for " + payload  );
	}

}
