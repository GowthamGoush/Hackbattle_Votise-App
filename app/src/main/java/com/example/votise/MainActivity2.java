package com.example.votise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gauravk.bubblenavigation.BubbleNavigationLinearView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

public class MainActivity2 extends AppCompatActivity {

    private BubbleNavigationLinearView bubbleNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bubbleNavigation = findViewById(R.id.bottom_navigation);

        Tab1();

        bubbleNavigation.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {

                switch (position) {
                    case 0: Tab1();
                            break;
                    case 1: Tab2();
                            break;
                    case 2: Tab3();
                            break;
                    case 3: Tab4();
                            break;
                }
            }
        });


    }

    private void Tab1() {

        Tab1_Fragment fragment1 = new Tab1_Fragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.tabLayout,fragment1);
        fragmentTransaction.commit();

    }

    private void Tab2() {

        Tab2_Fragment fragment2 = new Tab2_Fragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.tabLayout,fragment2);
        fragmentTransaction.commit();
    }

    private void Tab3() {

        Tab3_Fragment fragment3 = new Tab3_Fragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.tabLayout,fragment3);
        fragmentTransaction.commit();
    }

    private void Tab4() {

        Tab4_FragmentMap fragment4 = new Tab4_FragmentMap();

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.tabLayout,fragment4);
        fragmentTransaction.commit();

    }
}