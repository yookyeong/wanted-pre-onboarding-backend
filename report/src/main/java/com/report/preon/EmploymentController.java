package com.report.preon;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;





@RequiredArgsConstructor //구조체 설정하는어노테이션 불러와야지 사용가능~
@Controller
public class EmploymentController {
	
	private final EmploymentService employmentService; // 채용테이블 객체불러오는 서비스사용. 
	
	
	@GetMapping("/") //8080접속시 리스트로 
	public String root () {
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list (Model model) { // 자동으로 생성시킬려고 사용.
		List<Employment> employmentList= this.employmentService.getList(); //서비스에 만들어진 리스트불러오는거~
		model.addAttribute("employmentList",employmentList); // 연결시키려고 속성.값 연결되는 속성으로 사용.
		return "employment_list"; //리스트로 반환 
	}
	
	@GetMapping(value="/detail/{num}") //상세페이지 밸류에 num 넣어줘야지 각페이지값받아올수있음~ 직접넣을떄도 숫자넣어주
	public String detail (Model model, @PathVariable("num") Integer num) { 
		Employment employment = this.employmentService.getEmployment(num);
		//num값으로 가져오기.
		model.addAttribute("employment",employment);
		return "employment_detail"; //html반환 
	}
	
	@GetMapping("/create") //등록하기 클릭시에 폼 불러오기.
	public String employmentCreate(EmploymentForm employmentForm) {
		return "employment_form";
		
	}
	
	@PostMapping("/create") // 불러온폼에 데이터랑 매칭시키는 객체 넣어주기. 
	public String employmentCreate(@Valid EmploymentForm employmentForm,BindingResult bindingResult) {
		
		this.employmentService.create(employmentForm.getSubject(), employmentForm.getContent(), employmentForm.getEm_position(), employmentForm.getEm_tech(), employmentForm.getSal());
		return "redirect:/list"; //생성성공시 list 호춯.
	}
	
	
	@GetMapping("/modify/{num}") //id값인 num값으로 호출하기
	public String employmentModify( EmploymentForm employmentForm,  @PathVariable("num") Integer num) {
		Employment employment = this.employmentService.getEmployment(num);
		employmentForm.setSubject(employment.getSubject());
		employmentForm.setContent(employment.getContent());
		employmentForm.setEm_position(employment.getEm_position());
		employmentForm.setEm_tech(employment.getEm_tech());
		employmentForm.setSal(employment.getSal());
		return "employment_form";
	}
	
	@PostMapping("/modify/{num}") 
	public String employmentModify(@Valid EmploymentForm employmentForm,BindingResult bindingResult,@PathVariable("num") Integer num ) {
		Employment employment = this.employmentService.getEmployment(num);
		this.employmentService.modify(employment, employmentForm.getSubject(), employmentForm.getContent(), employmentForm.getEm_position(), employmentForm.getEm_tech(), employmentForm.getSal());
		
		
		return "redirect:/detail/{num}";
	}
	

	

	
	@GetMapping("/delete/{num}")
	public String emplopmentdelete (@PathVariable("num") Integer num) {
		
		Employment employment = this.employmentService.getEmployment(num);
		this.employmentService.delete(employment);
		return "redirect:/";
		
	}
	
	
}



