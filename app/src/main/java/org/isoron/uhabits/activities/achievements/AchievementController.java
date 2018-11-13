package org.isoron.uhabits.activities.achievements;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.VisibleForTesting;
import android.widget.ImageView;
import android.widget.TextView;
import org.isoron.uhabits.R;



public class AchievementController {

    private AchievementActivity activity;
    private int points;
    private final String ACHIEVED = "ACHIEVED";
    private final String LOCKED = "LOCKED";
    private final int ORANGE = 0xffE64A19;
    private final int GRAY = 0xff616161;
    private TextView pointsLabel;

    protected AchievementController(AchievementActivity activity) {
        this.activity = activity;
        points = 150;
    //    showPoints();
    //    showMedals();
    }

    public void shareText(Context context) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String text = "I have won " + String.valueOf(points) + " points in Loop Habit Tracker!";
        intent.putExtra(Intent.EXTRA_SUBJECT,"Share");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(
                Intent.createChooser(intent, "Share"));
    }


    public void showPoints() {
        pointsLabel = activity.findViewById(R.id.pointsLabel);
    //    points = 150;
        pointsLabel.setText(String.valueOf(points));
    }

    public void showMedals() {
        int[] idList = { R.id.medal_1_status, R.id.medal_2_status, R.id.medal_3_status, R.id.medal_4_status};
        int[] imageList = {R.id.medal_image_1, R.id.medal_image_2, R.id.medal_image_3, R.id.medal_image_4};
        ImageView imageView;

        Medals[] medals;

        medals = Medals.values();
        TextView textView;
        for(int i = 0; i < medals.length; i++) {
            medals[i].changeStatus(150);
            textView = activity.findViewById(idList[i]);
            imageView = activity.findViewById(imageList[i]);
            if(medals[i].getStatus().toString().equals(ACHIEVED)) {
                textView.setText(ACHIEVED);
                textView.setTextColor(ORANGE);
            }
            else {
                textView.setText(LOCKED);
                textView.setTextColor(GRAY);
                imageView.setColorFilter(convert());
            }
        }

    }

    // 将图片转为黑白
    private ColorMatrixColorFilter convert() {
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        return new ColorMatrixColorFilter(cm);
    }

}
