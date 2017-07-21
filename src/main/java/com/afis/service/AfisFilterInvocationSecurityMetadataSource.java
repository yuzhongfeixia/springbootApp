package com.afis.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import com.afis.entity.autodao.MenuMapper;
import com.afis.entity.automodel.Menu;
import com.afis.entity.automodel.MenuExample;

@Service
public class AfisFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private MenuMapper menuMapper;

	// map中保存所有维护的菜单(key-function,value-放的menu的id)
	private HashMap<String, Collection<ConfigAttribute>> map = null;

	public void loadResourceDefine() {
		map = new HashMap<>();
		Collection<ConfigAttribute> array;
		ConfigAttribute cfg;
		List<Menu> menus = menuMapper.selectByExample(new MenuExample());
		for (Menu menu : menus) {
			if (menu.getFunction() != null && menu.getFunction().trim().length() > 0) {
				array = new ArrayList<>();
				cfg = new SecurityConfig(menu.getId() + "");
				// 此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
				array.add(cfg);
				// 用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
				map.put(menu.getFunction().trim(), array);
			}
		}
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
