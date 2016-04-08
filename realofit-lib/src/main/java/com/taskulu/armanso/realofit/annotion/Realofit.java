package com.taskulu.armanso.realofit.annotion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for realize "Realm" object
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Realofit {
    Class value();
}
