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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class GreedyDijkstrasOneFragment extends Fragment {
    int vertices;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.djk_input_one, container, false);
        Button b = v.findViewById(R.id.buttonGRDDJKS1);
        final EditText input = v.findViewById(R.id.inputGRDDJK1);
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutGRDDJKO);
        input.requestFocus();
        DijkstrasFragment.setOutputText("STEP 2");
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vertices = Integer.parseInt(input.getText().toString());
                DijkstrasFragment.createGraph(vertices);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerDijkstrasInput, new GreedyDijkstrasTwoFragment(), "INPUTTWO").commit();
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });


        return v;
    }
}
