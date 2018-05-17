package encoders.encode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class AsciiFragment extends Fragment {
    String cc;
    Character c;
    int answer;
    EditText input;
    EditText output;
    Button convert;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ascii_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("ASCII");
        ((MainActivity)getActivity()).setNavItem(R.id.navref);

        final RelativeLayout mainLayout;
        mainLayout = (RelativeLayout)v.findViewById(R.id.mainLayout);

        input = (EditText) v.findViewById(R.id.editText);
        output = (EditText) v.findViewById(R.id.editText2);

        convert = (Button) v.findViewById(R.id.button);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cc = input.getText().toString();
                c = cc.charAt(0);
                int answer = (int) c;


                output.setText(Integer.toString(answer));

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });
        return v;
    }
}
