package com.zh.base.model;

import java.util.ArrayList;
import java.util.List;

import com.zh.base.model.bean.Notice;
import com.zh.core.base.model.BaseModel;

public class NoticeModel extends BaseModel {

	private List<Notice> noticeList = new ArrayList<Notice>();
	
	private Notice notice = new Notice();

	public List<Notice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

}
