package com.gussoft.controlles;

public class paginacion {
    public static void main(String[] args) {
        int maxPage = 9;
        int page = 4;
        int paginaInicio = page;
        int cantidadpaginas = 5;
        int next = page + cantidadpaginas;
        for (int i = paginaInicio; i <= next; i++){
            if ((i+cantidadpaginas) < maxPage){
                if(i > maxPage) {
                    break;
                }
            }else{
            //if(i > maxPage){
                break;
            }
            System.out.println(i);
        }
    }
}
