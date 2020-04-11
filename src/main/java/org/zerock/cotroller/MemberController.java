package org.zerock.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.MemberVO;
import org.zerock.model.BoardService;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	
	@Autowired
	private PasswordEncoder bcyptPasswordEncoder; //암호화함.
	
	@Autowired
	private BoardService service;
	
	
	//추가폼
	@GetMapping("/MemberJoin")
	public void insert() {
		
		
	}
	
	@PostMapping("/MemberJoin")
	public String insert(MemberVO member) {
		member.setUserpw(bcyptPasswordEncoder.encode(member.getUserpw()));
		service.insert(member);
		
		return "redirect:/board/list";
	}
	

}
