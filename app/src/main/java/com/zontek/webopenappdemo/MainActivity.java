package com.zontek.webopenappdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

/**
 * 利用Intent在网页中打开app
 * https://www.jianshu.com/p/5685b4a1b77e
 * <p>
 * --------------------------------------
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 作者：https://github.com/l376571926
 * 时间：2019/5/23 0023 11:17
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent i = new Intent();
        i.setAction("android.intent.action.VIEW");
        i.addCategory("android.intent.category.BROWSABLE");
        i.addCategory("android.intent.category.DEFAULT");
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //方式一添加参数
        i.setData(Uri.parse("wdgz://wdfull/card?card_id=828"));
        //方式二添加参数
//        i.setData(Uri.parse("wdgz://wdfull/card"));
//        i.putExtra("card_id", "828");

        String toUri = i.toUri(Intent.URI_INTENT_SCHEME);
        //下面这两种类型的uri华为nova 2s不能直接打开，要将前面的第一个intent替换为scheme，魅蓝U10无影响
        //方式一：intent://wdfull/card?card_id=828#Intent;scheme=wdgz;category=android.intent.category.DEFAULT;category=android.intent.category.BROWSABLE;launchFlags=0x10000000;end
        //方式二：intent://wdfull/card#Intent;scheme=wdgz;category=android.intent.category.DEFAULT;category=android.intent.category.BROWSABLE;launchFlags=0x10000000;S.card_id=828;end
        Log.e("shixiangyu", toUri);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
