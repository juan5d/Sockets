
/**
 *
 * @author Usuario
 */
public class iniciarCliente {
    
    public static Sockets sockets,usuario;//static las podemos tener en todo el programa
   public static void main(String[]arg){
        
        Cliente cliente = new Cliente();
        cliente.main();
    }
    

     public static void IniciarC(String ip){
         usuario = new Sockets(ip);
         usuario.start();
     }
}