package encoders.encode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class GreedyDijkstrasZeroFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.djk_input_zero, container, false);
        Button b1 = v.findViewById(R.id.buttonGRDDJKZ1);
        Button b2 = v.findViewById(R.id.buttonGRDDJKZ2);
        DijkstrasFragment.setOutputText("STEP 1");
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutGRDDJKZ);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DijkstrasFragment.setMode(false);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerDijkstrasInput, new GreedyDijkstrasOneFragment(), "INPUTONE").commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DijkstrasFragment.setMode(true);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerDijkstrasInput, new GreedyDijkstrasOneFragment(), "INPUTONE").commit();
            }
        });
        return v;
    }

}
