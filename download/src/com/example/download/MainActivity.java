package com.example.download;

import com.example.download.utils.DownUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button down;
	private Button downMp3;
	private EditText myUrl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initomponents();
		final String url = myUrl.getText().toString();
		down.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				System.out.println(DownUtil.downFile("http://10.0.2.2:8080/Mp3Server/resource.xml"));
				
			}
		});
		downMp3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				int result =DownUtil.downFile("http://10.0.2.2:8080/Mp3Server/a","yubin","b");
				if(result==0){
					System.out.println("down mp3 success");
				}else if(result ==1){
					System.out.println("the file already exist");
				}else{
					System.out.println("down mp3 fail");
				}
				
			}
		});
	}
	
	
	private void initomponents(){
		down=(Button) findViewById(R.id.down);
		downMp3=(Button) findViewById(R.id.downMp3);
		myUrl = (EditText) findViewById(R.id.myUrl);
	}
}
