package encoders.encode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FrameMetricsAggregator;
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

public class GreedyDijkstrasThreeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.djk_input_three, container, false);
        Button genButton = v.findViewById(R.id.buttonGRDDJKS4);
        Button newButton = v.findViewById(R.id.buttonGRDDJKS5);
        final EditText input1 = v.findViewById(R.id.inputGRDDJK5);
        final EditText input2 = v.findViewById(R.id.inputGRDDJK6);
        final TextView status = v.findViewById(R.id.statusTextDJK2);

        input1.requestFocus();
        DijkstrasFragment.setOutputText("Press \"Generate Traversal\" and you will see the output here");
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutGRDDJKTH);
        genButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(input1.getText().toString());
                int j = Integer.parseInt(input2.getText().toString());

                if(DijkstrasFragment.showTraversal(i,j,getActivity())==true)
                    status.setText("Shortest Path Generated!");
                else
                    status.setText("Invalifd Node");
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerDijkstrasInput, new GreedyDijkstrasOneFragment(), "INPUTZERO").commit();

            }
        });

        return v;
    }
}
