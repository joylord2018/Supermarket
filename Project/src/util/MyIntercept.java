package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import entity.User;

public class MyIntercept extends HandlerInterceptorAdapter{

/*	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");//完成conteoller渲染视图之后
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");//完成conteoller渲染视图之前
	}*/

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		User user=(User) request.getSession().getAttribute("user");//进入controller之前
		String path=request.getServletPath();
		if(path.equals("/jsp/login.s")){
			return true;
		}
		if(user!=null){
			return true;
		}
		else{
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
	}

}
