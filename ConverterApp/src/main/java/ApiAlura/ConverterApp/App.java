package ApiAlura.ConverterApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ApiAlura.ConverterApp.BL.ConsoleOutput;
import ApiAlura.ConverterApp.BL.ExchangeRateCreate;
import ApiAlura.ConverterApp.BL.ExchangeRateFileWriter;
import ApiAlura.ConverterApp.BL.JsonProcessor;
import ApiAlura.ConverterApp.BL.OmdbConverterApp;
import ApiAlura.ConverterApp.models.ExchangeRate;
import ApiAlura.ConverterApp.models.ExchangeRateOmdb;

/**
 * Clase principal de la aplicación que se encarga de interactuar con el usuario y realizar conversiones de moneda.
 * 
 * @author remr1
 */
public class App {

    /**
     * Objeto Scanner que se utiliza para leer la entrada del usuario.
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Punto de entrada de la aplicación.
     * 
     * @param args argumentos de la línea de comandos (no utilizados)
     * @throws IOException si ocurre un error al escribir en el archivo
     * @throws InterruptedException si ocurre un error al realizar la conversión
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        OmdbConverterApp omdbConverterApp = new OmdbConverterApp();
        List<ExchangeRate> exchangeRates = new ArrayList<>();

        while (true) {
            System.out.println("Proporcione tipo de moneda");
            String baseCode = sc.nextLine().toUpperCase();
            if (baseCode.equalsIgnoreCase("Salir")) {
                break;
            }

            String conversionsRange = omdbConverterApp.getConversionRates(baseCode);
            System.out.println(conversionsRange);
            System.out.println("Proporcione tipo de moneda");
            String targetCode = sc.nextLine().toUpperCase();
            if (targetCode.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Proporcione cantidad a convertir");
            double amount = sc.nextDouble();
            sc.nextLine();

            String json = omdbConverterApp.getExchangeRate(baseCode, targetCode, amount);
            JsonProcessor jsonProcessor = new JsonProcessor();
            ExchangeRateOmdb omdb = jsonProcessor.procesarJson(json);
            ExchangeRateCreate exchangeRateCreate = new ExchangeRateCreate();
            ExchangeRate exchangeRate = exchangeRateCreate.ExchangeRateCreate(omdb);
            System.out.println(exchangeRate);
            exchangeRates.add(exchangeRate);
            System.out.println("Escriba 'SALIR' si ya no quieres hacer más conversiones\n");
        }

        ExchangeRateFileWriter exchangeRateFileWriter = new ExchangeRateFileWriter();
        exchangeRateFileWriter.writeFilm(exchangeRates);
    }
}