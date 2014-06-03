package jp.ne.rockforest.searchproduct.app;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * APIをコールする非同期タスク
 */
public class ProductsLoader extends AsyncTaskLoader<ArrayList<String>> {


    /** Logcat出力用タグ. */
    private static final String TAG = ProductsLoader.class.getSimpleName();

    /**
     * コンストラクタ.
     * @param context Context
     */
    ProductsLoader(Context context) {
        super(context);
    }

    @Override
    public ArrayList<String> loadInBackground() {

        ArrayList<String> list = new ArrayList<String>();

        JSONObject obj = get();

        Log.d("status","ok");
        if(obj != null){

        }

        return null;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * Getリクエストを実行してBodyを取得する.
     * @return JSONObject
     */
    private JSONObject get() {
        try {
//            String url = "http://express.heartrails.com/api/json?" + getParams(name);
//            HttpClient httpClient = new DefaultHttpClient();
//            HttpGet get = new HttpGet(url);
//            HttpResponse res = httpClient.execute(get);
//            HttpEntity entity = res.getEntity();
//            String body = EntityUtils.toString(entity);
//            return new JSONObject(body);
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}