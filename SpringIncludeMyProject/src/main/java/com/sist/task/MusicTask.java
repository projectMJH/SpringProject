package com.sist.task;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sist.dao.MusicDAO;
import com.sist.vo.MusicVO;

@Component
public class MusicTask {
	@Autowired
	private MusicDAO mDao;
	
	//https://www.genie.co.kr/chart/top200
	@Scheduled(fixedRate = 60*60*1000)
	public void musicSchedule()
	{
		try
		{
			mDao.musicDelete();
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			String data=doc.toString();
			//System.out.println(data);
			// 2. 특정 요소 찾기 (class="list" 인 <tr> 태그)
            Elements rows = doc.select("tr.list");

            // 3. JSON 배열 생성
            JSONArray jArray = new JSONArray();
//            for (Element row : rows) {
            Element row=null;
            for(int i=0;i<10;i++) {
            	row=rows.get(i);
            	JSONObject jsonObject = new JSONObject();
                MusicVO vo=new MusicVO();
                // 🔹 Title (곡 제목)
                String title = row.select("td.info a.title").text();

                // 🔹 Rank (순위)
                String rank = row.select("td.number").text().split(" ")[0]; // 첫 번째 숫자가 순위

                // 🔹 Image URL (앨범 이미지)
                String imgUrl = row.select("td a.cover img").attr("src");
                
                // 🔹 Artist (아티스트)
                String artist = row.select("td.info a.artist").text();
                
                // 🔹 Album (앨범명)
                String album = row.select("td.info a.albumtitle").text();
                
//                System.out.println("title: "+title);
//                System.out.println("rank: "+rank);
//                System.out.println("imgUrl: "+imgUrl);
//                System.out.println("artist: "+artist);
//                System.out.println("album: "+album);

                vo.setAlbum(album);
                vo.setPoster(imgUrl);
                vo.setRank(Integer.parseInt(rank));
                vo.setSinger(artist);
                vo.setTitle(title);
                mDao.musicInsert(vo);
            }
		}catch(Exception ex) {}
	}

}
