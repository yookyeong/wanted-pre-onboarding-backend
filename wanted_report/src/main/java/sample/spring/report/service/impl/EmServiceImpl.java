package sample.spring.report.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.spring.report.dao.EmDAO;
import sample.spring.report.service.EmService;

@Service
public class EmServiceImpl implements EmService {

	private EmDAO emDAO;
	
	@Autowired
	public void EmServiceIm (EmDAO emDAO) { //?
		
		this.emDAO=emDAO;
	}
	
	@Override
	public int create(Map<String, Object> map) {
		int seq = this.emDAO.insert(map);
		return 0;
	}

}
