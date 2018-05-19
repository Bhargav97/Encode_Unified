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
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    NavigationView navigationView;
    static MaterialSearchView searchView;
   // static SearchView searchView;
    static TextView welcome;
    static View viewShadow;
    static ListView searchListView;
    String[] searchSource = {
        "Binary Tree",
        "Graph",
        "Directed Graph",
        "Undirected Graph",
        "Conversion",
        "ASCII",
        "Unicode",
        "Number System",
        "Numbah",
        "BFS",
        "DFS",
        "BST"
    };
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static void hideSearch(){
        searchView.setVisibility(View.GONE);
        welcome.setVisibility(View.GONE);
        viewShadow.setVisibility(View.GONE);
    }
    public static void showSearch(){
        searchView.setVisibility(View.VISIBLE);
        welcome.setVisibility(View.VISIBLE);
        viewShadow.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        drawer = findViewById(R.id.drawer_layout);
        //searchListView = findViewById(R.id.searchListView);
        searchView = findViewById(R.id.search_view);
        /*searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        //Search List View


        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,searchSource);
        searchListView.setAdapter(adapter);
*/
        //Set listeners to clicks on nav menu items

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Hamburger icon and toggle for drawer

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        welcome = findViewById(R.id.welcome_text);
        viewShadow = findViewById(R.id.shadowswag);
        //this check is to see if the device is just rotated or the app has just started
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).add(R.id.fragment_container, new HomeFragment(),"HOME_FRAGMENT").addToBackStack(null).commit();
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
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new HomeFragment(),"HOME_FRAGMENT").addToBackStack(null).commit();
                break;
            case R.id.navref:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new RefFragment()).addToBackStack(null).commit();
                break;
            case R.id.navds:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new DSFragment()).addToBackStack(null).commit();
                break;
            case R.id.navalgo:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new AlgoFragment()).addToBackStack(null).commit();
                break;
            case R.id.navcon:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new ConversionFragment()).addToBackStack(null).commit();
                break;
            case R.id.navfeedback:
                Toast.makeText(this, "What's the hurry dude!!",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.navsettings:
                Toast.makeText(this, "Really dude?",
                        Toast.LENGTH_LONG).show();
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
           /* Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/
           finish();
        }

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        //searchView = (SearchView)item.getActionView();
        return true;
    }

}
