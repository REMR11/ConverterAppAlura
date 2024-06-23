package ApiAlura.ConverterApp.BL;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ApiAlura.ConverterApp.models.ExchangeRateOmdb;

/**
 * Clase que se encarga de procesar JSON y convertirlo en objetos de dominio.
 * 
 * @author remr1
 */
public class JsonProcessor {

    /**
     * Instancia de Gson utilizada para procesar JSON.
     */
    private Gson gson;

    /**
     * Constructor que inicializa la instancia de Gson con configuración personalizada.
     */
    public JsonProcessor() {
        this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy
                .LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting().create();
    }

    /**
     * Procesa un string JSON y lo convierte en un objeto ExchangeRateOmdb.
     * 
     * @param json el string JSON a procesar
     * @return el objeto ExchangeRateOmdb resultante
     */
    public ExchangeRateOmdb procesarJson(String json) {
        return gson.fromJson(json, ExchangeRateOmdb.class);
    }
}
