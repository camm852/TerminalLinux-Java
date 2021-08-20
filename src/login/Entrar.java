package login;



public class Entrar {
        private String usuario;
        private String pass;
        
        
	public Entrar(){
            String[] credenciales = new Archivo().cargarDatos();
            
            this.usuario=credenciales[0];
            this.pass=credenciales[1];  
        }
        
        public boolean ingresar(String usuario,String pass){
            Cifrador c = new Cifrador();
            try {
                String passHash = c.hash(pass);
                return usuario.equals(this.usuario) && passHash.equals(this.pass);
            } catch (Exception e) {

            }
            
            return false;
        }
}
