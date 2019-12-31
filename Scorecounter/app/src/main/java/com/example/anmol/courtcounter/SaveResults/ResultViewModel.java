package com.example.anmol.courtcounter.SaveResults;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ResultViewModel extends AndroidViewModel {

    private ResultRepository resultRepository;
    private LiveData<List<Result>> allResults;

    public ResultViewModel(@NonNull Application application) {
        super(application);
        resultRepository = new ResultRepository(application);
        allResults = resultRepository.getAllResults();
    }

    public void insert(Result result){
        resultRepository.insert(result);
    }

    public void delete(Result result){
        resultRepository.delete(result);
    }

    public void deleteAllResults(){
        resultRepository.deleteAllResults();
    }

    public LiveData<List<Result>> getAllResults(){
        return allResults;
    }
}
