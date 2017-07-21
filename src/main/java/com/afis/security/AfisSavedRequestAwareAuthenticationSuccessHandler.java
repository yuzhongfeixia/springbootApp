package com.afis.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.afis.entity.autodao.OperatorMapper;
import com.afis.entity.automodel.Operator;
import com.afis.util.CookieConstants;
import com.afis.util.SessionUtil;
import com.afis.util.javacookie.Cookies;

@Component
public class AfisSavedRequestAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private OperatorMapper operatorMapper;

	private Logger logger = LoggerFactory.getLogger(AfisSavedRequestAwareAuthenticationSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		Cookies cookies = Cookies.initFromServlet(request, response);
		String operatorName = SessionUtil.getOperatorName();
		logger.debug("login success,user:{}", operatorName);
		cookies.set(CookieConstants.WEB_USERNAME, operatorName);

		// 更新最新登录时间和最新登录ip
		Long userId = SessionUtil.getUserId();
		Operator operator = new Operator();
		operator.setId(userId);
		operator.setLastLoginIp(SessionUtil.getIpAddr(request));
		operator.setLastLoginTime(new Date());
		operatorMapper.updateByPrimaryKeySelective(operator);

		super.onAuthenticationSuccess(request, response, authentication);

	}
}
