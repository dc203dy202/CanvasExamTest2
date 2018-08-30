package com.example.dayeon.canvasexam;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

import java.util.logging.LogRecord;

public class MyView extends View {

    Handler handler;
    Runnable runnable;

    final int UPDATE_MILLS = 30;

    Paint paint = new Paint();
    Bitmap birds[];
    int birdFrame;

    public MyView(Context context) {
        super(context);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        birds = new Bitmap[2];
        birds[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bird);
        birds[1] = BitmapFactory.decodeResource(getResources(), R.drawable.bird2);
        birdFrame = 0;


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(birdFrame == 0) birdFrame = 1;
        else birdFrame = 0;


        canvas.drawRect(100, 100, 300, 300, paint);
//        while(true){
//            canvas.drawBitmap(birds[0], 200, 300, paint);
//            canvas.drawBitmap(birds[1], 200, 300, paint);
//        }

        canvas.drawBitmap(birds[birdFrame], 300, 400, null);




        handler.postDelayed(runnable, UPDATE_MILLS);
    }
}
