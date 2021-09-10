
package servidorCliente;

//***** EJECUTAR EN GNU/LINUX ********

import hilos.Comando;
import hilos.Disco;
import hilos.Login;
import hilos.Procesador;
import hilos.Ram;




public class Servidor {

        public static void main(String[] args) {
            new Servidor();
        }
	public Servidor() {
            new Comando().start();
            new Ram().start();
            new Disco().start();
            new Procesador().start();
            new Login().start();
	}
}

