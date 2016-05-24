package com.free4lab.freemonitor.account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.log4j.Logger;

import com.free4lab.freemonitor.account.BaseAction;
import com.free4lab.freemonitor.account.AccountManager;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2567646001401970359L;
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	private String oauthToken;
	private String redirectUrl;
	private Integer groupId;

	public String execute() throws IOException {
		//System.out.println("in login action");
		String accessTokenInSession = getSessionToken();
		// 判断session中有accessToken
		if (accessTokenInSession != null) {
			String result = AccountManager
					.getUserInfoByAccessToken(accessTokenInSession);
			// 通过Token获取的用户信息为空，说明share上的session无效;无效则重新登录
			if (!result.contains("email")) {
				//logger.info("session中有accessToken但是失效。");
				return login();
			}
			//logger.info("session中有accessToken，而且有效，开始跳转。");
			return SUCCESS;
		} else {
//			logger.info("session中没有accessToken，通过oauthToken获取。oauthToken ： "
//					+ oauthToken);
			return login();
		}
	}

	private String login() {
		if (null != oauthToken) {
			// 获取accessToken
			String accessToken = AccountManager.getAccessToken(oauthToken);
			if (null == accessToken || accessToken.isEmpty()) {
				logger.info("accessToken is null or is empty!");
				return NOT_LOGINED;
			}
			// 获取用户名信息，并把用户信息写入会话中
			logger.info("开始到userinfo请求用户信息，acceeetoken为：" + accessToken);
			if (!AccountManager.writeToSession(
					AccountManager.getUserInfo(accessToken), accessToken)) {
				logger.info("用户信息写入session失败。");
				return NOT_LOGINED;
			}
			try {
				redirectUrl = java.net.URLEncoder.encode(redirectUrl, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("登录成功，开始跳转到：" + redirectUrl);
			if (redirectUrl == null || redirectUrl.equals("")) {
				setRedirectUrl("news");
			}
			return SUCCESS;
		} else {
			// 会话中无用户信息，而且无oauth_token参数，表示未登录
			return NOT_LOGINED;
		}
	}

	
	public String getOauthToken() {
		return oauthToken;
	}

	public void setOauthToken(String oauthToken) {
		this.oauthToken = oauthToken;
	}

	public String getRedirectUrl() {
		System.out.println(((String[]) ActionContext.getContext()
				.getParameters().get("redirectUrl"))[0]);
		try {
			redirectUrl = URLDecoder.decode(redirectUrl, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}
