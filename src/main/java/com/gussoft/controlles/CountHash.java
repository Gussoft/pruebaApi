package com.gussoft.controlles;

import com.gussoft.utils.DynamoUtil;

public class CountHash {

    public static void main(String[] args) {
        DynamoUtil dyno = new DynamoUtil();
        long count = dyno.getCount();
        System.out.println("Hasta la fecha de Ayer ud. va " + count + " Documentos Firmados!");
        long num = dyno.getCountNow();
        System.out.println("Hasta la fecha de hoy ud. va " + num + " Documentos Firmados!");
        //long hoy = num - count;
        //System.out.println("documentos firmados hoy : " + hoy);
    }
}
