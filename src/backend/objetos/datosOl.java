package backend.objetos;

public class datosOl {
    int num;
    String mayuscula;
    String minuscula;
    public datosOl(int num,String mayuscula,String minuscula){
        this.num=num;
        this.mayuscula=mayuscula;
        this.minuscula=minuscula;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMayuscula() {
        return mayuscula;
    }

    public void setMayuscula(String mayuscula) {
        this.mayuscula = mayuscula;
    }

    public String getMinuscula() {
        return minuscula;
    }

    public void setMinuscula(String minuscula) {
        this.minuscula = minuscula;
    }
    
}
