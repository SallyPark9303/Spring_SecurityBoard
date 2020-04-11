package org.zerock.cotroller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.model.BoardService;
import org.zerock.model.BoardServiceImpl;






@Controller
@RequestMapping("/board/")
public class BoardCotroller {
	
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void register() {
		
	}
	
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()") //로그인 후 권한이 있으면 register페이지로 감.
	public String register(BoardVO board, RedirectAttributes rttr) {
	//	Log.info("=======");
//		Log.info("register:"+board);
	//	if(board.getAttachList()!=null) {
		//	board.getAttachList().forEach(attach -> log.info(attach));
	//	}
	//	Log.info("======");
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(Model model,Criteria cri) {
		List<BoardVO>list = service.getList(cri);
		int total = service.getTotal(cri);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker",	new PageDTO(cri,total));
		model.addAttribute("total", total);
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.get(bno));
	}
	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		if(service.modify(board)) {
		rttr.addFlashAttribute("result", "success");
		}
		//return "redirect:/board/list"+cri.getListLink();
		return "redirect:/board/list";
	}
	@PreAuthorize("principal.username == #writer")
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") 
	Criteria cri, RedirectAttributes rttr, String writer) {
      System.out.println("remove..."+bno);		
		
		if(service.delete(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
	//	return "redirect:/board/list"+cri.getListLink();
		return "redirect:/board/list";		
	}
	
}
