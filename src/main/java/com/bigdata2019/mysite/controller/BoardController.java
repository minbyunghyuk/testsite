package com.bigdata2019.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata2019.mysite.vo.BoardVo;
import com.bigdata2019.mysite.vo.UserVo;
import com.bigdata2019.security.Auth;
import com.bigdata2019.security.AuthUser;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}

	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@AuthUser UserVo authUser, BoardVo vo) {
		vo.setUserNo(authUser.getNo());
		return "board/write";
	}
	
}
