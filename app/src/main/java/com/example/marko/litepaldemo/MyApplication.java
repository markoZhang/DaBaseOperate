package com.example.marko.litepaldemo;


import com.example.marko.litepaldemo.greendao.DatabaseManager;

import org.litepal.LitePalApplication;

/**
 * @author Marko
 * @date 2019/3/15
 */

public class MyApplication extends LitePalApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.getInstance().init(this);
    }


}
