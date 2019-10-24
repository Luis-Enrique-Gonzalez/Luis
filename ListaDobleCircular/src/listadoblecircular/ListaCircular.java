
package listadoblecircular;

/**
 *
 * @author Luis
 */
public class ListaCircular {

    private Nodo inicio;
    private Nodo ultimo;
    private int tamaño;

    public void Lista() {
        this.inicio = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTamanio() {
        return tamaño;
    }

    public void agregarAlFinal(int valor) {

        Nodo nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            inicio = nuevo;

            ultimo = nuevo;

            ultimo.setSiguiente(inicio);

        } else {

            ultimo.setSiguiente(nuevo);

            nuevo.setSiguiente(inicio);

            ultimo = nuevo;
        }

        tamaño++;
    }

    public void agregarAlInicio(int valor) {

        Nodo nuevo = new Nodo();

        nuevo.setValor(valor);

        if (esVacia()) {

            inicio = nuevo;
            ultimo = nuevo;

            ultimo.setSiguiente(inicio);

        } else {

            nuevo.setSiguiente(inicio);

            inicio = nuevo;

            ultimo.setSiguiente(inicio);
        }

        tamaño++;
    }

    public void insertarPorReferencia(int referencia, int valor) {

        Nodo nuevo = new Nodo();

        nuevo.setValor(valor);

        if (!esVacia()) {

            if (buscar(referencia)) {

                Nodo aux = inicio;

                while (aux.getValor() != referencia) {
                    aux = aux.getSiguiente();
                }

                if (aux == ultimo) {

                    aux.setSiguiente(nuevo);

                    nuevo.setSiguiente(inicio);

                    ultimo = nuevo;
                } else {

                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(nuevo);

                    nuevo.setSiguiente(siguiente);
                }

                tamaño++;
            }
        }
    }

    public void insrtarPorPosicion(int posicion, int valor) {

        if (posicion >= 0 && posicion <= tamaño) {
            Nodo nuevo = new Nodo();
            nuevo.setValor(valor);

            if (posicion == 0) {

                nuevo.setSiguiente(inicio);

                inicio = nuevo;

                ultimo.setSiguiente(inicio);
            } else {

                if (posicion == tamaño) {

                    ultimo.setSiguiente(nuevo);

                    nuevo.setSiguiente(inicio);

                    ultimo = nuevo;
                } else {

                    Nodo aux = inicio;

                    for (int i = 0; i < (posicion - 1); i++) {
                        aux = aux.getSiguiente();
                    }

                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(nuevo);

                    nuevo.setSiguiente(siguiente);
                }
            }

            tamaño++;
        }
    }

    public int getValor(int posicion) throws Exception {

        if (posicion >= 0 && posicion < tamaño) {

            if (posicion == 0) {

                return inicio.getValor();
            } else {

                Nodo aux = inicio;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }

                return aux.getValor();
            }

        } else {
            throw new Exception("Posicion inexistente en la lista.");
        }
    }

    public boolean buscar(int referencia) {

        Nodo aux = inicio;

        boolean encontrado = false;

        do {

            if (referencia == aux.getValor()) {

                encontrado = true;
            } else {

                aux = aux.getSiguiente();
            }
        } while (aux != inicio && encontrado != true);

        return encontrado;
    }

    public int getPosicion(int referencia) throws Exception {

        if (buscar(referencia)) {

            Nodo aux = inicio;

            int cont = 0;

            while (referencia != aux.getValor()) {

                cont++;

                aux = aux.getSiguiente();
            }

            return cont;

        } else {
            throw new Exception("Valor inexistente en la lista.");
        }
    }

    public void editarPorReferencia(int referencia, int valor) {

        if (buscar(referencia)) {

            Nodo aux = inicio;

            while (aux.getValor() != referencia) {
                aux = aux.getSiguiente();
            }

            aux.setValor(valor);
        }
    }

    public void editarPorPosicion(int posicion, int valor) {

        if (posicion >= 0 && posicion < tamaño) {

            if (posicion == 0) {

                inicio.setValor(valor);
            } else {

                Nodo aux = inicio;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }

                aux.setValor(valor);
            }
        }
    }

    public void removerPorReferencia(int referencia) {

        if (buscar(referencia)) {

            if (inicio.getValor() == referencia) {

                inicio = inicio.getSiguiente();

                ultimo.setSiguiente(inicio);
            } else {

                Nodo aux = inicio;

                while (aux.getSiguiente().getValor() != referencia) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {

                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(siguiente.getSiguiente());

                }
            }

            tamaño--;
        }
    }

    public void removerPorPosicion(int posicion) {

        if (posicion >= 0 && posicion < tamaño) {

            if (posicion == 0) {

                inicio = inicio.getSiguiente();

                ultimo.setSiguiente(inicio);
            } else {

                Nodo aux = inicio;

                for (int i = 0; i < posicion - 1; i++) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {

                    Nodo siguiente = aux.getSiguiente();

                    aux.setSiguiente(siguiente.getSiguiente());

                }
            }

            tamaño--;
        }
    }

    public void eliminar() {

        inicio = null;

        ultimo = null;

        tamaño = 0;
    }

    public void listar() {

        if (!esVacia()) {

            Nodo aux = inicio;

            int i = 0;
            System.out.print("-> ");

            do {

                System.out.print(i + ".[ " + aux.getValor() + " ]" + " ->  ");

                aux = aux.getSiguiente();

                i++;
            } while (aux != inicio);
        }
    }
}
