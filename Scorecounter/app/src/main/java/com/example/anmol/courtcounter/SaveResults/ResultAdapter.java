package com.example.anmol.courtcounter.SaveResults;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anmol.courtcounter.R;

import java.util.ArrayList;
import java.util.List;

public class ResultAdapter extends ListAdapter<Result, ResultAdapter.ResultHolder> {


    public ResultAdapter() {
        super(DIFF_CALLBACK);
    }

    public static final DiffUtil.ItemCallback<Result> DIFF_CALLBACK = new DiffUtil.ItemCallback<Result>() {
        @Override
        public boolean areItemsTheSame(@NonNull Result oldItem, @NonNull Result newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Result oldItem, @NonNull Result newItem) {
            return  oldItem.getTitle().equals(newItem.getTitle()) &&
                    oldItem.getOutcome().equals(newItem.getOutcome()) &&
                    oldItem.getScoreOne().equals(newItem.getScoreOne())&&
                    oldItem.getScoreTwo().equals(newItem.getScoreTwo())&&
                    oldItem.getScoreThree().equals(newItem.getScoreThree())&&
                    oldItem.getScoreFour().equals(newItem.getScoreFour())&&
                    oldItem.getScoreFive().equals(newItem.getScoreFive())
                    ;
        }
    };

    class ResultHolder extends RecyclerView.ViewHolder{

        private TextView textView_title;
        private TextView textView_outcome;
        private TextView textView_scoreOne;
        private TextView textView_scoreTwo;
        private TextView textView_scoreThree;
        private TextView textView_scoreFour;
        private TextView textView_scoreFive;


        public ResultHolder(@NonNull View itemView) {
            super(itemView);

            textView_title = itemView.findViewById(R.id.text_view_title);
           textView_outcome = itemView.findViewById(R.id.text_view_outcome);
           textView_scoreOne = itemView.findViewById(R.id.text_view_scoreOne);
           textView_scoreTwo = itemView.findViewById(R.id.text_view_scoreTwo);
           textView_scoreThree = itemView.findViewById(R.id.text_view_scoreThree);
           textView_scoreFour = itemView.findViewById(R.id.text_view_scoreFour);
           textView_scoreFive = itemView.findViewById(R.id.text_view_scoreFive);

        }
    }

    @NonNull
    @Override
    public ResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.result_item,parent, false);
        return new ResultHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultHolder holder, int position) {

        Result currentResult = getItem(position);
        holder.textView_title.setText(currentResult.getTitle());
        holder.textView_outcome.setText(currentResult.getOutcome());
        holder.textView_scoreOne.setText(currentResult.getScoreOne());
        holder.textView_scoreTwo.setText(currentResult.getScoreTwo());
        holder.textView_scoreThree.setText(currentResult.getScoreThree());
        holder.textView_scoreFour.setText(currentResult.getScoreFour());
        holder.textView_scoreFive.setText(currentResult.getScoreFive());
    }

    public Result getResultPosition(int position){

        return getItem(position);
    }
}
