package com.example.android.sih_telephony;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.priyesh.chroma.ChromaDialog;
import me.priyesh.chroma.ColorMode;
import me.priyesh.chroma.ColorSelectListener;

public class MainActivity extends AppCompatActivity {

//    RecyclerView pe list bnani h...100 80 60 20 0;
//    Shared prefrences p save karna h...

    private List<ColorPickerListItem> colorList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ColorPickerAdapter colorPickerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRec);

        colorPickerAdapter = new ColorPickerAdapter(colorList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                final View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null){

                    //child.setBackgroundColor(Color.CYAN);

                    int position = rv.getChildAdapterPosition(child);

                    Toast.makeText(MainActivity.this, "touch", Toast.LENGTH_SHORT).show();
                    ColorPickerListItem item = colorList.get(position);
                    new ChromaDialog.Builder()
                            .initialColor(Color.GRAY)
                            .colorMode(ColorMode.RGB)
                            .onColorSelected(new ColorSelectListener() {
                                @Override public void onColorSelected(int color) {
                                    child.setBackgroundColor(color);
                                }
                            })
                            .create()
                            .show(getSupportFragmentManager(), "dialog");
                }


                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        recyclerView.setAdapter(colorPickerAdapter);

        prepareColorPicker();

    }

    private void prepareColorPicker() {

        ColorPickerListItem item;

        item = new ColorPickerListItem("100%", "#AAAAAA");
        colorList.add(item);

        item = new ColorPickerListItem("80%", "#AAAAAA");
        colorList.add(item);

        item = new ColorPickerListItem("60%", "#AAAAAA");
        colorList.add(item);

        item = new ColorPickerListItem("40%", "#AAAAAA");
        colorList.add(item);

        item = new ColorPickerListItem("20%", "#AAAAAA");
        colorList.add(item);

        item = new ColorPickerListItem("0%", "#AAAAAA");
        colorList.add(item);

    }

}
