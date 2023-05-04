package weather;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Current extends OpenWeatherApi {

	// date
	public String data() {
		String data = js.getString("dt");
		int num = Integer.parseInt(data);
		long multiply = num * 1000L;
		Date date = new Date(multiply);
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE dd MMMM");
		String formattedDate = formatter.format(date);
		return formattedDate;
	}
	
	//weather icon
	public String iconCurrent() {
		String icon = js.getString("weather[0].icon");
		return icon;
	}

	// weather conditions
	public String description() {
		String main = js.getString("weather.description").replace("[", "").replace("]", "");
		return main;
	}

	// current temperature
	public String currentTemp() {
		String currentTemp = js.getString("main.temp");
		return "current temperature " + currentTemp + "°C";
	}

	// feels like temperature
	public String feelsLike() {
		String feelsLike = js.getString("main.feels_like");
		return "feels like " + feelsLike + "°C";
	}

	// Precipitation
	public String precipitation() {
	    String precipitation = js.getString("rain.1h");
	    if (precipitation == null) {
	        precipitation = "0";
	    } else {
	        double p = Double.parseDouble(precipitation);
	        precipitation = String.format("%.3f", p);
	    }
	    return "precipitation " + precipitation + " mm";
	}

	// wind
	public String wind() {
		String wind = js.getString("wind.speed");
		return "wind " + wind + " m/s";

	}

	// pm2_5
	public String pm2_5() {
		String pm2_5 = js_second.getString("list.components.pm2_5").replace("[", "").replace("]", "");
		return "(PM 2.5) " + pm2_5 + " μg/m3";
	}

	// pm10
	public String pm10() {
		String pm10 = js_second.getString("list.components.pm10").replace("[", "").replace("]", "");
		return "(PM 10) " + pm10 + " μg/m3";
	}

}
