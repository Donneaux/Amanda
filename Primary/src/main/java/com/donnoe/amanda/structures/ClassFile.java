/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.donnoe.amanda.structures;
import java.io.*;
import java.util.concurrent.*;
/**
 *
 * @author joshuadonnoe
 */
public class ClassFile extends Structure {
    
    public static ExecutorService eS = Executors.newCachedThreadPool();
    
    public Future<byte[]> bytesFuture;
    public Future<DataInputStream> dISFuture;
    
    public ClassFile(String fileName) {
        super(null);
        this.cF = this;
        bytesFuture = eS.submit(() -> new FileInputStream(fileName).readAllBytes());
    }
   
    public void read() throws IOException {
    }
    
    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("ClassFile");
        return sb.toString();
    }
}