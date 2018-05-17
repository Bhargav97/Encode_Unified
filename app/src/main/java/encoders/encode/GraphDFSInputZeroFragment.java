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
import android.widget.TextView;

public class GraphDFSInputZeroFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dfs_input_zero_layout, container, false);
        Button b1 = v.findViewById(R.id.buttonGRDFSZ1);
        Button b2 = v.findViewById(R.id.buttonGRDFSZ2);
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutGRDFSO);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphDFSFragment.setMode(false);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerGraphInput, new GraphDFSInputOneFragment(), "INPUTONE").commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GraphDFSFragment.setMode(true);
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).replace(R.id.fragContainerGraphInput, new GraphDFSInputOneFragment(), "INPUTONE").commit();
            }
        });
        return v;
    }
}

