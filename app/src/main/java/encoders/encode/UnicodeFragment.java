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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class UnicodeFragment extends Fragment {
    String cc;
    Character c;
    int answer;
    EditText input;
    EditText output;
    Button convert;
    //To enable searchView on non-Major fragments
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainActivity.partialSearch();
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.unicode_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Unicode");
        ((MainActivity)getActivity()).setNavItem(R.id.navref);

        final RelativeLayout mainLayout;
        mainLayout = (RelativeLayout)v.findViewById(R.id.mainLayoutUC);

        input = (EditText) v.findViewById(R.id.editTextUC);
        output = (EditText) v.findViewById(R.id.editText2UC);

        convert = (Button) v.findViewById(R.id.buttonUC);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cc = input.getText().toString();
                c = cc.charAt(0);
                int answer = (int) c;

               //  "\\u" + Integer.toHexString('÷' | 0x10000).substring(1)
                String ans = "\\u" + Integer.toHexString(answer | 0x10000).substring(1);
                output.setText(ans);

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });
        return v;
    }
}
