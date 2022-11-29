package com.gsr.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Sudoku board;
    ArrayList<TextView> textViewsGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textViewsGrid = new ArrayList<>();

        initialize();
    }

    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), v.getId() + " clicked", Toast.LENGTH_SHORT).show();
    }

    public void initialize() {
        board = new Sudoku();
        board.createSeed();
        board.genPuzzle();

        textViewsGrid.add(findViewById(R.id.text_view_1_1));
        textViewsGrid.add(findViewById(R.id.text_view_1_2));
        textViewsGrid.add(findViewById(R.id.text_view_1_3));
        textViewsGrid.add(findViewById(R.id.text_view_1_4));
        textViewsGrid.add(findViewById(R.id.text_view_1_5));
        textViewsGrid.add(findViewById(R.id.text_view_1_6));
        textViewsGrid.add(findViewById(R.id.text_view_1_7));
        textViewsGrid.add(findViewById(R.id.text_view_1_8));
        textViewsGrid.add(findViewById(R.id.text_view_1_9));
        textViewsGrid.add(findViewById(R.id.text_view_2_1));
        textViewsGrid.add(findViewById(R.id.text_view_2_2));
        textViewsGrid.add(findViewById(R.id.text_view_2_3));
        textViewsGrid.add(findViewById(R.id.text_view_2_4));
        textViewsGrid.add(findViewById(R.id.text_view_2_5));
        textViewsGrid.add(findViewById(R.id.text_view_2_6));
        textViewsGrid.add(findViewById(R.id.text_view_2_7));
        textViewsGrid.add(findViewById(R.id.text_view_2_8));
        textViewsGrid.add(findViewById(R.id.text_view_2_9));
        textViewsGrid.add(findViewById(R.id.text_view_3_1));
        textViewsGrid.add(findViewById(R.id.text_view_3_2));
        textViewsGrid.add(findViewById(R.id.text_view_3_3));
        textViewsGrid.add(findViewById(R.id.text_view_3_4));
        textViewsGrid.add(findViewById(R.id.text_view_3_5));
        textViewsGrid.add(findViewById(R.id.text_view_3_6));
        textViewsGrid.add(findViewById(R.id.text_view_3_7));
        textViewsGrid.add(findViewById(R.id.text_view_3_8));
        textViewsGrid.add(findViewById(R.id.text_view_3_9));
        textViewsGrid.add(findViewById(R.id.text_view_4_1));
        textViewsGrid.add(findViewById(R.id.text_view_4_2));
        textViewsGrid.add(findViewById(R.id.text_view_4_3));
        textViewsGrid.add(findViewById(R.id.text_view_4_4));
        textViewsGrid.add(findViewById(R.id.text_view_4_5));
        textViewsGrid.add(findViewById(R.id.text_view_4_6));
        textViewsGrid.add(findViewById(R.id.text_view_4_7));
        textViewsGrid.add(findViewById(R.id.text_view_4_8));
        textViewsGrid.add(findViewById(R.id.text_view_4_9));
        textViewsGrid.add(findViewById(R.id.text_view_5_1));
        textViewsGrid.add(findViewById(R.id.text_view_5_2));
        textViewsGrid.add(findViewById(R.id.text_view_5_3));
        textViewsGrid.add(findViewById(R.id.text_view_5_4));
        textViewsGrid.add(findViewById(R.id.text_view_5_5));
        textViewsGrid.add(findViewById(R.id.text_view_5_6));
        textViewsGrid.add(findViewById(R.id.text_view_5_7));
        textViewsGrid.add(findViewById(R.id.text_view_5_8));
        textViewsGrid.add(findViewById(R.id.text_view_5_9));
        textViewsGrid.add(findViewById(R.id.text_view_6_1));
        textViewsGrid.add(findViewById(R.id.text_view_6_2));
        textViewsGrid.add(findViewById(R.id.text_view_6_3));
        textViewsGrid.add(findViewById(R.id.text_view_6_4));
        textViewsGrid.add(findViewById(R.id.text_view_6_5));
        textViewsGrid.add(findViewById(R.id.text_view_6_6));
        textViewsGrid.add(findViewById(R.id.text_view_6_7));
        textViewsGrid.add(findViewById(R.id.text_view_6_8));
        textViewsGrid.add(findViewById(R.id.text_view_6_9));
        textViewsGrid.add(findViewById(R.id.text_view_7_1));
        textViewsGrid.add(findViewById(R.id.text_view_7_2));
        textViewsGrid.add(findViewById(R.id.text_view_7_3));
        textViewsGrid.add(findViewById(R.id.text_view_7_4));
        textViewsGrid.add(findViewById(R.id.text_view_7_5));
        textViewsGrid.add(findViewById(R.id.text_view_7_6));
        textViewsGrid.add(findViewById(R.id.text_view_7_7));
        textViewsGrid.add(findViewById(R.id.text_view_7_8));
        textViewsGrid.add(findViewById(R.id.text_view_7_9));
        textViewsGrid.add(findViewById(R.id.text_view_8_1));
        textViewsGrid.add(findViewById(R.id.text_view_8_2));
        textViewsGrid.add(findViewById(R.id.text_view_8_3));
        textViewsGrid.add(findViewById(R.id.text_view_8_4));
        textViewsGrid.add(findViewById(R.id.text_view_8_5));
        textViewsGrid.add(findViewById(R.id.text_view_8_6));
        textViewsGrid.add(findViewById(R.id.text_view_8_7));
        textViewsGrid.add(findViewById(R.id.text_view_8_8));
        textViewsGrid.add(findViewById(R.id.text_view_8_9));
        textViewsGrid.add(findViewById(R.id.text_view_9_1));
        textViewsGrid.add(findViewById(R.id.text_view_9_2));
        textViewsGrid.add(findViewById(R.id.text_view_9_3));
        textViewsGrid.add(findViewById(R.id.text_view_9_4));
        textViewsGrid.add(findViewById(R.id.text_view_9_5));
        textViewsGrid.add(findViewById(R.id.text_view_9_6));
        textViewsGrid.add(findViewById(R.id.text_view_9_7));
        textViewsGrid.add(findViewById(R.id.text_view_9_8));
        textViewsGrid.add(findViewById(R.id.text_view_9_9));

        for (int i = 0; i < textViewsGrid.size(); i++) {
            int row = i / 9;
            int col = i % 9;
            Log.i("RC", row + " " + col);
            textViewsGrid.get(i).setText(Integer.toString(board.getGrid()[row][col]));
        }
    }

}