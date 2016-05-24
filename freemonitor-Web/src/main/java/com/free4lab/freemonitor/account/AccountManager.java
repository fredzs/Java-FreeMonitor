package com.free4lab.freemonitor.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.free4lab.freemonitor.account.SessionConstants;
import com.free4lab.freemonitor.account.HttpApiManager;
import com.free4lab.utils.userinfo.UserInfo;
import com.free4lab.utils.userinfo.UserInfoUtil;
import com.opensymphony.xwork2.ActionContext;

public class AccountManager {

	private static final Logger logger = Logger.getLogger(AccountManager.class);
	private static final String ACCESS_TOKEN = "accessToken";
	private static final String KEY = "key";

	private static final String SECRET_KEY = "servicemonitoringSecretKey";
	private static final String APIPrefix_FreeAccount = "http://authentication.free4lab.com/";

	private static final String frAccountAPI_getUserInfo = APIPrefix_FreeAccount
			+ "api/getUserInfo";
	private static final String frAccountAPI_getToken = APIPrefix_FreeAccount
			+ "api/getAccessToken";

	/**
	 * 根据oauthToken和freeshare的secret_key向freeaccount获取用户accessToken
	 * 
	 * @param oauthToken
	 * @return accessToken
	 */
	public static String getAccessToken(String oauthToken) {
		//logger.info("session中无accessToken，通过oauthToken获取");
		HashMap<String, List<String>> params = new HashMap<String, List<String>>();
		List<String> keyValue = new ArrayList<String>();
		// 构造参数变量
		keyValue.add(SECRET_KEY);
		keyValue.add(oauthToken);
		params.put(KEY, keyValue);

		String accessToken = null;
		String result = HttpApiManager.invokeApi(frAccountAPI_getToken, params);
		try {
			JSONObject obj = new JSONObject(result);
			accessToken = obj.getString(ACCESS_TOKEN);
		} catch (NullPointerException npe) {
			//logger.debug("account api :return null", npe);
		} catch (JSONException je) {
			//logger.debug("Analysis Json object failed!", je);
		}
		return accessToken;
	}

	/**
	 * 通过API向frAccount获取用户信息,检验session中的内容是否还有效
	 * 
	 * @param accessToken
	 * @return result 向account请求得到的结果
	 */
	public static String getUserInfoByAccessToken(String accessToken) {
		// 初始化
		HashMap<String, List<String>> params = new HashMap<String, List<String>>();
		List<String> valueList = new ArrayList<String>();
		// 构造参数变量
		valueList.add(accessToken);
		params.put("key", valueList);
		long newsstarttime = System.currentTimeMillis();
		String result = HttpApiManager.invokeApi(frAccountAPI_getUserInfo,
				params);
		long newsendtime = System.currentTimeMillis();
		//System.out.println("the get cost time is " + (newsendtime - newsstarttime));
		return result;
	}

	/**
	 * 通过API向frAccount获取用户信息
	 * 
	 * @param accessToken
	 * @return 成功获取,则返回获得的UserInfo；否则返回null
	 */
	public static UserInfo getUserInfo(String accessToken) {
		//logger.info("通过accessToken向userInfo获取用户信息。accessToken :" + accessToken);
		List<UserInfo> uiList = UserInfoUtil
				.getUserInfoByUid(accessToken, null);
		if (uiList != null & uiList.size() > 0) {
			UserInfo ui = uiList.get(0);
			return ui;
		} else {
			//logger.info("获取用户信息失败失败。");
			return null;
		}
	}

	/**
	 * 把用户信息和accessToken写入到session
	 * 
	 * @return 成功写入返回 true;否则返回false
	 * 
	 */
	public static boolean writeToSession(UserInfo ui, String accessToken) {
		if (ui != null) {

			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put(SessionConstants.UserID,
					Integer.parseInt(ui.getUserId()));
			session.put(SessionConstants.UserName, ui.getUserName());
			session.put(SessionConstants.UserEmail, ui.getEmail());
			session.put(SessionConstants.Avatar, ui.getAvatar());
			session.put(SessionConstants.AccessToken, accessToken);
			logger.info("获取用户信息并写入session。");
			return true;
		} else {

			return false;
		}
	}
}
