package com.openwudi.apiguide.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.openwudi.apiguide.IMyAidlInterface;

/**
 * Created by wudi on 15/7/8.
 */
public class AIDLService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private final IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int count(int x, int y) throws RemoteException {
            return x + y;
        }
    };
}
