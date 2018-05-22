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

public class GreedyDijkstrasTwoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.djk_input_two, container, false);
        Button addButton = v.findViewById(R.id.buttonGRDDJKS2);
        Button doneButton = v.findViewById(R.id.buttonGRDDJKS3);
        final EditText input1 = v.findViewById(R.id.inputGRDDJK2);
        final EditText input2 = v.findViewById(R.id.inputGRDDJK3);
        final EditText input3 = v.findViewById(R.id.inputGRDDJK4);
        final TextView status = v.findViewById(R.id.statusTextDJK);
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutGRDDJKT);
        input1.requestFocus();
        DijkstrasFragment.setOutputText("STEP 3");
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=0,j=0,k=0;
                try {
                    i = Integer.parseInt(input1.getText().toString());
                    j = Integer.parseInt(input2.getText().toString());
                    k = Integer.parseInt(input3.getText().toString());
                }
                catch(NumberFormatException e){
                    Toast.makeText(getActivity(),"Enter all three values",Toast.LENGTH_LONG).show();
                    return;
                }
                if((DijkstrasFragment.addNode(i,j,k,getActivity()))==true) {
                    if(DijkstrasFragment.mode==true)
                        status.setText("Edge " + i + " -- " + j + "with weight = " + k + " added!");
                    else
                        status.setText("Edge " + i + " -> " + j + "with weight = " + k + " added!");
                }
                else
                    status.setText("Invalid nodes submitted");
                input1.setText("");
                input2.setText("");
                input3.setText("");
                if(input1.requestFocus()) {
                    getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerDijkstrasInput, new GreedyDijkstrasThreeFragment(), "INPUTTHREE").commit();

            }
        });

        return v;
    }
}
