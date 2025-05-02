package com.sist.spring4;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
public class Container {
	private Map clsMap=new HashedMap();
	public Container()
	{
		clsMap.put("a",	new A());
		clsMap.put("b",	new B());
		clsMap.put("c",	new C());
		
	}
	public Object getBean(String key)
	{
		return clsMap.get(key);
	}
}
