package com.yyb.mp3player;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Mp3ListActivity extends ListActivity {

	private static final int UPDATELIST = 1; 
	private static final int ABOUT = 2; 
	private TextView mp3Name;
	private TextView mp3Size;
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
	
	private void initomponents(){
//		mp3Name=(TextView) findViewById(R.id.mp3_name);
//		mp3Size=(TextView) findViewById(R.id.mp3_size);
	}
	private void updateList(){
		System.out.println("updateList");
	}
	private void about() {
		System.out.println("about");
	}
}