package com.afis.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.afis.entity.CustomUserDetails;
import com.afis.entity.autodao.OperatorMapper;
import com.afis.entity.automodel.Menu;
import com.afis.entity.automodel.Operator;
import com.afis.entity.automodel.OperatorExample;
import com.afis.jx.mapper.BusinessMapper;
import com.afis.util.Constants.AccountStatus;
import com.afis.util.MD5;

/**
 * 通过登录页登录走的类
 * 
 * @author chengen
 *
 */
@Component
public class AfisAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private OperatorMapper operatorMapper;

	@Autowired
	private BusinessMapper businessMapper;

	private Logger logger = LoggerFactory.getLogger(AfisAuthenticationProvider.class);

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		OperatorExample example = new OperatorExample();
		example.createCriteria().andLoginAccountEqualTo(username);
		List<Operator> list = operatorMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			Operator opr = list.get(0);
			// 账号是否注销验证
			if (AccountStatus.CANCEL.key.equals(opr.getStatus())) {// 账号注销
				throw new DisabledException("account disabled.");
			}

			// 密码验证
			if (!opr.getPassword().equals(MD5.code16(password.toString()))) {
				throw new BadCredentialsException("Wrong password.");
			}

			// 获取当前用户能访问的所有菜单
			final Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			List<Menu> menuList = businessMapper.queryMenuByOperatorId(opr.getId());
			if (menuList != null) {
				for (Menu menu : menuList) {
					authorities.add(new SimpleGrantedAuthority(menu.getId() + ""));
				}
			}
			return new UsernamePasswordAuthenticationToken(
					new CustomUserDetails(opr.getId(), username, password, authorities), password, authorities);
		} else {
			throw new BadCredentialsException("Username not found.");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
