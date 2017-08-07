package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.it.shop.model.Account;

@Controller
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String query(){
		jsonList = accountService.query();
		return "jsonList";
	}

}
