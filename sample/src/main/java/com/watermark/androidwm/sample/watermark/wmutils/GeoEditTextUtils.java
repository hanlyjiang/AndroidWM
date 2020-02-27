package com.watermark.androidwm.sample.watermark.wmutils;

import android.text.TextUtils;
import android.widget.EditText;

import com.watermark.androidwm.sample.watermark.param.base.WMAlign;

/**
 * @Author: wangsengren
 * @Description: EditText数据获取工具
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class GeoEditTextUtils {

    /**
     * 获取一个float文本，如果为空或者格式失败返回默认值
     *
     * @param editText
     * @param def
     * @return
     */
    public static float getOptFloat(EditText editText, float def) {
        String editString = editText.getText().toString();
        return getOptFloat(editString, def);
    }

    /**
     * 获取一个float文本，如果为空或者格式失败返回默认值
     *
     * @param editString
     * @param def
     * @return
     */
    public static float getOptFloat(String editString, float def) {
        if (TextUtils.isEmpty(editString)) {
            return def;
        }
        try {
            Float aFloat = Float.valueOf(editString);
            return aFloat;
        } catch (Exception e) {
            return def;
        }
    }


    /**
     * 获取一个int文本，如果为空或者格式失败返回默认值
     *
     * @param editText
     * @param def
     * @return
     */
    public static int getOptInt(EditText editText, int def) {
        String editString = editText.getText().toString();
        if (TextUtils.isEmpty(editString)) {
            return def;
        }
        try {
            Integer value = Integer.valueOf(editString);
            return value;
        } catch (Exception e) {
            return def;
        }
    }


    /**
     * 获取一个editString，如果为空或者格式失败返回默认值
     *
     * @param editString
     * @param def
     * @return
     */
    public static String getOptString(String editString, String def) {
        if (TextUtils.isEmpty(editString)) {
            return def;
        }
        return editString;
    }

    /**
     * 获取一个String文本，如果为空或者格式失败返回默认值
     *
     * @param editText
     * @param def
     * @return
     */
    public static String getOptString(EditText editText, String def) {
        String editString = editText.getText().toString();
        return getOptString(editString, def);
    }


    /**
     * 获取Align，如果为空或者格式失败返回默认值
     *
     * @param editText
     * @param def
     * @return
     */
    public static String getAlign(EditText editText, String def) {
        String editString = editText.getText().toString();
        if (WMAlign.CENTER.equals(editString)) {
            return WMAlign.CENTER;
        }
        if (WMAlign.START.equals(editString)) {
            return WMAlign.START;
        }
        if (WMAlign.END.equals(editString)) {
            return WMAlign.END;
        }
        if (TextUtils.isEmpty(def)) {
            return WMAlign.CENTER;
        }
        return def;
    }

    /**
     * 获取Align，如果为空或者格式失败返回默认值
     *
     * @param editText
     * @return
     */
    public static String getAlign(EditText editText) {
        return getAlign(editText, WMAlign.CENTER);
    }

}
