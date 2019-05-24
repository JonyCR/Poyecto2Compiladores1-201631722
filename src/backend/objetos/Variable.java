package backend.objetos;

public class Variable {

    private String nombre;
    private String tipo;
    private String valor;

    public Variable(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        if (tipo.equals("INTEGER")) {
            this.valor= "0";
        } else {
            this.valor = "null";
        }
    }

    public Variable(String nombre, String tipo, String valor) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        if (tipo.equals("STRING")) {
            this.valor = valor.substring(0, valor.length() - 1);
        } else {
            this.valor = valor;
        }
    }

}
