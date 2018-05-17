package encoders.encode;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    NavigationView navigationView;

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        //Set listeners to clicks on nav menu items

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Hamburger icon and toggle for drawer

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //this check is to see if the device is just rotated or the app has just started
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new HomeFragment(),"HOME_FRAGMENT").addToBackStack(null).commit();
            navigationView.setCheckedItem(R.id.navhome);
        }
/*
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        switch(id){
            case R.id.navhome:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment(),"HOME_FRAGMENT").addToBackStack(null).commit();
                break;
            case R.id.navref:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RefFragment()).addToBackStack(null).commit();
                break;
            case R.id.navds:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DSFragment()).addToBackStack(null).commit();
                break;
            case R.id.navalgo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AlgoFragment()).addToBackStack(null).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public void setNavItem(int id){
        navigationView.setCheckedItem(id);
    }
    @Override
    public void onBackPressed() {
        /*int count = getFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }*/

        HomeFragment myFragment = (HomeFragment)getSupportFragmentManager().findFragmentByTag("HOME_FRAGMENT");
        if (myFragment != null && myFragment.isVisible()) {
            // add your code here
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
