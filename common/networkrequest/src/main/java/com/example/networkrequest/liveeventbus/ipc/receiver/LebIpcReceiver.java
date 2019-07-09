package com.example.networkrequest.liveeventbus.ipc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.networkrequest.liveeventbus.LiveEventBus;
import com.example.networkrequest.liveeventbus.ipc.IpcConst;
import com.example.networkrequest.liveeventbus.ipc.decode.DecodeException;
import com.example.networkrequest.liveeventbus.ipc.decode.IDecoder;
import com.example.networkrequest.liveeventbus.ipc.decode.ValueDecoder;

/**
 * Created by liaohailiang on 2019/3/26.
 */
public class LebIpcReceiver extends BroadcastReceiver {

    private IDecoder decoder = new ValueDecoder();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (IpcConst.ACTION.equals(intent.getAction())) {
            String key = intent.getStringExtra(IpcConst.KEY);
            try {
                Object value = decoder.decode(intent);
                if (key != null) {
                    LiveEventBus
                            .get()
                            .with(key)
                            .post(value);
                }
            } catch (DecodeException e) {
                e.printStackTrace();
            }
        }
    }
}
