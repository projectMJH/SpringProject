package com.sist.vo;

import lombok.Data;

/*
 *  
    rank number,
    poster varchar2(260),
    title varchar2(600),
    singer varchar2(300),
    album varchar2(600)
 */
@Data
public class MusicVO {
	private int rank;
	private String poster,title,singer,album;
}
