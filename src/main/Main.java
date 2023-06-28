package main;

import control.Control;
import clases.*;
import menu.Menu;

public class Main {

    public static void main(String[] args) {
        Filesystem sistema = new Filesystem("newSystem");
        Control controlSistema = new Control(sistema);
        Menu menuSistema = new Menu(controlSistema);
        menuSistema.menuPrincipal();
    }
    
}
