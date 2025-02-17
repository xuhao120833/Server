package com.htc.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class AidlTestService extends Service {

    private String hello;

    private Map<Integer,People> peopleMap;
    private static String TAG = "AidlTestService";


    @Override
    public void onCreate() {
        super.onCreate();
        hello = "hello xu";
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.d(TAG, "basicTypes: \nanInt = "+anInt
                    +"\naLong = "+aLong
                    +"\naBoolean = "+aBoolean
                    +"\naFloat = "+aFloat
                    +"\naDouble = "+aDouble
                    +"\naString = "+aString
            );
        }

        @Override
        public String getString() throws RemoteException {
            return hello;
        }

        @Override
        public void setString(String string) throws RemoteException {
            hello = string;
        }

        @Override
        public void addPeople(People people) throws RemoteException {
            Log.d(TAG, "addPeople: "+people);
            if(peopleMap == null){
                peopleMap = new HashMap<>();
            }
            peopleMap.put(people.getId(), people);
        }

        @Override
        public People getPeople(int id) throws RemoteException {
            if(peopleMap != null){
                People people = peopleMap.get(id);
                Log.d(TAG, id + " -> getPeople: "+people);
                return people;
            }
            Log.d(TAG, id + " -> getPeople: null");
            return null;
        }

    }
}