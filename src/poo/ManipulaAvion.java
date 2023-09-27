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
public class ManipulaAvion
{

    private Avion arr[] = null;

    public ManipulaAvion()
    {
    }

    /**
     * @return the arr
     */
    public Avion[] getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(Avion[] arr)
    {
        this.arr = arr;
    }

    public int tamanio()
    {
        if (arr == null)
        {
            return 0;
        } else
        {
            return arr.length;
        }
    }

    public void inserta(Avion a)
    {
        if (arr == null)
        {
            arr = new Avion[1];
            arr[0] = a;
        } else
        {
            Avion nvo[] = new Avion[arr.length + 1];
            System.arraycopy(arr, 0, nvo, 0, arr.length);
            nvo[arr.length] = a;
            arr = nvo;
        }
    }

    public void inserta(Avion[] a)
    {
        arr = a;
    }

    public Avion elimina(int p)
    {
        if (p != -1)
        {
            if (p >= 0 && arr != null)
            {
                Avion a = arr[p];
                if (p == 0 && arr.length == 1)
                {
                    arr = null;
                    System.out.println("Dato eliminado con exito... ");
                } else
                {
                    Avion nvo[] = new Avion[arr.length - 1];
                    int j = 0;
                    for (int i = 0; i < arr.length; i++)
                    {
                        if (p != i)
                        {
                            nvo[j++] = arr[i];
                        }
                    }
                    arr = nvo;
                    System.out.println("Dato eliminado con exito... ");
                }
                return a;
            } else
            {
                System.out.println("Posicion incorrecta o no hay datos en el arreglo ");
                return null;
            }

        } else
        {
            return null;
        }
    }

    public int busca(int cla)
    {
        if (arr == null)
        {
            return -1;
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].getClave() == cla)
                {
                    return i;
                }
            }
            System.out.println("Dato no encontrado ");
            return -1;
        }
    }

    public String buscaDetalles(int posicion)
    {
        if (posicion >= 0)
        {
            if (arr == null)
            {
                return "No hay aviones ";
            } else
            {
                System.out.println("Clave      Compañia     Marca       Asientos");
                return arr[posicion].despSinSaltos();
            }
        } else
        {
            return "El registro no existe. ";
        }

    }

    public void desp()
    {
        if (arr == null)
        {
            System.out.println("No hay datos en el arreglo que desplegar");
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                System.out.println("Clave      Compañia      Marca      Asientos");
                System.out.println(arr[i].despSinSaltos());

            }
        }
    }

    public void despAvD()
    {
        ManipulaRutas ruta = new ManipulaRutas();
        if (arr == null)
        {
            System.out.println("No hay datos en el arreglo que desplegar");
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                int x = arr[i].getClave();
                if ((ruta.buscaAv(x)) == -1)
                {
                    System.out.println("Clave     Compañia       Marca      Asientos");
                    System.out.println(arr[i].despSinSaltos());
                } else
                {

                }
            }
        }
    }

    public Avion[] avionesAsociadosARutas(Rutas rutas)
    {
        if (rutas == null)
        {
            System.out.println("No hay rutas. ");
            return null;
        } else
        {
            Avion[] devolver= new Avion[0];
            
                for (int j = 0; j < arr.length; j++)
                {
                    if (rutas.getClaveAvion()== arr[j].getClave())
                    {
                        Avion[] nvo= new Avion[devolver.length+1];
                        System.arraycopy(devolver, 0, nvo, 0, devolver.length);
                        nvo[nvo.length]= arr[j];
                        devolver= nvo;
                        
                    }
                }

            return devolver;
        }

    }

    public Avion[] guardar()
    {
        return arr;
    }

}
