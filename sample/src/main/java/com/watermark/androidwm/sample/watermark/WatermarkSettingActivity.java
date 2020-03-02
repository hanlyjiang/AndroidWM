package com.watermark.androidwm.sample.watermark;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.watermark.androidwm.sample.R;
import com.watermark.androidwm.sample.watermark.param.base.Margin;
import com.watermark.androidwm.sample.watermark.param.base.PositionParam;
import com.watermark.androidwm.sample.watermark.param.style.TextShadow;
import com.watermark.androidwm.sample.watermark.param.wmtext.WmTextParam;
import com.watermark.androidwm.sample.watermark.param.wmtext.WmTextStyle;
import com.watermark.androidwm.sample.watermark.wmutils.EditTextUtils;
import com.watermark.androidwm.sample.watermark.wmutils.WatermarkUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: wangsengren
 * @Description: 水印参数设置
 * @Date: 2020-02-21
 * @Version: 1.0
 */
public class WatermarkSettingActivity extends AppCompatActivity {

    private Button getDataBtn, clearBtn, buildBtn,btn_save;

    private Integer[] ids = new Integer[]{R.id.et_text, R.id.et_x, R.id.et_y, R.id.et_rotation, R.id.et_horizontalAlign, R.id.et_verticalAlign,
            R.id.et_left, R.id.et_top, R.id.et_right, R.id.et_bottom, R.id.et_textColor, R.id.et_backgroundColor, R.id.et_textSize,
            R.id.et_textAlpha, R.id.et_blurRadius, R.id.et_shadowXOffset, R.id.et_shadowYOffset, R.id.et_shadowColor};

    private Map<Integer, EditText> editTextMap = new HashMap<>();
    private Map<Integer, String> dataMap = new HashMap<>();

    private ImageView iv_test;
    private EditText tv_json;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geo_activity_watermark_setting);
        getDataBtn = findViewById(R.id.btn_data);
        clearBtn = findViewById(R.id.btn_clear);
        buildBtn = findViewById(R.id.btn_build);
        tv_json = findViewById(R.id.tv_json);
        iv_test = findViewById(R.id.iv_test);
        btn_save = findViewById(R.id.btn_save);
        for (Integer id : ids) {
            EditText e = findViewById(id);
            editTextMap.put(id, e);
        }

        getDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WatermarkUtils.setWmBitmapToImageView(WatermarkSettingActivity.this, getData(), iv_test);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearEditText();

            }
        });

        buildBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * 设置水印到图片
                 */
                WatermarkUtils.setWmBitmapToImageView(WatermarkSettingActivity.this, WmTextParam.getWmTextParamBean(tv_json.getText().toString()), iv_test);

            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WatermarkUtils.saveWmTextBitmap(WatermarkSettingActivity.this, WmTextParam.getWmTextParamBean(tv_json.getText().toString()));
            }
        });
    }

    public void clearEditText() {
        for (Integer id : ids) {
            editTextMap.get(id).setText("");
        }
    }

    public WmTextParam getData() {
        StringBuilder data = new StringBuilder();
        for (Integer id : ids) {
            data.append(editTextMap.get(id).getText()).append(" , ");
        }

        WmTextParam wmTextParam = new WmTextParam();
        //设置文本
        wmTextParam.setText(editTextMap.get(R.id.et_text).getText().toString());

        //设置位置样式
        PositionParam positionParam = new PositionParam();
        positionParam.setX(EditTextUtils.getOptFloat(editTextMap.get(R.id.et_x), 0));
        positionParam.setY(EditTextUtils.getOptFloat(editTextMap.get(R.id.et_y), 0));
        positionParam.setMargin(new Margin(
                EditTextUtils.getOptInt(editTextMap.get(R.id.et_left), 0),
                EditTextUtils.getOptInt(editTextMap.get(R.id.et_top), 0),
                EditTextUtils.getOptInt(editTextMap.get(R.id.et_right), 0),
                EditTextUtils.getOptInt(editTextMap.get(R.id.et_bottom), 0)));
        positionParam.setHorizontalAlignAnchor(EditTextUtils.getAlign(editTextMap.get(R.id.et_horizontalAlign)));
        positionParam.setVerticalAlignAnchor(EditTextUtils.getAlign(editTextMap.get(R.id.et_verticalAlign)));
        positionParam.setRotation(EditTextUtils.getOptInt(editTextMap.get(R.id.et_rotation), 0));
        wmTextParam.setPosition(positionParam);

        //设置文字样式
        WmTextStyle wmTextStyle = new WmTextStyle();
        wmTextStyle.setTextSize(EditTextUtils.getOptInt(editTextMap.get(R.id.et_textSize), 14));
        wmTextStyle.setTextAlpha(EditTextUtils.getOptInt(editTextMap.get(R.id.et_textAlpha), 255));
        wmTextStyle.setTextColor(EditTextUtils.getOptString(editTextMap.get(R.id.et_textColor), "#000000"));
        wmTextStyle.setBackgroundColor(EditTextUtils.getOptString(editTextMap.get(R.id.et_backgroundColor), "#00000000"));
        wmTextStyle.setShadow(new TextShadow(
                EditTextUtils.getOptFloat(editTextMap.get(R.id.et_blurRadius), 0),
                EditTextUtils.getOptInt(editTextMap.get(R.id.et_shadowXOffset), 0),
                EditTextUtils.getOptInt(editTextMap.get(R.id.et_shadowYOffset), 0),
                EditTextUtils.getOptString(editTextMap.get(R.id.et_shadowColor), "#00000000")));
        wmTextParam.setStyle(wmTextStyle);
        Log.i("wsr", WmTextParam.getWmTextParam(wmTextParam));
        Toast.makeText(this, wmTextParam.toString(), Toast.LENGTH_LONG).show();
        return wmTextParam;
    }


}
