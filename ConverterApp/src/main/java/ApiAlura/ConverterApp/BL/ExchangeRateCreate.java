package ApiAlura.ConverterApp.BL;

import ApiAlura.ConverterApp.models.ExchangeRate;
import ApiAlura.ConverterApp.models.ExchangeRateOmdb;

/**
 * Clase que se encarga de crear objetos ExchangeRate a partir de objetos ExchangeRateOmdb.
 * 
 * @author remr1
 */
public class ExchangeRateCreate {

    /**
     * Crea un objeto ExchangeRate a partir de un objeto ExchangeRateOmdb.
     * 
     * @param pExchangeRateOmdb el objeto ExchangeRateOmdb que se utilizará para crear el objeto ExchangeRate
     * @return el objeto ExchangeRate creado
     */
    public ExchangeRate ExchangeRateCreate(ExchangeRateOmdb pExchangeRateOmdb) {
        return new ExchangeRate(pExchangeRateOmdb);
    }
}
