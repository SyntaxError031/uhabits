package org.isoron.uhabits.activities.achievements;

import android.view.View;
import android.widget.TextView;
import org.isoron.uhabits.R;
import java.util.ArrayList;



public class DetailsController {

    private DetailsActivity activity;
    private ArrayList<Record> recordList = new ArrayList<Record>();

    DetailsController(DetailsActivity activity) {
        this.activity = activity;
        addData();
        showRecords();
    }

    private void showRecords() {
        int[] idList = {R.id.record_1, R.id.record_2, R.id.record_3, R.id.record_4, R.id.record_5};
        int[] nameList = {R.id.record_1_name, R.id.record_2_name, R.id.record_3_name, R.id.record_4_name, R.id.record_5_name};
        int[] timeList = {R.id.record_1_time, R.id.record_2_time, R.id.record_3_time, R.id.record_4_time, R.id.record_5_time};
        int[] valueList = {R.id.record_1_value, R.id.record_2_value, R.id.record_3_value, R.id.record_4_value, R.id.record_5_value};

        int size;
        if(recordList.size() < 5)
            size = recordList.size();
        else
            size = 5;

        int i;
        for(i = 0; i < size; i++) {
            TextView textView = activity.findViewById(nameList[i]);
            textView.setText(recordList.get(i).getName());
            textView = activity.findViewById(timeList[i]);
            textView.setText(recordList.get(i).getTime());
            textView = activity.findViewById(valueList[i]);
            int value = recordList.get(i).getValue();
            textView.setText("+" + String.valueOf(value));
        }

        if(i < 5) {
            for(int j = i; j < 5; j++)
                activity.findViewById(idList[j]).setVisibility(View.GONE);
        }

    }

    private void addData() {
        Record tmp = new Record("exercise", "2018-10-09 18:23", 1);
        recordList.add(tmp);
        tmp = new Record("get up early", "2018-10-09 08:00", 3);
        recordList.add(tmp);
        tmp = new Record("exercise", "2018-10-07 10:23", 5);
        recordList.add(tmp);

    }
}
