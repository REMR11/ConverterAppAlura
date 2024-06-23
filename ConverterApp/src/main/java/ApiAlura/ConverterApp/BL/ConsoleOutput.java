package ApiAlura.ConverterApp.BL;

import java.util.List;
import ApiAlura.ConverterApp.models.ExchangeRate;

/**
 * Clase que se encarga de mostrar la salida en la consola.
 * 
 * @author remr1
 */
public class ConsoleOutput {

    /**
     * Constructor vacío.
     */
    public ConsoleOutput() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Muestra la lista de tasas de conversión en la consola.
     * 
     * @param pExchangeRates la lista de tasas de conversión a mostrar
     */
    public void showpExchangeRates(List<ExchangeRate> pExchangeRates) {
        pExchangeRates.forEach(ExchangeRate -> System.out.println(ExchangeRate));
    }
}
