package com.watermark.androidwm.sample.watermark.param.base;

/**
 * @Author: wangsengren
 * @Description: 文件描述
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class Margin {
    private int left = 0;
    private int top = 0;
    private int right = 0;
    private int bottom = 0;

    public Margin() {
    }

    public Margin(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        return "Margin{" +
                "left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                '}';
    }
}
