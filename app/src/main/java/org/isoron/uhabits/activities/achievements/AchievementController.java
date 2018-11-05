package org.isoron.uhabits.activities.achievements;


import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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

    protected AchievementController(AchievementActivity activity) {
        this.activity = activity;
        showPoints();
        showMedals();
    }

    private void showPoints() {
        TextView pointsLabel = activity.findViewById(R.id.pointsLabel);
        points = 150;
        pointsLabel.setText(String.valueOf(points));
    }

    private void showMedals() {
        TextView text1 = activity.findViewById(R.id.medal_1_status);
        TextView text2 = activity.findViewById(R.id.medal_2_status);
        TextView text3 = activity.findViewById(R.id.medal_3_status);
        TextView text4 = activity.findViewById(R.id.medal_4_status);
        ImageView imageView;

        text1.setText(LOCKED); text1.setTextColor(GRAY);
        text2.setText(LOCKED); text2.setTextColor(GRAY);
        text3.setText(LOCKED); text3.setTextColor(GRAY);
        text4.setText(LOCKED); text4.setTextColor(GRAY);

        if(points >= 1000) {
            text1.setText(ACHIEVED); text1.setTextColor(ORANGE);
            text2.setText(ACHIEVED); text2.setTextColor(ORANGE);
            text3.setText(ACHIEVED); text3.setTextColor(ORANGE);
            text4.setText(ACHIEVED); text4.setTextColor(ORANGE);
        }
        else if(points >= 500) {
            text1.setText(ACHIEVED); text1.setTextColor(ORANGE);
            text2.setText(ACHIEVED); text2.setTextColor(ORANGE);
            text3.setText(ACHIEVED); text3.setTextColor(ORANGE);
            imageView = activity.findViewById(R.id.medal_image_4);
            imageView.setColorFilter(convert());

        }
        else if(points >= 100) {
            text1.setText(ACHIEVED); text1.setTextColor(ORANGE);
            text2.setText(ACHIEVED); text2.setTextColor(ORANGE);
            imageView = activity.findViewById(R.id.medal_image_4);
            imageView.setColorFilter(convert());
            imageView = activity.findViewById(R.id.medal_image_3);
            imageView.setColorFilter(convert());
        }
        else if(points >= 10) {
            text1.setText(ACHIEVED); text1.setTextColor(ORANGE);
            imageView = activity.findViewById(R.id.medal_image_4);
            imageView.setColorFilter(convert());
            imageView = activity.findViewById(R.id.medal_image_3);
            imageView.setColorFilter(convert());
            imageView = activity.findViewById(R.id.medal_image_2);
            imageView.setColorFilter(convert());
        }
        else {
            imageView = activity.findViewById(R.id.medal_image_4);
            imageView.setColorFilter(convert());
            imageView = activity.findViewById(R.id.medal_image_3);
            imageView.setColorFilter(convert());
            imageView = activity.findViewById(R.id.medal_image_2);
            imageView.setColorFilter(convert());
            imageView = activity.findViewById(R.id.medal_image_1);
            imageView.setColorFilter(convert());
        }
    }

    private ColorMatrixColorFilter convert() {
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        return new ColorMatrixColorFilter(cm);
    }

}
