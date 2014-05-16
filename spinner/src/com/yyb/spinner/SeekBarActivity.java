package com.yyb.spinner;

import java.util.RandomAccess;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.SeekBar;

public class SeekBarActivity extends Activity {

	private SeekBar seekBar;
	RatingBar ratingBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seek_bar);
		initComponent();
		seekBar.setOnSeekBarChangeListener(new SeekBarListener());
		ratingBar.setOnRatingBarChangeListener(new RatingBarChangeListener());
	
		
	}
	
	protected class SeekBarListener implements SeekBar.OnSeekBarChangeListener{

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			System.out.println(progress);
			
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			System.out.println(seekBar.getProgress());
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			System.out.println(seekBar.getProgress());
		}
		
	}
	
	protected class RatingBarChangeListener implements RatingBar.OnRatingBarChangeListener{

		@Override
		public void onRatingChanged(RatingBar ratingBar, float rating,
				boolean fromUser) {
			System.out.println(rating);
		}
		
	}

	private void initComponent() {
		seekBar = (SeekBar) findViewById(R.id.mySeekBar);
		ratingBar = (RatingBar)findViewById(R.id.myRatingBar);
		
	}
}
