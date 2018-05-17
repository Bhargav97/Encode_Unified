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
import android.widget.Toast;

public class GraphDFSFragment extends Fragment {
    static Spinner spinner1, spinner2;
    ArrayAdapter<CharSequence> adapter1, adapter2;
    Button go;
    int binary;
    EditText input;
    static TextView output;
    String inp;
    static String selectedInput, selectedOutput;
    int[] inparr;
    String[] inpstrarr;
    static Graph g;

    public static void createGraph(int v){
        g=null;
        g = new Graph(v);
    }

    public static boolean addNode(int v, int w, Context context){
        if(g.addEdge(v,w)==false) {
            Toast.makeText(context, "Enter valid nodes", Toast.LENGTH_LONG).show();
            return false;
        }
        else
            return true;
    }


    public static boolean showTraversal(int i,Context context) {
        if(i>=g.V || i<0) {
            Toast.makeText(context, "Enter a valid node", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            if (selectedInput.equals("Breadth-First Traversal")) {
                g.BFS(i);
            } else
                g.DFS(i);
            output.setText(selectedInput + " is shown below\n\n" + g.traversal.toString());
            g.traversal = new StringBuilder("");
            return  true;
        }
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.graph_dfs_fragment,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Graph DFS & BFS");
        ((MainActivity)getActivity()).setNavItem(R.id.navds);
        spinner1 = (Spinner) v.findViewById(R.id.spinner1GRDFS);
        adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.output_mode_graph_names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        final RelativeLayout mainLayout;
        mainLayout = (RelativeLayout)v.findViewById(R.id.mainLayoutGRDFS);

        output = (TextView) v.findViewById(R.id.textView3GRDFS);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedInput = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).add(R.id.fragContainerGraphInput, new GraphDFSInputOneFragment(), "INPUTONE").commit();
       // Fragment inputOne = getActivity().getSupportFragmentManager().findFragmentByTag("INPUTONE");
        /*go.setOnClickListener(new View.OnClickListener() {

            //TreeNode root;

            @Override
            public void onClick(View view) {

               // Graph g = new Graph(v);

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });*/

        return v;
    }

}
