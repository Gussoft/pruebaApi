package com.gussoft.controlles;

public class MargenY {
    public static void main(String[] args) {
//si firma.getY - tag.getY < 3
        boolean setear = false;
        boolean firmas = false;
        System.out.println("Welcome to the Jungle!");
        String coordY = "380";
        String coordX = "287";
        String firmaY = "382";
        String firmaX = "287";

        Boolean posY = evaluarY(Integer.parseInt(coordY), Integer.parseInt(firmaY));
        Boolean posX = evaluarY(Integer.parseInt(coordX), Integer.parseInt(firmaX));
        if (posX) {
            if (posY) {
                firmas = false;
            }
        }//si firma.getY - tag.getY < 3
        if (posX && posY) {

            setear = true;
            System.out.println("Occupied Position: setear = true");
            //break;
        } else {
            if (!firmas) {
                System.out.println("firmar " + coordX + " and " + coordY + " firmar = true");
                firmas = true;
            }

        }
    }

    private static Boolean evaluarY(int coordY, int firmaY) {
        int mayor = coordY;
        int menor = firmaY;
        if (mayor < firmaY) {
            mayor= firmaY;
            menor = coordY;
        }
        if (mayor - menor < 3){
            return true;
        }
        System.out.println(mayor + ","+ menor);
        return false;
    }
}
/*  if (vl.getVisY().equals(coordFromTextparts[1])) {
                        if(vl.getVisX().equals(coordFromTextparts[0])){
                            firmas = false; // habilita la firma hasta encontrar el tag correcto
                        }
                    }//si firma.getY - tag.getY < 3
                    if (vl.getVisX().equals(coordFromTextparts[0]) && vl.getVisY().equals(coordFromTextparts[1])) {
                        System.out.println("Posicion Ocupada:: " + vl.getVisX() + "=" + coordFromTextparts[0] + " " +
                                vl.getVisY() + "=" + coordFromTextparts[1]);
                        setear = true;
                        break;
                    } else */
