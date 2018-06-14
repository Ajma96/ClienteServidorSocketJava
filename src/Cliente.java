import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente
{
    public static void main( String[] args )
    {
        final String HOST          = "192.168.17.107";
        final int    PORT          = 3001;
        /*
         * final String HTTP_GET      = "GET";
         * final String GET_ENDPOINT  = "/users";
         * final String HTTP_VERSION  = "HTTP/1.1";
         */

        Socket      clientSocket;
        PrintWriter output;
        Scanner     input;

        try
        {
            clientSocket = new Socket( HOST, PORT );

            System.out.println( "Cliente iniciado" );

            output = new PrintWriter( new OutputStreamWriter( clientSocket.getOutputStream() ) );

            /*
             * output.write( HTTP_GET + " " + GET_ENDPOINT + " " + HTTP_VERSION + "\n" );
             * output.write( "HOST: " + HOST + "\n\n" );
             */

            output.write( "ll | grep \".bash\"" );

            System.out.println( "Comando enviado" );

            input = new Scanner( new InputStreamReader( clientSocket.getInputStream() ) );

            System.out.println( "Iniciando Scanner (InputStreamReader) para lo arrojado por el servidor" );

            while ( input.hasNextLine() )
            {
                System.out.println( input.nextLine() );
            }

            input .close();
            output.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
