// IMyAidlInterface.aidl
package com.htc.server;

// Declare any non-default types here with import statements

import com.htc.server.People;

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    //上面这个是新建的时候自己生成的，可以去掉，我们自己新建以下方法，一个get(从服务端取值)，一个set(传值给服务端)
    String getString();

    void setString(String string);

    void addPeople(in People people);

    People getPeople(int id);
}