package weather;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ForecastDay1 extends OpenWeatherApi {

	// date
	public String data_forecast() {
		String data = js.getString("dt");
		int num = Integer.parseInt(data);
		long multiply = num * 1000L;
		Date dateCurenta = new Date(multiply);
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE dd MMMM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateCurenta);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date incrementedDate = calendar.getTime();
		String formattedIncrementedDate = formatter.format(incrementedDate);
		return formattedIncrementedDate;
	}

	// forecast weather conditions
	public String weatherCondition() {

	    String formattedIncrementedDate = data_forecast();

	    int size = js_third.getInt("list.size()");
	    List<String> conditions = new ArrayList<>();

	    for (int i = 0; i < size; i++) {
	        String weatherCond = js_third.getString("list[" + i + "].weather[0].main");
	        String dataPrognoza = js_third.getString("list[" + i + "].dt_txt");
	        LocalDateTime dateTime = LocalDateTime.parse(dataPrognoza,
	                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM"));
	        if (formattedDate.equals(formattedIncrementedDate)) {
	            conditions.add(weatherCond);
	        }
	    }

	    if (conditions.contains("Rain")) {
	        return "Rain";
	    }

	    int maxCount = 0;
	    String mostCommonCondition = null;
	    for (String condition : conditions) {
	        int count = Collections.frequency(conditions, condition);
	        if (count >= 5) {
	            mostCommonCondition = condition;
	            break;
	        } else if (count > maxCount) {
	            maxCount = count;
	            mostCommonCondition = condition;
	        }
	    }

	    if (mostCommonCondition != null) {
	        return mostCommonCondition;
	    } else if (conditions.size() > 0) {
	        return "Unpredictable weather";
	    } else {
	        return "No weather data available";
	    }
	}

	// weather icon
	public String iconForecastDay1() {
		String formattedIncrementedDate = data_forecast();
		int size = js_third.getInt("list.size()");
		String[] iconIdForecastDay1 = new String[size];

		for (int i = 0; i < size; i++) {
			String icon = js_third.getString("list[" + i + "].weather[0].icon");
			String dataPrognoza = js_third.getString("list[" + i + "].dt_txt");
			LocalDateTime dateTime = LocalDateTime.parse(dataPrognoza,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM"));
			if (formattedDate.equals(formattedIncrementedDate)) {
				iconIdForecastDay1[i] = icon;
			}
		}

		int maxCount = 0;
		String mostCommonIconId = null;
		for (String iconId : iconIdForecastDay1) {
		    if (iconId != null) {
		        if (iconId.startsWith("10") || iconId.startsWith("11") ) {
		            mostCommonIconId = iconId;
		            break;
		        }
		        int count = 0;
		        for (String otherIconId : iconIdForecastDay1) {
		            if (iconId.equals(otherIconId)) {
		                count++;
		            }
		        }
		        if (count >= 5) {
		            mostCommonIconId = iconId;
		            break;
		        } else if (count > maxCount) {
		            maxCount = count;
		            if (iconId.startsWith("02") || iconId.startsWith("03") || iconId.startsWith("04")) {
		                mostCommonIconId = "03d";  // consider all listed conditions as cloudy
		            } else {
		                mostCommonIconId = iconId;
		            }
		        }
		    }
		}

		if (mostCommonIconId != null) {
		    return mostCommonIconId;
		} else if (weatherCondition().equals("Rain")) {
		    return "10d";
		} else {
		    return "unpredictable";
		}
	}

	// lowest temperature
	public String lowest_temp() {

		String formattedIncrementedDate = data_forecast();

		int size = js_third.getInt("list.size()");
		String[] temperatures = new String[size];

		for (int i = 0; i < size; i++) {
			String temp = js_third.getString("list[" + i + "].main.temp");
			String dataPrognoza = js_third.getString("list[" + i + "].dt_txt");
			LocalDateTime dateTime = LocalDateTime.parse(dataPrognoza,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM"));
			if (formattedDate.equals(formattedIncrementedDate)) {
				temperatures[i] = temp;
			}
		}

		double[] tempArray = new double[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			if (temperatures[i] != null) {
				tempArray[i] = Double.parseDouble(temperatures[i]);
			}
		}

		Arrays.sort(tempArray); // sort the temperatures array

		String lowestTemp = Double.toString(tempArray[tempArray.length - 8]);
		return "low " + lowestTemp + "°C";
	}

	// highest temperature
	public String highest_temp() {

		String formattedIncrementedDate = data_forecast();

		int size = js_third.getInt("list.size()");
		String[] temperatures = new String[size];

		for (int i = 0; i < size; i++) {
			String temp = js_third.getString("list[" + i + "].main.temp");
			String dataPrognoza = js_third.getString("list[" + i + "].dt_txt");
			LocalDateTime dateTime = LocalDateTime.parse(dataPrognoza,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM"));
			if (formattedDate.equals(formattedIncrementedDate)) {
				temperatures[i] = temp;
			}
		}

		double[] tempArray = new double[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			if (temperatures[i] != null) {
				tempArray[i] = Double.parseDouble(temperatures[i]);
			}
		}

		Arrays.sort(tempArray); // sort the temperatures array

		String highestTemp = Double.toString(tempArray[tempArray.length - 1]);
		return "high " + highestTemp + "°C";
	}

	// pricipitation
	public String precipitation_forecast_day1() {

		String formattedIncrementedDate = data_forecast();

		int size = js_third.getInt("list.size()");
		double sumPrecipitation = 0.0;

		for (int i = 0; i < size; i++) {
			String ploaie = js_third.getString("list[" + i + "].rain.3h");
			String dataPrognoza = js_third.getString("list[" + i + "].dt_txt");
			LocalDateTime dateTime = LocalDateTime.parse(dataPrognoza,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM"));
			if (formattedDate.equals(formattedIncrementedDate)) {

				if (ploaie != null) {
					double p = Double.parseDouble(ploaie);
					if (p >= 0.0) {
						sumPrecipitation += p;
					}
				}
			}

		}
		String precipitation = String.format("%.3f", sumPrecipitation);
		return "precipitation " + precipitation + " mm";
	}

	// lowest wind speed value
	public String lowest_wind_speed() {

		String formattedIncrementedDate = data_forecast();

		int size = js_third.getInt("list.size()");
		String[] wind_speed = new String[size];

		for (int i = 0; i < size; i++) {
			String wind = js_third.getString("list[" + i + "].wind.speed");
			String dataPrognoza = js_third.getString("list[" + i + "].dt_txt");
			LocalDateTime dateTime = LocalDateTime.parse(dataPrognoza,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM"));
			if (formattedDate.equals(formattedIncrementedDate)) {
				wind_speed[i] = wind;
			}
		}

		double[] tempArray = new double[wind_speed.length];
		for (int i = 0; i < wind_speed.length; i++) {
			if (wind_speed[i] != null) {
				tempArray[i] = Double.parseDouble(wind_speed[i]);
			}
		}

		Arrays.sort(tempArray); // sort the temperatures array

		String lowWind = Double.toString(tempArray[tempArray.length - 8]);
		return lowWind + " m/s";
	}

	// highest wind speed value
	public String highest_wind_speed() {

		String formattedIncrementedDate = data_forecast();

		int size = js_third.getInt("list.size()");
		String[] wind_speed = new String[size];

		for (int i = 0; i < size; i++) {
			String wind = js_third.getString("list[" + i + "].wind.speed");
			String dataPrognoza = js_third.getString("list[" + i + "].dt_txt");
			LocalDateTime dateTime = LocalDateTime.parse(dataPrognoza,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("EEEE dd MMMM"));
			if (formattedDate.equals(formattedIncrementedDate)) {
				wind_speed[i] = wind;
			}
		}

		double[] tempArray = new double[wind_speed.length];
		for (int i = 0; i < wind_speed.length; i++) {
			if (wind_speed[i] != null) {
				tempArray[i] = Double.parseDouble(wind_speed[i]);
			}
		}

		Arrays.sort(tempArray); // sort the temperatures array

		String highWind = Double.toString(tempArray[tempArray.length - 1]);
		return highWind + " m/s";
	}

	// sunrise
	public String sunrise() {
		
	    int timezoneOffset = js_third.getInt("city.timezone");
	    String data = js_third.getString("city.sunrise");
	    int num = Integer.parseInt(data);
	    long multiply = (num + timezoneOffset) * 1000L;
	    Date date = new Date(multiply);
	    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	    formatter.setTimeZone(TimeZone.getTimeZone("GMT+0"));
	    String formattedDate = formatter.format(date);
	    return "sunrise " + formattedDate;
	}

	// sunset
	public String sunset() {
		
		int timezoneOffset = js_third.getInt("city.timezone");
		String data = js_third.getString("city.sunset");
		int num = Integer.parseInt(data);
		long multiply = (num + timezoneOffset) * 1000L;
		Date date = new Date(multiply);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		String formattedDate = formatter.format(date);
		return "sunset  " + formattedDate;
	}

}
