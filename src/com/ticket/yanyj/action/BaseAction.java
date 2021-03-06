package com.ticket.yanyj.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ticket.yanyj.service.AccountService;
import com.ticket.yanyj.service.ProfitService;
import com.ticket.yanyj.service.TicketService;
import com.ticket.yanyj.service.impl.AccountServiceImpl;
import com.ticket.yanyj.service.impl.ProfitServiceImpl;
import com.ticket.yanyj.service.impl.TIcketServiceImpl;

public class BaseAction extends ActionSupport{
	
 private static final Logger logger = Logger.getLogger("");
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String page ;
	private String rows ;
	protected static TicketService ticketService = new TIcketServiceImpl();
	protected static ProfitService profitService = new ProfitServiceImpl();
	protected static AccountService accountservice = new AccountServiceImpl();
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}
	private String render(String text, String contentType)
	  {
	    try
	    {
	      HttpServletResponse response = ServletActionContext.getResponse();
	      response.setContentType(contentType);
	      response.getWriter().write(text);
	    }
	    catch (IOException e)
	    {
	      logger.error(e.getMessage(), e);
	    }
	    return null;
	  }
	  
	  public String renderText(String text)
	  {
	    return render(text, "text/plain;charset=UTF-8");
	  }

	public static TicketService getTicketService() {
		return ticketService;
	}

	public static void setTicketService(TicketService ticketService) {
		BaseAction.ticketService = ticketService;
	}

}
