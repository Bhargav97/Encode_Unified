package encoders.encode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class BinaryTreeBFSFragment extends Fragment {
    Spinner spinner1, spinner2;
    ArrayAdapter<CharSequence> adapter1, adapter2;
    Button go;
    int binary;
    EditText input;
    TextView output;
    String inp;
    String selectedInput, selectedOutput;
    int[] inparr;
    String[] inpstrarr;
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
    public void onStop() {
        MainActivity.toggleTutIcon(getActivity(),false);
        super.onStop();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.binary_tree_bfs_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Breadth-First Traversal");
        ((MainActivity)getActivity()).setNavItem(R.id.navds);
        spinner1 = (Spinner) v.findViewById(R.id.spinner1BTBFS);
        adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.input_mode_names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        final RelativeLayout mainLayout;
        mainLayout = (RelativeLayout)v.findViewById(R.id.mainLayoutBTBFS);

        input = (EditText) v.findViewById(R.id.inputBTBFS);
        output = (TextView) v.findViewById(R.id.textView3BTBFS);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedInput = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        go = (Button) v.findViewById(R.id.buttonBTBFS);
        go.setOnClickListener(new View.OnClickListener() {
            BinaryTree bt = new BinaryTree();
            //TreeNode root;

            @Override
            public void onClick(View view) {
                inp = input.getText().toString();
                inpstrarr = inp.split(",");
                int len = inpstrarr.length;
                inparr = new int[len];
                for(int i = 0; i<len; i++){
                    inparr[i]=Integer.parseInt(inpstrarr[i]);
                }
                if (selectedInput.equals("Preorder")) {
                    bt.root=bt.constructTreeFromPre(inparr,len);
                }
                else{
                    bt.root=bt.constructTreeFromPost(inparr,len);
                }

                bt.genLevelOrder();
                String lev = bt.levorder.toString();
                output.setText(lev);
                bt.levorder = new StringBuilder("");
                bt.root=null;

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });

        return v;
    }
}
