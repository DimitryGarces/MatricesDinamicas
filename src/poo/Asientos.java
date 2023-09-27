package poo;

import java.io.Serializable;

public class Asientos implements Serializable
{
    
    ManipulaBoletos manipulaBoletos = new ManipulaBoletos();
    ManipulaRutas manipulaRutas = new ManipulaRutas();
    
    private String matriz[][] = null;
    
    public Asientos()
    {
    }

    /**
     * @return the matriz
     */
    public String[][] getMatriz()
    {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(String[][] matriz)
    {
        this.matriz = matriz;
    }
    
    public void inserta(Avion a)
    {
        if (matriz == null)
        {
            matriz = new String[1][a.getAsientos()];
            
            for (int j = 0; j < a.getAsientos(); j++)
            {
                matriz[0][j] = " ";
            }
            
        } else
        {
            
            String[][] nvo;
            nvo = new String[matriz.length + 1][];
            nvo[matriz.length] = new String[a.getAsientos()];
            for (int f = 0; f < nvo.length - 1; f++)
            {
                int elementos = matriz[f].length;
                nvo[f] = new String[elementos];
            }
            
            for (int i = 0; i < matriz.length; i++)
            {
                for (int j = 0; j < matriz[i].length; j++)
                {
                    nvo[i][j] = matriz[i][j];
                }
            }
            
            for (int i = matriz.length; i < matriz.length + 1; i++)
            {
                for (int j = 0; j < nvo[i].length; j++)
                {
                    nvo[i][j] = " ";
                }
            }
            matriz = nvo;
            
        }
        
    }
    
    
    public void elimina(int posAvion)
    {
        
        if (matriz == null)
        {
            
        } else
        {
            if (matriz.length == 1 && posAvion == 0)
            {
                matriz = null;
                System.out.println("Asientos del avion eliminados con exito ");
            } else
            {
                String[][] nvo = new String[matriz.length - 1][];
                int cont = 0;
                for (int f = 0; f < matriz.length; f++)
                {
                    if (f != posAvion)
                    {
                        int elementos = matriz[f].length;
                        nvo[cont] = new String[elementos];
                        cont++;
                    }
                    
                }
                int filaInsertar = 0;
                
                for (int i = 0; i < matriz.length; i++)
                {
                    if (i != posAvion)
                    {
                        for (int j = 0; j < matriz[i].length; j++)
                        {
                            nvo[filaInsertar][j] = matriz[i][j];
                            
                        }
                        filaInsertar++;
                    }
                }
                matriz = nvo;
            }
            
            System.out.println("Asientos del avion eliminados con exito ");
            
        }
        
    }
    
    public void modifica(int posAvion, int nuevosAsientos)
    {
        
        if (matriz == null)
        {
            
        } else
        {
            String[][] nvo = new String[matriz.length][];
            int cont = 0;
            for (int f = 0; f < matriz.length; f++)
            {
                if (f != posAvion)
                {
                    int elementos = matriz[f].length;
                    nvo[cont] = new String[elementos];
                    cont++;
                } else
                {
                    int elementos = nuevosAsientos;
                    nvo[cont] = new String[elementos];
                    cont++;
                }
                
            }
            
            for (int i = 0; i < matriz.length; i++)
            {
                if (i != posAvion)
                {
                    
                    for (int j = 0; j < nvo[i].length; j++)
                    {
                        
                        nvo[i][j] = matriz[i][j];
                    }                    
                }
            }
            matriz = nvo;
            
        }
        
        System.out.println("Asientos del avion modificados con exito. ");
        
    }
    
    public void inserta(String[][] ma)
    {
        matriz = ma;
    }
    
    public String[][] guarda()
    {
        return matriz;
    }
    
    public void desp()
    {
        if (matriz == null)
        {
            System.out.println("No hay datos para desplegar ");
        } else
        {
            System.out.println("\n\n\n\n\n");
            for (int i = 0; i < matriz.length; i++)
            {
                System.out.println("****** Asientos del avion [" + i + "] ****** ");
                for (int j = 0; j < matriz[i].length; j++)
                {
                    System.out.print(matriz[i][j] + "\t");
                    
                }
                System.out.println("");
            }
        }
        
    }
    
    public int busca(Boletos[] boletos, int posAvion, String asiento)
    {
        if (matriz == null)
        {
            return -1;
        } else
        {
            for (int i = 0; i < boletos.length; i++)
            {
                if (boletos[i].getNumeroAsiento().equals(asiento))
                {
                    return i;
                }
                
            }
            
        }
        return -1;
    }
    public int validarElAsiento(int posAvion, String asiento)
    {
        if (matriz == null)
        {
            return -1;
        } else
        {
            for (int i = 0; i < matriz[posAvion].length; i++)
            {
                if (matriz[posAvion][i].equals(asiento))
                {
                    return i;
                }
                
            }
            
        }
        return -1;
    }
    
    public void despDisponibles(int posAvion, Boletos[] boletos, int posRuta)
    {
        if (boletos == null)
        {
            System.out.println("No hay boletos comprados aun, todos los asientos estan disponibles");
            for (int i = 0; i < matriz[posAvion].length; i++)
            {
                System.out.print("- \t" + matriz[posAvion][i] + "\t ");
            }
            System.out.println("");
        } else
        {
            if (matriz == null)
            {
                System.out.println("No hay datos para desplegar ");
            } else
            {
                int cont = 0;
                System.out.println("\n\n\n\n\n");
                System.out.println("****** Asientos disponibles del avion en la posición [" + posAvion  + "] ****** ");
                for (int i = 0; i < matriz[posAvion].length; i++)
                {
                    if (busca(boletos, posAvion, matriz[posAvion][i]) == -1)
                    {
                        cont = 1;
                        System.out.print("- \t" + matriz[posAvion][i] + "\t ");
                    } else
                    {
                        
                    }
                }
                if (cont == 0)
                {
                    System.out.println("\nUpps parece ser que no hay asientos disponibles:( \nIngrese cualquier numero o letra para salir");
                } else
                {
                    System.out.println("\nIngrese el asiento deseado, este definira la ubicacion en el avion: ");
                }
                System.out.println("");
            }
        }
        
    }
    
    public String asignar(int numAsientos, int nuevoOmodificar)
    {
        int x = 0;
        if (numAsientos <= 50)
        {
            x = numAsientos / 3;
        } else if (numAsientos <= 250)
        {
            x = numAsientos / 7;
        } else
        {
            x = numAsientos / 11;
        }
        
        if (nuevoOmodificar == -1)
        {
            int cont = 0, fila = 1;
            if (x == 0)
            {
                fila = 0;
            }
            for (int i = 0; i < matriz[matriz.length - 1].length; i++)
            {
                if (cont != x)
                {
                    matriz[matriz.length - 1][i] = asignarLetras(cont + 1, fila);
                } else
                {
                    cont = 0;
                    fila++;
                    matriz[matriz.length - 1][i] = asignarLetras(cont + 1, fila);
                }
                cont++;
            }
            fila = 1;
            return null;
        } else
        {
            int cont = 0, fila = 1;
            if (x == 0)
            {
                fila = 0;
            }
            for (int i = 0; i < matriz[nuevoOmodificar].length; i++)
            {
                if (cont != x)
                {
                    matriz[nuevoOmodificar][i] = asignarLetras(cont + 1, fila);
                } else
                {
                    cont = 0;
                    fila++;
                    matriz[nuevoOmodificar][i] = asignarLetras(cont + 1, fila);
                }
                cont++;
                
            }
        }
        return null;
    }
    
    public String asignarLetras(int asiento, int fila)
    {
        int x = 0;
        String asientoConLetra = Integer.toString(asiento);
        int opc = fila;
        switch (opc)
        {
            case 1:
                asientoConLetra = asientoConLetra + "A";
                break;
            case 2:
                asientoConLetra = asientoConLetra + "B";
                break;
            case 3:
                asientoConLetra = asientoConLetra + "C";
                break;
            case 4:
                asientoConLetra = asientoConLetra + "D";
                break;
            case 5:
                asientoConLetra = asientoConLetra + "E";
                break;
            case 6:
                asientoConLetra = asientoConLetra + "F";
                break;
            case 7:
                asientoConLetra = asientoConLetra + "G";
                break;
            case 8:
                asientoConLetra = asientoConLetra + "H";
                break;
            case 9:
                asientoConLetra = asientoConLetra + "I";
                break;
            case 10:
                asientoConLetra = asientoConLetra + "J";
                break;
            case 11:
                asientoConLetra = asientoConLetra + "K";
                break;
            case 12:
                asientoConLetra = asientoConLetra + "L";
                break;
            default:
                System.out.println("Uppss, algo a salido mal :( ");
        }
        
        return asientoConLetra;
    }
    
}
