/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donnoe.amanda.structures;
import java.io.IOException;
/**
 *
 * @author joshuadonnoe
 */
public abstract class Structure {
    
    protected ClassFile cF;
    
    protected Structure(ClassFile cF) {
        this.cF = cF; 
    }
    
    public abstract void read() throws IOException;
}