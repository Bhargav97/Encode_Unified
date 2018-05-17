package encoders.encode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GraphDFSInputTwoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dfs_input_two_layout, container, false);
        Button addButton = v.findViewById(R.id.buttonGRDFS2);
        Button doneButton = v.findViewById(R.id.buttonGRDFS3);
        final EditText input1 = v.findViewById(R.id.inputGRDFS2);
        final EditText input2 = v.findViewById(R.id.inputGRDFS3);
        final TextView status = v.findViewById(R.id.statusText);
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutGRDFST);
        input1.requestFocus();
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=0,j=0;
                try {
                    i = Integer.parseInt(input1.getText().toString());
                    j = Integer.parseInt(input2.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getActivity(),"Enter both the values",Toast.LENGTH_LONG).show();
                    return;
                }
                if((GraphDFSFragment.addNode(i,j,getActivity()))==true)
                    status.setText("Edge " + i + " -> " + j + " added!");
                else
                    status.setText("Invalid nodes submitted");
                input1.setText("");
                input2.setText("");
                if(input1.requestFocus()) {
                    getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerGraphInput, new GraphDFSInputThreeFragment(), "INPUTTHREE").commit();

            }
        });

        return v;
    }
}
