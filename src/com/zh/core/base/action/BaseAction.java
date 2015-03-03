package com.zh.core.base.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zh.base.model.bean.User;
import com.zh.core.model.Pager;
import com.zh.core.model.VariableUtil;

public abstract class BaseAction extends ActionSupport implements
		ModelDriven<Object> {

	public static boolean STATS_BOOL = false;
	
	/**static
	{
		SystemInfo sys = SystemInfo.getInstance();
		//if(sys.getSystem().contains("Windows"))
		//{
		//	throw new ExceptionManager("数据出错",new RuntimeException());
		//}
		String mac = sys.getMac();
		SystemService systemService = (SystemService) new ClassPathXmlApplicationContext(
		"spring-config.xml").getBean("systemService");
		String ll = systemService.querySysteminfo();
		if(!BCrypt.checkpw(mac ,ll))
		{
			throw new ExceptionManager("数据出错",new RuntimeException());
		}
		
	}*/
	/**
	 * 在struts2中可以设置：
	 * ActionContext.getContext().getSession().put("WW_TRANS_I18N_LOCALE",
	 * locale); locale为：国家语言，例如：Locale locale = new Locale("zh","CN"); 这样就改变了语言。
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分页显示的当前页
	 * */
	private int curPage;
	/**
	 * 返回错误消息
	 */
	protected String errorMessage;
	/**
	 * 返回消息
	 */
	private String messages;
	
	/**
	 * 语言 1为切换语言
	 */
	//private String language;
	
	/**
	 * 用户登陆信息
	 */


	/**
	 * 分页器 传入总数据数
	 * 
	 * @param TotalRows
	 */
	protected Pager pageInfo(int TotalRows) {
		Pager pageInfoObject = new Pager();
		pageInfoObject.setCurPage(this.getCurPage());
		pageInfoObject.setTotalRow(TotalRows);
		ActionContext.getContext().put("pageInfo", pageInfoObject);
		return pageInfoObject;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getCurPage() {
		return curPage;
	}

	/**
	 * 构造函数,用来初始数据
	 */
	public BaseAction() {
		// employeeInfoVO =
		// (EmployeeInfoVO)this.getRequest().getSession().getAttribute("employeeInfoVO");
	}

	/**
	 * JSON字符串
	 */
	private String returnJSON;



	/**
	 * 获取当前Request对象
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(
				ServletActionContext.HTTP_REQUEST);
	}
	
	/**
	 * 获取当前Request对象
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	/**
	 * 获取当前登陆的用户id
	 * @return
	 */
	public Integer queryUserId()
	{
		User user = (User) this.getSession().getAttribute(VariableUtil.SESSION_KEY);
		return user.getId();
	}
	
	/**
	 * 获取当前登陆的用户
	 * @return
	 */
	public User queryUser()
	{
		User user = (User) this.getSession().getAttribute(VariableUtil.SESSION_KEY);
		return user;
	}

	/**
	 * 获取当前Response对象
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return (HttpServletResponse) ActionContext.getContext().get(
				ServletActionContext.HTTP_RESPONSE);
	}

	public String getReturnJSON() {
		return returnJSON;
	}

	public void setReturnJSON(String returnJSON) {
		this.returnJSON = returnJSON;
	}

	/**
	 * 向前台返回数据 修改：增加了页面写出的方法，并增加了页面写出的编码格式 修改者：zhangqing
	 * 
	 * @return
	 */
	public void write(String str, String ecode) throws IOException {
		getResponse().setCharacterEncoding(ecode);
		getResponse().setContentType("text/html;charset=" + ecode);
		PrintWriter out = getResponse().getWriter();
		out.println(str);
		out.flush();
		out.close();
	}
	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
