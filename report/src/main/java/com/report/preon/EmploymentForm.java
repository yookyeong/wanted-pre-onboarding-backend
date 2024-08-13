package com.report.preon;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentForm {

	
	private Integer num; //게시글 등록번호 
	
	@NotEmpty(message="필수입력값")
	@Size(max=200)
	private String subject; //공고글제목
	
	
	private String com_id; //회사 아이디 
	
	
	private String em_position; //채용포지션 
	
	
	private Integer sal; //연봉 
	
	@NotEmpty(message="필수입력값")
	private String content; //채용내용 
	

	private String em_tech; // 채용기술  
	
	
	private LocalDateTime createdate;
	
	//private LocalDateTime modifydate; 파싱오류중에이것도 해당인가 싶어서 넣엇는데 이거때문에 등록시 오류 났음. 지우기.
 
}
