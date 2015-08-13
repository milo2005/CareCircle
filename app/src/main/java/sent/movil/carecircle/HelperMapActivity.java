package sent.movil.carecircle;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HelperMapActivity extends AppCompatActivity implements GoogleMap.OnMyLocationChangeListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_helper_map);
        setUpMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    private void setUpMapIfNeeded() {
        if (map == null) {
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (map != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        LatLng latLng = new LatLng(2.4409554291238837,-76.60787304492186);
        CameraPosition cameraPosition = new CameraPosition(latLng, 15,0,0);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        map.moveCamera(cameraUpdate);
        map.setMyLocationEnabled(true);
        map.setOnMyLocationChangeListener(this);


        map.addMarker(new MarkerOptions()
                .position(new LatLng(2.4401407771886703, -76.61001881213377))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mark_disabled)));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(2.4416843278052736, -76.61280830950926))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mark_disabled)));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(2.4445141659962912, -76.60688599200438))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_helper)));
        map.addMarker(new MarkerOptions()
                .position(new LatLng(2.441041181930445, -76.60551270098875))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nurs)));

        map.setOnMarkerClickListener(this);
    }

    @Override
    public void onMyLocationChange(Location location) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent intent = new Intent(this, HelperActivity.class);
        startActivity(intent);
        return false;
    }
}
