package sample.spring.report.em.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sample.spring.report.service.EmService;
import sample.spring.report.service.impl.EmServiceImpl;


@Controller
public class EmController {
	
	@Autowired
	EmService emService;
	
	@RequestMapping(value="/create",method = RequestMethod.GET) 
	public String getcreate() {
		
		return "em/create";
		
	}
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String postCreate(@RequestParam Map<String, Object> map ) {
		int emContsnum = this.emService.create(map);
		return "request:/read/" +String.valueOf(emContsnum);
		
	}

}
