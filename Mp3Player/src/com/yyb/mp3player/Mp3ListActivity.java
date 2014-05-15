package com.yyb.mp3player;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.yyb.mp3player.model.Mp3VO;
import com.yyb.mp3player.utils.DownUtil;
import com.yyb.mp3player.utils.ModelUtil;
import com.yyb.mp3player.utils.Mp3Handler;

public class Mp3ListActivity extends ListActivity {

	private static final int UPDATELIST = 1;
	private static final int ABOUT = 2;
    private static final Mp3VO model = new Mp3VO();
	private static final String[] listColumn =new String[]{model.getMp3Name() ,model.getMp3Size()};
	private static final int[] toList =new int[]{R.id.mp3Name,R.id.mp3Size};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mp3_list);
		initomponents();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case UPDATELIST:
			updateList();
			break;
		case ABOUT:
			about();
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(UPDATELIST, UPDATELIST, UPDATELIST, R.string.update_list);
		menu.add(ABOUT, ABOUT, ABOUT, R.string.about);
		return true;
	}

	private void initomponents() {
		
	}

	private void updateList() {
		// 1从服务器下载歌曲信息---
		String mp3Xml = DownUtil.downFile("http://10.0.2.2:8080/Mp3Server/resource.xml");
		List<Mp3VO> mp3s = praseXml(mp3Xml);
//		List<Map<String, String>> mp3Map = ModelUtil.model2Map(mp3s);
		List<Map<String, String>> mp3Map = new ArrayList<Map<String,String>>();
		for (Mp3VO mp3 :mp3s) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("mp3Name", mp3.getMp3Name());
			map.put("mp3Size", mp3.getMp3Size());
			mp3Map.add(map);
		}
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, mp3Map, R.layout.mp3_item, listColumn, toList);
		setListAdapter(simpleAdapter);
		
	}

	private void about() {
		System.out.println("about");
	}

	// 解析xml 获取歌曲信息到list
	private List<Mp3VO> praseXml(String mp3Xml) {
		List<Mp3VO> mp3s = new ArrayList<Mp3VO>();
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();
			Mp3Handler handler = new Mp3Handler(mp3s);
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new StringReader(mp3Xml)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mp3s;
	}

}
