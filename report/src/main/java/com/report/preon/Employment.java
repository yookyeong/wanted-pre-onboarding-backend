package com.report.preon;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Employment {

	
	@Id //기본키지정 
    @GeneratedValue(strategy  = GenerationType.IDENTITY) //자동으로 1씩 증가하는 고유한 번호생
	private Integer num; //게시글 등록번호 
	
	@Column
	private String subject; //공고글제목
	
	@Column
	private String com_id; //회사 아이디 
	
	@Column
	private String em_posion; //채용포지션 
	
	@Column
	private Integer sal; //연봉 
	
	@Column(columnDefinition = "text")
	private String content; //채용내용 
	
	@Column
	private String em_tech; // 채용기술  
	
	@Column
	private LocalDateTime createdate;
	
	@Column
	private LocalDateTime modifydate;
	
	
}
