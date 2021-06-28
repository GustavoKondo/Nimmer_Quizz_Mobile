package com.example.nimmer_quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nimmer_quizz.model.Quizzz;

import java.util.List;

public class QuizzList extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Quizzz> quizzs;
    private static String JSON_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz_list);
    }
}