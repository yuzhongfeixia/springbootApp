package com.afis.service;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.afis.entity.CustomUserDetails;
import com.afis.entity.autodao.OperatorMapper;
import com.afis.entity.automodel.Operator;
import com.afis.entity.automodel.OperatorExample;

/**
 * 记住密码功能使用
 * 
 * 根据rememberMe获得的登录名去获取用户权限
 * @author chengen
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private OperatorMapper operatorMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		OperatorExample example = new OperatorExample();
		example.createCriteria().andLoginAccountEqualTo(username);
		List<Operator> list = operatorMapper.selectByExample(example);
		Operator opr = list.get(0);
		//获取用户权限
		final Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		return new CustomUserDetails(opr.getId(), username, opr.getPassword(), authorities);
	}
}
