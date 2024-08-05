package sample.spring.report.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class EmDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("EMPLOYMENT.insert",map);
		
		if (result > 0 && map.containsKey("employment")) {
			return  (Integer) map.get("employment");
		}
		return -1;
	}
	

}
