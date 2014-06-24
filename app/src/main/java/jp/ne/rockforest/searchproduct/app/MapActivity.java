package jp.ne.rockforest.searchproduct.app;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivity extends FragmentActivity {

    private GoogleMap map;
    private LocationClient mLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map = ((SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map))
                .getMap();

        MapsInitializer.initialize(this);

        moveToMap();
    }

    protected void moveToMap() {
        LatLng location = new LatLng(43.0675, 141.350784);
        CameraUpdate cu =
                CameraUpdateFactory.newLatLngZoom(location, 15);
        map.moveCamera(cu);

//        getCurrentLocation();

        //マーカー設定
        MarkerOptions options = new MarkerOptions();
        options.position(location);
        map.addMarker(options);
    }

    private void getCurrentLocation() {
        // 接続されているときだけ現在地を取得
        if (mLocationClient.isConnected()) {
            Location location = mLocationClient.getLastLocation();
            //処理を書く
            Log.d("latitude", "now!");
        } else {
            //処理を書く
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
