package com.watermark.androidwm.sample.watermark.param.base;

/**
 * @Author: wangsengren
 * @Description: 文件描述
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class PositionParam {
    private float x = 0.1f;
    private float y = 0.1f;
    private int rotation = 0;
    /**CENTER**/
    private String horizontalAlignAnchor;
    /**CENTER**/
    private String verticalAlignAnchor;
    private Margin margin = new Margin();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public String getHorizontalAlignAnchor() {
        return horizontalAlignAnchor;
    }

    public void setHorizontalAlignAnchor(String horizontalAlignAnchor) {
        this.horizontalAlignAnchor = horizontalAlignAnchor;
    }

    public String getVerticalAlignAnchor() {
        return verticalAlignAnchor;
    }

    public void setVerticalAlignAnchor(String verticalAlignAnchor) {
        this.verticalAlignAnchor = verticalAlignAnchor;
    }

    public Margin getMargin() {
        return margin;
    }

    public void setMargin(Margin margin) {
        this.margin = margin;
    }

    @Override
    public String toString() {
        return "PositionParam{" +
                "x=" + x +
                ", y=" + y +
                ", rotation=" + rotation +
                ", horizontalAlignAnchor='" + horizontalAlignAnchor + '\'' +
                ", verticalAlignAnchor='" + verticalAlignAnchor + '\'' +
                ", margin=" + margin +
                '}';
    }
}
