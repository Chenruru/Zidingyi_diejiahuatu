package test.bwie.com.zidingyi_diejiahuatu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.graphics.Path.Op.DIFFERENCE;

/**
 * date: 2017/5/8
 * author:陈茹
 * 类的用途:
 */

public class Neifangwaiyuan extends View {
    private Paint mPaint;
    private Region mRegion;
    private Region mRegion1;

    public Neifangwaiyuan(Context context) {
        super(context);
    }

    public Neifangwaiyuan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    //写个方法，重写画笔
    private void initPaint() {
        mPaint = new Paint();  //画笔
        mPaint.setStyle(Paint.Style.FILL);   //设置样式（fill装满，填满）
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.GREEN);
    }

       public Neifangwaiyuan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //绘图的内容都写在 onDraw里了
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getWidth() / 2;  //X轴
        int y = getHeight() / 2; //Y轴
        Path path0 = new Path();
        path0.addCircle(x, y, 200, Path.Direction.CCW);//Path.Direction.CCW路径反时针道路
        mPaint.setColor(Color.YELLOW);  //之前设置颜色
        canvas.drawPath(path0, mPaint);

        Path path = new Path();
        path.moveTo(x - 200, y);
        path.lineTo(x, y - 200);
        path.lineTo(x + 200, y);
        path.lineTo(x, y + 200);
        path.lineTo(x - 200, y);
        path.close();
        mPaint.setColor(Color.RED);
        canvas.drawPath(path, mPaint);

        Path path2 = new Path();
        path2.moveTo(x - 100, y - 100);
        path2.lineTo(x + 100, y - 100);
        path2.lineTo(x + 100, y + 100);
        path2.lineTo(x - 100, y + 100);
        path2.lineTo(x - 100, y - 100);
        mPaint.setColor(Color.BLUE);
        canvas.drawPath(path2, mPaint);

        path0.op(path, DIFFERENCE);
        path.op(path2, DIFFERENCE);

        mRegion = new Region();
        mRegion1 = new Region();
        mRegion.setPath(path0, new Region(0, 0, 1000, 1000));
        mRegion1.setPath(path, new Region(0, 0, 1000, 1000));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int w = (int) event.getX();
        int h = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (mRegion.contains(w, h)) {
                    mListener.onClick(this);
                }
                if (mRegion1.contains(w, h)) {
                    m.onClick(this);
                }
                break;
        }
        return true;
    }


    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        mListener = l;
    }

    public void setOnClick(OnClickListener m) {
        this.m = m;
    }

    OnClickListener mListener;
    OnClickListener m;
}
