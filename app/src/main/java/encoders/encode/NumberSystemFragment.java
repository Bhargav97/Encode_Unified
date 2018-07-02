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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NumberSystemFragment extends Fragment {


    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Button go;
    int binary;
    EditText input;
    TextView output1,out2,out3;
    String inp;
    String selected;
    //To enable searchView on non-Major fragments
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainActivity.partialSearch();
        MainActivity.toggleTutIcon(getActivity(),true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        MainActivity.toggleTutIcon(getActivity(),true);
        super.onResume();
    }

    @Override
    public void onStop() {
        MainActivity.toggleTutIcon(getActivity(),false);
        super.onStop();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.number_system_layout,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Number Systems");
        ((MainActivity)getActivity()).setNavItem(R.id.navref);

        spinner = (Spinner) v.findViewById(R.id.spinnerNS);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.number_system_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setPrompt("Select a Number system");
        spinner.setAdapter(adapter);

        final RelativeLayout mainLayout;
        mainLayout = (RelativeLayout)v.findViewById(R.id.mainLayoutNS);

        input = (EditText) v.findViewById(R.id.inputNS);
        output1 = (TextView) v.findViewById(R.id.binaryNS);
        out2 = (TextView) v.findViewById(R.id.decimalNS);
        out3 = (TextView) v.findViewById(R.id.hexadecimalNS);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });



        go = (Button) v.findViewById(R.id.buttonNS);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inp = input.getText().toString();

                if(selected.equals("Binary"))
                {
                    if(inp.matches("[01]+")) {
                        output1.setText(inp);
                        out2.setText(Integer.toString(Integer.parseInt(inp, 2)));
                        out3.setText(Integer.toString(Integer.parseInt(inp, 2), 16));
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Enter a valid Binary Number", Toast.LENGTH_SHORT).show();
                    }
                }

                else if(selected.equals("Decimal"))
                {
                    if(inp.matches("[0123456789]+")) {
                        out2.setText(inp);
                        output1.setText(Integer.toBinaryString(Integer.parseInt(inp)));
                        out3.setText(Integer.toHexString(Integer.parseInt(inp)));
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Enter a valid Decimal Number", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(selected.equals("Hexadecimal")) {
                    if (inp.matches("[0123456789abcdef]+")) {
                        out3.setText(inp);
                        out2.setText(Integer.toString(Integer.parseInt(inp, 16)));
                        output1.setText(Integer.toBinaryString(Integer.parseInt(inp, 16)));
                    } else {
                        Toast.makeText(getActivity(), "Enter a valid Hexadecimal Number", Toast.LENGTH_SHORT).show();
                    }
                }

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);

                // autoclose Keypad

                // show the 'Selec' dialogue in the spinner itself
            }

        });
        return v;
    }
}
