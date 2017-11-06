package com.nzoshq.nonthwatzaza.nonthwatzaza_hq;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        homeFragment homeFragment = new homeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.Relative_main,
                homeFragment,
                homeFragment.getTag()
        ).commit();
    }


    public void openyoutube(View view) {
        Intent openyoutubeapp = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
        startActivity(openyoutubeapp);
    }
    public void camera (View view) {
        Intent opencameraapp = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.camera");
        startActivity(opencameraapp);
    }
    public void truephonecall (View view) {
        Intent opentruephonecallapp = getPackageManager().getLaunchIntentForPackage("com.hb.dialer.free");
        startActivity(opentruephonecallapp);
    }

    public void mxplayer (View view) {
        Intent openmxplayerapp = getPackageManager().getLaunchIntentForPackage("com.mxtech.videoplayer.ad");
        startActivity(openmxplayerapp);
    }

    public void poweramp (View view) {
        Intent openpowerampapp = getPackageManager().getLaunchIntentForPackage("com.maxmpz.audioplayer");
        startActivity(openpowerampapp);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_home) {
            homeFragment homeFragment = new homeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Relative_main,
                    homeFragment,
                    homeFragment.getTag()
            ).commit();

        } else if (id == R.id.nav_relax) {
            relaxFragment relaxFragment = new relaxFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Relative_main,
                    relaxFragment,
                    relaxFragment.getTag()
            ).commit();
        } else if (id == R.id.nav_Devtool) {
            DevtoolFragment DevtoolFragment = new DevtoolFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Relative_main,
                    DevtoolFragment,
                    DevtoolFragment.getTag()
            ).commit();

        } else if (id == R.id.nav_social) {
            socialFragment socialFragment = new socialFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Relative_main,
                    socialFragment,
                    socialFragment.getTag()
            ).commit();

        } else if (id == R.id.nav_Picture) {
            PictureFragment pictureFragment = new PictureFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Relative_main,
                    pictureFragment,
                    pictureFragment.getTag()
            ).commit();

        } else if (id == R.id.nav_about) {
            aboutFragment aboutFragment = new aboutFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Relative_main,
                    aboutFragment,
                    aboutFragment.getTag()
            ).commit();
        } else if (id == R.id.nav_etc) {
            etcFragment etcFragment = new etcFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.Relative_main,
                    etcFragment,
                    etcFragment.getTag()
            ).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
