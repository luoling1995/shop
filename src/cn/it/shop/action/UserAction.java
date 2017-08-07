package cn.it.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.it.shop.model.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	
	public String login(){
		model = userService.login(model);
		if(model == null){
			session.put("error", "µ«»Î ß∞‹");
			return "ulogin";
		}else{
			session.put("user", model);
			if(session.get("goURL") == null){
				return "index";
			}else{
				return "goURL";
			}
		}
	}

}
