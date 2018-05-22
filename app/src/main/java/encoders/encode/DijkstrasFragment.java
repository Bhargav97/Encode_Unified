package encoders.encode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DijkstrasFragment extends Fragment {
    //static String selectedInput;
    static Graph g;
    static boolean mode;
    static TextView outputText1, outputText2;//If true, Graph is Undirected and if false its a directed Graph
    public static void createGraph(int v){
        g=null;
        g = new Graph(v,true);
    }
    public static void setMode(boolean b){
        mode=b;
    }
    public static boolean addNode(int v, int w, int weight, Context context){
        if(mode==true) {
            if (g.addEdge(v, w, weight) == false && g.addEdge(w,v, weight)==false) {
                Toast.makeText(context, "Enter valid nodes", Toast.LENGTH_LONG).show();
                return false;
            } else
                return true;
        }
        else{
            if (g.addEdge(v, w, weight) == false) {
                Toast.makeText(context, "Enter valid nodes", Toast.LENGTH_LONG).show();
                return false;
            } else
                return true;
        }
    }

    public static void setOutputText(String id ){
        outputText1.setText(id);outputText2.setText("");
    }

    public static boolean showTraversal(int i,int j,Context context) {
        if(i>=g.V || i<0 || j>=g.V || j<0) {
            Toast.makeText(context, "Enter a valid node", Toast.LENGTH_LONG).show();
            return false;
        }
        Toast.makeText(context, "prepping", Toast.LENGTH_LONG).show();

        g.dijkstra(i,j,context);
        outputText1.setText(Integer.toString(g.shortestDist));
        outputText2.setText(g.shortestPath);
        g.shortestPath="";
        g.shortestDist=0;
        return  true;
    }

    //To enable searchView on non-Major fragments
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainActivity.partialSearch();
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.dijkstra_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Dijkstra's Shortest Path");
        ((MainActivity)getActivity()).setNavItem(R.id.navalgo);
        outputText1 = v.findViewById(R.id.textView3GRDDJK);
        outputText2 = v.findViewById(R.id.textView4GRDDJK);
        getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).add(R.id.fragContainerDijkstrasInput, new GreedyDijkstrasZeroFragment(), "INPUTZERO").commit();
        return v;
    }
}
