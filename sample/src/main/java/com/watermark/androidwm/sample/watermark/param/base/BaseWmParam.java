package com.watermark.androidwm.sample.watermark.param.base;

/**
 * @Author: wangsengren
 * @Description: 文件描述
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public abstract class BaseWmParam {
    protected String filePath;
    protected PositionParam position;
    /**
     * 压缩比最大100
     */
    protected int quality = 100;

    public PositionParam getPosition() {
        return position;
    }

    public void setPosition(PositionParam position) {
        this.position = position;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
