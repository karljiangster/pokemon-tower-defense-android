package com.example.pokemontowerdefense.controller;



import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomView extends SurfaceView implements SurfaceHolder.Callback
{
	//field var
	
	private UpdateThread updateThread; 
	private LevelOneDisplay levelOneDisplay; 
	SurfaceHolder holder;  
	
	
	public CustomView(Context context, AttributeSet attrs) {
		super(context, attrs);
		holder = getHolder(); 
		holder.addCallback(this); 
		setFocusable(true); 
		levelOneDisplay = new LevelOneDisplay(context);
		updateThread = new UpdateThread(holder, context, levelOneDisplay, new Handler()); 
		// TODO Auto-generated constructor stub
	}
	
	public CustomView(Context context) {
		super(context);
		holder = getHolder(); 
		holder.addCallback(this); 
		setFocusable(true); 
		levelOneDisplay = new LevelOneDisplay(context);
		updateThread = new UpdateThread(holder, context, levelOneDisplay, new Handler());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// do nothing 
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		
		updateThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
		try {
			updateThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
