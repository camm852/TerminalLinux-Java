
package comunicacion;

//***** EJECUTAR EN GNU/LINUX ********

import hilos.Disco;
import hilos.Comando;
import hilos.Ram;
import hilos.Procesador;


public class Servidor {

        public static void main(String[] args) {
            new Servidor();
        }
	public Servidor() {
            new Comando().start();
            new Ram().start();
            new Disco().start();
            new Procesador().start();
	}
}


