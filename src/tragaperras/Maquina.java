package tragaperras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Maquina {
    private final int nmrCasillas;
    private double preciodeJugada;
    private double creditosActuales;
    private final HashSet <Premio> premios = new HashSet<>();
    
    public Maquina(int numCasillas, double precio, Premio... premios) {
        this.nmrCasillas = numCasillas;
        this.preciodeJugada = precio;
    
        boolean addAll = Collections.addAll(this.premios, premios);
    }

    public int getNumCasillas() { return nmrCasillas; }
    public double getPrecioJugada() { return preciodeJugada; }
    public double getCreditoActual() { return creditosActuales; }
    
    public void setPrecioJugada(double preciodelaJugada) { this.preciodeJugada = preciodelaJugada; }
    
    public void incrementarCredito(double creditos) {
        this.creditosActuales += creditos;
    }
    
    private ArrayList<Fruta> generarCombinacion() {
        ArrayList<Fruta> combinacion = new ArrayList<>(this.nmrCasillas);
        Random random = new Random();
        Fruta[] frutas = Fruta.values();
        for(int i = 0; i < this.nmrCasillas; i++) {
            Fruta fruta = frutas[random.nextInt(frutas.length)];
            combinacion.add(fruta);
        }
        
        return combinacion;
    }
    
    public ArrayList<Fruta> jugar() {
        if(this.creditosActuales >= this.preciodeJugada) {
            this.creditosActuales -= this.preciodeJugada;
            ArrayList <Fruta> combActual, combPremio;
            combActual = this.generarCombinacion();
            for(Premio pt : this.premios) {
                combPremio = pt.getCombGanadora();
                if(combActual.equals(combPremio)) {
                    this.creditosActuales += pt.getCantDinero();
                }
            }
            return combActual;
        }
        
            return null;
    }
    
    
}
