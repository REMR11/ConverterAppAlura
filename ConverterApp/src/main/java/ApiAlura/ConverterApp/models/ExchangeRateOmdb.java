package ApiAlura.ConverterApp.models;

public record ExchangeRateOmdb(
		String baseCode, 
		String targetCode, 
		String timeLastUpdateUtc,
		double conversionRate,
		String result,
		double conversionResult
		) {}
