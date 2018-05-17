package encoders.encode;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BTtut extends Fragment {
    TextView t1,t2,t3,t4,t5,t6,t7;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bttut_layout, container, false);
        t1 = (TextView) v.findViewById(R.id.titleText1bt);
        t2 = (TextView) v.findViewById(R.id.titleText2bt);
        t3 = (TextView) v.findViewById(R.id.descText1bt);
        t4 = (TextView) v.findViewById(R.id.codeText1);
        t5 = (TextView) v.findViewById(R.id.titleText3bt);
        t6 = (TextView) v.findViewById(R.id.titleText4bt);
        t7 = (TextView) v.findViewById(R.id.descText2bt);
        t1.setText("Heading 1");
        t2.setText("Heading 2");
        t3.setText("And I find it kind of funny\n" +
                "I find it kind of sad\n" +
                "The dreams in which I'm dying\n" +
                "Are the best I've ever had\n" +
                "I find it hard to tell you\n" +
                "I find it hard to take\n" +
                "When people run in circles\n" +
                "It's a very, very\n" +
                "Mad world, mad world");
        t4.setText( "   android:id=\"@+id/btll\"\n" +
                "        android:orientation=\"vertical\"\n" +
                "        android:padding=\"10dp\">\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/titleText1bt\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        style=\"@style/TutHeadingText\"/>\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/titleText2bt\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        style=\"@style/TutHeading2Text\"/>\n" +
                "    <TextView\n" +
                "        android:id=\"@+id/descText1bt\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        style=\"@style/TutDescText\"/>\n" +
                "    <HorizontalScrollView\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\">\n" +
                "        <TextView\n" +
                "        android:id=\"@+id/codeText1\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        style=\"@style/CodeView\"/>\n" +
                "    </HorizontalScrollView>\n" +
                "\n" +
                "</LinearLayout>" +
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                "    android:layout_width=\"match_parent\"\n" +
                "    android:layout_height=\"176dp\"");
        t5.setText("Heading 1");
        t6.setText("Heading 2");
        t7.setText("And I find it kind of funny\n" +
                "I find it kind of sad\n" +
                "The dreams in which I'm dying\n" +
                "Are the best I've ever had\n" +
                "I find it hard to tell you\n" +
                "I find it hard to take\n" +
                "When people run in circles\n" +
                "It's a very, very\n" +
                "Mad world, mad world");
        return v;
    }
}
