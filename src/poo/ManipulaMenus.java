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
public class ManipulaMenus
{
    public static int pintaMenus(String s, String [] mnu){
        System.out.println("==== "+ s +" ======" );
        for (int i = 0; i < mnu.length; i++)
        {
            System.out.println((i+1)+ ".- "+ mnu[i]);
        }
        System.out.println("Elije una opcion ");
        return Lecturas.Entero();
    }
}
