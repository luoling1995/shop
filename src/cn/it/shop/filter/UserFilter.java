package cn.it.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//�жϵ�ǰsession�Ƿ����û���Ϣ
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		if(req.getSession().getAttribute("user") == null){
			//���浱ǰ�ͻ���Ҫȥ��URL��ַ��/user/confirm.jsp
			String goURL = req.getServletPath();
			//����/user/confirm.jsp����Ĳ���������еĻ�
			String param = req.getQueryString();
			if(param != null){
				goURL = goURL + "?" + param;
			}
			req.getSession().setAttribute("goURL", goURL);
			req.getSession().setAttribute("error", "�Ƿ����������");
			res.sendRedirect(req.getContextPath() + "/ulogin.jsp");
		}else{
			
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		
	}

}
