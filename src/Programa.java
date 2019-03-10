
import java.util.ArrayList;
import java.util.Scanner;
import tragaperras.Fruta;
import tragaperras.Maquina;
import tragaperras.Premio;

public class Programa {

    public static void main(String[] args) {
      
        Premio premio1 = new Premio(20, Fruta.FRESA, Fruta.FRESA, Fruta.FRESA);
        Premio premio2 = new Premio(10, Fruta.SANDIA, Fruta.FRESA, Fruta.FRESA);
       
        Maquina maquina = new Maquina(3, 0.5, premio1, premio2);
        
        System.out.print("Ingrese Crédito: ");
        Scanner sn = new Scanner(System.in);
        double credito = sn.nextDouble();
        sn.nextLine();
        maquina.incrementarCredito(credito);
        
        while(maquina.getCreditoActual() > 0) {

            ArrayList <Fruta> combinacion = maquina.jugar();
            
            System.out.println(combinacion.toString() + " --- " + maquina.getCreditoActual());
            
            System.out.println("Intro para Volver a Jugar");
            sn.nextLine();
        }
        
        sn.close();
    }
}
