package com.example.logbook2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button previousButton;
    private Button nextButton;
    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3}; // Add your image resources

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        ImageAdapter adapter = new ImageAdapter(this, images);
        viewPager.setAdapter(adapter);

        // Set the starting position to a large value divided by 2 for seamless looping
        int startPosition = Integer.MAX_VALUE / 2;
        viewPager.setCurrentItem(startPosition);

        // Set click listeners for the Previous and Next buttons
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousImage();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextImage();
            }
        });
    }
    private void showPreviousImage() {
        int currentItem = viewPager.getCurrentItem();
        if (currentItem > 0) {
            viewPager.setCurrentItem(currentItem - 1);
        } else {
            // If at the beginning, loop to the end
            viewPager.setCurrentItem(images.length - 1, true);
        }
    }

    private void showNextImage() {
        int currentItem = viewPager.getCurrentItem();
        if (currentItem < Integer.MAX_VALUE) {
            viewPager.setCurrentItem(currentItem + 1);
        } else {
            // If at the end, loop to the beginning
            viewPager.setCurrentItem(0, true);
        }
    }
}