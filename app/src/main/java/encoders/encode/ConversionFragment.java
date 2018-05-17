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

import java.util.ArrayList;
import java.util.List;

public class ConversionFragment extends Fragment {

    static String options[] = {"ASCII", "Unicode", "Number System"};
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
        View v = inflater.inflate(R.layout.conversion_layout,container,false);
        // Set title bar
        ((MainActivity)getActivity()).setActionBarTitle("Conversion");
        ((MainActivity)getActivity()).setNavItem(R.id.navcon);
        //trying to get hamburger icon back for nav drawer
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        Toolbar toolbar = v.findViewById(R.id.toolbaridcon);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        recyclerView = (RecyclerView) v.findViewById(R.id.con_rlv);

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
                if(selectedItem.equals("ASCII")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AsciiFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Unicode")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UnicodeFragment()).addToBackStack(null).commit();
                }
                else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NumberSystemFragment()).addToBackStack(null).commit();

                }
            }
        } ;
        rvAdapter = new RVAdapter(getActivity(),getData(),listener);
        recyclerView.setAdapter(rvAdapter);
        // Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();


        // recyclerView.setHasFixedSize(true);
        /*recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                int action = e.getAction();
                switch (action) {
                    case MotionEvent.ACTION_MOVE:
                        rv.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });*/
        /*ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        ListViewUtility.setListViewHeightBasedOnChildren(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("ASCII")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AsciiFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Unicode")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UnicodeFragment()).addToBackStack(null).commit();
                }
                else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NumberSystemFragment()).addToBackStack(null).commit();

                }
                /*Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);
            }
        }); */
        return v;
    }
}
