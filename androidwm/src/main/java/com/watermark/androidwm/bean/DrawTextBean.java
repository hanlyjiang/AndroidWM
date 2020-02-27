package com.watermark.androidwm.bean;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextPaint;

import java.util.Arrays;

public class DrawTextBean {
    private TextPaint textPaint;
    private String drwaText;
    private int maxWidth;
    //最大高度
    private int maxHight;
    private String[] strings;

    //每行最高
    public static int BASELINE_HIAHT = 10;
    //左右间距
    public static int BASELINE_WIDTH = 26;
    private int lineHight;

    public DrawTextBean(String drwaText, TextPaint textPaint) {
        this.drwaText = drwaText;
        this.textPaint = textPaint;
        this.strings = stringToArray(drwaText);
        Rect bounds = new Rect();
        textPaint.getTextBounds(drwaText, 0, drwaText.length(), bounds);
        this.maxWidth = getMaxLength(strings, textPaint) + 20;
        this.lineHight = bounds.height();
        BASELINE_HIAHT = lineHight / 4;
        this.maxHight = lineHight * strings.length + (strings.length + 2) * BASELINE_HIAHT;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxHight() {
        return maxHight;
    }

    public void setMaxHight(int maxHight) {
        this.maxHight = maxHight;
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public int getLineHight() {
        return lineHight;
    }

    public void setLineHight(int lineHight) {
        this.lineHight = lineHight;
    }

    private static String[] stringToArray(String s) {
        if (s == null || s.length() <= 0) {
            return new String[]{};
        }
        if (s.contains("\n")) {
            return s.split("\n");
        }
        return new String[]{s};
    }

    private static int getMaxLength(String[] strings, TextPaint textPaint) {
        int maxWidth = 0;
        for (String str : strings) {
            int i = (int) textPaint.measureText(str);
            if (i > maxWidth) {
                maxWidth = i;
            }
        }
        return maxWidth;
    }

    @Override
    public String toString() {
        return "DrawTextBean{" +
                "textPaint=" + textPaint +
                ", drwaText='" + drwaText + '\'' +
                ", maxWidth=" + maxWidth +
                ", maxHight=" + maxHight +
                ", strings=" + Arrays.toString(strings) +
                ", lineHight=" + lineHight +
                '}';
    }
}
