package encoders.encode;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class HomeFragment extends Fragment implements View.OnClickListener {
    CardView refCard, dsCard, algoCard, fbCard;
    //Hide the main activity Toolbar to set our collapsableToolbar
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
    /*public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        ((MainActivity)getActivity()).setActionBarTitle("Home");
        ((MainActivity)getActivity()).setNavItem(R.id.navhome);
        //Changes for Collapsing Toolbar
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        Toolbar toolbar = v.findViewById(R.id.toolbaridhome);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
      /*  if (v.findViewById(R.id.home_cl) != null) {
            CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT);
            params.setMargins(0, -getStatusBarHeight(), 0, 0); //setting negative margin to root CL, important
            v.findViewById(R.id.home_cl).setLayoutParams(params);
        }

        getActivity().getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);*/
        refCard = (CardView) v.findViewById(R.id.refcardId);
        dsCard = (CardView) v.findViewById(R.id.dscardId);
        algoCard = (CardView) v.findViewById(R.id.algocardId);
        fbCard = (CardView) v.findViewById(R.id.concardId);
        refCard.setOnClickListener(this);
        dsCard.setOnClickListener(this);
        algoCard.setOnClickListener(this);
        fbCard.setOnClickListener(this);
        return v;
    }

    public void onClick(View v){
        Intent i;

        switch(v.getId()){
            case R.id.refcardId:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RefFragment()).addToBackStack(null).commit();
                break;
            case R.id.dscardId:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DSFragment()).addToBackStack(null).commit();
                break;
            case R.id.algocardId:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AlgoFragment()).addToBackStack(null).commit();
                break;
            case R.id.concardId:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ConversionFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
