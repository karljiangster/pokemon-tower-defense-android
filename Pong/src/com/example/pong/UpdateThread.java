package com.example.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.SurfaceHolder;


public class UpdateThread extends Thread{

	protected SurfaceHolder surfaceHolder; 
	protected PongDisplay display; 
	protected Paint paint; 
	protected Handler handler; 
	protected Context context; 
	boolean isSetup; 
	
	public UpdateThread(SurfaceHolder holder, Context context,
			PongDisplay pongDisplay, Handler handler) {
		
		this.surfaceHolder = holder;
		this.display = pongDisplay;
		this.paint = new Paint(); 
		this.handler = handler;
		this.context = context; 
		isSetup = false; 
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			Canvas canvas = surfaceHolder.lockCanvas(); 
			
			if(!isSetup)
			{
				display.setUp(canvas, paint); 
				isSetup = true; 
			}
			// update hereeeee 
			display.update(canvas, paint);
			display.draw(canvas, paint);
			surfaceHolder.unlockCanvasAndPost(canvas);
		}
	}

}
