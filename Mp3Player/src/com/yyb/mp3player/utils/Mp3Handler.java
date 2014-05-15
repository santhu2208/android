package com.yyb.mp3player.utils;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.yyb.mp3player.model.Mp3VO;

public class Mp3Handler extends DefaultHandler {
	private List<Mp3VO> mp3VOs = null;
	private Mp3VO mp3VO =null;
	private String tagName;
	public Mp3Handler(List<Mp3VO> mp3VOs){
		this.mp3VOs=mp3VOs;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String temp =  new String(ch, start, length);
	   if("id".equals(tagName)){
		   mp3VO.setId(temp);
	   }else if("mp3.name".equals(tagName)){
		   mp3VO.setMp3Name(temp);
	   }else if("mp3.size".equals(tagName)){
		   mp3VO.setMp3Size(temp);
	   }else if("lrc.name".equals(tagName)){
		   mp3VO.setLrcName(temp);
	   }else if("lrc.size".equals(tagName)){
		   mp3VO.setLrcSize(temp);
	   }
	   
	 }

	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		if("resurce".equals(localName)){
			mp3VO = new Mp3VO();
		}
		this.tagName = localName;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("resurce".equals(localName)){
			mp3VOs.add(mp3VO);
		}
		this.tagName ="";
	}
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

}
