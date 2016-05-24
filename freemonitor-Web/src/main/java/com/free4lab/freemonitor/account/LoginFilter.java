package com.free4lab.freemonitor.account;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.free4lab.freemonitor.account.SessionConstants;
import com.free4lab.freemonitor.account.AccountManager;
public class LoginFilter extends PermissionFilter {

	/**
	 * 判断是否已经登录
	 * 方法：判断session内是的acceeetoken是否有效
	 */
	protected boolean checkPermission(HttpServletRequest request,
			HttpServletResponse response) {	
//		System.out.println("In the loginfilter, the request url is " + request.getRequestURI());
		HttpSession session = request.getSession();
		String accessToken = (String) session.getAttribute(SessionConstants.AccessToken);
		if(accessToken != null){
			if(AccountManager.getUserInfoByAccessToken(accessToken).indexOf("avatar") == -1){
				session.invalidate();
				return false;
			}
			else{
				
				return true;
			}
		}
		return false;
	}
}
