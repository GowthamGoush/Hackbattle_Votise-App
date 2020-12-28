package com.example.votise;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

public class Tab4_FragmentMap extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng loc = new LatLng(13.082680, 80.270721);
            googleMap.addMarker(new MarkerOptions().position(loc).title("Your Location"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 15));

            clusterManager = new ClusterManager<MyItem>(getContext(), googleMap);

            googleMap.setOnCameraIdleListener(clusterManager);
            googleMap.setOnMarkerClickListener(clusterManager);

            addItems();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab4_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }


    }

    private ClusterManager<MyItem> clusterManager;

    private void addItems() {

        double lat = 13.0847;
        double lng = 80.2675;
        double lat1 = 13.1297;
        double lng1 = 80.2897;
        double lat2 = 13.081822018465415;
        double lng2 = 80.27522125128127;

        clusterManager.addItem(new MyItem(lat,lng,"User",""));
        clusterManager.addItem(new MyItem(lat+0.0002,lng,"User",""));
        clusterManager.addItem(new MyItem(lat+0.0002,lng+0.0002,"User",""));
        clusterManager.addItem(new MyItem(lat+0.0003,lng,"User",""));
        clusterManager.addItem(new MyItem(lat,lng+0.0002,"User",""));
        clusterManager.addItem(new MyItem(lat+0.0003,lng+0.0003,"User",""));
        clusterManager.addItem(new MyItem(lat1,lng1,"User",""));
        clusterManager.addItem(new MyItem(lat1+0.0002,lng1,"User",""));
        clusterManager.addItem(new MyItem(lat1+0.0002,lng1+0.0002,"User",""));
        clusterManager.addItem(new MyItem(lat1+0.0003,lng1,"User",""));
        clusterManager.addItem(new MyItem(lat1,lng1+0.0002,"User",""));
        clusterManager.addItem(new MyItem(lat1+0.0003,lng1+0.0003,"User",""));
        clusterManager.addItem(new MyItem(lat2,lng2,"User",""));
        clusterManager.addItem(new MyItem(lat2+0.0002,lng2,"User",""));
        clusterManager.addItem(new MyItem(lat2+0.0002,lng2+0.0002,"User",""));
        clusterManager.addItem(new MyItem(lat2+0.0003,lng2,"User",""));
        clusterManager.addItem(new MyItem(lat2,lng2+0.0002,"User",""));
        clusterManager.addItem(new MyItem(lat2+0.0003,lng2+0.0003,"User",""));

    }

}