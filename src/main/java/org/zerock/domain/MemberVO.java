package org.zerock.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO  implements Serializable{
	private String userid;
	private String userpw;
	private String userName;
	private boolean enabled;
	private String regDate;
	private String updateDate;
	private List<AuthVO> authList;
}
