package org.iclass.mvc.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CommunityComments {

	private int idx;
	private long mref;
	private String wirter;
	private String content;
	private LocalDate createdat;
	private String ip;
	private int commentCount;
}
