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
public class Rutas implements Serializable 
{
    private String clave;
    private String cdOrigen;
    private String cdDestino;
    private String horaSalida;
    private int claveAvion;
    private int posAvion;

    public Rutas()
    {
    }

    public Rutas(String clave, String cdOrigen, String cdDestino, String horaSalida, int claveAvion, int posAvion)
    {
        this.clave = clave;
        this.cdOrigen = cdOrigen;
        this.cdDestino = cdDestino;
        this.horaSalida = horaSalida;
        this.claveAvion = claveAvion;
        this.posAvion= posAvion;
    }

    /**
     * @return the clave
     */
    public String getClave()
    {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave)
    {
        this.clave = clave;
    }

    /**
     * @return the cdOrigen
     */
    public String getCdOrigen()
    {
        return cdOrigen;
    }

    /**
     * @param cdOrigen the cdOrigen to set
     */
    public void setCdOrigen(String cdOrigen)
    {
        this.cdOrigen = cdOrigen;
    }

    /**
     * @return the cdDestino
     */
    public String getCdDestino()
    {
        return cdDestino;
    }

    /**
     * @param cdDestino the cdDestino to set
     */
    public void setCdDestino(String cdDestino)
    {
        this.cdDestino = cdDestino;
    }

    /**
     * @return the horaSalida
     */
    public String getHoraSalida()
    {
        return horaSalida;
    }

    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(String horaSalida)
    {
        this.horaSalida = horaSalida;
    }

    /**
     * @return the claveAvion
     */
    public int getClaveAvion()
    {
        return claveAvion;
    }

    /**
     * @param claveAvion the claveAvion to set
     */
    public void setClaveAvion(int claveAvion)
    {
        this.claveAvion = claveAvion;
    }
    
    /**
     * @return the posAvion
     */
    public int getPosAvion()
    {
        return posAvion;
    }

    /**
     * @param posAvion the posAvion to set
     */
    public void setPosAvion(int posAvion)
    {
        this.posAvion = posAvion;
    }

    public String despSinSalto(){
        return clave+"         "+
         cdOrigen+"             "+
         cdDestino+"            "+
         horaSalida+"                     "+
         claveAvion+"                    "+
         posAvion+"\n";
        
    }

}
