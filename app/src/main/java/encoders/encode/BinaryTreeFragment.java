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

public class BinaryTreeFragment extends Fragment {

    String options[] = {"Perform BFS", "Perform DFS"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.binary_tree_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Binary Tree");
        ((MainActivity)getActivity()).setNavItem(R.id.navds);
        ListView listView = (ListView) v.findViewById(R.id.dsbt_lv);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_expandable_list_item_1,options);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View v, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

                if(selectedItem.equals("Perform DFS")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BinaryTreeDFSFragment()).addToBackStack(null).commit();
                }
                else if(selectedItem.equals("Perform BFS")){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BinaryTreeBFSFragment()).addToBackStack(null).commit();
                }

                /*Intent intent = new Intent(Activity.this,destinationActivity.class);
                //based on item add info to intent
                startActivity(intent);*/
            }
        });
        return v;
    }

}
