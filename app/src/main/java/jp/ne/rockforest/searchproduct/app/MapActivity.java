package jp.ne.rockforest.searchproduct.app;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
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

        // 現在地表示ボタンを有効にする
        map.setMyLocationEnabled(true);

    }

//    @Override
//    public void onLocationChanged(Location location) {
//        // TODO Auto-generated method stub
//        // 現在地に移動
//        CameraPosition cameraPos = new CameraPosition.Builder()
//        .target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(7.0f)
//        .bearing(0).build();
//        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPos));
//        }

    //マーカー設定
    public void setMarker() {
        MarkerOptions options = new MarkerOptions();
        LatLng position = new LatLng(43.0675, 141.350784);
        options.position(position);
        map.addMarker(options);
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
