package com.watermark.androidwm.sample.watermark.param.wmtext;

import com.watermark.androidwm.sample.watermark.param.base.BaseStyleParam;
import com.watermark.androidwm.sample.watermark.param.style.TextShadow;

/**
 * @Author: wangsengren
 * @Description: 水印文本样式
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class WmTextStyle extends BaseStyleParam {
    private String textColor ;
    private int textSize = 14;
    private int textAlpha = 255;
    private TextShadow shadow;

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getTextAlpha() {
        return textAlpha;
    }

    public void setTextAlpha(int textAlpha) {
        this.textAlpha = textAlpha;
    }

    public TextShadow getShadow() {
        return shadow;
    }

    public void setShadow(TextShadow shadow) {
        this.shadow = shadow;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WmTextStyle{");
        sb.append("textColor='").append(textColor).append('\'');
        sb.append(", textSize=").append(textSize);
        sb.append(", textAlpha=").append(textAlpha);
        sb.append(", shadow=").append(shadow);
        sb.append(", backgroundColor='").append(backgroundColor).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
