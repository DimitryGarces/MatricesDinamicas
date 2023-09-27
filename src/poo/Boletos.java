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
public class Boletos implements Serializable
{

    private static int consecutivo = 0;
  
    private String folio;
    private String nombre;
    private String numeroAsiento;
    private String claveRuta;
    private int posRuta;

    public Boletos()
    {

    }

    public Boletos(String nombre, String numeroAsiento, String claveRuta, int posRuta)
    {
        consecutivo = (int) ManipulaArchivos.carga("Consecutivo.dat");
        consecutivo++;
        String noS = Integer.toString(consecutivo);
        do{
            noS = "0" + noS;
        }
        while(noS.length()<4);
        this.folio = noS;
        this.nombre = nombre;
        this.numeroAsiento = numeroAsiento;
        this.claveRuta = claveRuta;
        this.posRuta= posRuta;
        ManipulaArchivos.guardaInt("Consecutivo.dat", consecutivo);
    }
    /**
     * @return the folio
     */
    public String getFolio()
    {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio)
    {
        this.folio = folio;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the numeroAsiento
     */
    public String getNumeroAsiento()
    {
        return numeroAsiento;
    }

    /**
     * @param numeroAsiento the numeroAsiento to set
     */
    public void setNumeroAsiento(String numeroAsiento)
    {
        this.numeroAsiento = numeroAsiento;
    }

    /**
     * @return the claveRuta
     */
    public String getClaveRuta()
    {
        return claveRuta;
    }

    /**
     * @param claveRuta the claveRuta to set
     */
    public void setClaveRuta(String claveRuta)
    {
        this.claveRuta = claveRuta;
    }
    /**
     * @return the posRuta
     */
    public int getPosRuta()
    {
        return posRuta;
    }

    /**
     * @param posRuta the posRuta to set
     */
    public void setPosRuta(int posRuta)
    {
        this.posRuta = posRuta;
    }

    public String despSinSaltos()
    {
        consecutivo = (int) ManipulaArchivos.carga("Consecutivo.dat");
        return consecutivo + "                   "
                 + folio + "             "
                + nombre + "                "
                 + numeroAsiento + "             "
                + claveRuta + "                       "
                +posRuta+ "                    ";
    }
}
