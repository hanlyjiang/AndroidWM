package com.watermark.androidwm.sample.watermark.wmutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.watermark.androidwm.WatermarkBuilder;
import com.watermark.androidwm.bean.WatermarkAlignAnchor;
import com.watermark.androidwm.bean.WatermarkText;
import com.watermark.androidwm.sample.R;
import com.watermark.androidwm.sample.watermark.param.base.PositionParam;
import com.watermark.androidwm.sample.watermark.param.base.WMAlign;
import com.watermark.androidwm.sample.watermark.param.wmtext.WmTextParam;
import com.watermark.androidwm.sample.watermark.param.wmtext.WmTextStyle;

/**
 * @Author: wangsengren
 * @Description: 谁赢工具类
 * @Date: 2020-02-22
 * @Version: 1.0
 */
public class WatermarkUtils {
    private final static String DEF_WM_BACKGROUNDCOLOR = "#00000000";
    private final static String DEF_WM_TEXT_COLOR = "#000000";

    /**
     * 通过Json获取Watermar参数
     *
     * @return
     */
    protected static WatermarkText getTextWatermar(String json) {
        Gson gson = new Gson();
        WmTextParam wmTextParam = gson.fromJson(json, WmTextParam.class);
        return getTextWatermar(wmTextParam);
    }

    protected static WatermarkText getTextWatermar(WmTextParam wmTextParam) {
        WatermarkText watermarkText = new WatermarkText(wmTextParam.getText());
        PositionParam wmTextParamPosition = wmTextParam.getPosition();
        if (wmTextParamPosition == null) {
            wmTextParamPosition = new PositionParam();
        }

        // 设置位置 0.5 居中
        watermarkText.setPositionX(wmTextParamPosition.getX())
                .setPositionY(wmTextParamPosition.getY())
                .setRotation(wmTextParamPosition.getRotation())
                .setAlignAnchor(new WatermarkAlignAnchor(WMAlign.getWMAlign(wmTextParamPosition.getHorizontalAlignAnchor()),
                        WMAlign.getWMAlign(wmTextParamPosition.getVerticalAlignAnchor())));
        //设置Margin

        watermarkText.setMargin(new WatermarkText.Margin(wmTextParamPosition.getMargin().getLeft(),
                wmTextParamPosition.getMargin().getTop(), wmTextParamPosition.getMargin().getRight(),
                wmTextParamPosition.getMargin().getBottom()));


        //设置样式
        WmTextStyle wmTextStyle = wmTextParam.getStyle();
        if (wmTextStyle == null) {
            wmTextStyle = new WmTextStyle();
        }
        watermarkText.setTextStyle(Paint.Style.FILL);
        watermarkText.setTextSize(wmTextStyle.getTextSize());
        watermarkText.setTextAlpha(wmTextStyle.getTextAlpha())
                .setTextColor(Color.parseColor(EditTextUtils.getOptString(wmTextStyle.getTextColor(), DEF_WM_TEXT_COLOR)))
                .setBackgroundColor(Color.parseColor(EditTextUtils.getOptString(wmTextStyle.getBackgroundColor(), DEF_WM_BACKGROUNDCOLOR)));
        //设置字体阴影
        if (wmTextStyle.getShadow() != null) {
            watermarkText.setTextShadow(wmTextStyle.getShadow().getBlurRadius(),
                    wmTextStyle.getShadow().getShadowXOffset(),
                    wmTextStyle.getShadow().getShadowYOffset(),
                    Color.parseColor(EditTextUtils.getOptString(wmTextStyle.getShadow().getShadowColor(), "#00000000")));
        }
        return watermarkText;
    }

    /**
     * 保存水印图片
     *
     * @param context
     * @param wmTextParam
     * @return
     */
    public static String saveWmTextBitmap(Context context, WmTextParam wmTextParam) {
        WatermarkText watermarkText = getTextWatermar(wmTextParam);
        Bitmap bitmap = BitmapFactory.decodeFile(wmTextParam.getFilePath());
        Bitmap outputImage = builderTextWatermarkBitmap(context, bitmap, watermarkText);
        return GeoBitmapUtils.saveWmBitmap(outputImage, wmTextParam);
    }

    /**
     * 将水印设置到ImageView上，ImageView要提前设置宽高
     *
     * @param context
     * @param wmTextParam
     * @param imageView
     */
    public static void setWmBitmapToImageView(Context context, WmTextParam wmTextParam, ImageView imageView) {
        WatermarkText watermarkText = getTextWatermar(wmTextParam);
        builderTextWatermarkImageView(context, imageView, watermarkText);
    }


    /**
     * 创建一个文本水印
     *
     * @param context
     * @param bitmap
     */
    public static Bitmap builderTextWatermarkBitmap(Context context, Bitmap bitmap, WatermarkText watermarkText) {
        return WatermarkBuilder.create(context, bitmap)
                .setTileMode(false)
                .loadWatermarkText(watermarkText)
                .getWatermark()
                .getOutputImage();
    }

    /**
     * 给一个ImageView添加水印
     * @param context
     * @param imageView
     * @param watermarkText
     */
    public static void builderTextWatermarkImageView(Context context, ImageView imageView, WatermarkText watermarkText) {
        WatermarkBuilder.create(context, R.drawable.test2)
                .setTileMode(false)
                .loadWatermarkText(watermarkText)
                .getWatermark()
                .setToImageView(imageView);
    }
}
