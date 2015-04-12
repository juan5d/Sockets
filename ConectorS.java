
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Juan David Zapata
 */
public class ConectorS extends Thread{
    /**
     * @param args the command line arguments
     */
    private Socket socket;
    private ServerSocket servidor;
    private InputStreamReader ESocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int p= 8000;
    
    
    
    public void run(){
        String texto="test";
        try{
           this.servidor = new ServerSocket(p);//creamos para que escuche el puerto
           this.socket = servidor.accept(); //generar la coneccion cuando un cliente inicia 
       
           this.ESocket = new InputStreamReader(socket.getInputStream()); //entrada
           this.entrada = new BufferedReader(ESocket);// leer los datos
           this.salida = new DataOutputStream(socket.getOutputStream());// salida de datos
       
       
        while(true){
            texto = this.entrada.readLine();
            System.out.println(texto);
            Servidor.jTextArea1.setText(Servidor.jTextArea1.getText()+"\n"+texto);
        }   
        }catch(IOException e){
                System.out.println("error");
        
        };
    }
    
        
    
    public void enviarMensaje(String mensaje){
        
        try{
             this.salida.writeUTF(mensaje+"\n");
        }catch(IOException e){
            System.out.println("problema al enviar");
        }
    }
    
    public String LeerMensaje(){
        try{
            return entrada.readLine();// lee la linea de texto que se envio
            
        }catch(IOException e){
        }
        return null;
    }
    
    
    public void desconectar(){
        try{
            socket.close();
        }catch(Exception e){
        }
        try{
            servidor.close();
        }catch(Exception e){
        }
        
    }
}