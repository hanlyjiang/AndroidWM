package com.watermark.androidwm.sample.watermark.param.style;

/**
 * @Author: wangsengren
 * @Description: 文件描述
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class TextShadow {
    private float blurRadius;
    private int shadowXOffset;
    private int shadowYOffset;
    private String shadowColor;

    public TextShadow() {
    }

    public TextShadow(float blurRadius, int shadowXOffset, int shadowYOffset, String shadowColor) {
        this.blurRadius = blurRadius;
        this.shadowXOffset = shadowXOffset;
        this.shadowYOffset = shadowYOffset;
        this.shadowColor = shadowColor;
    }

    public float getBlurRadius() {
        return blurRadius;
    }

    public void setBlurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
    }

    public int getShadowXOffset() {
        return shadowXOffset;
    }

    public void setShadowXOffset(int shadowXOffset) {
        this.shadowXOffset = shadowXOffset;
    }

    public int getShadowYOffset() {
        return shadowYOffset;
    }

    public void setShadowYOffset(int shadowYOffset) {
        this.shadowYOffset = shadowYOffset;
    }

    public String getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    @Override
    public String toString() {
        return "TextShadow{" +
                "blurRadius=" + blurRadius +
                ", shadowXOffset=" + shadowXOffset +
                ", shadowYOffset=" + shadowYOffset +
                ", shadowColor='" + shadowColor + '\'' +
                '}';
    }
}
