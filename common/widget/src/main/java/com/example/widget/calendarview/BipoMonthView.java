package com.example.widget.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;


import com.example.widget.R;

import java.util.HashMap;
import java.util.List;

/**
 * @author：ivan huang
 * @date：2018/10/28
 * @describle  高仿魅族日历布局
 */

public class BipoMonthView extends MonthView {
    private int mRadius;
    /**
     * 灰色文字
     */
    private Paint mTextGrayPaint = new Paint();

    /**
     * 自定义标记的圆形背景（选中圆形）
     */
    private Paint mSchemeBasicPaint = new Paint();
    private Context mContext;
    private final int space = 6;
    private final int FONT_SIZE = 14;
     //绘制灰色圆点
    private Paint mPaintGray = new Paint();
    //绘制红色圆点
    private Paint mPaintRed = new Paint();
    //绘制橙色圆点
    private Paint mPointOrange = new Paint();
    //绘制蓝色圆点
    private Paint mPointBlue = new Paint();

    //绘制绿色圆点
    private Paint mPointGreen = new Paint();
    private HashMap<String, Paint> paintMap = new HashMap();

    public BipoMonthView(Context context) {
        super(context);
        mContext = context;

        //绘制灰色文字
        mTextGrayPaint.setAntiAlias(true);
//        mTextGrayPaint.setStyle(Paint.Style.FILL);
        mTextGrayPaint.setTextAlign(Paint.Align.CENTER);
        mTextGrayPaint.setColor(0xffDCDCDC);
//        mTextGrayPaint.setFakeBoldText(true);
        mTextGrayPaint.setTextSize(dipToPx(context, 14));
        //绘制灰色圆点
        mPaintGray.setAntiAlias(true);
        mPaintGray.setTextAlign(Paint.Align.CENTER);
        mPaintGray.setColor(ContextCompat.getColor(getContext(),R.color.color_guide_grey));

        mPaintRed.setAntiAlias(true);
        mPaintRed.setTextAlign(Paint.Align.CENTER);
        mPaintRed.setColor(ContextCompat.getColor(getContext(), R.color.color_guide_red));

        mPointOrange.setAntiAlias(true);
        mPointOrange.setTextAlign(Paint.Align.CENTER);
        mPointOrange.setColor(ContextCompat.getColor(getContext(),R.color.color_guide_orange));

        mPointBlue.setAntiAlias(true);
        mPointBlue.setTextAlign(Paint.Align.CENTER);
        mPointBlue.setColor(ContextCompat.getColor(getContext(),R.color.color_guide_blue));


        mPointGreen.setAntiAlias(true);
        mPointGreen.setTextAlign(Paint.Align.CENTER);
        mPointGreen.setColor(ContextCompat.getColor(getContext(),R.color.color_guide_green));
        paintMap.put("pointGray", mPaintGray);
        paintMap.put("pointRed", mPaintRed);
        paintMap.put("pointOrange", mPointOrange);
        paintMap.put("pointBlue", mPointBlue);
        paintMap.put("pointGreen", mPointGreen);

        mSchemeBasicPaint.setAntiAlias(true);
//        mSchemeBasicPaint.setStyle(Paint.Style.FILL);
        mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER);
        mSchemeBasicPaint.setColor(ContextCompat.getColor(getContext(),R.color.color_login_blue));
        mTextGrayPaint.setTextSize(dipToPx(context, FONT_SIZE));
        mCurDayTextPaint.setTextSize(dipToPx(context, FONT_SIZE));
        mSchemeTextPaint.setTextSize(dipToPx(context, FONT_SIZE));
//        mSchemeBasicPaint.setFakeBoldText(true);
        //兼容硬件加速无效的代码
//        setLayerType(View.LAYER_TYPE_SOFTWARE, mSchemeBasicPaint);
        //4.0以上硬件加速会导致无效
//        mSchemeBasicPaint.setMaskFilter(new BlurMaskFilter(25, BlurMaskFilter.Blur.SOLID));
    }

    /**
     * 绘制选中的日子
     *
     * @param canvas    canvas
     * @param calendar  日历日历calendar
     * @param x         日历Card x起点坐标
     * @param y         日历Card y起点坐标
     * @param hasScheme hasScheme 非标记的日期
     * @return true 则绘制onDrawScheme，因为这里背景色不是是互斥的
     */
    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        int cx = x + mItemWidth / 2;
        int cy = y + mItemHeight / 2;
        canvas.drawCircle(cx, cy, mRadius, mSchemeBasicPaint);
        return true;

    }

    @Override
    protected void onPreviewHook() {
        mRadius = Math.min(mItemWidth, mItemHeight) / 5 * 2;
    }

    /**
     * 绘制标记的事件日子
     *
     * @param canvas   canvas
     * @param calendar 日历calendar
     * @param x        日历Card x起点坐标
     * @param y        日历Card y起点坐标
     */
    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
        mSchemeBasicPaint.setColor(calendar.getSchemeColor());

        drawPaint(calendar, canvas, x, y);
    }

    /**
     * 画点
     *
     * @param calendar
     * @param canvas
     * @param x
     * @param y
     */
    private void drawPaint(Calendar calendar, Canvas canvas, int x, int y) {
        int cx = x + mItemWidth / 2;
//        int cy = y + mItemHeight / 2;
        int radius = dipToPx(mContext, 2);
        try {
            List<String> statusList = calendar.getSchemes().get(0).getStatusList();
            switch (statusList.size()) {
                case 1:
                    if (statusList.size() > 0) {
                        canvas.drawCircle(cx, y + mItemHeight - radius, radius, paintMap.get(statusList.get(0)));
                    }
                    break;
                case 2:
                    canvas.drawCircle(cx - radius - space / 2, y + mItemHeight - radius, radius, paintMap.get(statusList.get(0)));
                    canvas.drawCircle(cx + radius + space / 2, y + mItemHeight - radius, radius, paintMap.get(statusList.get(1)));
                    break;
                case 3:
                    canvas.drawCircle(cx - 2 * radius - space, y + mItemHeight - radius, radius, paintMap.get(statusList.get(0)));
                    canvas.drawCircle(cx, y + mItemHeight - radius, radius, paintMap.get(statusList.get(1)));
                    canvas.drawCircle(cx + 2 * radius + space, y + mItemHeight - radius, radius, paintMap.get(statusList.get(2)));
                    break;
                case 4:
                    canvas.drawCircle(cx - 3 * radius - space / 2 - space, y + mItemHeight - radius, radius, paintMap.get(statusList.get(0)));
                    canvas.drawCircle(cx - radius - space / 2, y + mItemHeight - radius, radius, paintMap.get(statusList.get(1)));
                    canvas.drawCircle(cx + space / 2 + radius, y + mItemHeight - radius, radius, paintMap.get(statusList.get(2)));
                    canvas.drawCircle(cx + space / 2 + 3 * radius + space, y + mItemHeight - radius, radius, paintMap.get(statusList.get(3)));
                    break;

            }
            invalidate();
        } catch (Exception e) {
        }

    }

