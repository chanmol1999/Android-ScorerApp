package com.example.anmol.courtcounter.SaveResults;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ResultRepository {
    private ResultDao resultDao;
    private LiveData<List<Result>> allResults;

    public ResultRepository(Application application){
        ResultDatabase database = ResultDatabase.getInstance(application);
        resultDao = database.resultDao();
        allResults = resultDao.getAllResults();
    }

    public void insert(Result result){
        new InsertResultAsyncTask(resultDao).execute(result);
    }

    public void delete(Result result){
        new DeleteResultAsyncTask(resultDao).execute(result);
    }
    public void deleteAllResults(){
        new DeleteAllResultsAsyncTask(resultDao).execute();
    }

    public LiveData<List<Result>> getAllResults(){
        return allResults;
    }

    private static class InsertResultAsyncTask extends AsyncTask<Result,Void,Void>{

        private ResultDao resultDao;

        public InsertResultAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
            resultDao.insert(results[0]);
            return null;
        }
    }

    private static class DeleteResultAsyncTask extends AsyncTask<Result,Void,Void>{

        private ResultDao resultDao;

        public DeleteResultAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Result... results) {
            resultDao.delete(results[0]);
            return null;
        }
    }

    private static class DeleteAllResultsAsyncTask extends AsyncTask<Void,Void,Void>{

        private ResultDao resultDao;

        public DeleteAllResultsAsyncTask(ResultDao resultDao) {
            this.resultDao = resultDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            resultDao.deleteAllResults();
            return null;
        }
    }
}
