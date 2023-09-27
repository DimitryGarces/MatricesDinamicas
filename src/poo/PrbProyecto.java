/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

/**
 *
 * @author Diego Garces Morales
 */
public class PrbProyecto
{

    public static void main(String[] args)
    {
        System.out.println("Proyecto Diego Garces Morales");
        ManipulaArchivos archivos = new ManipulaArchivos();
        Object arr1[], arr2[], arr3[];
        String matriz[][];
        Avion modificar = new Avion();
        arr1 = archivos.cargaArr("Aviones.dat");

        arr2 = archivos.cargaArr("Rutas.dat");

        arr3 = archivos.cargaArr("Boletos.dat");

        matriz = archivos.cargaMatriz("Asientos.dat");

        String mnu1[] =
        {
            "Rutas", "Boletos", "Aviones", "Salir"
        };
        String mnu2[] =
        {
            "Altas", "Bajas", "Consultas", "Modificar", "Regresar"
        };
        String mnu3[] =
        {
            "Venta", "Cancelación", "Consultas", "Regresar"
        };

        ManipulaAvion manipulaAvion = new ManipulaAvion();
        ManipulaRutas manipulaRutas = new ManipulaRutas();
        ManipulaBoletos manipulaBoletos = new ManipulaBoletos();
        ManipulaConsecutivo manipulaConsecutivo = new ManipulaConsecutivo();
        Asientos asientos = new Asientos();

        manipulaAvion.setArr((Avion[]) arr1);
        manipulaRutas.setArr((Rutas[]) arr2);
        manipulaBoletos.setArr((Boletos[]) arr3);
        asientos.setMatriz((String[][]) matriz);

        int opc = 0;
        do
        {
            opc = ManipulaMenus.pintaMenus("Menu principal", mnu1);
            switch (opc)
            {
                case 1:
                    System.out.println("Elegiste...");
                    opc = 0;
                    do
                    {
                        opc = ManipulaMenus.pintaMenus("Menu Rutas", mnu2);
                        switch (opc)
                        {
                            case 1:
                                arr1 = manipulaAvion.getArr();
                                arr2 = manipulaRutas.getArr();
                                if (arr1 == null && arr2 == null)
                                {
                                    System.out.println("Aun no se han registrado datos");
                                } else
                                {

                                    System.out.println("Dame la clave de la ruta: ");
                                    String x = Lecturas.Cadena();
                                    if (manipulaRutas.busca(x) == -1)
                                    {
                                        System.out.println("Dame la ciudad de origen: ");
                                        String y = Lecturas.Cadena();
                                        System.out.println("Dame la ciudad de destino: ");
                                        String z = Lecturas.Cadena();
                                        System.out.println("Dame la hora de salida: ");
                                        String i = Lecturas.Cadena();
                                        int b;
                                        System.out.println("********** Claves de aviones disponibles ********");
                                        for (int j = 0; j < arr1.length; j++)
                                        {
                                            if (manipulaRutas.buscaAv(((Avion) arr1[j]).getClave()) == -1)
                                            {
                                                System.out.print("\t - \t" + ((Avion) arr1[j]).getClave());
                                            }
                                        }
                                        System.out.println("\nDame la clave del avion: ");
                                        int u = Lecturas.Entero(true);
                                        if (manipulaAvion.busca(u) != -1 && manipulaRutas.buscaAv(u) == -1)
                                        {
                                            b = manipulaAvion.busca(u);
                                            Rutas ruta = new Rutas(x, y, z, i, u, b);
                                            manipulaRutas.inserta(ruta);
                                        } else
                                        {
                                            System.out.println("La clave del avion no es valida posiblemente no exista o\n"
                                                    + "el avion seleccionado ya este asociado a otra ruta.");
                                        }
                                    } else
                                    {
                                        System.out.println("La clave de la ruta ya existe, ingrese otra. ");
                                    }
                                }
                          
                                break;
                            case 2:
                                if (manipulaRutas.tamanio() == 0)
                                {
                                    System.out.println("No puedes dar de baja una ruta ya que aun no existen. ");
                                } else
                                {
                                    manipulaRutas.desp();
                                    arr3 = manipulaBoletos.getArr();
                                    System.out.println("Dame la clave de la ruta que quieres dar de baja: ");
                                    String x = Lecturas.Cadena();
                                    int validar = 0;
                                    for (int i = 0; i < arr3.length; i++)
                                    {
                                        if (((Boletos) arr3[i]).getClaveRuta().equals(x))
                                        {
                                            validar = 1;
                                        }
                                    }
                                    if (validar != 1)
                                    {
                                        if (manipulaRutas.busca(x) != -1)
                                        {
                                            manipulaRutas.elimina(manipulaRutas.busca(x));

                                            arr2 = manipulaRutas.getArr();

                                            manipulaBoletos.reOrdenaPosRutas(((Rutas[]) arr2));
                                        } else
                                        {
                                            System.out.println("La clave no existe ");
                                        }

                                    } else
                                    {
                                        System.out.println("No puedes eliminar esta ruta, ya que tiene boletos asociados a ella.");
                                    }

                                }
//                                      manipulaBoletos.boletosAsociados("1");

                                break;
                            case 3:
                                if (manipulaRutas.tamanio() != 0)
                                {
                                    arr2 = manipulaRutas.getArr();
                                    for (int v = 0; v < arr2.length; v++)
                                    {
                                        if (arr2[v] instanceof Rutas)
                                        {
                                            System.out.println("Clave       Ciudad de origen        Ciudad de destino       Hora de salida      Clave del avion         Posicion del avion");
                                            System.out.println(((Rutas) arr2[v]).despSinSalto());
                                        } else
                                        {
                                            System.out.println(arr2[v]);
                                        }
                                    }
                                    int opcion;
                                    do
                                    {
                                        System.out.println("Deseas ver el detalle de alguna ruta?\n1.-Si\n2.-No");
                                        opcion = Lecturas.Entero(true);
                                    } while (opcion < 0 || opcion > 2);

                                    if (opcion == 1)
                                    {
                                        System.out.println("\n¿De qué ruta desea ver el detalle? Ingrese su clave");
                                        String r = Lecturas.Cadena();
                                        int bus = manipulaRutas.busca(r);
                                        if (bus != -1)
                                        {
                                            System.out.println(manipulaAvion.buscaDetalles(((Rutas) arr2[bus]).getPosAvion()));
                                        } else
                                        {
                                            System.out.println("La clave ingresada no es valida, intentelo de nuevo mas tarde. ");
                                        }

                                    }
                                } else
                                {
                                    System.out.println("No se puede desplegar nada, no hay datos.");
                                }

                                break;
                            case 4:
                                if (manipulaRutas.tamanio() == 0)
                                {
                                    System.out.println("Aun no se puede modificar nada ya que no existen rutas.");
                                } else
                                {
                                    arr2 = manipulaRutas.getArr();
                                    arr1 = manipulaAvion.getArr();
                                    manipulaRutas.desp();
                                    System.out.println("Dame la clave de la ruta que deseas modificar: ");
                                    String x = Lecturas.Cadena();
                                    int m = manipulaRutas.busca(x);
                                    if (m != -1)
                                    {
                                        System.out.println("Dame la nueva ciudad de origen: ");
                                        String y = Lecturas.Cadena();
                                        System.out.println("Dame la nueva ciudad de destino: ");
                                        String z = Lecturas.Cadena();
                                        System.out.println("Dame la nueva hora de salida: ");
                                        String i = Lecturas.Cadena();
                                        int b;
                                        System.out.println("********** Claves de aviones disponibles ********");
                                        for (int j = 0; j < arr1.length; j++)
                                        {
                                            if (manipulaRutas.buscaAv(((Avion) arr1[j]).getClave()) == -1)
                                            {
                                                System.out.println(((Avion) arr1[j]).getClave());
                                            }
                                        }
                                        System.out.println("Dame la nueva clave del avion: ");
                                        int u = Lecturas.Entero(true);
                                        if (manipulaAvion.busca(u) != -1 && manipulaRutas.buscaAv(u) == -1)
                                        {
                                            b = manipulaAvion.busca(u);
                                            ((Rutas) arr2[m]).setCdOrigen(y);
                                            ((Rutas) arr2[m]).setCdDestino(z);
                                            ((Rutas) arr2[m]).setHoraSalida(i);
                                            ((Rutas) arr2[m]).setClaveAvion(u);
                                            ((Rutas) arr2[m]).setPosAvion(b);
                                            manipulaRutas.inserta((Rutas[]) arr2);
                                            System.out.println("Dato modificado con exito.");
                                        } else
                                        {
                                            System.out.println("La clave del avion no es valida posiblemente no exista o\n"
                                                    + "el avion seleccionado ya este asociado a otra ruta.");
                                        }

                                    } else
                                    {
                                        System.out.println("No hay datos para modificar.");
                                    }

                                }

                                break;
                            case 5:

                                break;
                            default:
                                System.out.println("Error, opcion incorrecta. ");

                        }

                    } while (opc != mnu2.length);

                    break;
                case 2:
                    System.out.println("Elejiste... ");
                    opc = 0;
                    do
                    {
                        opc = ManipulaMenus.pintaMenus("Menu Boletos", mnu3);
                        switch (opc)
                        {
                            case 1:

                                arr3 = manipulaRutas.getArr();
                                if (arr3 == null)
                                {
                                    System.out.println("No podemos venderle un boleto ya que no hay rutas disponibles. ");
                                } else
                                {
                                    manipulaRutas.desp();
                                    System.out.println("Escriba la clave de la ruta a la que comprara el boleto ");
                                    String clave = Lecturas.Cadena();
                                    int b = manipulaRutas.busca(clave);

                                    if (b != -1)
                                    {
                                        arr2 = manipulaBoletos.guardarBoletosAvion(b);
                                        System.out.println("Ingrese su nombre: ");
                                        String n = Lecturas.Cadena();
                                        int posAvion = ((Rutas) arr3[b]).getPosAvion();
                                        asientos.despDisponibles(posAvion, ((Boletos[]) arr2), b);
                                        int pos = ((Rutas) arr3[b]).getPosAvion();
                                        String a = Lecturas.Cadena();
                                        if (arr2 == null)
                                        {
                                            if (asientos.validarElAsiento(posAvion, a) > 0)
                                            {
                                                String c = ((Rutas) arr3[b]).getClave();
                                                Boletos boleto = new Boletos(n, a, c, b);
                                                manipulaBoletos.inserta(boleto);
                                                System.out.println("Pago procesado.");
                                            } else
                                            {
                                                System.out.println("Seguramente el asiento ingresado no exista, intentelo de nuevo mas tarde. ");
                                            }

                                        } else
                                        {
                                            if ((asientos.busca(((Boletos[]) arr2), pos, a)) == -1)
                                            {
                                                if (asientos.validarElAsiento(posAvion, a) > 0)
                                                {
                                                    String c = ((Rutas) arr3[b]).getClave();
                                                    Boletos boleto = new Boletos(n, a, c, b);
                                                    manipulaBoletos.inserta(boleto);
                                                    System.out.println("Pago procesado.");
                                                } else
                                                {
                                                    System.out.println("Seguramente el asiento ingresado no exista, intentelo de nuevo mas tarde. ");
                                                }

                                            } else
                                            {
                                                System.out.println("El asiento seleccionado no existe, o ya a sido vendido.");
                                            }
                                        }

                                    } else
                                    {
                                        System.out.println("Error la ruta que ha ingresado no existe.");
                                    }
                                }

                                break;
                            case 2:

                                if (manipulaBoletos.tamanio() == 0)
                                {
                                    System.out.println("No puedes dar de baja un boleto ,nadie a comprado uno, aun. ");
                                } else
                                {
                                    manipulaBoletos.desp();
                                    System.out.println("Dame el folio del boleto que deseas dar de baja: ");
                                    String fo = Lecturas.Cadena();
                                    if (manipulaBoletos.busca(fo) != -1)
                                    {

                                        manipulaBoletos.elimina(manipulaBoletos.busca(fo));

                                    } else
                                    {
                                        System.out.println("El folio ingresado no existe ");
                                    }
                                }

                                break;
                            case 3:
                                arr3 = manipulaBoletos.getArr();

                                if (arr3 != null)
                                {
                                    for (int v = 0; v < arr3.length; v++)
                                    {
                                        if (arr3[v] instanceof Boletos)
                                        {
                                            System.out.println("Consecutivo        Folio           Nombre          Numero de asiento      Clave de la ruta         Posicion de la ruta");
                                            System.out.println(((Boletos) arr3[v]).despSinSaltos());
                                        } else
                                        {
                                            System.out.println(arr3[v]);
                                        }
                                    }
                                    int opcion;
                                    do
                                    {
                                        System.out.println("Deseas ver el detalle de algun boleto?\n1.-Si\n2.-No");
                                        opcion = Lecturas.Entero(true);
                                    } while (opcion < 0 || opcion > 2);
                                    if (opcion == 1)
                                    {
                                        System.out.println("\n¿De qué boleto desea ver el detalle? Ingrese su folio");
                                        String r = Lecturas.Cadena();
                                        int bus = manipulaBoletos.busca(r);
                                        if (bus != -1)
                                        {
                                            System.out.println(manipulaRutas.buscarDetalles(((Boletos) arr3[bus]).getPosRuta()));
                                        } else
                                        {
                                            System.out.println("No existe ese folio, intentelo de nuevo mas tarde. ");
                                        }

                                    }
                                } else
                                {
                                    System.out.println("No se puede desplegar nada, no hay datos.");
                                }
                                break;
                            case 4:

                                break;

                            default:
                                System.out.println("Error, opcion incorrecta.");

                        }
                    } while (opc != mnu3.length);
                    opc = 0;
                    break;
                case 3:
                    System.out.println("Elegiste... ");
                    opc = 0;
                    do
                    {
                        opc = ManipulaMenus.pintaMenus("Menu Aviones", mnu2);
                        switch (opc)
                        {
                            case 1:
                                System.out.println("Dame la clave del avion: ");
                                int x = Lecturas.Entero(true);
                                if (manipulaAvion.busca(x) == -1)
                                {
                                    System.out.println("Dame la compañia del avion: ");
                                    String y = Lecturas.Cadena();
                                    System.out.println("Dame la marca del avion: ");
                                    String z = Lecturas.Cadena();
                                    System.out.println("Considere que no existen aun aviones con más de 538 asientos \no sin asientos ya que esto podria ser peligroso ");

                                    int cont;
                                    do
                                    {
                                        System.out.println("Dame los asientos del avion: ");
                                        int i = Lecturas.Entero(true);
                                        cont = i;
                                    } while (cont < 1 || cont > 538);

                                    Avion avion = new Avion(x, cont, z, y);
                                    manipulaAvion.inserta(avion);
                                    asientos.inserta(avion);
                                    asientos.asignar(cont, -1);
                                } else
                                {
                                    System.out.println("La clave del avion ya existe, intente con otra.");
                                }

                                break;
                            case 2:
                                if (manipulaAvion.tamanio() == 0)
                                {
                                    System.out.println("No hay aviones para dar de baja ya que aun no se han registrado. ");
                                } else
                                {
                                    manipulaAvion.desp();
                                    System.out.println("Dame la clave del avion al cual quieres dar de baja ");
                                    x = Lecturas.Entero(true);

                                    int busqueda = manipulaAvion.busca(x);
                                    if (busqueda != -1 && manipulaRutas.buscaAv(x) == -1)
                                    {
                                        manipulaAvion.elimina(busqueda);
                                        asientos.elimina(busqueda);
                                        arr1 = manipulaAvion.getArr();
                                        manipulaRutas.reOrdenaPosAvion((Avion[]) arr1);
                                    } else
                                    {
                                        System.out.println("El avion seleccionado posiblemente este asociado a una ruta o simplemente no exista");
                                    }
                                }
                                asientos.desp();

                                break;
                            case 3:
                                arr1 = manipulaAvion.getArr();
                                if (arr1 != null)
                                {
                                    for (int v = 0; v < arr1.length; v++)
                                    {
                                        if (arr1[v] instanceof Avion)
                                        {
                                            System.out.println("Clave     Compañia       Marca       Asientos");
                                            System.out.println(((Avion) arr1[v]).despSinSaltos());
                                        } else
                                        {
                                            System.out.println(arr1[v]);
                                        }
                                    }

                                } else
                                {
                                    System.out.println("No se puede desplegar nada, no hay datos.");
                                }
                                break;
                            case 4:
                                arr1 = manipulaAvion.getArr();
                                if (arr1 == null)
                                {
                                    System.out.println("No hay nada para modificar ya que aun no se han registrado aviones. ");
                                } else
                                {
                                    System.out.println("\t\t***** Claves de Aviones disponibles *****");
                                    for (int i = 0; i < arr1.length; i++)
                                    {
                                        System.out.print("- \t" + ((Avion) arr1[i]).getClave() + " \t");
                                    }
                                    System.out.println("\nDame la clave del avion que deseas modificar ");
                                    x = Lecturas.Entero(true);
                                    int m = manipulaAvion.busca(x);
                                    if (m != -1)
                                    {
                                        System.out.println("\nDame el nuevo nombre de la compañia: ");
                                        String y = Lecturas.Cadena();
                                        System.out.println("Dame la nueva marca: ");
                                        String z = Lecturas.Cadena();
                                        int cont;
                                        System.out.println("Considere que el numero de asientos no puede pasar de los 538 ya que esto podria ser peligroso");
                                        do
                                        {
                                            System.out.println("Dame el nuevo numero de asientos: ");
                                            int i = Lecturas.Entero(true);
                                            cont = i;
                                        } while (cont < 1 || cont > 538);

                                        ((Avion) arr1[m]).setCompania(y);
                                        ((Avion) arr1[m]).setMarca(z);
                                        ((Avion) arr1[m]).setAsientos(cont);
                                        asientos.modifica(m, cont);
                                        asientos.asignar(cont, m);
                                        manipulaAvion.inserta((Avion[]) arr1);
                                        System.out.println("Dato modificado con exito  ");
                                    } else
                                    {
                                        System.out.println("\nLa clave ingresada seguramente no exista ");
                                    }
                                }

                                break;
                            case 5:

                                break;
                            default:
                                System.out.println("Error, opcion incorrecta... ");

                        }
                    } while (opc != mnu2.length);

                    break;
                case 4:
                    Rutas newDato1[] = manipulaRutas.guardar();
                    archivos.guarda("Rutas.dat", newDato1);
                    Avion newDato2[] = manipulaAvion.guardar();
                    archivos.guarda("Aviones.dat", newDato2);
                    Boletos newDato3[] = manipulaBoletos.guardar();
                    archivos.guarda("Boletos.dat", newDato3);
                    String newDato4[][] = asientos.guarda();
                    archivos.guarda("Asientos.dat", newDato4);
                    System.out.println("Elegiste salir");

                    break;
                default:
                    System.out.println("Opcion incorrecta ");
            }

        } while (opc != mnu1.length);
    }

}
