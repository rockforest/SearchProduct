package jp.ne.rockforest.searchproduct.app;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * APIをコールする非同期タスク
 */
public class ProductsLoader extends AsyncTask<String, Void, String> {

    /**
     * コンストラクタ
     */
    public ProductsLoader() {
        super();
    }

    /**
     * バックグランドで行う処理
     */
    @Override
    protected String doInBackground(String... uri) {
        try {
            Log.d("Task", "start");
            byte[] response = getJson().getBytes("UTF-8");
            Log.d("result", new String(response,"UTF-8"));
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * バックグランド処理が完了し、UIスレッドに反映する
     */
    @Override
    protected void onPostExecute(String result) {
    }

    /**
     * JSONGet処理
     */
    private String getJson() {

        String uri = "http://gogosuper.in/gospa?format=raw&task=ajax&format=json&action=get_shopmap";

        HttpClient objHttp = new DefaultHttpClient();
        HttpParams params = objHttp.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 1000); //接続のタイムアウト
        HttpConnectionParams.setSoTimeout(params, 1000); //データ取得のタイムアウト
        String sReturn = "";
        try {
            HttpGet objGet = new HttpGet(uri);
            HttpResponse objResponse = objHttp.execute(objGet);
            if (objResponse.getStatusLine().getStatusCode() < 400) {
                HttpEntity httpEntity = objResponse.getEntity();
                String json = EntityUtils.toString(httpEntity, "SJIS");
                Log.d("res",json);
//                InputStreamReader objReader = new InputStreamReader(objStream);
//                BufferedReader objBuf = new BufferedReader(objReader);
//                StringBuilder objJson = new StringBuilder();
//                String sLine;
//                while ((sLine = objBuf.readLine()) != null) {
//                    objJson.append(sLine);
//                }
//                sReturn = objJson.toString();
//                objStream.close();
            }
        } catch (IOException e) {
            return null;
        }
        return sReturn;
    }
}