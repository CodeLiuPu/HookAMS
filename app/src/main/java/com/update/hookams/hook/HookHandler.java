package com.update.hookams.hook;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author : liupu
 * date   : 2019/6/21
 * desc   :
 */
public class HookHandler implements InvocationHandler {

    private static final String TAG = "HookHandler";

    private Object mBase;

    public HookHandler(Object base) {
        this.mBase = base;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.e(TAG, "hook start");
        Log.e(TAG, "hook start method:" + method.getName() + " called with args:" + Arrays.toString(args));
        return method.invoke(mBase,args);
    }
}
