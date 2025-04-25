package com.sist.manager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.stereotype.Component;

import com.sist.vo.*;
@Component
public class YoutubeManager {
	public static void main(String[] args) {
		YoutubeManager y=new YoutubeManager();
		y.youtubeJsonData("부산여행");
	}
	public String youtubeJsonData(String fd)
	{
		String result="";
		try {
			String strUrl="https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q="
							+URLEncoder.encode(fd,"UTF-8")
							+"&type=video&key=AIzaSyDMRTikvaxbcXhLC2sskccD7vzKFhsCC1o";
			URL url=new URL(strUrl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			// Jsoup.connection()
			StringBuffer sb=new StringBuffer();
			if(conn!=null)	// 연결된 경우
			{
				BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while(true)
				{
					String s=in.readLine();
					if(s==null)
						break;
					sb.append(s);	
				}
				
				result=sb.toString();
				
				in.close();
				conn.disconnect();
			}
			System.out.println(sb.toString());
		} catch (Exception ex) {}
		return result;
	}
}
