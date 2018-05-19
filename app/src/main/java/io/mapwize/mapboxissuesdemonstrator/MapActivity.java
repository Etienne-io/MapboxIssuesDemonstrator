package io.mapwize.mapboxissuesdemonstrator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.style.layers.RasterLayer;
import com.mapbox.mapboxsdk.style.sources.RasterSource;
import com.mapbox.mapboxsdk.style.sources.TileSet;

public class MapActivity extends AppCompatActivity {

    final String MAPBOX_ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";
    final String DEMO_LAYER_ID = "demo-layer";
    final String TILES_URL_TEMPLATE = "https://mapwizecdn2.azureedge.net/layers/569f5f76b4d7200b003c329d/5420531f6218359cef2dcf95068beab1/tiles/fb4785491c60e1a5e09018118fd73192/{z}/{x}/{y}.png";
    final float LATITUDE_MIN = 50.63233693020572f;
    final float LATITUDE_MAX = 50.63397144674026f;
    final float LONGITUDE_MIN = 3.0191004115182145f;
    final float LONGITUDE_M1X = 3.0214923620224003f;
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, MAPBOX_ACCESS_TOKEN);
        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                displayLayer(mapboxMap);

                LatLngBounds bounds = new LatLngBounds.Builder()
                        .include(new LatLng(LATITUDE_MIN, LONGITUDE_MIN))
                        .include(new LatLng(LATITUDE_MAX, LONGITUDE_M1X))
                        .build();
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds,0);
                mapboxMap.animateCamera(cameraUpdate);
            }
        });
    }

    void displayLayer(MapboxMap mapboxMap) {
        TileSet tileSet = new TileSet("2.1.0", TILES_URL_TEMPLATE);
        tileSet.setBounds(LONGITUDE_MIN, LATITUDE_MIN, LONGITUDE_M1X, LATITUDE_MAX);
        mapboxMap.addSource(new RasterSource(DEMO_LAYER_ID, tileSet, 256));
        RasterLayer rasterLayer = new RasterLayer(DEMO_LAYER_ID, DEMO_LAYER_ID);
        mapboxMap.addLayer(rasterLayer);

    }
}
