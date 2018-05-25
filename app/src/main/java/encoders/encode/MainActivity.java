package encoders.encode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    private DrawerLayout drawer;
    NavigationView navigationView;
    static MaterialSearchView searchView;
   // static SearchView searchView;
    static TextView welcome;
    static View viewShadow;
    static LinearLayout homell;
    static ListView searchListView;
    static ActionBar actionBar;
    static boolean isMajor;
    static Toolbar toolbar;
    float scale;
    int pixels,pixels2;
    public static boolean hideIcon;
    public static void setMajor(){ isMajor=true; }
    public static void unsetMajor(){ isMajor=false; }
    static Window w;
    FragmentManager mFragmentManager;
    CardView refCard, dsCard, algoCard, fbCard;
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
    ArrayAdapter searchListViewAdapter;
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    public static void partialSearch(){
        searchView.setVisibility(View.VISIBLE);
    }
    public static void hideSearch(){
        searchView.setVisibility(View.GONE);
        welcome.setVisibility(View.GONE);
        viewShadow.setVisibility(View.GONE);
        homell.setVisibility(View.GONE);
    }
    public static void showSearch(){
        homell.setVisibility(View.VISIBLE);
        searchView.setVisibility(View.VISIBLE);
        welcome.setVisibility(View.VISIBLE);
        viewShadow.setVisibility(View.VISIBLE);
    }
    public static void setTitleToHome(){
        actionBar.setTitle("Home");
    }

    public static void dothis(){
        // in Activity's onCreate() for instance
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
       /* CollapsingToolbarLayout.LayoutParams lp = (CollapsingToolbarLayout.LayoutParams) toolbar.getLayoutParams();
        lp.setMargins(0,24,0,0);
        toolbar.setLayoutParams(lp);*/
    }
    public static void undothis(){
        // in Activity's onCreate() for instance

        w.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void takeToAppropriateTutFragment(){
        String actionBarTitle = getSupportActionBar().getTitle().toString();
        switch (actionBarTitle){
            case "Binary Search Tree": case "Breadth-First Traversal": case "Depth-First Traversal":
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new BTtut()).addToBackStack(null).commit();
                break;
        }

    }

    public static void toggleTutIcon(Activity activity, boolean state){
        if(state!=hideIcon){

        }
        else {
            hideIcon = !state;
            activity.invalidateOptionsMenu();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hideIcon=true;
        invalidateOptionsMenu();
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        drawer = findViewById(R.id.drawer_layout);
        //searchListView = findViewById(R.id.searchListView);
        searchView = findViewById(R.id.search_view);
        searchListView = findViewById(R.id.searchListView);
        searchListView.setVisibility(View.GONE);
        actionBar = getSupportActionBar();
        homell = findViewById(R.id.homell);
        w = getWindow();
        mFragmentManager = ((FragmentActivity) this).getSupportFragmentManager();
        searchListViewAdapter = new ArrayAdapter(this,R.layout.search_item_layout,searchSource);
        searchListView.setAdapter(searchListViewAdapter);
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            String selectedQuery;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedQuery = searchListView.getItemAtPosition(position).toString();
                switch(selectedQuery){
                    case "Binary Tree": case "Tree":
                        searchListView.setVisibility(View.GONE);
                        searchView.closeSearch();
                        hideSearch();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new BinaryTreeFragment()).addToBackStack(null).commit();
                        break;
                    case "Graph":
                        searchListView.setVisibility(View.GONE);
                        searchView.closeSearch();
                        hideSearch();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new GraphFragment()).addToBackStack(null).commit();
                        break;
                    case "Directed Graph": case "Undirected Graph": case "BFS": case "DFS":
                        searchListView.setVisibility(View.GONE);
                        searchView.closeSearch();
                        hideSearch();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new GraphDFSFragment()).addToBackStack(null).commit();
                        break;
                    case "ASCII":
                        searchListView.setVisibility(View.GONE);
                        searchView.closeSearch();
                        hideSearch();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new AsciiFragment()).addToBackStack(null).commit();
                        break;
                    case "Unicode":
                        searchListView.setVisibility(View.GONE);
                        searchView.closeSearch();
                        hideSearch();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new UnicodeFragment()).addToBackStack(null).commit();
                        break;
                    case "Number System": case "Numbah":
                        searchListView.setVisibility(View.GONE);
                        searchView.closeSearch();
                        hideSearch();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new NumberSystemFragment()).addToBackStack(null).commit();
                        break;
                    case "Conversion":
                        searchListView.setVisibility(View.GONE);
                        searchView.closeSearch();
                        hideSearch();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new ConversionFragment()).addToBackStack(null).commit();
                        break;
                }
            }
        });

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
            //Do when the app begins
            //getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).add(R.id.fragment_container, new HomeFragment(),"HOME_FRAGMENT").addToBackStack(null).commit();
            navigationView.setCheckedItem(R.id.navhome);
            setTitleToHome();
        }
      refCard = (CardView) findViewById(R.id.refcardId);
        dsCard = (CardView) findViewById(R.id.dscardId);
        algoCard = (CardView) findViewById(R.id.algocardId);
        fbCard = (CardView) findViewById(R.id.concardId);
        refCard.setOnClickListener(this);
        dsCard.setOnClickListener(this);
        algoCard.setOnClickListener(this);
        fbCard.setOnClickListener(this);

        //FOR FANCY SEARCH
        scale = getResources().getDisplayMetrics().density;
        pixels = (int) (10 * scale + 0.5f);
       // pixels2 = (int) (56 * scale + 0.5f);

       /* Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        switch(id){
            case R.id.navhome:
                //getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new HomeFragment(),"HOME_FRAGMENT").addToBackStack(null).commit();
                getSupportActionBar().show();
                setTitleToHome();
                showSearch();
                for (int i = 0; i < mFragmentManager.getBackStackEntryCount(); ++i) {
                    mFragmentManager.popBackStack();
                }
                break;
            case R.id.navref:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new RefFragment(),"REF").addToBackStack(null).commit();
                break;
            case R.id.navds:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new DSFragment(),"DS").addToBackStack(null).commit();
                break;
            case R.id.navalgo:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new AlgoFragment(),"ALGO").addToBackStack(null).commit();
                break;
            case R.id.navcon:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new ConversionFragment(),"CONV").addToBackStack(null).commit();
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
       // HomeFragment myFragment = (HomeFragment)getSupportFragmentManager().findFragmentByTag("HOME_FRAGMENT");
       /* if (myFragment != null && myFragment.isVisible() && searchListView.getVisibility()==View.GONE ) {
            // add your code here
           /* Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/
         /*  finish();
        }*/
