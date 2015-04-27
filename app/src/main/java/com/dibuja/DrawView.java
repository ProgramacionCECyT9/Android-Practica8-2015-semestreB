package com.dibuja;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.View;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

public class DrawView extends View {
    Paint paint = new Paint();
    public static final float TOP_POSITION_TRIANGLE = 3;
    public static final float LEFT_POSITION_TRIANGLE = 3;
    Context myContext;

    public DrawView(Context context) {
        super(context);
        myContext = context;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //.drawRect(left, top, right, bottom, paint)
        paint.setColor(Color.RED);
        canvas.drawRect(30, 30, 80, 80, paint);
        paint.setColor(Color.CYAN);
        canvas.drawRect(33, 60, 77, 77, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(33, 33, 77, 60, paint);

        //.drawCircle(cx, cy, radius, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(100, 100, 20, paint);

        //.drawText(text, x, y, paint)
        canvas.drawText("Texto con CANVAS", 200, 30, paint);

        //.drawLine(startX, startY, stopX, stopY, paint)
        paint.setColor(Color.BLUE);
        canvas.drawLine(0, 0, 350, 100, paint);


        Path trazo = new Path();
        trazo.addCircle(150, 450, 100, Path.Direction.CCW);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(trazo, paint);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(20);
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath("Cecyt 9 \"Juan de Dios Bátiz\" graficos en Android ", trazo, 150, 40, paint);

        drawTriangle(canvas, 300, 300, Color.YELLOW);
        drawPentagon(canvas, 10, 10, Color.CYAN);
        drawHexagon(canvas, 400, 100, Color.RED);

    }

    public void drawTriangle(Canvas canvas, int topLeftX, int topLeftY, int color){;
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);

        Point a = new Point(topLeftX, topLeftY);
        Point b = new Point(topLeftX, topLeftY+100);
        Point c = new Point(topLeftX+87, topLeftY+50);

        Path path = new Path();
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);
    }

    public void drawHexagon(Canvas canvas, int topLeftX, int topLeftY, int color){;
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        Point a = new Point(topLeftX, topLeftY+20);
        Point b = new Point(topLeftX, topLeftY+80);
        int squareSideSize = a.y-b.y;
        Point c = new Point(topLeftX+squareSideSize/2, b.y+20);
        Point d = new Point(topLeftX+squareSideSize, b.y);
        Point e = new Point(topLeftX+squareSideSize, a.y);
        Point f = new Point(topLeftX+squareSideSize/2, topLeftY);

        Path path = new Path();
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(d.x, d.y);
        path.lineTo(e.x, e.y);
        path.lineTo(f.x, f.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);
    }

    public void drawPentagon(Canvas canvas, int topLeftX, int topLeftY, int color){;
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);

        Point a = new Point(topLeftX, topLeftY+20);
        Point b = new Point(topLeftX, topLeftY+80);
        Point c = new Point(topLeftX+50, topLeftY+100);
        Point d = new Point(topLeftX+100, topLeftY+50);
        Point e = new Point(topLeftX+50, topLeftY);


        Path path = new Path();
        path.moveTo(a.x, a.y);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(d.x, d.y);
        path.lineTo(e.x, e.y);
        path.close();

        canvas.drawPath(path, paint);
    }

}