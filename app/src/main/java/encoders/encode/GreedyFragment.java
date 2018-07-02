package encoders.encode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GreedyFragment extends Fragment {
    String options[] = {"Dijkstra's Shortest Path"};
    //To enable searchView on non-Major fragments
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainActivity.partialSearch();
        MainActivity.toggleTutIcon(getActivity(),true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        MainActivity.toggleTutIcon(getActivity(),true);
        super.onResume();
    }

    @Override
    public void onStop() {
        MainActivity.toggleTutIcon(getActivity(),false);
        super.onStop();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.greedy_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Greedy Algorithms");
        ((MainActivity)getActivity()).setNavItem(R.id.navalgo);
        ListView listView = (ListView) v.findViewById(R.id.algogreedy_lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("Dijkstra's Shortest Path")){
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new DijkstrasFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Hold on")){
                    //getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragment_container,new BinaryTreeBFSFragment()).addToBackStack(null).commit();
                }

                /*Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);*/
            }
        });
        return v;
    }
}
