package com.example.brocast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

public class SMSRecevier extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("recevier sms");
		SmsManager sms = SmsManager.getDefault(); // 得到短信管理器
		Bundle bundle = intent.getExtras(); // 得到意图中的bundle对象
		if (bundle != null) {
			Object[] pdus = (Object[]) bundle.get("pdus"); // 得到名称为"pdus"的对象,是一个Object数组,里面的每一个元素为一个byte[]数组
			SmsMessage[] messages = new SmsMessage[pdus.length];
			for (int i = 0; i < pdus.length; i++)
				messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
			for (SmsMessage message : messages) {
				String msg = message.getMessageBody(); // 短信内容
				String to = message.getOriginatingAddress(); // 短信地址
				sms.sendTextMessage(to, null, msg, null, null);//发送短信to
				System.out.println("msg:"+msg +"to:"+to);
			}
		}
	}
}
