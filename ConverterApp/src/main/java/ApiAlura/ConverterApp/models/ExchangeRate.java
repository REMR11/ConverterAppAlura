package ApiAlura.ConverterApp.models;

import com.google.gson.annotations.SerializedName;

public class ExchangeRate {
	@SerializedName("base_code")
	private String baseCode;
	@SerializedName("target_code")
	private String targetCode;
	@SerializedName("time_last_update_utc")
	private String lastUpdate;
	@SerializedName("conversion_rate")
	private double conversionRate;
	@SerializedName("result")
	private String result;
	@SerializedName("conversion_result")
	private double conversionResult;

	/**
	 * Constructuro que crea una instancia de {@link ExchangeRateResponse} a partil
	 * de un objeto {@link ExchangeRateResponseOmdb}.
	 * 
	 * @param pExchangeRateResponseOmdb objeto que contiene informacion sobre
	 *                                  valores de cambio de monedas.
	 */
	public ExchangeRate(ExchangeRateOmdb pExchangeRateOmdb) {
		this.baseCode = pExchangeRateOmdb.baseCode();
		this.targetCode = pExchangeRateOmdb.targetCode();
		this.lastUpdate = pExchangeRateOmdb.timeLastUpdateUtc();
		this.conversionRate = pExchangeRateOmdb.conversionRate();
		this.result = pExchangeRateOmdb.result();
		this.conversionResult = pExchangeRateOmdb.conversionResult();
	}

	/**
	 * @return the baseCode
	 */
	public String getBaseCode() {
		return baseCode;
	}

	/**
	 * @param baseCode the baseCode to set
	 */
	public void setBaseCode(String baseCode) {
		baseCode = baseCode;
	}

	/**
	 * @return the targetCode
	 */
	public String getTargetCode() {
		return targetCode;
	}

	/**
	 * @param targetCode the targetCode to set
	 */
	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	/**
	 * @return the lastUpdate
	 */
	public String getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the conversionRate
	 */
	public double getConversionRate() {
		return conversionRate;
	}

	/**
	 * @param conversionRate the conversionRate to set
	 */
	public void setConversionRate(double conversionRate) {
		this.conversionRate = conversionRate;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the conversionResult
	 */
	public double getConversionResult() {
		return conversionResult;
	}

	/**
	 * @param conversionResult the conversionResult to set
	 */
	public void setConversionResult(double conversionResult) {
		this.conversionResult = conversionResult;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conversion de modeda {\n");
		if (baseCode != null) {
			builder.append("Codigo base=");
			builder.append(baseCode);
			builder.append(", ");
		}
		if (targetCode != null) {
			builder.append("Codigo objetivo=");
			builder.append(targetCode);
			builder.append(", \n");
		}
		if (lastUpdate != null) {
			builder.append("Ultima actualizacion=(");
			builder.append(lastUpdate);
			builder.append("), \n");
		}
		builder.append("Equivalencia de la moneda=");
		builder.append(conversionRate);
		builder.append(", \n");
		if (result != null) {
			builder.append("Estado de conversion=");
			builder.append(result);
			builder.append(", \n");
		}
		builder.append("Total=");
		builder.append(conversionResult);
		builder.append("}\n");
		return builder.toString();
	}

}
