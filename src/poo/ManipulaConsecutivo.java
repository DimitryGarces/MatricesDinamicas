/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author HPPERSONAL
 */
public class ManipulaConsecutivo
{
    private int arr =0;

    public ManipulaConsecutivo()
    {
    }

    /**
     * @return the arr
     */
    public int getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(int arr)
    {
        this.arr = arr;
    }
    
    public int tamanio(){
        
            return arr;
        
    }
    
    public void inserta(){
        arr=arr+1;
    }
    public void insertaI(int a){
        arr=a;
    }
    public String permisoConCeros(int no)
    {
        String noS = Integer.toString(no);
        while(noS.length()<4)
        {
            noS = "0" + noS;
        }
        return noS;
    }
    public int guardar(){
        return arr;
    }
}
