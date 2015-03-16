package com.wisedu.scc.love.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.wisedu.scc.love.application.LoveApplication;
import com.wisedu.scc.love.utils.CommonUtil;

/**
 * Created by JZ on 2015/3/9.
 */
public class BaseExitActivity extends Activity {

    // 退出系统字段
    protected long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 在两秒钟内连续按两次返回，则退出
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                CommonUtil.shortToast(getApplicationContext(), "再按一次退出系统");
                exitTime = System.currentTimeMillis();
            } else {
                // 退出应用
                LoveApplication.getInstance().exit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LoveApplication.getInstance().addActivity(this);
        super.onCreate(savedInstanceState);
    }

}
