/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donnoe.amanda.structures;
import java.io.*;
/**
 *
 * @author joshuadonnoe
 */
public class ClassFile extends Structure {
    
    public DataInputStream dIS;
    
    public ClassFile(String fileName) {
        try {
            dIS = new DataInputStream(new FileInputStream(fileName));
        } catch (FileNotFoundException x) {
            throw new AssertionError(x);
        }
    }
}