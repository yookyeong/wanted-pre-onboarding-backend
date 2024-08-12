package com.report.preon;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmploymentService {
	// 레파지토리 객체호출하는 기능. 서비스통해서 호출하여 데이터노출도 낮.직접적으로꺼내쓰는게아닌 서비스를 이용해서 쓴다..택배?
	
	private final EmploymentRepository employmentRepository;
	
	public List<Employment> getList () {
		return this.employmentRepository.findAll();
	}
	
	public Employment getEmployment (Integer num) {
		Optional<Employment> employment=this.employmentRepository.findById(num);
		
		if (employment.isPresent()) { //참일경우에 employment 리
			return employment.get();
		}else { //아니면 오류값반환 하기.
			throw new DataNotFoundException ("employment not found"); //이것찾아보다가 오류처리하는거있길래.
			
		}
	}

	public void create(String subject, String content,String em_postion,String em_tech,Integer sal) {
		Employment em = new Employment(); //초기화 
		em.setSubject(subject);
		em.setContent(content);
		em.setEm_posion(em_postion);
		em.setEm_tech(em_tech);
		em.setSal(sal);
		em.setCreatedate(LocalDateTime.now());
		this.employmentRepository.save(em);
	}
	
	public void modify(Employment employment,String subject, String contetn,String em_position,String em_tech,Integer sal) {
		
		employment.setSubject(subject);
		employment.setContent(contetn);
		employment.setEm_posion(em_position);
		employment.setEm_tech(em_tech);
		employment.setSal(sal);
		employment.setCreatedate(LocalDateTime.now());
		this.employmentRepository.save(employment);
	}
	public void delete (Employment employment) {
		this.employmentRepository.delete(employment);
		
	}
}
