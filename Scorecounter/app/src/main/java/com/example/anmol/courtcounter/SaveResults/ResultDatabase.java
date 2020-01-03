package com.example.anmol.courtcounter.SaveResults;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Result.class, version = 1)
public abstract class ResultDatabase extends RoomDatabase {

    private static ResultDatabase instance;

    public abstract ResultDao resultDao();

    public static ResultDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),ResultDatabase.class,"result_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static ResultDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    } ;

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private ResultDao resultDao;

        public PopulateDbAsyncTask(ResultDatabase db) {
            resultDao = db.resultDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
