package com.example.marko.litepaldemo.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Marko
 * @date 2019/3/15
 * GreenDao参考资料
 * https://blog.csdn.net/qq_38520096/article/details/78833801
 */

public class DatabaseManager {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private SportInfoDao mSportInfoDao = null;
    private DayStepDao mDayStepDao = null;
    private UserInfoDao mUserInfoDao = null;


    public DatabaseManager() {
    }

    public DatabaseManager init(Context context){
        initDao(context);
        return this;
    }

    private static final class Holder{
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }
    public static DatabaseManager getInstance(){
        return Holder.INSTANCE;
    }

    private void initDao(Context context) {
        /**
         * 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
         * 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
         * 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
         * 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
         * 此处sport-db表示数据库名称 可以任意填写
         */
        mHelper = new DaoMaster.DevOpenHelper(context, "sport.db");
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        mDayStepDao = mDaoSession.getDayStepDao();
        mSportInfoDao = mDaoSession.getSportInfoDao();
        mUserInfoDao = mDaoSession.getUserInfoDao();
    }

    public SportInfoDao getSportInfoDao() {
        return mSportInfoDao;
    }

    public DayStepDao getDayStepDao() {
        return mDayStepDao;
    }

    public UserInfoDao getUserInfoDao() {
        return mUserInfoDao;
    }
}
