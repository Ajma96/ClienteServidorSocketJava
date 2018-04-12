import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
        PrintWriter output;

        ServerSocket listener = new ServerSocket( PORT );

        while ( true )
        {
            Socket socket = listener.accept();

            output = new PrintWriter( socket.getOutputStream(), true );
            output.println( 5 * 2 + "" );

            socket.close();
        }
    }
}
