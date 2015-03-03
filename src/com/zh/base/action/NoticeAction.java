package com.zh.base.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zh.base.model.NoticeModel;
import com.zh.base.model.bean.Notice;
import com.zh.base.service.NoticeService;
import com.zh.core.base.action.Action;
import com.zh.core.base.action.BaseAction;
import com.zh.core.model.Pager;

public class NoticeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4413452191876013540L;

	private static Logger LOGGER = LoggerFactory.getLogger(NoticeAction.class);

	@Autowired
	private NoticeService noticeService;

	private NoticeModel noticeModel = new NoticeModel();

	@Override
	public Object getModel() {

		return noticeModel;
	}

	/**
	 * 公司公告入口
	 */
	public String execute() {
		LOGGER.debug("execute()");
		Notice notice = this.noticeModel.getNotice();
		Pager pager = this.noticeModel.getPageInfo();
		Integer count = noticeService.count(notice);
		pager.setTotalRow(count);
		List<Notice> noticeList = noticeService.queryList(notice, pager);
		this.noticeModel.setNoticeList(noticeList);
		return Action.SUCCESS;
	}

	public String editor() {
		LOGGER.debug("editor()");
		Integer id = this.noticeModel.getId();
		if (null != id && !"".equals(id)) {
			Notice notice = this.noticeModel.getNotice();
			notice.setId(id);
			Notice noticeReult = noticeService.query(notice);
			this.noticeModel.setNotice(noticeReult);
		}
		return Action.EDITOR;
	}

	public String save() {
		LOGGER.debug("save()");
		Notice notice = this.noticeModel.getNotice();

		//去除空格
		if(null != notice.getContent())
		{
			notice.getContent().trim();
		}
		// 判断当前是设置成启动状态还是停用状态
		String view = this.noticeModel.getView();
		if (null != view && "enabled".equals(view)) {
			String enabled = this.noticeModel.getEnabled();
			Integer id = this.noticeModel.getId();
			if ("0".equals(enabled)) {
				notice.setEnabled("1");
			} else {
				notice.setEnabled("0");
			}
			notice.setId(id);
		}

		// 判断是新增还是修改
		Integer id = notice.getId();
		if (null == id || 0 == id) {
			Integer userid = this.queryUserId();
			notice.setUserid(userid);
			noticeService.insert(notice);
		} else {
			noticeService.update(notice);
		}
		return Action.EDITOR_SUCCESS;
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public NoticeModel getNoticeModel() {
		return noticeModel;
	}

	public void setNoticeModel(NoticeModel noticeModel) {
		this.noticeModel = noticeModel;
	}

}
