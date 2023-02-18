/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donnoe.amanda.annotations;

/**
 *
 * @author joshuadonnoe
 */
import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
public @interface ConstantIndexer {
    public int value();
}