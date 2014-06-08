package jp.ne.rockforest.searchproduct.app;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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

        //Todo　地図アクティビティ渡す
        ProductsLoader pLoder = new ProductsLoader(this);
        pLoder.execute("format=raw&task=ajax&format=json&action=get_shopmap");
        //Todo 画面遷移

    }
}
