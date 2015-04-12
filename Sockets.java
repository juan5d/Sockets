
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
public class Sockets extends Thread{
    /**
     * @param args the command line arguments
     */
    private Socket socket;
    private ServerSocket servidor;
    private InputStreamReader ESocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int p= 8000;
    
    public Sockets(){
       try{
           servidor = new ServerSocket(p);//creamos para que escuche el puerto
           socket = servidor.accept(); //generar la coneccion cuando un cliente inicia 
       
           ESocket = new InputStreamReader(socket.getInputStream()); //entrada
           entrada = new BufferedReader(ESocket);// leer los datos
           salida = new DataOutputStream(socket.getOutputStream());// salida de datos
           
       }catch(Exception e){
           
       }
    }
    
    public void run(){
        String msj;
        while(true){
            try{
            msj = entrada.readLine();
            Cliente.AreaCliente.setText(Cliente.AreaCliente.getText()+"\n"+msj);
        }catch(IOException e){
        }
        }
    }
    
    public Sockets(String ip){
        try{
          
           socket = new Socket(ip,this.p);
       
           ESocket = new InputStreamReader(socket.getInputStream()); 
           entrada = new BufferedReader(ESocket);
           salida = new DataOutputStream(socket.getOutputStream());
           salida.writeUTF("Conectado- \n");
       }catch(Exception e){
           
       }
    }
    
    public void enviarMensaje(String mensaje){
       try{
            this.salida = new DataOutputStream(socket.getOutputStream());
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