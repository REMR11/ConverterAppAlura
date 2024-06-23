package ApiAlura.ConverterApp.BL;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import ApiAlura.ConverterApp.models.ExchangeRate;

/**
 * Clase que se encarga de escribir una lista de objetos ExchangeRate en un archivo de texto.
 * 
 * @author remr1
 */
public class ExchangeRateFileWriter {

    /**
     * Escribe una lista de objetos ExchangeRate en un archivo de texto llamado "ExchangeRate.txt".
     * Cada objeto ExchangeRate se escribe en una línea separada en formato JSON.
     * 
     * @param ExchangeRates la lista de objetos ExchangeRate a escribir
     * @throws IOException si ocurre un error al escribir en el archivo
     */
    public void writeFilm(List<ExchangeRate> ExchangeRates) throws IOException {
        FileWriter escritura = new FileWriter("ExchangeRate.txt");
        for (ExchangeRate titulo : ExchangeRates) {
            String JSON = new Gson().toJson(titulo);
            escritura.write(JSON + "\n");
        }
        escritura.close();
    }
}
