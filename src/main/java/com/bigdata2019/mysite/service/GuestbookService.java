package com.bigdata2019.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata2019.mysite.repository.GuestbookRepository;
import com.bigdata2019.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> getMessages() {
		return guestbookRepository.findAll();
	}
	
	public boolean deleteMessage( Long no, String password ){
		return guestbookRepository.delete( no, password );
	}
	
	public boolean writeMessage( GuestbookVo vo ) {
		return guestbookRepository.insert(vo);
	}
}