//    private float getTextWidth(String text) {
//        return mTextPaint.measureText(text);
//    }

    /**
     * 绘制文本
     *
     * @param canvas     canvas
     * @param calendar   日历calendar
     * @param x          日历Card x起点坐标
     * @param y          日历Card y起点坐标
     * @param hasScheme  是否是标记的日期
     * @param isSelected 是否选中
     */
    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        float baselineY = mTextBaseLine + y;
        int cx = x + mItemWidth / 2;
        //是否选中
        if (isSelected) {
            canvas.drawText(String.valueOf(calendar.getDay()),
                    cx,
                    baselineY,
                    mSelectTextPaint);

        } else if (hasScheme) {//是否标记
            canvas.drawText(String.valueOf(calendar.getDay()),
                    cx,
                    baselineY,
                    //如果是当前日期就绘制
                    calendar.isCurrentDay() ? mCurDayTextPaint : calendar.getSchemes().get(0).isDataGray() ? mTextGrayPaint : mSchemeTextPaint);
//            drawPaint(calendar, canvas, x, y);

        } else {
            canvas.drawText(String.valueOf(calendar.getDay()), cx, baselineY, calendar.isCurrentDay() ? mCurDayTextPaint : mTextGrayPaint);
        }


    }

    /**
     * dp转px
     *
     * @param context context
     * @param dpValue dp
     * @return px
     */
    private static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
