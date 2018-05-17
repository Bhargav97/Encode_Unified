package encoders.encode;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DSFragment extends Fragment {
    static String options[] = {"Binary Tree", "n-ary Tree", "Directed Graph", "Undirected Graph", "DAG"};
    RecyclerView recyclerView;
    RVAdapter rvAdapter;

    //Hide the main activity Toolbar to set our collapsableToolbar
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
        View v = inflater.inflate(R.layout.ds_fragment,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Data Structures");
        ((MainActivity)getActivity()).setNavItem(R.id.navds);
        //trying to get hamburger icon back for nav drawer
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        Toolbar toolbar = v.findViewById(R.id.toolbaridds);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        recyclerView = (RecyclerView) v.findViewById(R.id.ds_rlv);

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
                if(selectedItem.equals("Binary Tree")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BinaryTreeFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("n-ary Tree")){
                    //todo
                }
                else if(selectedItem.equals("Directed Graph")){
                    //todo
                }
                else if(selectedItem.equals("Undirected Graph")){
                    //todo
                }
                else {
                    //todo
                }
            }
        } ;
        rvAdapter = new RVAdapter(getActivity(),getData(),listener);
        recyclerView.setAdapter(rvAdapter);
        /*ListView listView = (ListView) v.findViewById(R.id.ds_lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_expandable_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("Binary Tree")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BinaryTreeFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("n-ary Tree")){
                    //todo
                }
                else if(selectedItem.equals("Directed Graph")){
                    //todo
                }
                else if(selectedItem.equals("Undirected Graph")){
                    //todo
                }
                else {
                    //todo
                }
                /*Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);
            }
        });*/
        return v;
    }

}
