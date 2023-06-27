package main;
import clases.*;

public class Main {

    public static void main(String[] args) {
        Filesystem sistema = new Filesystem("newSystem");
        Control controlSistema = new Control(sistema);
    }
    
}
