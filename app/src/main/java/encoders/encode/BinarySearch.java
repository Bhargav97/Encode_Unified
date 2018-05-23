package encoders.encode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Arrays;
public class BinarySearch extends Fragment {
    EditText input1, input2;
    Button search;
    TextView defaultTV;
    static int iteration;
    static String currentOutput;
    LinearLayout linearLayout;
    //To enable searchView on non-Major fragments
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MainActivity.partialSearch();
        super.onCreate(savedInstanceState);
    }
    // x is MID and y is the Element we're searching for
    public static String decorMyArr(int[] arr, int x, int y, int lower, int upper, int itr){  //Function to make part of text bold
        String htmlString="Iteration "+ itr + ": ";
        for(int i=lower; i<upper; i++){
            if(i==y && arr[i]==x){
                htmlString = htmlString + " <b><u><i>" + arr[i] + "</i></u></b> ";
                continue;
            }
            //search Element
            if(arr[i]==x){
                htmlString = htmlString + " <u><i>" + arr[i] + "</i></u> ";
                continue;
            }
            //enBold the Mid
            if(i==y){
                htmlString = htmlString + " <b>" + arr[i] + "</b> ";
                continue;
            }


            htmlString = htmlString + " " + arr[i] + " ";
        }
        return htmlString;
    }
    public static int binarySearch(int arr[], int l, int r, int x, Context ctx, LinearLayout ll)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x) {
                currentOutput = decorMyArr(arr,x,mid,l,r,iteration);
                TextView tv = new TextView(ctx);
                tv.setText(Html.fromHtml(currentOutput));
                tv.setTextAppearance(ctx, R.style.BinarySearchDynamicOutputView);
                ll.addView(tv);
                return mid;
            }
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x) {
                currentOutput = decorMyArr(arr,x,mid,l,r,iteration);
                TextView tv = new TextView(ctx);
                tv.setText(Html.fromHtml(currentOutput));
                tv.setTextAppearance(ctx, R.style.BinarySearchDynamicOutputView);
                ll.addView(tv);
                iteration++;
                return binarySearch(arr, l, mid - 1, x,ctx,ll);
            }
            // Else the element can only be present
            // in right subarray
            currentOutput = decorMyArr(arr,x,mid,l,r,iteration);
            TextView tv = new TextView(ctx);
            tv.setText(Html.fromHtml(currentOutput));
            tv.setTextAppearance(ctx, R.style.BinarySearchDynamicOutputView);
            ll.addView(tv);
            iteration++;
            return binarySearch(arr, mid+1, r, x,ctx,ll);
        }

        // We reach here when element is not present
        //  in array
        return -1;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.binary_search,container,false);
        ((MainActivity)getActivity()).setActionBarTitle("Binary Search");
        ((MainActivity)getActivity()).setNavItem(R.id.navalgo);
        final LinearLayout mainLayout = v.findViewById(R.id.mainLayoutBinarySearch);
        linearLayout = (LinearLayout) v.findViewById(R.id.dynamicBSLL); //dynamic children containing BS LL
        defaultTV = v.findViewById(R.id.binarySearchDefault);
        input1 = (EditText) v.findViewById(R.id.binarySearchInput1);
        input2 = (EditText) v.findViewById(R.id.binarySearchInput2);
        final TextView statusText = v.findViewById(R.id.statusTextBS);
        //output = (EditText) v.findViewById(R.id.editText2UC);
        search = (Button) v.findViewById(R.id.binarySearchButton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.removeAllViews();
                defaultTV.setVisibility(View.GONE);
                statusText.setText("Bold is the MID and underlined is element to search");
                String[] inputStr;
                iteration=0;
                inputStr = input1.getText().toString().split(" ");
                int searchElement = Integer.parseInt(input2.getText().toString());
                int[] inputInt = new int[inputStr.length];
                for(int i = 0; i < inputStr.length; i++) {
                    inputInt[i] = Integer.parseInt(inputStr[i]);
                }
                Arrays.sort(inputInt);
                binarySearch(inputInt,0,inputInt.length,searchElement, getActivity(),linearLayout);
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
            }
        });
        return v;
    }
}
