class Contacto {

    private String nombre;
    private int numero;

    public Contacto(String nombre, int numero) throws InvalidData{
        this.setNombre(nombre);
        this.setNumero(numero);
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) throws InvalidData {
        if(nombre==null||nombre.trim().isEmpty()) throw new InvalidData
                ("El nombre no puede estar en blanco");
        if(!Character.isUpperCase(nombre.charAt(0)) || nombre.length()<4) throw new InvalidData
                ("El nombre debe tener mínimo 4 caracteres y comenzar con mayúscula.");
        this.nombre = nombre;
    }

    public int getNumero() {return numero;}
    public void setNumero(int numero) throws InvalidData {
        if(String.valueOf(numero).length()!=10)throw new InvalidData
                ("El numero debe contener 10 caracteres");
        this.numero = numero;
    }




}
