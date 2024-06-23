package ApiAlura.ConverterApp.BL;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Clase que proporciona métodos para obtener tasas de conversión de monedas y realizar conversiones.
 * 
 * @author remr1
 */
public class OmdbConverterApp {

    /**
     * Clave API de Exchange Rate.
     */
    final String APIKEY = "79b09beb8411016612500808";

    /**
     * Constructor vacío.
     */

	/**
	 * Obtiene la tasa de conversión para una moneda base y una moneda objetivo
	 * específicas.
	 * 
	 * @param pBaseCode   la moneda base para la conversión (por ejemplo, "USD",
	 *                    "EUR", "JPY", etc.)
	 * @param pTargetCode la moneda objetivo para la conversión (por ejemplo, "USD",
	 *                    "EUR", "JPY", etc.)
	 * @param pAmount     la cantidad a convertir
	 * @return la tasa de conversión en formato JSON
	 */
	public String getExchangeRate(String pBaseCode, String pTargetCode, double pAmount) {

		String direction = "https://v6.exchangerate-api.com/v6/" + 
				APIKEY + "/pair/" +	pBaseCode + "/" + pTargetCode + "/" + pAmount;

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(direction))
				.build();

		try {
			
			HttpResponse<String> response = HttpClient.newHttpClient()
					.send(request, HttpResponse.BodyHandlers.ofString());
			
			return response.body();
		} catch (IOException e) {
			System.out.println("Tuvimos problemas: ");
			System.out.println(e.getMessage());
			return null;
		} catch (InterruptedException e) {
			System.out.println("Tuvimos problemas: ");
			System.out.println(e.getMessage());
			return null;
		}

	}

	/**
	 * Obtiene las tasas de conversión para una moneda base específica.
	 * 
	 * @param apiKey       la clave API de Exchange Rate
	 * @param baseCurrency la moneda base para la conversión (por ejemplo, "USD",
	 *                     "EUR", "JPY", etc.)
	 * @return un objeto JsonObject con las tasas de conversión
	 * @throws IOException          si ocurre un error de entrada/salida
	 * @throws InterruptedException si la petición es interrumpida
	 */
	public String getConversionRates(String baseCurrency) throws IOException, InterruptedException {

		try {
			String url = "https://v6.exchangerate-api.com/v6/" + APIKEY + "/latest/" + 
					baseCurrency + "?base="	+ 
					baseCurrency + "&select=conversion_rates";
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			Gson gson = new GsonBuilder()
					.setPrettyPrinting()
					.create();
			
			JsonElement jsonElement = gson.fromJson(response.body(), JsonElement.class);
			JsonObject jsonData = jsonElement.getAsJsonObject();
			JsonObject conversionRates = jsonData.getAsJsonObject("conversion_rates");
			String jsonPretty = gson.toJson(conversionRates);
			return jsonPretty;

		} catch (IOException e) {
			throw new IOException("Error al obtener las tasas de conversión: " + e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new InterruptedException("La petición fue interrumpida: " + e.getMessage());
		}
	}
}
