package com.zeros.mybottomred.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

import com.zeros.mybottomred.R;

/**
 * 可以显示小圆点的RadioButton ▏2018/4/19.
 */

@SuppressLint("AppCompatCustomView")
public class TipButton extends RadioButton {

    private boolean mTipOn = false;
    private Dot mDot;

    public TipButton(Context context) {
        super(context);
        init();
    }

    public TipButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TipButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDot = new Dot();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mTipOn) {
            float cx = getWidth() - mDot.marginRight - mDot.radius;
            float cy = mDot.marginTop + mDot.radius;

            Drawable drawableTop = getCompoundDrawables()[1];
            if (drawableTop != null) {
                int drawableTopWidth=drawableTop.getIntrinsicWidth();
                if (drawableTopWidth > 0) {
                    int dotLeft = getWidth() / 2 + drawableTopWidth / 2;
                    cx = dotLeft + mDot.radius;
                }
            }

            Paint paint = getPaint();
            //save
            int tempColor = paint.getColor();
            paint.setColor(mDot.color);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(cx, cy, mDot.radius, paint);

            //restore
            paint.setColor(tempColor);
        }
    }

    private class Dot {
        int color;
        int radius;
        int marginTop;
        int marginRight;

        Dot() {
            float density = getContext().getResources().getDisplayMetrics().density;
            radius = (int) (5 * density);
            marginTop = (int) (3 * density);
            marginRight = (int) (3 * density);
            color = getContext().getResources().getColor(R.color.red);
        }
    }

    public boolean isTipOn() {
        return mTipOn;
    }

    public void setTipOn(boolean mTipOn) {
        this.mTipOn = mTipOn;
        invalidate();
    }
}

