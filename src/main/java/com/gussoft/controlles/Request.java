package com.gussoft.controlles;

public class Request {
    private String saludo;

    public Request() {
    }

    public Request(String saludo) {
        this.saludo = saludo;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}
