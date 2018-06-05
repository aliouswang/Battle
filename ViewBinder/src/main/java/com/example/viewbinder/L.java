package com.example.viewbinder;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

/**
 * Created by aliouswang on 2018/6/5.
 */

public class L {

    public static void d(Messager messager, String message) {
        messager.printMessage(Diagnostic.Kind.NOTE, message);
    }

}
