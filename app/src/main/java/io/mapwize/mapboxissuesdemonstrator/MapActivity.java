package io.mapwize.mapboxissuesdemonstrator;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapboxMap;

public class MapActivity extends AppCompatActivity implements MapboxFragment.OnFragmentInteractionListener {

    final String MAPBOX_ACCESS_TOKEN = "YOUR_ACCESS_TOKEN";
    MapboxFragment mapboxFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, MAPBOX_ACCESS_TOKEN);
        setContentView(R.layout.activity_map);
        Button show = findViewById(R.id.show);
        Button hide = findViewById(R.id.hide);
        show.setOnClickListener(v -> show());
        hide.setOnClickListener(v -> hide());
    }

    private void show() {
        mapboxFragment = MapboxFragment.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container, mapboxFragment);
        ft.commit();
    }

    private void hide() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(mapboxFragment);
        ft.commit();
    }

    @Override
    public void onFragmentReady(MapboxMap mapboxMap) {
        // Todo use mapbox map
    }
}
