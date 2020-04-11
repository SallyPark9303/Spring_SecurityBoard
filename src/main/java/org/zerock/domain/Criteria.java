package org.zerock.domain;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}

	public Criteria(int pageNum, int amount) {
		// TODO Auto-generated constructor stub
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split("");
	}
	
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
		.queryParam("pageNum",this.pageNum)
		.queryParam("getAmount",this.getAmount())
		.queryParam("getType",this.getType())
		.queryParam("getKeyword",this.getKeyword());
	
		return builder.toUriString();
		
	}
}
