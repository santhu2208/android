package com.yyb.animations;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements AnimationListener{

	private ImageView myImage;
	private Button myRotate;
	private Button myScale;
	private Button myAlpha;
	private Button myTranslate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initCompents();
		myRotate.setOnClickListener(new OnclickRotateListener());
		myScale.setOnClickListener(new OnclickScaleListener());
		myAlpha.setOnClickListener(new OnclickAlphaListener());
		myTranslate.setOnClickListener(new OnclickTranslateListener());
		
		
	}
	private void initCompents() {
		myImage =(ImageView)findViewById(R.id.myImage);
		myRotate = (Button) findViewById(R.id.myRotate);
		myScale = (Button) findViewById(R.id.myScale);
		myAlpha = (Button) findViewById(R.id.myAlpha);
		myTranslate = (Button) findViewById(R.id.myTranslate);
	}
	
	class OnclickRotateListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			//RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
//			animals(rotateAnimation);
			Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
			animation.setAnimationListener(MainActivity.this);
			myImage.startAnimation(animation);
		}
		
	}
	class OnclickScaleListener implements OnClickListener{
		
		@Override
		public void onClick(View v) {
			//ScaleAnimation scaleAnimation  = new ScaleAnimation(0f,0.5f,0f,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//			animals(scaleAnimation);
			Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
			animation.setAnimationListener(MainActivity.this);
			myImage.startAnimation(animation);
		}
		
	}
	class OnclickAlphaListener implements OnClickListener{
		
		@Override
		public void onClick(View v) {
			//AlphaAnimation alphaAnimation = new AlphaAnimation(1,0.3f);
//			animals(alphaAnimation);
			
			Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
			animation.setAnimationListener(MainActivity.this);
			myImage.startAnimation(animation);
		}
		
	}
	class OnclickTranslateListener implements OnClickListener{
		
		@Override
		public void onClick(View v) {
//			TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,0.5f);
//			animals(translateAnimation);
			
			Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
			animation.setAnimationListener(MainActivity.this);
			myImage.startAnimation(animation);
		}
		
	}
	
	private void animals(Animation animation){
		AnimationSet animationSet =new AnimationSet(true);
		if(animation instanceof AlphaAnimation){
			AlphaAnimation alphaAnimation =(AlphaAnimation)animation;
			
			animationSet.addAnimation(alphaAnimation);
		}else if(animation instanceof RotateAnimation){
			RotateAnimation rotateAnimation =(RotateAnimation)animation;
			
			animationSet.addAnimation(rotateAnimation);
		}else if(animation instanceof ScaleAnimation){
			ScaleAnimation scaleAnimation =(ScaleAnimation)animation;
			
			animationSet.addAnimation(scaleAnimation);
		}else if(animation instanceof TranslateAnimation){
			TranslateAnimation translateAnimation =(TranslateAnimation)animation;
			
			animationSet.addAnimation(translateAnimation);
		}
		animationSet.setDuration(2000);
		myImage.startAnimation(animationSet);
		
	}
	@Override
	public void onAnimationStart(Animation animation) {
		System.out.println("onAnimationStart");
		
	}
	@Override
	public void onAnimationEnd(Animation animation) {
		System.out.println("onAnimationEnd");
	}
	@Override
	public void onAnimationRepeat(Animation animation) {
		System.out.println("onAnimationRepeat");
	} 
	
}