package weather;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class OpenWeatherApi {
	public static JsonPath js;
	public static JsonPath js_second;
	public static JsonPath js_third;

	public JsonPath getJsonPath() {
		return js;
	}

	public JsonPath getJsonPath_second() {
		return js_second;
	}

	public JsonPath getJsonPath_third() {
		return js_third;
	}

	public void OpenWeatherApiResults(String cautare, String apiKey) {

		RestAssured.baseURI = "https://api.openweathermap.org";

		String currentWeather = given().queryParam("q", cautare).queryParam("units", "metric")
				.queryParam("appid", apiKey).when().get("data/2.5/weather").then().extract()
				.response().asString();

		js = new JsonPath(currentWeather);

		// coords
		String latitude = js.getString("coord.lat");
		String longitude = js.getString("coord.lon");

		String currentAirPolutionResponse = given().queryParam("lat", latitude).queryParam("lon", longitude)
				.queryParam("appid", apiKey).when().get("data/2.5/air_pollution").then()
				.extract().response().asString();

		js_second = new JsonPath(currentAirPolutionResponse);

		String weatherForcecastResponse = given().queryParam("q", cautare).queryParam("units", "metric")
				.queryParam("appid", apiKey).when().get("data/2.5/forecast").then()
				.extract().response().asString();

		js_third = new JsonPath(weatherForcecastResponse);


	}
}