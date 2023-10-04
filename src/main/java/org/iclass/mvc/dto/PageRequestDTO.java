package org.iclass.mvc.dto;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class PageRequestDTO {

	private int page = 1;    //현재 페이지 번호
	private int size = 5;      //size 는 한 개 페이지 글 갯수

	//sql 쿼리에 필요한 값
	private int start;        //페이지 시작 글번호
	private int end;        //페이지 끝 글번호

	//검색 파라미터
	private String[] types;    //"twc"를 동적 쿼리로 전달하기 위해 배열로 변환하여저장 {"t","w","c"}
	private String type;    //view 에서 "twc"로 전달되는 값저장
	private String keyword;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate from;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate to;

	//list.html 에서 검색 버튼을 누르며면 /community/list getmapping 입니다.  해당 핸들러 메소드에 인자로
	//pageRequerstDTO 선언합니다.
	// getmapping 핸들러 메소드는 PageRequestDTO 로 모든 파라미터를 받습니다.(생성자가+(*주의점)setter 동작)

	public void setDatas() {    //오라클에서만 필요한 작업입니다. mysql은 쉽게 팔수 있는 limit라는 연산자가 있습니다.
		start = (page - 1) * size + 1;    //글목록 시작행번호(rownum)
		end = start + (size - 1);


		//String "tc" 와 같이 view 에서 받은 파라미터 값은 배열로 변경
		if (type != null && !type.isEmpty() && !type.equals("a")) {
			types = type.split(""); // "tc"를 new String[]{"t", "c"}로 변환합니다.
		}

	}
}

