package com.gussoft.controlles;

import java.io.File;
import java.nio.file.Files;

public class ReadBytes {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\LENOVO\\Desktop\\musicafalsa.mp3");
        try{
            String tipoExt = Files.probeContentType(file.toPath());
            System.out.println("El tipo de archivo es : " + tipoExt);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
