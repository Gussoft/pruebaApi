package com.gussoft.controlles;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Scanner;

public class demo implements RequestHandler<Request, String> {

    @Override
    public String handleRequest(Request request, Context context) {
        Response response = new Response();
        if(request.getSaludo().equals("welcome")){
            response.setEscucha("Welcome to the secret shop!");
        }else{
            response.setEscucha("No te saludo!");
        }

        return response.getEscucha();
    }

/*
    public static String paralelo(Request request, Context context){
        Response response = new Response();
        if(request.getSaludo().equals("welcome")){
            response.setEscucha("Welcome to the secret shop!");
        }else{
            response.setEscucha("No te saludo!");
        }
        return response.getEscucha();
    }*/
    public static void main(String[] args) {
       /* Request request = new Request();
        request.setSaludo("");
        String response = paralelo(request, null);
        System.out.println(response);
        //int matriz2[][] = new int[3][3];ab
        //String contra = "abc123";// pon tu scaner
        Scanner enrada = new Scanner(System.in);
        String contra = enrada.nextLine();
        String [][] matriz = {{"z","b","c","1","2","0"},{"a","b","3","1","2","c"},{"a","b","c","1","2","3"},
                {"a","b","c","3","2","1"},{"1","b","c","a","2","3"},{"a","2","c","1","b","3"}};
        StringBuffer cadena = new StringBuffer();
        String newc="";
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                System.out.println (matriz[x][y]);
                newc = String.valueOf(cadena.append(matriz[x][y]));
            }
            if(newc.equals(contra)){
                System.out.println("pass encontrada " +  newc);
                break;
            }else{
                System.out.println("Pass Incorrecto " + newc);
            }
            cadena.setLength(0);
            newc ="";
        }
       /*
        String[] pass = {"a","b","c","1","2","3"};

        for (int x=0;x<pass.length;x++){
            cadena = cadena.append(pass[x]);
        }
        System.out.println(cadena);
        String newc = String.valueOf(cadena);
        if(newc.equals(contra)){
            //hacer lo que deba hacer si se cumple

        }*/
    }


}
