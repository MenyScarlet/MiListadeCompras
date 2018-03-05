package com.example.melania.milistadecompras;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Melania on 04/03/2018.
 */

public class AArticulo implements Parcelable {

    String nombre;
    String marca;
    String mercado;
    String categoria;
    double precio;
    boolean articulo;

    //CREATOR
    public static final Parcelable.Creator<AArticulo> CREATOR = new
            Parcelable.Creator<AArticulo>() {
                public AArticulo createFromParcel(Parcel in) {
                    return new AArticulo(in);
                }
                public AArticulo[] newArray(int size) {
                    return new AArticulo[size];
                }
            };

    //Constructor vacio
    public AArticulo() {
    }

    //Constructor


    public AArticulo(String nombre, String marca, String mercado, String categoria, double precio,
                     boolean articulo) {
        this.nombre = nombre;
        this.marca = marca;
        this.mercado = mercado;
        this.categoria = categoria;
        this.precio = precio;
        this.articulo = articulo;
    }

    //Constructor recibiendo parametros
    public AArticulo(Parcel p) {
        //Llamamos al metodo readFromParcel() y le pasamos el parcelable.
        readFromParcel(p);
    }


    //Getters and Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isArticulo() {
        return articulo;
    }

    public void setArticulo(boolean articulo) {
        this.articulo = articulo;
    }

    //Implementar metodo parceable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.nombre);
        parcel.writeString(this.marca);
        parcel.writeString(this.mercado);
        parcel.writeString(this.categoria);
        parcel.writeDouble(this.precio);

    }

    //Creamos un metodo readFromParcel que usaremos para llamarlo en el
    //constructor parcelable
    private void readFromParcel(Parcel p) {

        this.nombre = p.readString();
        this.marca = p.readString();
        this.mercado = p.readString();
        this.categoria = p.readString();
        this.precio = p.readDouble();



    }
}
