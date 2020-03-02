package com.watermark.androidwm.bean;

import android.graphics.Rect;
import android.text.TextPaint;

import java.util.Arrays;

/**
 * 文本水印相关参数实体，包括文本内容
 *
 * @author 王僧仁
 */
public class DrawTextBean {

    private static final String LINE_SEPARATE = "<br/>";

    private TextPaint textPaint;
    private String drawText;
    private String[] separatedLineStrs;

    private int maxWidth;
    /**
     * 最大高度
     */
    private int maxHeight;
    private int lineHeight;

    /**
     * 行间距，默认为 lineHeight 的1/4
     */
    private int lineSpace;
    /**
     * 字间距
     */
    private int wordSpace = 26;

    public DrawTextBean(String drawText, TextPaint textPaint) {
        this.drawText = drawText;
        this.textPaint = textPaint;
        this.separatedLineStrs = separateToMultiLine(drawText);
        Rect bounds = new Rect();
        textPaint.getTextBounds(drawText, 0, drawText.length(), bounds);
        this.lineHeight = bounds.height();
        calculate(separatedLineStrs);
    }

    private void calculate(String[] separatedLineStrs) {
        maxWidth = getMaxLength(separatedLineStrs, textPaint) + 20;
        lineSpace = lineHeight / 4;
        maxHeight = lineHeight * this.separatedLineStrs.length + (this.separatedLineStrs.length + 2) * getLineSpace();
    }

    public int getLineSpace() {
        return lineSpace;
    }

    /**
     * 设置行间距
     *
     * @param lineSpace 行间距 px
     */
    public void setLineSpace(int lineSpace) {
        this.lineSpace = lineSpace;
    }

    public int getWordSpace() {
        return wordSpace;
    }

    /**
     * 设置字间距 默认为26px
     *
     * @param wordSpace 字间距的值 px
     */
    public void setWordSpace(int wordSpace) {
        this.wordSpace = wordSpace;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public String[] getSeparatedLineStrs() {
        return separatedLineStrs;
    }

    /**
     * 获取的文本行高，不包含行间距
     *
     * @return 文本行高
     */
    public int getLineHeight() {
        return lineHeight;
    }

    private static String[] separateToMultiLine(String s) {
        if (s == null || s.length() <= 0) {
            return new String[]{};
        }
        if (s.contains(LINE_SEPARATE)) {
            return s.split(LINE_SEPARATE);
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
                ", drawText='" + drawText + '\'' +
                ", maxWidth=" + maxWidth +
                ", maxHeight=" + maxHeight +
                ", separatedLineStrs=" + Arrays.toString(separatedLineStrs) +
                ", lineHeight=" + lineHeight +
                '}';
    }
}
