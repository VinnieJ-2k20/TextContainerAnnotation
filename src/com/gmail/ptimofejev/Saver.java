package com.gmail.ptimofejev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Saver {

    public static boolean saveToFile(TextContainer container) throws InvocationTargetException, IllegalAccessException {
        if (container.getClass().isAnnotationPresent(Main.SaveToFile.class)) {
            Method[] methods = container.getClass().getDeclaredMethods();
            for (Method mthd : methods) {
                if (mthd.isAnnotationPresent(Main.SaverService.class)) {
                    Main.SaveToFile saver = container.getClass().getAnnotation(Main.SaveToFile.class);
                    mthd.invoke(container, saver.path());
                    return true;
                }
            }
        }
        return false;
    }
}
