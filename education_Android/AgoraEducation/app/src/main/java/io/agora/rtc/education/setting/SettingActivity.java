package io.agora.rtc.education.setting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import io.agora.rtc.education.R;
import io.agora.rtc.education.base.BaseActivity;
import io.agora.rtc.education.constant.SPKey;
import io.agora.rtc.education.widget.eyecare.EyeCare;
import io.agora.rtc.lib.util.SPUtil;

public class SettingActivity extends BaseActivity {

    private Switch mSwitch;

    @Override
    protected void initUI(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        mSwitch = findViewById(R.id.switch_eye_care);
        mSwitch.setChecked(SPUtil.get(SPKey.KEY_IS_EYE_CARE, false));
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EyeCare.setNeedShow(isChecked);
                if (isChecked) {
                    showEyeCareView();
                } else {
                    dismissEyeCareView();
                }
            }
        });
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickSwitch(View view) {
        mSwitch.setChecked(!mSwitch.isChecked());
    }
}
