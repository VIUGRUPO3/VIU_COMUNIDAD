package usuario;

public class Vecino extends Usuario {

        /**
         * Constructor de la clase Usuario.
         *
         * @param nombre
         * @param clave
         * @param telefono
         * @param email
         * @param tipo
         */
        public Vecino(int id,String nombre, String clave, String telefono, String email, String tipo) {
            super(id,nombre, clave, telefono, email, tipo);
        }
    public String toString(){
        System.out.println(this.idUsuario);
        System.out.println(this.nombre);
        System.out.println(this.clave);
        System.out.println(this.telefono);
        System.out.println(this.email);
        System.out.println(this.tipo);
        return String.format("%s - %s",this.idUsuario,this.nombre) ;
    }
}

