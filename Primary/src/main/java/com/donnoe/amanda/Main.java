/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.donnoe.amanda;
import com.donnoe.amanda.structures.ClassFile;
import java.io.*;
/**
 *
 * @author joshuadonnoe
 */
public class Main {

    public static void main(String[] args) {
        ClassFile cF = new ClassFile("target/classes/com/donnoe/amanda/Main.class");
        try {
            cF.read();
        } catch (IOException x) {
            throw new AssertionError(x);
        }
        System.out.println(cF);
    }
}
