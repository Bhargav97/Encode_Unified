package encoders.encode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RefFragment extends Fragment {
                                                                                            //4,8,11,13
    static String options[] = {"Data Structures","Binary Search Tree", "Graphs","Algorithms","Sorting Algos","Quick Sort","Merge Sort","Bubble Sort", "Search Algorithms","Binary Search","Fibonacci Search","Greedy Algos","Dijkstra's Shortest Path","Dynamic Programming Algos","Knapsack Problem","Assembly Line Scheduling"};
    RecyclerView recyclerView;
    RVwithSectionAdapter rvAdapter;

    //Hide the main activity Toolbar to set our collapsableToolbar
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        MainActivity.hideSearch();
        MainActivity.setMajor();
        MainActivity.dothis();

    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        MainActivity.unsetMajor();
        MainActivity.undothis();

    }
    public static List<RVInfo> getData(){
        List<RVInfo> dataList = new ArrayList<>();
        int len = options.length;
        for(int i = 0; i<len; i++){
            RVInfo current = new RVInfo();
            current.title = options[i];
            dataList.add(current);
        }
        return dataList;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ref_fragment,container,false);
        // Set title bar
        ((MainActivity)getActivity()).setActionBarTitle("References");
        ((MainActivity)getActivity()).setNavItem(R.id.navref);
        //trying to get hamburger icon back for nav drawer
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        Toolbar toolbar = v.findViewById(R.id.toolbaridref);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        recyclerView = (RecyclerView) v.findViewById(R.id.ref_rlv);

        LinearLayoutManager llm = new LinearLayoutManager(recyclerView.getContext());
       DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                llm.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setLayoutManager(llm);

        recyclerView.setNestedScrollingEnabled(false);
        //Understand this code
        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                String selectedItem = (String) rvAdapter.data.get(position).title;
                if(selectedItem.equals("Data Structures")){
                    //do nothing, its just a header
                }
                else if(selectedItem.equals("Binary Search Tree")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new BTtut()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Graphs")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new GTut()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Bubble Sort")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new BubbleTut()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Binary Search")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new BStut()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Dijkstra's Shortest Path")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new Dijtut()).addToBackStack(null).commit();
                }
                else {
                  //  getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new NumberSystemFragment()).addToBackStack(null).commit();

                }
            }
        } ;
        rvAdapter = new RVwithSectionAdapter(getActivity(),getData(),listener);
        recyclerView.setAdapter(rvAdapter);
        return v;
    }
}
