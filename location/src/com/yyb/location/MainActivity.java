package com.yyb.location;


import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button down;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initomponents();
		down.setOnClickListener(new ButtonOnClickListener());
		
		
	}
	private void initomponents() {
		down=(Button) findViewById(R.id.myButton);
		
	}
	
	class ButtonOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			LocationManager locationManager = (LocationManager) MainActivity.this.getSystemService(LOCATION_SERVICE);
//			List<String> providers = locationManager.getAllProviders();
//			for (String string : providers) {
//				System.out.println(string);
//			}
			//设置查询条件，选择最好的provider
//			Criteria criteria = new Criteria();
//			criteria.setAccuracy(Criteria.ACCURACY_FINE);
//			criteria.setAltitudeRequired(true);
//			criteria.setCostAllowed(false);
//			String provider = locationManager.getBestProvider(criteria, false);
//			System.out.println(provider);
//			locationManager.requestLocationUpdates ( LocationManager.NETWORK_PROVIDER, 0, 0, new MyLocationLitener());
		
			new GeoLocationListener().execute();
		}
		
	}
	
	class MyLocationLitener implements LocationListener{

		@Override
		public void onLocationChanged(Location location) {
			System.out.println("onLocationChanged");
			System.out.println(location.getLatitude()+"  "+location.getLongitude());
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			System.out.println("onStatusChanged");
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			System.out.println("onProviderEnabled");
		}

		@Override
		public void onProviderDisabled(String provider) {
			System.out.println("onProviderDisabled");
			
		}
		
	}
	
	//异步执行某些方法
	private class GeoLocationListener  extends AsyncTask<Integer, Integer, Integer>{

		@Override
		protected Integer doInBackground(Integer... params) {
			Geocoder geocoder =new Geocoder(MainActivity.this);
			List<Address> list =null;
			try{
				list = geocoder.getFromLocation(30.1, 40, 1);
			    for (Address address : list) {
					System.out.println(address.getCountryName());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
	}
}
