package pitagoras;

public class Pitagoras {
    public double calcularHipotenusa(int catetoA, int catetoB) {
        double resultado = 0.0;
        resultado = Math.sqrt(catetoA*catetoA + catetoB*catetoB);
        return resultado;
    }
}


