package com.gsr.sudoku;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Sudoku board;
    ArrayList<TextView> textViewsGrid;
    TextView selectedTextView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.selectedTextView = null;
        this.textViewsGrid = new ArrayList<>();

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

        initialize();
    }

    public void onClick(View v) {
        TextView clickedTextView = findViewById(v.getId());
        if (clickedTextView.isClickable()){
            if (this.selectedTextView != null){
                this.selectedTextView.setBackgroundColor(0x00FFFFFF);
            }
            this.selectedTextView = clickedTextView;
            this.selectedTextView.setBackgroundColor(getResources().getColor(R.color.highlight));
        }
    }

    public void numberClick(View v){
        if (this.selectedTextView == null) {
            Toast.makeText(getApplicationContext(),  "please select a position on the board", Toast.LENGTH_SHORT).show();
            return;
        }
        Button button = findViewById(v.getId());
        this.selectedTextView.setText(button.getText());
        this.selectedTextView.setBackgroundColor(0x00FFFFFF);
        this.selectedTextView = null;
//        Toast.makeText(getApplicationContext(), button.getText() + " clicked", Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void resetBoard(View v){
        board.reset();
        board.createGame();
        for (int i = 0; i < board.getGridSize()*board.getGridSize(); i++) {
            textViewsGrid.get(i).setText(" ");
            textViewsGrid.get(i).setClickable(true);
            textViewsGrid.get(i).setTextAppearance(R.style.normal);
        }
        for (int i = 0; i < board.getGridSize()*board.getGridSize(); i++) {
            int row = i / board.getGridSize();
            int col = i % board.getGridSize();
            if (board.getGrid()[row][col] != 0) {
                textViewsGrid.get(i).setText(String.valueOf(board.getGrid()[row][col]));
                textViewsGrid.get(i).setTextAppearance(R.style.bold);
                textViewsGrid.get(i).setClickable(false);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void initialize() {
        board = new Sudoku(9);
        board.createGame();
        for (int i = 0; i < board.getGridSize()*board.getGridSize(); i++) {
            int row = i / board.getGridSize();
            int col = i % board.getGridSize();
            if (board.getGrid()[row][col] != 0) {
                textViewsGrid.get(i).setTextAppearance(R.style.bold);
                textViewsGrid.get(i).setText(String.valueOf(board.getGrid()[row][col]));
                textViewsGrid.get(i).setClickable(false);
            }
        }
    }

}