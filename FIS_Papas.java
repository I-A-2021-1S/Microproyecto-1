package fis_aire;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */

public class FIS_Aire {

    public static void main(String[] args) {
        
        // Carga el archivo de lenguaje de control difuso 'FCL'
        String fileName = "src/fis_aire/FCL_Aire.fcl";
        FIS fis = FIS.load(fileName, true);
        
        // En caso de error
        if (fis == null) {
            System.err.println("No se puede cargar el archivo: '" + fileName + "'");
            return;
        }
        
        // Establecer las entradas del sistema
        fis.setVariable("TEMPERATURA", 25);
        fis.setVariable("ALTITUD", 7.5);
        fis.setVariable("LUZ", 20);
        fis.setVariable("AGUA", 12);
        fis.setVariable("PH", 12);
        
        /*
        // Muestra las reglas
        for (Rule r : fis.getFunctionBlock("prop").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }
        System.out.println();
        */

        // Inicia el funcionamiento del sistema
        fis.evaluate();

        // Muestra los gráficos de las variables de entrada y salida
        //JFuzzyChart.get().chart(fis.getFunctionBlock("prop"));
        
        /*
        // Muestra la salida difusa sobre la que se calcula COG
        Variable tip = fis.getVariable("propina");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
        */
             
        // Imprime el valor de salida del sistema
        double CALIDAD_CULTIVO = fis.getVariable("CALIDAD_CULTIVO").getLatestDefuzzifiedValue();
        double CONDICION_SUELO = fis.getVariable("CONDICION_SUELO").getLatestDefuzzifiedValue();
        System.out.println("Para los valores de entrada\nla calidad del cultivo es: " + CALIDAD_CULTIVO + "\n" +
                            "la condición del suelo es: " + CONDICION_SUELO + "%\n");
        
        
        
        /*
        // Muestra cuanto peso tiene la variable de salida en cada CD de salida
        double salidaPertenenciaBaja = fis.getVariable("propina").getMembership("baja");
        double salidaPertenenciaPromedio = fis.getVariable("propina").getMembership("promedio");
        double salidaPertenenciaGenerosa = fis.getVariable("propina").getMembership("generosa");
        
        System.out.println("La propina es baja con una pertenencia de: " + salidaPertenenciaBaja);
        System.out.println("La propina es promedio con una pertenencia de: " + salidaPertenenciaPromedio);
        System.out.println("La propina es generosa con una pertenencia de: " + salidaPertenenciaGenerosa);
        */
    }
    
}
