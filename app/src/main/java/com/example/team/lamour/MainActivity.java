package com.example.team.lamour;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setBreadCrumbTitle("Frag" + mStackLevel);
        ft.replace(R.id.simple_fragment, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(context, Invitation_fragment.class);
                    startActivity(intent);
                    mTextMessage.setText("Invitation_fragment");
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText("Info");
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("Images");
                    return true;
                case R.id.navigation_notifications2:
                    mTextMessage.setText("Our Story");
                    return true;
                case R.id.navigation_notifications3:
                    mTextMessage.setText("Profile");
                    return true;
            }
            return false;
        }
    };
}
