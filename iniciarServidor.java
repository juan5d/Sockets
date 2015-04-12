/**
 *
 * @author Usuario
 */
public class iniciarServidor {
        public static ConectorS sockets,usuario;//static las podemos tener en todo el programa
    public static void main(String[]arg){
        
        Servidor servidor = new Servidor();
        servidor.main();
    }
    
     public static void IniciarS(){
        sockets = new ConectorS();
        sockets.start();
    }
}