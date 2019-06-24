package com.update.hookams.hook;

import java.lang.reflect.Proxy;

/**
 * @author : liupu
 * date   : 2019/6/21
 * desc   :
 */
public class HookHelper {
    public static void hookActivityManager() {
        try {

            Object gDefault = RefInvoke.getStaticFieldObject("android.app.ActivityManagerNative", "gDefault");

            Object rawIActivityManager = RefInvoke.getFieldObject("android.util.Singleton", gDefault, "mInstance");

            Class<?> iActivityManagerInterface = Class.forName("android.app.IActivityManager");

            Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{iActivityManagerInterface}, new HookHandler(rawIActivityManager));

            RefInvoke.setFieldObject("android.util.Singleton", gDefault, "mInstance", proxy);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Hook Failed", e);
        }
    }
}
