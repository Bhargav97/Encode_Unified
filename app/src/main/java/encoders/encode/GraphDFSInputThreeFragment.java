package encoders.encode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class GraphDFSInputThreeFragment extends Fragment {
    Spinner spinner1;
    String selectedInput;
    ArrayAdapter adapter1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.graph_input_three_layout, container, false);
        Button genButton = v.findViewById(R.id.buttonGRDFS4);
        Button newButton = v.findViewById(R.id.buttonGRDFS5);
        final EditText input = v.findViewById(R.id.inputGRDFS4);
        final TextView status = v.findViewById(R.id.statusText2);
        spinner1 = (Spinner) v.findViewById(R.id.spinner1GRDFS);
        adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.output_mode_graph_names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedInput = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        input.requestFocus();
        GraphDFSFragment.setOutputText("Press \"Generate Traversal\" and you will see the output here");
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutGRDFSTH);
        genButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphDFSFragment.setSelectedInput(selectedInput);
                int i = Integer.parseInt(input.getText().toString());
                if(GraphDFSFragment.showTraversal(i,getActivity())==true)
                    status.setText("Traversal Generated!");
                else
                    status.setText("Invalid Node");
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerGraphInput, new GraphDFSInputZeroFragment(), "INPUTZERO").commit();

            }
        });

        return v;
    }
}
