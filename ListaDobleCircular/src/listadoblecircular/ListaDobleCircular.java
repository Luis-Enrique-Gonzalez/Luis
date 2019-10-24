
package listadoblecircular;

/**
 *
 * @author Luis
 */
public class ListaDobleCircular {

    public static void main(String[] args) {
        ListaCircular listaCircular = new ListaCircular();
        System.out.println("Lista circular simple");
        
        
        listaCircular.agregarAlFinal(5);
        listaCircular.agregarAlFinal(8);
        listaCircular.agregarAlFinal(20);
       
        listaCircular.agregarAlInicio(1);
        listaCircular.agregarAlInicio(3);
        
        System.out.println("Lista Circular");
        listaCircular.listar();
    }
    
}
