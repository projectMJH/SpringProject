package com.sist.spring;
import java.io.*;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.collections.map.HashedMap;
public class ApplicationContext {
	private Map map=new HashedMap();
	public ApplicationContext(String path)
	{
		try
		{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			XMLParser xp=new XMLParser();
			sp.parse(new File(path), xp);
			map=xp.clsMap;
		}catch(Exception ex)	{}
	}
	public Object getBean(String key)
	{
		return map.get(key);
	}
}
