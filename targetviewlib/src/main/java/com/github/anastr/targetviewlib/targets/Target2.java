package com.github.anastr.targetviewlib.targets;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.github.anastr.targetviewlib.Target;

public class Target2 extends Target {

    public Target2(Context context, Target.Builder builder) {
        super(context, builder);
        init();
    }

    private void init() {
        rect_paint = new Paint();
        indicator_paint = new Paint();
        rect = new RectF();

        rect_paint.setAntiAlias(true);
        rect_paint.setStyle(Paint.Style.STROKE);

        indicator_paint.setAntiAlias(true);
    }

    private Paint rect_paint, indicator_paint;
    private RectF rect;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /** Arc indicator */
        float indicatorHeight = getWidth() / (2f + (getWidth() / 100 + 1));
        float indicatorRisk = indicatorHeight - 10f;

        rect_paint.setColor(targetColor);
        rect_paint.setStrokeWidth(targetWidth);
        indicator_paint.setColor(targetColor);

        float risk = targetWidth /2f;
        rect.set(getLeft() +risk + indicatorRisk, getTop() +risk + indicatorRisk
                , getRight() -risk - indicatorRisk, getBottom()-risk - indicatorRisk);
        canvas.drawOval(rect, rect_paint);

        // indicator Top
        rect.set(getWidth()/2f - (getWidth()/16f), getTop() -(indicatorHeight /2f)
                , getWidth()/2f + (getWidth()/16f), getTop() + indicatorHeight);
        canvas.save();
        for (int i=1; i<=4; i++) {
            canvas.drawArc (rect, 70f, 40f, true, indicator_paint);
            canvas.rotate(90f, getWidth()/2f, getHeight()/2f);
        }
        canvas.restore();
    }
}
