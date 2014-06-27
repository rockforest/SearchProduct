package jp.ne.rockforest.searchproduct.app;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.ArrayList;


import java.util.ArrayList;


public class HomeActivity extends ActionBarActivity implements OnClickListener{

    private static final int LOADER_ID = 0;

    /**
     * 自身のインスタンス.
     */
    private final HomeActivity self = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.searchButton).setOnClickListener(self);
    }

    @Override
    public void onClick(View v) {

        //Todo 画面遷移
        Intent intent  = new Intent(HomeActivity.this, MapActivity.class);
        //Todo フィールドから文字列取得する
        intent.putExtra("param","豚肉");
        startActivity(intent);

    }
}
