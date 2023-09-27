/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.io.Serializable;

/**
 *
 * @author HPPERSONAL
 */
public class Avion implements Serializable
{
    private int clave;
    private int asientos;
    private String compania;
    private String marca;

    public Avion()
    {
    }

    public Avion(int clave, int asientos, String compania, String marca)
    {
        this.clave = clave;
        this.asientos = asientos;
        this.compania = compania;
        this.marca = marca;
    }

    /**
     * @return the clave
     */
    public int getClave()
    {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(int clave)
    {
        this.clave = clave;
    }

    /**
     * @return the asientos
     */
    public int getAsientos()
    {
        return asientos;
    }

    /**
     * @param asientos the asientos to set
     */
    public void setAsientos(int asientos)
    {
        this.asientos = asientos;
    }

    /**
     * @return the compania
     */
    public String getCompania()
    {
        return compania;
    }

    /**
     * @param compania the compania to set
     */
    public void setCompania(String compania)
    {
        this.compania = compania;
    }

    /**
     * @return the marca
     */
    public String getMarca()
    {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String despSinSaltos(){
        return +clave+      "            "+
               compania+"         "+
               marca+      "            "+   
               asientos+"         ";
    }

}
