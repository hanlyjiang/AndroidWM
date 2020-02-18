package com.watermark.androidwm.bean;

/**
 * 水印布局对齐方式
 *
 * @author hanlyjiang on 2020-02-18-13:03.
 * @version 1.0
 */
public class WatermarkAlignAnchor {

    /**
     * 对齐方式
     */
    public enum Alignment {
        START,
        END,
        CENTER,
    }

    /**
     * 水平方向对齐方式
     */
    Alignment horizontalAlign = Alignment.START;
    /**
     * 垂直方向对齐方式
     */
    Alignment verticalAlign = Alignment.START;

    public WatermarkAlignAnchor() {
    }

    /**
     * 构造函数
     *
     * @param horizontalAlign
     * @param verticalAlign
     */
    public WatermarkAlignAnchor(Alignment horizontalAlign, Alignment verticalAlign) {
        this.horizontalAlign = horizontalAlign;
        this.verticalAlign = verticalAlign;
    }

    public Alignment getHorizontalAlign() {
        return horizontalAlign;
    }

    public void setHorizontalAlign(Alignment horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public Alignment getVerticalAlign() {
        return verticalAlign;
    }

    public void setVerticalAlign(Alignment verticalAlign) {
        this.verticalAlign = verticalAlign;
    }
}
