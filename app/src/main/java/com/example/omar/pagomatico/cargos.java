package com.example.omar.pagomatico;

/**
 * Created by OMAR on 12/04/2015.
 */
public class cargos {
    private String Producto="";
    private String Telefono="";
    private String Monto="";
    private String Semanas="";




    public String getSemanas()
    {
        return Semanas;
    }
    public void setSemanas(String Semanas) {this.Semanas=Semanas;}
    public String getProducto() {
        return Producto;
    }


    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }
}
