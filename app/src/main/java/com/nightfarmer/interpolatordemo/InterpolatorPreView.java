package com.nightfarmer.interpolatordemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;

/**
 * Created by zhangfan on 16-9-12.
 */
public class InterpolatorPreView extends View {


    private Path path;
    private Paint paintLine;
    private Paint paintPath;
    private ValueAnimator valueAnimator;

    private float horizontalPadding = 10;

    public InterpolatorPreView(Context context) {
        this(context, null);
    }

    public InterpolatorPreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public InterpolatorPreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Interpolator interpolator;

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        initPath();
    }

    public Interpolator getInterpolator() {
        return interpolator;
    }

    private float process = 0;

    public void startAnim() {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        process = 0;
        invalidate();
        valueAnimator = ObjectAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                process = (Float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setStartDelay(500);
        valueAnimator.setDuration(1000);
        valueAnimator.start();
    }

    private void init() {
        path = new Path();
        paintLine = new Paint();
        paintLine.setColor(Color.BLUE);
        paintLine.setStrokeWidth(2);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setAntiAlias(true);

        paintPath = new Paint();
        paintPath.setColor(Color.RED);
        paintPath.setStrokeWidth(2);
        paintPath.setStyle(Paint.Style.STROKE);
        paintPath.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        if (height != 0) {
            canvas.drawLine(0, height / 4f, width, height / 4f, paintLine);
            canvas.drawLine(0, height / 4f * 3, width, height / 4f * 3, paintLine);
            if (path.isEmpty()){
                initPath();
                return;
            }
            canvas.drawPath(path, paintPath);
        }
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, horizontalPadding, getResources().getDisplayMetrics());
        canvas.drawCircle(((width - padding * 2) * process) + padding, interpolator.getInterpolation(process) * (height / 2f) + height / 4f, 15, paintPath);
    }

    public void initPath() {
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, horizontalPadding, getResources().getDisplayMetrics());

        int height = getHeight();
        int width = (int) (getWidth() - padding * 2);
        if (height != 0) {
            path.reset();
            path.moveTo(padding, interpolator.getInterpolation(0) * (height / 2f) + height / 4f);
            for (float i = 0; i <= width; i++) {
                path.lineTo(i + padding, interpolator.getInterpolation(i / width) * (height / 2f) + height / 4f);
            }
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initPath();
    }
}