/*
        if (mFragmentManager.getBackStackEntryCount() > 0)
                mFragmentManager.popBackStackImmediate();
            else
                super.onBackPressed();
*/
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(isMajor){
                    for (int i = 0; i < mFragmentManager.getBackStackEntryCount(); ++i) {
                        mFragmentManager.popBackStack();
                    }
                    showSearch();
                    getSupportActionBar().show();
                    setNavItem(R.id.navhome);
                    setTitleToHome();
                   // Toast.makeText(this,"Clearing shit",Toast.LENGTH_LONG).show();
        }
        else if (searchListView.getVisibility() == View.VISIBLE && searchView.isSearchOpen()){
            searchListView.setVisibility(View.GONE);
            searchView.closeSearch();
        }
        //when coming back to home from any fragment we reached thru search
        else if(mFragmentManager.getBackStackEntryCount() == 1){
            showSearch();
            getSupportActionBar().show();
            setNavItem(R.id.navhome);
            setTitleToHome();
            MainActivity.toggleTutIcon(this,false);

        }

        else if(searchView.isSearchOpen()){
            searchView.closeSearch();
        }
        else {
            super.onBackPressed();
        }

    }
    /*public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem item = menu.findItem(R.id.action_search);

        //searchView = (SearchView)item.getActionView();
        return true;
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        if (hideIcon){
            menu.findItem(R.id.action_tut).setVisible(false);
        }else{
            menu.findItem(R.id.action_tut).setVisible(true);
        }
        final MenuItem searchActionItem = menu.findItem( R.id.action_search);
        final MenuItem tutActionItem = menu.findItem( R.id.action_tut);
        searchActionItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toolbar.LayoutParams temp_layout = new Toolbar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, pixels2);
                toolbar.setLayoutParams(temp_layout);
                return true;
            }
        });

        searchView.setMenuItem(searchActionItem);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (searchListView.getVisibility() == View.GONE && !newText.equals("") && newText!=null)
                    searchListView.setVisibility(View.VISIBLE);
                searchListViewAdapter.getFilter().filter(newText);
                return true;
            }
        });
        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
               /*if (searchListView.getVisibility() == View.GONE)
                    searchListView.setVisibility(View.VISIBLE);*/
              //  Toast.makeText(getApplicationContext(),"Works",Toast.LENGTH_LONG).show();*/
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
                layoutParams.height+=pixels;
                toolbar.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) searchView.getLayoutParams();
                layoutParams2.height+=pixels;
                searchView.setLayoutParams(layoutParams2);
                searchView.setElevation(10);
                View v = findViewById(R.id.backdrop);
                v.setVisibility(View.VISIBLE);

                //Toast.makeText(getApplicationContext(), "Yes i am called", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onSearchViewClosed() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
                layoutParams.height-=pixels;
                toolbar.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) searchView.getLayoutParams();
                layoutParams2.height-=pixels;
                searchView.setLayoutParams(layoutParams2);
                View v = findViewById(R.id.backdrop);

                v.setVisibility(View.GONE);
                if (searchListView.getVisibility() == View.VISIBLE)
                    searchListView.setVisibility(View.GONE);
            }
        });

        //tutActionItem.setOnActionExpandListener()

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle onclick of actionbar items
        switch (item.getItemId()){
            case R.id.action_tut:
                takeToAppropriateTutFragment();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.refcardId:
                if(searchView.isSearchOpen()){
                    searchView.closeSearch();
                }
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new RefFragment(),"REF").addToBackStack(null).commit();
                break;
            case R.id.dscardId:
                if(searchView.isSearchOpen()){
                    searchView.closeSearch();

                }
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new DSFragment(),"DS").addToBackStack(null).commit();
                break;
            case R.id.algocardId:
                if(searchView.isSearchOpen()){
                    searchView.closeSearch();
                }
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new AlgoFragment(),"ALGO").addToBackStack(null).commit();
                break;
            case R.id.concardId:
                if(searchView.isSearchOpen()){
                    searchView.closeSearch();
                }
                getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new ConversionFragment(),"CONV").addToBackStack(null).commit();
                break;
        }
    }


}
