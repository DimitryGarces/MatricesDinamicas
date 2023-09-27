/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author HPPERSONAL
 */
public class ManipulaArchivos <Tipo>
{
    public void guarda(String nomArch, Tipo obj){
        try
        {
            FileOutputStream ubicacion = new FileOutputStream(nomArch);
            ObjectOutputStream arch = new ObjectOutputStream(ubicacion);
            arch.writeObject(obj);
            arch.close();
        } catch (FileNotFoundException ex)
        {
            System.out.println("Error, no se encontró el archivo "+nomArch);
        }
        catch(Exception ex){
            System.out.println("Error "+ ex.toString());
        }
    }
    public void guarda(String nomArch, Tipo obj[]){
        try
        {
            FileOutputStream ubicacion = new FileOutputStream(nomArch);
            ObjectOutputStream arch = new ObjectOutputStream(ubicacion);
            arch.writeObject(obj);
            System.out.println("Registro guardado con exito en el archivo ["+nomArch+"] ");
            arch.close();
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Error, no se encontró el archivo ["+nomArch+"] ");
        }
        catch(Exception ex){
            System.out.println("Error "+ ex.toString());
        }
    }
    public static void guardaInt(String s,int o){
        try
        {
            FileOutputStream fis=new FileOutputStream(s);
            ObjectOutputStream arch=new ObjectOutputStream(fis);
            arch.writeInt(o);
            arch.close();
        } catch (Exception e)
        {
            System.out.println("Error " + e.toString());
        }
    }
    public static void guardaMatriz(String s,String o[][]){
        try
        {
            FileOutputStream fis=new FileOutputStream(s);
            ObjectOutputStream arch=new ObjectOutputStream(fis);
            arch.writeObject(o);
            arch.close();
        } catch (Exception e)
        {
            System.out.println("Error " + e.toString());
        }
    }
    public static int carga(String nomArch){
        int obj= 0;
        try
        {
            FileInputStream ubicacion = new FileInputStream(nomArch);
            ObjectInputStream arch = new ObjectInputStream(ubicacion);
            obj =(int)arch.readInt();
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Error no se encontro el archivo ");
        } catch (Exception ex)
        {
            System.out.println("Error "+ ex.toString());
        }
        return obj;
    }
    public Tipo[] cargaArr(String nomArch){
        Tipo obj[]= null;
        try
        {
            FileInputStream ubicacion = new FileInputStream(nomArch);
            ObjectInputStream arch = new ObjectInputStream(ubicacion);
            obj =(Tipo[])arch.readObject();
            System.out.println("Archivo cargado con exito ["+nomArch+"] ");
            
        } catch (FileNotFoundException ex)
        {
            System.out.println("Error no se encontro el archivo ["+nomArch+"] ");
        } catch (Exception ex)
        {
            System.out.println("Error no se a podido cargar el archivo ["+nomArch+"] "+ ex.toString());
        }
        return obj;
    }
    public String[][] cargaMatriz(String nomArch)
    {
        String obj[][]=null;
        try
        {
            FileInputStream ubicacion = new FileInputStream(nomArch);
            ObjectInputStream arch = new ObjectInputStream(ubicacion);
            obj = (String [][]) arch.readObject();
            arch.close();
        } catch (FileNotFoundException ex)
        {
           System.out.println("Error no se encontró el archivo["+nomArch+"]"+ex.toString());
        } catch(Exception ex)
        {
            System.out.println("Error no se a podido cargar el archivo"+ex.toString());
        }
        return obj;
    }
}
