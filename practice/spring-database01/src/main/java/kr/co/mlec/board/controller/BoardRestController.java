package kr.co.mlec.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.board.service.BoardService;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardService service;

	// method delete이면서 localhost:7777/board/no - no번 번호의 게시글 삭제
	@RequestMapping(value="/board/{no}", method=RequestMethod.DELETE)
	public Map<String, Boolean> delete(@PathVariable("no") int no) {
		service.deleteBoard(no);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("flag", true);
		return result;
	}
}
