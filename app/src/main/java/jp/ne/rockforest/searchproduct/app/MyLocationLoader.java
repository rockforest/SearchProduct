package jp.ne.rockforest.searchproduct.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 現在地を取得する非同期タスク
 */
public class MyLocationLoader extends AsyncTask<String, Void, String> {

    private Activity MyLocationLoader;

    private String param;

    /**
     * コンストラクタ
     */
    public MyLocationLoader(Activity activity) {
        this.MyLocationLoader = activity;
    }

    /**
     * バックグランドで行う処理
     */
    @Override
    protected String doInBackground(String... param) {
        try {
            this.param = param[0];
            return "ok";

        } catch (Exception e) {
        }
        return null;
    }

    /**
     * バックグランド処理が完了し、UIスレッドに反映する
     */
    @Override
    protected void onPostExecute(String result) {

        //Todo 地図描画処理
    }

}
