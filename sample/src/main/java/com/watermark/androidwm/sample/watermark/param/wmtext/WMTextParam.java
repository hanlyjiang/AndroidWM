package com.watermark.androidwm.sample.watermark.param.wmtext;

import android.graphics.Color;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.watermark.androidwm.sample.watermark.param.base.BaseWmParam;

/**
 * @Author: wangsengren
 * @Description: 文本水印参数
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class WMTextParam extends BaseWmParam {
    private String text;
    private WmTextStyle style;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public WmTextStyle getStyle() {
        return style;
    }

    public void setStyle(WmTextStyle style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "WMTextParam{" +
                "text='" + text + '\'' +
                ", style=" + style +
                ", filePath='" + filePath + '\'' +
                ", position=" + position +
                '}';
    }

    public static String getWmTextParam(WMTextParam wmTextParam) {
        //建造者模式设置不同的配置
        Gson gson = new GsonBuilder()
                //序列化为null对象
                .serializeNulls()
                //设置日期的格式
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .disableHtmlEscaping()//防止对网址乱码 忽略对特殊字符的转换
                .create();
        String s = gson.toJson(wmTextParam);
        return s;
    }

    public static WMTextParam getWmTextParamBean(String json) {
        Gson gson = new Gson();
        WMTextParam textParam = gson.fromJson(json, WMTextParam.class);
        return textParam;
    }


}
