package com.example.marko.litepaldemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marko.litepaldemo.greendao.DatabaseManager;
import com.example.marko.litepaldemo.greendao.DayStep;
import com.example.marko.litepaldemo.greendao.DayStepDao;
import com.example.marko.litepaldemo.greendao.SportInfo;
import com.example.marko.litepaldemo.greendao.SportInfoDao;
import com.example.marko.litepaldemo.greendao.UserInfo;
import com.example.marko.litepaldemo.greendao.UserInfoDao;
import com.example.marko.litepaldemo.litepal.Book;
import com.example.marko.litepaldemo.sqlite.MySQLiteHelper;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.create_database_btn)
    Button createDatabaseBtn;
    @BindView(R.id.upgrade_database_btn)
    Button upgradeDatabaseBtn;
    @BindView(R.id.add_data_btn)
    Button addDataBtn;
    @BindView(R.id.update_data_btn)
    Button updateDataBtn;
    @BindView(R.id.delete_data_btn)
    Button deleteDataBtn;
    @BindView(R.id.query_data_btn)
    Button queryDataBtn;
    @BindView(R.id.litepal_create_database_btn)
    Button litepalCreateDatabaseBtn;
    @BindView(R.id.litepal_upgrade_database_btn)
    Button litepalUpgradeDatabaseBtn;
    @BindView(R.id.litepal_add_data_btn)
    Button litepalAddDataBtn;
    @BindView(R.id.litepal_update_data_btn)
    Button litepalUpdateDataBtn;
    @BindView(R.id.litepal_delete_data_btn)
    Button litepalDeleteDataBtn;
    @BindView(R.id.litepal_query_data_btn)
    Button litepalQueryDataBtn;
    @BindView(R.id.greendao_create_database_btn)
    Button greendaoCreateDatabaseBtn;
    @BindView(R.id.greendao_upgrade_database_btn)
    Button greendaoUpgradeDatabaseBtn;
    @BindView(R.id.greendao_add_data_btn)
    Button greendaoAddDataBtn;
    @BindView(R.id.greendao_update_data_btn)
    Button greendaoUpdateDataBtn;
    @BindView(R.id.greendao_delete_data_btn)
    Button greendaoDeleteDataBtn;
    @BindView(R.id.greendao_query_data_btn)
    Button greendaoQueryDataBtn;

    private SQLiteOpenHelper openHelper;

    private DatabaseManager databaseManager = DatabaseManager.getInstance();
    private UserInfoDao userInfoDao = databaseManager.getUserInfoDao();
    private SportInfoDao sportInfoDao = databaseManager.getSportInfoDao();
    private DayStepDao dayStepDao = databaseManager.getDayStepDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        openHelper = new MySQLiteHelper(this, "demo.db", null, 1);
    }

    @OnClick({R.id.create_database_btn, R.id.upgrade_database_btn, R.id.add_data_btn,
            R.id.update_data_btn, R.id.delete_data_btn, R.id.query_data_btn})
    public void onSQLiteViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create_database_btn:
                openHelper.getWritableDatabase();
                upgradeDatabaseBtn.setClickable(false);
                break;
            case R.id.upgrade_database_btn:
                SQLiteOpenHelper openHelper1 = new MySQLiteHelper(this, "demo.db", null, 2);
                openHelper1.getWritableDatabase();
                break;
            case R.id.add_data_btn:
                SQLiteDatabase database = openHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 19.9);
                //插入第一条数据
                database.insert("Book", null, values);
                //开始组装第二条数据
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                //插入第二条数据
                database.insert("Book", null, values);
                break;
            case R.id.update_data_btn:
                SQLiteDatabase database2 = openHelper.getWritableDatabase();
                ContentValues values2 = new ContentValues();
                values2.put("price", 18.88);
                //第三个参数对应于SQL语句中的where部分，表示更新所有name等于？的行
                //？是占位符，可以通过第四个参数提供的一个字符串数组为第三个参数中的每个占位符指定相应的内容
                database2.update("Book", values2, "name = ?", new String[]{"The Da Vinci Code"});
                break;
            case R.id.delete_data_btn:
                SQLiteDatabase database3 = openHelper.getWritableDatabase();
                database3.delete("Book", "pages > ?", new String[]{"500"});
                break;
            case R.id.query_data_btn:
                SQLiteDatabase database4 = openHelper.getWritableDatabase();
                //查询Book表中的所有数据
                Cursor cursor = database4.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        //遍历Cursor对象，取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("*****", "Book name is :" + name);
                        Log.d("*****", "Book author is :" + author);
                        Log.d("*****", "Book pages is :" + pages);
                        Log.d("*****", "Book price is :" + price);
                    } while (cursor.moveToNext());
                    cursor.close();
                }
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.litepal_create_database_btn, R.id.litepal_upgrade_database_btn,
            R.id.litepal_add_data_btn, R.id.litepal_update_data_btn,
            R.id.litepal_delete_data_btn, R.id.litepal_query_data_btn})
    public void onLitePalViewClicked(View view) {
        switch (view.getId()) {
            case R.id.litepal_create_database_btn:
                Connector.getDatabase();
                break;
            case R.id.litepal_upgrade_database_btn:
                Connector.getDatabase();
                break;
            case R.id.litepal_add_data_btn:
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.69);
                book.setPress("Unknown");
                book.save();
                break;
            case R.id.litepal_update_data_btn:
                Book book1 = new Book();
                book1.setName("The Lost Symbol");
                book1.setAuthor("Dan Brown");
                book1.setPages(510);
                book1.setPrice(18.99);
                book1.setPress("Unknown");
                /**
                 * 此处也可以调用saveThrows()如果存储失败会抛出异常
                 * save()返回一个布尔值，可以判断是否存储成功
                 */
                book1.save();
                //下面是更新数据库的操作
                book1.setPrice(16.68);
                book1.setPress("Anchor");
                //将所有书名为The Lost Symbol ，作者是Dan Brown的价格更新为16.68，出版社更新为Anchor
                book1.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");
                break;
            case R.id.litepal_delete_data_btn:
                LitePal.deleteAll(Book.class, "pages > ?", "500");
                break;
            case R.id.litepal_query_data_btn:
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book2 : books) {
                    Log.d("*****", "Book name is :" + book2.getName());
                    Log.d("*****", "Book author is :" + book2.getAuthor());
                    Log.d("*****", "Book pages is :" + book2.getPages());
                    Log.d("*****", "Book price is :" + book2.getPrice());
                    Log.d("*****", "Book press is :" + book2.getPress());
                }
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.greendao_create_database_btn, R.id.greendao_upgrade_database_btn, R.id.greendao_add_data_btn, R.id.greendao_update_data_btn, R.id.greendao_delete_data_btn, R.id.greendao_query_data_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.greendao_create_database_btn:
                Toast.makeText(this,"数据库创建成功",Toast.LENGTH_SHORT).show();
                /**
                 * 在Application中调用DatabaseManager.getInstance().init(this)
                 * 当app安装后，会自动建立数据库，同时根据实体类建立所有的表
                 */
                break;
            case R.id.greendao_upgrade_database_btn:

                break;
            case R.id.greendao_add_data_btn:
                UserInfo userInfo1 = new UserInfo(null,"0","0","a");
                UserInfo userInfo2 = new UserInfo(null,"1","1","b");
                UserInfo userInfo3 = new UserInfo(null,"2","2","c");
                UserInfo userInfo4 = new UserInfo(null,"3","3","d");
                List<UserInfo> userInfoList = new ArrayList<>();
                userInfoList.add(userInfo2);
                userInfoList.add(userInfo3);
                userInfoList.add(userInfo4);
                userInfoDao.insertInTx(userInfoList);

                String date = new Date().toString();
                SportInfo sportInfo = new SportInfo(null,date,userInfo1.getUserId());
                sportInfoDao.insert(sportInfo);
                DayStep dayStep = new DayStep(1,date,10000,sportInfo.getSportId());
                dayStepDao.insert(dayStep);
                break;
            case R.id.greendao_update_data_btn:
                SportInfo sportInfo1 = new SportInfo(null,"2019.03.14", (long) 1);
                sportInfoDao.insertOrReplace(sportInfo1);
                sportInfoDao.update(new SportInfo((long) 2,"2019.03.13",null));
                break;
            case R.id.greendao_delete_data_btn:
                sportInfoDao.delete(new SportInfo((long) 2,"2019.03.13",null));
                break;
            case R.id.greendao_query_data_btn:
                //方法一
//                List<SportInfo> mSportInfo = sportInfoDao.loadAll();
                //方法二
//                List<SportInfo> mSportInfo = sportInfoDao.queryBuilder().list();
                //方法三：惰性加载
//                List<SportInfo> mSportInfo = sportInfoDao.queryBuilder().listLazy();
                //查找指定条件的数据
                List<SportInfo> mSportInfo = sportInfoDao.
                        queryBuilder().where(SportInfoDao.Properties.Date.eq("2019.03.14")).listLazy();
                for (int i = 0; i < mSportInfo.size(); i++){
                    Log.e("********","SportId:" +
                            mSportInfo.get(i).getSportId());
                }
                break;
            default:
                break;
        }
    }
}
