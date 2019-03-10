package tragaperras;

import java.util.ArrayList;
import java.util.Objects;

public class Premio {
    private final ArrayList <Fruta> combinacionGanadora;
    private final double cantidadDinero;
    
    public Premio(double cantDinero, Fruta... frutas) {
        this.cantidadDinero = cantDinero;
        combinacionGanadora = new ArrayList<>();
        for(Fruta ft : frutas) {
            this.combinacionGanadora.add(ft);
        }
    }
   
    public ArrayList<Fruta> getCombGanadora() { return combinacionGanadora; }
    public double getCantDinero() { return cantidadDinero; }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.combinacionGanadora);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.cantidadDinero) ^ (Double.doubleToLongBits(this.cantidadDinero) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Premio other = (Premio) obj;
        return Objects.equals(this.combinacionGanadora, other.combinacionGanadora);
    }
}
