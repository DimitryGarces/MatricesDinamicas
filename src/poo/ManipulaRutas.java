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
public class ManipulaRutas implements Serializable
{

    public static final long serialVersionUID = 1L;

    private Rutas arr[] = null;

    public ManipulaRutas()
    {
    }

    /**
     * @return the arr
     */
    public Rutas[] getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(Rutas[] arr)
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

    public void inserta(Rutas a)
    {
        if (arr == null)
        {
            arr = new Rutas[1];
            arr[0] = a;
        } else
        {
            Rutas nvo[] = new Rutas[arr.length + 1];
            System.arraycopy(arr, 0, nvo, 0, arr.length);
            nvo[arr.length] = a;
            arr = nvo;
        }
    }

    public void inserta(Rutas[] a)
    {
        arr = a;
    }

    public Rutas elimina(int p)
    {
        if (p != -1)
        {
            if (p >= 0 && arr != null)
            {
                Rutas a = arr[p];
                if (p == 0 && arr.length == 1)
                {
                    arr = null;
                    System.out.println("Dato eliminado con exito... ");
                } else
                {
                    Rutas nvo[] = new Rutas[arr.length - 1];
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

    public int busca(String cla)
    {
        if (arr == null)
        {
            return -1;
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].getClave().equals(cla))
                {
                    return i;
                }
            }
            System.out.println("Dato no encontrado.");
            return -1;
        }
    }

    public int buscaPos(String cla)
    {

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].getClave().equals(cla))
            {
                return i;
            }
        }
        return -1;

    }

    public int buscaAv(int cla)
    {
        if (arr == null)
        {
            return -1;
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].getClaveAvion() == cla)
                {
                    return i;
                }
            }
            return -1;
        }
    }

    public int buscaRutas(String co, String cd)
    {
        if (arr == null)
        {
            return -1;
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].getCdOrigen().equals(co) && arr[i].getCdDestino().equals(cd))
                {
                    return i;
                }
            }
            System.out.println("Dato no encontrado ");
            return -1;
        }
    }

    public void reOrdenaPosAvion(Avion[] aviones)
    {
        if (arr == null)
        {

        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                for (int j = 0; j < aviones.length; j++)
                {
                    if (arr[i].getClaveAvion() == (aviones[j].getClave()))
                    {
                        arr[i].setPosAvion(j);
                    }
                }

            }

        }
    }

    public void desp()
    {
        if (arr == null)
        {
            System.out.println("No hay datos que desplegar");
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                System.out.println("Clave   Ciudad de origen   Ciudad de destino   Hora de salida   Clave del avion   Posicion del avion");
                System.out.println(arr[i].despSinSalto());

            }
        }
    }

    public Rutas[] guardar()
    {
        return arr;
    }

    public int posicionAvion(int po)
    {
        if (arr == null)
        {
            return -1;
        } else
        {
            return arr[po].getPosAvion();
        }

    }

    public void asientos()
    {
        Object a;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - i; j++)
            {
                int comp1 = (arr[j].getCdOrigen().charAt(0));
                int comp2 = (arr[j + 1].getCdOrigen().charAt(0));
                if (comp1 > comp2)
                {
                    a = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = (Rutas) a;
                }
            }
        }
    }

    public Rutas[] rutasAsociadas(Avion avion)
    {
        if (arr == null)
        {
            return null;
        } else
        {
            Rutas[] rutas = new Rutas[0];
            for (int i = 0; i < 10; i++)
            {
                if (arr[i].getClaveAvion() == avion.getClave())
                {
                    Rutas[] nvo = new Rutas[rutas.length+1];
                    System.arraycopy(rutas, 0, nvo, 0, rutas.length);
                    nvo[rutas.length]= arr[i];
                    rutas= nvo;

                }
            }
            return rutas;
        }

    }

    public String buscarDetalles(int p)
    {
        if (p >= 0)
        {
            if (arr == null)
            {
                return "No hay datos para desplegar";
            } else
            {
                System.out.println("Clave      Ciudad de origen      Ciudad de destino       Hora de salida        Clave del Avion    Posicion del avion");
                return arr[p].despSinSalto();
            }
        } else
        {
            return "El registro no existe.";
        }

    }
    

}
