package com.gmail.ptimofejev;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;

public class Main {

    @Target(value= ElementType.TYPE)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface SaveToFile {
        String path();
    }

    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface SaverService{}

    public static void main(String[] args) {
        TextContainer tc1 = new TextContainer("This text was written for saving to file purposes");
        try {
            System.out.println(Saver.saveToFile(tc1));
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
