package com.example.brocast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	private Button brocast;
	private Button unbrocast;
	private SMSRecevier smsRecevier;
	private final static String SMS_ACTION ="android.provider.Telephony.SMS_RECEIVED";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initomponents();
		brocast.setOnClickListener(new Register());
		unbrocast.setOnClickListener(new UnRegister());
		
	}
	
	private void initomponents(){
		brocast=(Button) findViewById(R.id.brocast);
		unbrocast=(Button) findViewById(R.id.unbrocast);
	}
	
	class Register implements OnClickListener {

		@Override
		public void onClick(View v) {
			smsRecevier = new SMSRecevier();
//			Intent intent = new Intent();
//			intent.setAction(Intent.ACTION_EDIT);
//			MainActivity.this.sendBroadcast(intent);
			IntentFilter intentFilter = new IntentFilter();
			intentFilter.addAction(SMS_ACTION);
			MainActivity.this.registerReceiver(smsRecevier, intentFilter);
			
		}
		
	}
	
	class UnRegister implements OnClickListener {

		@Override
		public void onClick(View v) {
			MainActivity.this.unregisterReceiver(smsRecevier);
		}
		
	}
}
