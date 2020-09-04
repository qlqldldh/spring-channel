package com.jinsu.proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jinsu.proj.reposi.NoticeRepos;
import com.jinsu.proj.vo.NoticeVO;

@Service
public class NoticeService {
	@Autowired
	NoticeRepos noticeRepos;
	
	public NoticeVO showNoticeByTitle(String title) {
		return noticeRepos.selectOneByJpa(title);
	}
	
	public List<NoticeVO> showNotices(){
		return noticeRepos.selectAllByJpa();
	}
	
	public void regisNewNotice(NoticeVO vo) {
		noticeRepos.insertByJpa(vo);
		System.out.println("inserted");
	}
	
	public void deleteNotice(String title) {
		noticeRepos.deleteByJpa(title);
		System.out.println("deleted");
	}
	
	public void updateNotice(String title, String content) {
		noticeRepos.updateByJpa(title, content);
		System.out.println("updated");
	}
}
