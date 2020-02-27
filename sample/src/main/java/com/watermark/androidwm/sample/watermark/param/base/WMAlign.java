package com.watermark.androidwm.sample.watermark.param.base;

import com.watermark.androidwm.bean.WatermarkAlignAnchor;

/**
 * @Author: wangsengren
 * @Description: Align
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class WMAlign {
    public static final String CENTER = "CENTER";
    public static final String START = "START";
    public static final String END = "END ";

    public static WatermarkAlignAnchor.Alignment getWMAlign(String align) {
        if (CENTER.equals(align)) {
            return WatermarkAlignAnchor.Alignment.CENTER;
        } else if (START.equals(align)) {
            return WatermarkAlignAnchor.Alignment.START;
        } else if (END.equals(align)) {
            return WatermarkAlignAnchor.Alignment.END;
        }
        return WatermarkAlignAnchor.Alignment.CENTER;
    }
}
