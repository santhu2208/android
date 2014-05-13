package com.yyb.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.yyb.socket.utils.FileUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button start;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initomponents();
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new serverThread().start();
			}
		});
	}
	
	private void initomponents(){
		start=(Button) findViewById(R.id.start);
	}
	
	class serverThread extends Thread{

		@Override
		public void run() {
			ServerSocket sSocket =null;
			try {
				sSocket = new ServerSocket(4567);
				Socket socket = sSocket.accept();
				InputStream is = socket.getInputStream();
				FileUtil.down2SD("socketDir", "socketFile", is);
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					sSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
}
