import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servidor
{
    /**
     * @todo Implementar InputStream y funcionamiento correcto del servidor, y pensar qué hacer si la lista llega vacía.
     * @params Una lista de números
     * @return El producto ( a · b ) de todos los números contenidos en la lista de números recibida.
     */
    public static void main( String[] args ) throws IOException
    {
        final int   PORT = 3001;
        Scanner     input;
        PrintWriter output;

        List<String> listaComandos = new ArrayList<>();

        ServerSocket listener = new ServerSocket( PORT );

        while ( true )
        {
            Socket socket = listener.accept();

            input = new Scanner( new InputStreamReader( socket.getInputStream() ) );

            while ( input.hasNextLine() )
            {
                listaComandos.add( input.nextLine() );
            }

            input.close(); // Forzamos cerrado de flujo de entrada por seguridad

            // Ejecutar comandos en hilo separado

            output = new PrintWriter( socket.getOutputStream(), true );

            output.println( "Comandos recibidos: " + listaComandos.toString() ); // Marcar como salida los resultados de la concatenación de comandos

            socket.close();
        }
    }
}
// MAL planteado, cambiar
class HiloDeEjecucion implements Runnable
{
    private Process myProcess;

    public HiloDeEjecucion( Process process )
    {
        this.myProcess = process;
    }

    @Override
    public void run()
    {
        Thread myThread = new Thread(  );
    }
}
