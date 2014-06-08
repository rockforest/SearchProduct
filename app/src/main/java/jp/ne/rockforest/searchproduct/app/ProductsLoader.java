package jp.ne.rockforest.searchproduct.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

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
 * APIをコールする非同期タスク
 */
public class ProductsLoader extends AsyncTask<String, Void, String> {

    private Activity productLoader;

    private String uri = "http://gogosuper.in/gospa";
    private String param;

    /**
     * コンストラクタ
     */
    public ProductsLoader(Activity activity)
    {
        this.productLoader = activity;
    }

    /**
     * バックグランドで行う処理
     */
    @Override
    protected String doInBackground(String... param) {
        try {
            this.param = param[0];
            return getJson(this.param);

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
        TextView textView = (TextView)this.productLoader.findViewById(R.id.AsyncResult);
        textView.setText(result);
        Log.d("time","taskloader");
    }

    /**
     * JSONGet処理
     */
    private String getJson(String param) {

        String url = uri + "?" + param;

        HttpClient objHttp = new DefaultHttpClient();
        HttpParams params = objHttp.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 1000); //接続のタイムアウト
        HttpConnectionParams.setSoTimeout(params, 1000); //データ取得のタイムアウト
        String sReturn = "";
        try {
            HttpGet objGet = new HttpGet(url);
            HttpResponse objResponse = objHttp.execute(objGet);
            if (objResponse.getStatusLine().getStatusCode() < 400) {
                HttpEntity httpEntity = objResponse.getEntity();
                sReturn = EntityUtils.toString(httpEntity);
            }
        } catch (IOException e) {
            return null;
        }
        return sReturn;
    }
}