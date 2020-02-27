package com.watermark.androidwm.sample.watermark.wmutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.ImageView;

import com.watermark.androidwm.WatermarkBuilder;
import com.watermark.androidwm.bean.WatermarkAlignAnchor;
import com.watermark.androidwm.bean.WatermarkText;
import com.watermark.androidwm.sample.watermark.param.base.PositionParam;
import com.watermark.androidwm.sample.watermark.param.base.WMAlign;
import com.watermark.androidwm.sample.watermark.param.wmtext.WMTextParam;
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
     * TextWatermar 样式设置
     *
     * @param wmTextParam
     * @return
     */
    private static WatermarkText getTextWatermar(WMTextParam wmTextParam) {
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
        watermarkText.setTextSize(wmTextStyle.getTextSize());
        watermarkText.setTextAlpha(wmTextStyle.getTextAlpha())
                .setTextColor(Color.parseColor(GeoEditTextUtils.getOptString(wmTextStyle.getTextColor(), DEF_WM_TEXT_COLOR)))
                .setBackgroundColor(Color.parseColor(GeoEditTextUtils.getOptString(wmTextStyle.getBackgroundColor(), DEF_WM_BACKGROUNDCOLOR)));
        //设置字体阴影
        if (wmTextStyle.getShadow() != null) {
            watermarkText.setTextShadow(wmTextStyle.getShadow().getBlurRadius(),
                    wmTextStyle.getShadow().getShadowXOffset(),
                    wmTextStyle.getShadow().getShadowYOffset(),
                    Color.parseColor(GeoEditTextUtils.getOptString(wmTextStyle.getShadow().getShadowColor(), "#00000000")));
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
    public static String saveWmTextBitmap(Context context, WMTextParam wmTextParam) {
        WatermarkText watermarkText = getTextWatermar(wmTextParam);
        Bitmap bitmap = BitmapFactory.decodeFile(wmTextParam.getFilePath());
        Bitmap outputImage = builderTextWatermarkBitmap(context, bitmap, watermarkText);
        return GeoBitmapUtils.saveWmBitmap(outputImage, wmTextParam);
    }

    /**
     * 将水印设置到ImageView上，ImageView要提前设置宽高
     * @param context
     * @param wmTextParam
     * @param imageView
     */
    public static void setWmBitmapToImageView(Context context, WMTextParam wmTextParam, ImageView imageView) {
        WatermarkText watermarkText = getTextWatermar(wmTextParam);
        Bitmap bitmap = BitmapFactory.decodeFile(wmTextParam.getFilePath());
        Bitmap outputImage = builderTextWatermarkBitmap(context, bitmap, watermarkText);
        imageView.setImageBitmap(com.watermark.androidwm.utils.BitmapUtils.resizeBitmap(outputImage, imageView.getMeasuredWidth()));
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

}
