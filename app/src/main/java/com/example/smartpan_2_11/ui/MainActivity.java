package com.example.smartpan_2_11.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.smartpan_2_11.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private ContactsFragment contactsFragment;
    private SearchFragment searchFragment;
    private PictureFragment pictureFragment;

    private ArrayList<Fragment> fragments;

    private int[] icons = {
            R.drawable.ic_person_grey_24dp,
            R.drawable.ic_search_grey_24dp,
            R.drawable.ic_camera_enhance_grey_24dp
    };

    private int[] titles = {
            R.string.contacts,
            R.string.search,
            R.string.picture
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setSelectedTabIndicatorHeight(0);

        contactsFragment = new ContactsFragment();
        searchFragment = new SearchFragment();
        pictureFragment = new PictureFragment();

        fragments = new ArrayList<>();
        fragments.add(contactsFragment);
        fragments.add(searchFragment);
        fragments.add(pictureFragment);

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        setIcons();

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                LinearLayout linearLayout;
                ImageView imageView;
                TextView textView;
                switch (tab.getPosition()) {
                    case 0:
                        linearLayout = (LinearLayout) tab.getCustomView();
                        imageView = (ImageView) linearLayout.getChildAt(0);
                        textView = (TextView) linearLayout.getChildAt(1);
                        imageView.setColorFilter(getResources().getColor(R.color.selected));
                        textView.setTextColor(getResources().getColor(R.color.selected));
                        break;
                    case 1:
                        linearLayout = (LinearLayout) tab.getCustomView();
                        imageView = (ImageView) linearLayout.getChildAt(0);
                        textView = (TextView) linearLayout.getChildAt(1);
                        imageView.setColorFilter(getResources().getColor(R.color.selected));
                        textView.setTextColor(getResources().getColor(R.color.selected));
                        break;
                    case 2:
                        linearLayout = (LinearLayout) tab.getCustomView();
                        imageView = (ImageView) linearLayout.getChildAt(0);
                        textView = (TextView) linearLayout.getChildAt(1);
                        imageView.setColorFilter(getResources().getColor(R.color.selected));
                        textView.setTextColor(getResources().getColor(R.color.selected));
                        break;
                }
                super.onTabSelected(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LinearLayout linearLayout;
                ImageView imageView;
                TextView textView;
                switch (tab.getPosition()) {
                    case 0:
                        linearLayout = (LinearLayout) tab.getCustomView();
                        imageView = (ImageView) linearLayout.getChildAt(0);
                        textView = (TextView) linearLayout.getChildAt(1);
                        imageView.setColorFilter(getResources().getColor(R.color.unselected));
                        textView.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                    case 1:
                        linearLayout = (LinearLayout) tab.getCustomView();
                        imageView = (ImageView) linearLayout.getChildAt(0);
                        textView = (TextView) linearLayout.getChildAt(1);
                        imageView.setColorFilter(getResources().getColor(R.color.unselected));
                        textView.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                    case 2:
                        linearLayout = (LinearLayout) tab.getCustomView();
                        imageView = (ImageView) linearLayout.getChildAt(0);
                        textView = (TextView) linearLayout.getChildAt(1);
                        imageView.setColorFilter(getResources().getColor(R.color.unselected));
                        textView.setTextColor(getResources().getColor(R.color.unselected));
                        break;
                }
                super.onTabUnselected(tab);
            }
        });
    }

    private void setIcons() {
        //tabLayout.getTabAt(0).setIcon(icons[0]);
        //tabLayout.getTabAt(1).setIcon(icons[1]);
        //tabLayout.getTabAt(2).setIcon(icons[2]);
        //LinearLayout linearLayout = new LinearLayout(this);
        for (int i = 0; i < 3; i++) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tab_item, null);
            TextView textView = linearLayout.findViewById(R.id.tv_tab);
            ImageView imageView = linearLayout.findViewById(R.id.iv_tab);
            textView.setText(titles[i]);
            imageView.setImageResource(icons[i]);
            tabLayout.getTabAt(i).setCustomView(linearLayout);
        }
    }
}
