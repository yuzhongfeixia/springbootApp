package com.afis.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;

import com.afis.entity.CustomUserDetails;

/**
 * Created by wanghui on 16-11-25.
 */
public class SessionUtil {

	/**
	 * 获取操作员名称
	 * 
	 * @return
	 */
	public static String getOperatorName() {
		CustomUserDetails customUserDetails = getCustomUserDetails();
		if (customUserDetails != null) {
			return customUserDetails.getUsername();
		}

		return null;
	}

	public static CustomUserDetails getCustomUserDetails() {
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (obj != null && obj instanceof CustomUserDetails) {
			return (CustomUserDetails) obj;
		}

		return null;
	}

	public static Long getUserId() {
		CustomUserDetails customUserDetails = getCustomUserDetails();
		if (customUserDetails != null) {
			return customUserDetails.getId();
		}

		return null;
	}

	public static final String getIpAddr(final HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
