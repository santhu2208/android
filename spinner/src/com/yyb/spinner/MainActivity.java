package com.yyb.spinner;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private Spinner spinner ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initComponents();
//		ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
//	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//第二种方法，动态创建adapter
		List<String> list=new ArrayList<String>();
		list.add("123");
		list.add("456");
		ArrayAdapter adapter  = new ArrayAdapter(this, R.layout.items,R.id.textviewId,list);
	    spinner.setAdapter(adapter);
	    spinner.setPrompt("测试");
	    spinner.setOnItemSelectedListener(new spinnerItemSelect());
	}

	private void initComponents() {
		spinner = (Spinner) findViewById(R.id.planets_spinner);
	}
	
	class spinnerItemSelect implements OnItemSelectedListener{

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {

			String selected = parent.getSelectedItem().toString();
			System.out.println(selected);
			System.out.println("id:"+view.getId()+"="+id+"  position:"+position+"  text:"+parent.getItemAtPosition(position)); 
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			System.out.println("nothing select ");
		}
		
	}
	
	
	

}
