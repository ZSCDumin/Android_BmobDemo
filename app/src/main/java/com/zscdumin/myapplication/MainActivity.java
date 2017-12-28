package com.zscdumin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.delete)
    TextView delete;
    @BindView(R.id.update)
    TextView update;
    @BindView(R.id.search)
    TextView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Bmob.initialize(this, "e7edc6aee5407505ad8a1b08cddbd4d8");

    }

    public void add() {
        Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("北京海淀");
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "添加数据成功，返回objectId为：" + objectId, Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(MainActivity.this, "创建数据失败：" + e.getMessage(), Toast.LENGTH_LONG);
                }
            }
        });
    }

    public void delete() {
        final Person p2 = new Person();
        p2.setObjectId("847678181b");
        p2.delete(new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "删除成功:" + p2.getUpdatedAt(), Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(MainActivity.this, "删除失败：" + e.getMessage(), Toast.LENGTH_LONG);
                }
            }

        });
    }

    public void update() {
        final Person p2 = new Person();
        p2.setAddress("北京朝阳");
        p2.update("847678181b", new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "更新成功:" + p2.getUpdatedAt(), Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(MainActivity.this, "更新失败：" + e.getMessage(), Toast.LENGTH_LONG);
                }
            }

        });
    }

    public void search() {
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject("847678181b", new QueryListener<Person>() {
            @Override
            public void done(Person object, BmobException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this, "查询成功", Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(MainActivity.this, "查询失败", Toast.LENGTH_LONG);
                }
            }
        });
    }


    @OnClick({R.id.add, R.id.delete, R.id.update, R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.update:
                update();
                break;
            case R.id.search:
                search();
                break;
        }
    }


}
