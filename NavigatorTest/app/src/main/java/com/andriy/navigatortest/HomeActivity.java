package com.andriy.navigatortest;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView btn_NavigView;
    ListView lv_home_menu;

    @SuppressLint({"RestrictedApi", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_NavigView = findViewById(R.id.btn_Navigation);
        MapsActivity.disableShiftMode(btn_NavigView);

        btn_NavigView.setItemBackgroundResource(R.color.ItemBackgroundResource_Select);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) btn_NavigView.getChildAt(0);
        BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(0);

        item.setIconTintList(ColorStateList.valueOf(Color.parseColor("#f97d2a")));
        item.setTextColor(ColorStateList.valueOf(Color.parseColor("#f97d2a")));

        lv_home_menu = findViewById(R.id.lv_home_menu);
        createListView();

        lv_home_menu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "My profile", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "My income", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "My settings", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    private void createListView() {
        String[] menu_home_text = new String[] {"Мой профиль", "Мои доходы", "Мои настройки"};
        Object[] menu_home_image = new Object[] {R.drawable.ic_account_circle_black_24dp, R.drawable.ic_monetization_on_black_24dp,
                R.drawable.ic_settings_black_24dp};

        ArrayList<Map<String, Object>> data = new ArrayList<>(3);
        Map<String, Object> m;
        for (int i = 0; i < 3; i++) {
            m = new HashMap<>();
            m.put("ItemText", menu_home_text[i]);
            m.put("ItemImage", menu_home_image[i]);
            data.add(m);
        }

        String[] from = { "ItemImage", "ItemText" };
        int[] to = { R.id.iv_menu_home_item, R.id.tv_menu_home_item };

        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.lv_item, from, to);
        lv_home_menu.setAdapter(sAdapter);
    }
}
