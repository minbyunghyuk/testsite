package com.bigdata2019.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata2019.mysite.service.GuestbookService;
import com.bigdata2019.mysite.vo.GuestbookVo;

@Controller
@RequestMapping( "/guestbook" )
public class GuestbookController {
	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping( "" )
	public String index( Model model ){
		List<GuestbookVo> list = guestbookService.getMessages();
		model.addAttribute( "list", list );
		return "guestbook/index";
	}
	
	@RequestMapping( value="/delete/{no}", method=RequestMethod.GET )
	public String deleteform( @PathVariable( "no" ) Long no, Model model ){
		model.addAttribute( "no", no );
		return "guestbook/delete";
	}
	
	@RequestMapping( value="/delete", method=RequestMethod.POST )
	public String delete( @ModelAttribute GuestbookVo vo ){
		guestbookService.deleteMessage( vo.getNo(), vo.getPassword() );
		return "redirect:/guestbook";
	}
	
	@RequestMapping( value="/add", method=RequestMethod.POST )
	public String add( @ModelAttribute GuestbookVo vo ) {
		guestbookService.writeMessage( vo );
		return "redirect:/guestbook";
	}

}
