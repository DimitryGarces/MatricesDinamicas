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
public class ManipulaBoletos
{

    private Boletos arr[] = null;

    ManipulaRutas manipulaRutas = new ManipulaRutas();

    public ManipulaBoletos()
    {
    }

    /**
     * @return the arr
     */
    public Boletos[] getArr()
    {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(Boletos[] arr)
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

    public void inserta(Boletos a)
    {
        if (arr == null)
        {
            arr = new Boletos[1];
            arr[0] = a;
        } else
        {
            Boletos nvo[] = new Boletos[arr.length + 1];
            System.arraycopy(arr, 0, nvo, 0, arr.length);
            nvo[arr.length] = a;
            arr = nvo;
        }
    }

    public void inserta(Boletos[] a)
    {
        arr = a;
    }

    public Boletos elimina(int p)
    {
        if (p != -1)
        {
            if (p >= 0 && arr != null)
            {
                Boletos a = arr[p];
                if (p == 0 && arr.length == 1)
                {
                    arr = null;
                    System.out.println("Boleto cancelado con exito... ");
                } else
                {
                    Boletos nvo[] = new Boletos[arr.length - 1];
                    int j = 0;
                    for (int i = 0; i < arr.length; i++)
                    {
                        if (p != i)
                        {
                            nvo[j++] = arr[i];
                        }
                    }
                    arr = nvo;
                    System.out.println("Boleto cancelado con exito... ");
                }
                return a;
            } else
            {
                System.out.println("El folio de boleto ingresado no existe  ");
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
                if (arr[i].getFolio().equals(cla))
                {
                    return i;
                }
            }
            System.out.println("Dato no encontrado ");
            return -1;
        }
    }

    public int buscaBoleto(Boletos boleto)
    {
        if (arr == null)
        {
            return -1;
        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].getFolio().equals(boleto.getFolio()))
                {
                    return i;
                }
            }
//            System.out.println("Dato no encontrado ");
            return -1;
        }
    }

    public void reOrdenaPosRutas(Rutas[] rutas)
    {
        if (arr == null)
        {

        } else
        {
            for (int i = 0; i < arr.length; i++)
            {
                for (int j = 0; j < rutas.length; j++)
                {
                    if (arr[i].getClaveRuta().equals(rutas[j].getClave()))
                    {
                        arr[i].setPosRuta(j);
                    }
                }

            }

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
                System.out.println("Consecutivo        Folio           Nombre          Numero de asiento      Clave de la ruta         Posicion de la ruta");
                System.out.println(arr[i].despSinSaltos());

            }
        }
    }

    public String permisoConCeros(int no)
    {
        String noS = Integer.toString(no);
        while (noS.length() < 4)
        {
            noS = "0" + noS;
        }
        return noS;
    }

    public Boletos[] guardar()
    {
        return arr;
    }

    public Boletos[] guardarBoletosAvion(int posRuta)
    {
        if (arr == null)
        {
            return null;
        } else
        {
            Boletos nvo[] = new Boletos[0];
            for (int i = 0; i < arr.length; i++)
            {
                if (posRuta == arr[i].getPosRuta())
                {
                    Boletos aux[] = new Boletos[nvo.length + 1];
                    System.arraycopy(nvo, 0, aux, 0, nvo.length);
                    aux[nvo.length] = arr[i];
                    nvo = aux;
                }
            }
            return nvo;
        }
    }

    public void boletosAsociados(String claveRuta)
    {
        if (arr == null)
        {
            System.out.println("No hay boletos ");;
        } else
        {
            System.out.println("Los aviones asociados a la ruta son: ");
            System.out.println("Consecutivo     Folio       Nombre      Numero de asiento       Clave de la ruta        Posicion de la ruta");
                
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].getClaveRuta().equals(claveRuta))
                {
                    System.out.println(arr[i].despSinSaltos());
                }

            }
            
        }

    }

    public void ordenaBoletos()
    {
        if (arr == null)
        {
            System.out.println("No hay boletos aun");
        } else
        {
            if (arr.length == 1)
            {
                System.out.println("Solo hay un boleto, no es necesario ordenar. ");
            } else
            {
                for (int i = 0; i < arr.length - 1; i++)
                {
                    for (int j = 0; j < arr.length - 1; j++)
                    {
                        if (arr[j].getClaveRuta().compareTo(arr[j + 1].getClaveRuta()) > 0)
                        {
                            Boletos aux = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = aux;
                        }

                    }
                }
            }

        }
    }

    public void boletosVendidosAvion(int claveAvion)
    {
        if (arr == null)
        {
            System.out.println("No hay boletos ");
        } else
        {
            Rutas[] rutas = manipulaRutas.getArr();
            String claRuta = "";
            if (rutas == null)
            {
                System.out.println("No hay rutas ");
            } else
            {
                for (int i = 0; i < arr.length; i++)
                {
                    if (rutas[i].getClaveAvion() == claveAvion)
                    {
                        claRuta = rutas[i].getClave();

                    }

                }
            }

            if (claRuta.equals(""))
            {
                System.out.println("No hay boletos asociados a ese avion");
            } else
            {
                Boletos[] boletosAsociados = new Boletos[0];
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i].getClaveRuta().equals(claRuta))
                    {
                        Boletos[] nvo = new Boletos[boletosAsociados.length + 1];
                        System.arraycopy(boletosAsociados, 0, nvo, 0, boletosAsociados.length);
                        nvo[boletosAsociados.length] = arr[i];
                        boletosAsociados = nvo;
                    }

                }
                System.out.println("Consecutivo     Folio       Nombre      Numero de asiento       Clave de la ruta        Posicion de la ruta");
               
                for (int i = 0; i < boletosAsociados.length; i++)
                {
                    System.out.println(boletosAsociados[i].despSinSaltos());

                }
            }

        }

    }

}
