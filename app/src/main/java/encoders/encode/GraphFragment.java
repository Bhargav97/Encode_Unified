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

public class GraphFragment extends Fragment {
    String options[] = {"Perform BFS or DFS", "Placeholder"};
    //To enable searchView on non-Major fragments
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainActivity.partialSearch();
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.graph_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Graph Algorithms");
        ((MainActivity)getActivity()).setNavItem(R.id.navds);
        ListView listView = (ListView) v.findViewById(R.id.dsgraph_lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("Perform BFS or DFS")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new GraphDFSFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Placeholder")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new BinaryTreeBFSFragment()).addToBackStack(null).commit();
                }

                /*Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);*/
            }
        });
        return v;
    }

}
