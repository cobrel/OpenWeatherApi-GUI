package weather;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GuiWeather extends JFrame {

	private JPanel contentPane;
	private JTextField SearchTextField;
	private JTextField apiKeyTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiWeather frame = new GuiWeather();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiWeather() {
		setTitle("Open Weather");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 718);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		SearchTextField = new JTextField();
		SearchTextField.setBorder(new LineBorder(new Color(192, 192, 192)));
		SearchTextField.setBackground(new Color(255, 255, 255));
		SearchTextField.setBounds(10, 62, 240, 25);
		contentPane.add(SearchTextField);
		SearchTextField.setColumns(10);

		JButton SearchButton = new JButton("Get Weather");
		SearchButton.setBorder(new LineBorder(Color.LIGHT_GRAY));
		SearchButton.setForeground(Color.WHITE);
		SearchButton.setBackground(new Color(0, 102, 153));

		SearchButton.setBounds(636, 62, 114, 25);
		contentPane.add(SearchButton);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBounds(10, 145, 240, 525);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextPane DateTextPane = new JTextPane();
		DateTextPane.setEditable(false);
		DateTextPane.setBounds(20, 11, 200, 25);
		panel.add(DateTextPane);

		JTextPane MaintextPane = new JTextPane();
		MaintextPane.setEditable(false);
		MaintextPane.setBounds(20, 270, 200, 25);
		panel.add(MaintextPane);

		JTextPane CurrentTempTextPane = new JTextPane();
		CurrentTempTextPane.setEditable(false);
		CurrentTempTextPane.setBounds(20, 305, 200, 25);
		panel.add(CurrentTempTextPane);

		JTextPane FeelsLikeTempTextPane = new JTextPane();
		FeelsLikeTempTextPane.setEditable(false);
		FeelsLikeTempTextPane.setBounds(20, 340, 200, 25);
		panel.add(FeelsLikeTempTextPane);

		JTextPane RainTextPane = new JTextPane();
		RainTextPane.setEditable(false);
		RainTextPane.setBounds(20, 375, 200, 25);
		panel.add(RainTextPane);

		JTextPane WindTextPane = new JTextPane();
		WindTextPane.setEditable(false);
		WindTextPane.setBounds(20, 410, 200, 25);
		panel.add(WindTextPane);

		JTextPane PM2_5TextPane = new JTextPane();
		PM2_5TextPane.setEditable(false);
		PM2_5TextPane.setBounds(20, 445, 200, 25);
		panel.add(PM2_5TextPane);

		JTextPane PM10TextPane = new JTextPane();
		PM10TextPane.setEditable(false);
		PM10TextPane.setBounds(20, 480, 200, 25);
		panel.add(PM10TextPane);

		JLabel icon = new JLabel("");
		icon.setBounds(20, 60, 200, 200);
		panel.add(icon);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(260, 145, 240, 525);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JTextPane DateTextPane_2 = new JTextPane();
		DateTextPane_2.setEditable(false);
		DateTextPane_2.setBounds(20, 11, 200, 25);
		panel_1.add(DateTextPane_2);

		JTextPane MaintextPane_2 = new JTextPane();
		MaintextPane_2.setEditable(false);
		MaintextPane_2.setBounds(20, 270, 200, 25);
		panel_1.add(MaintextPane_2);

		JTextPane low_forecast_temp = new JTextPane();
		low_forecast_temp.setEditable(false);
		low_forecast_temp.setBounds(20, 305, 200, 25);
		panel_1.add(low_forecast_temp);

		JTextPane high_forecast_temp = new JTextPane();
		high_forecast_temp.setEditable(false);
		high_forecast_temp.setBounds(20, 340, 200, 25);
		panel_1.add(high_forecast_temp);

		JTextPane RainTextPane_2 = new JTextPane();
		RainTextPane_2.setEditable(false);
		RainTextPane_2.setBounds(20, 375, 200, 25);
		panel_1.add(RainTextPane_2);

		JTextPane WindTextPane_2 = new JTextPane();
		WindTextPane_2.setEditable(false);
		WindTextPane_2.setBounds(20, 410, 200, 25);
		panel_1.add(WindTextPane_2);

		JTextPane sunrise = new JTextPane();
		sunrise.setEditable(false);
		sunrise.setBounds(20, 445, 200, 25);
		panel_1.add(sunrise);

		JTextPane sunset = new JTextPane();
		sunset.setEditable(false);
		sunset.setBounds(20, 480, 200, 25);
		panel_1.add(sunset);

		JLabel icon_2 = new JLabel("");
		icon_2.setBounds(20, 60, 200, 200);
		panel_1.add(icon_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(510, 145, 240, 525);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JTextPane MaintextPane_3 = new JTextPane();
		MaintextPane_3.setEditable(false);
		MaintextPane_3.setBounds(20, 270, 200, 25);
		panel_2.add(MaintextPane_3);

		JTextPane low_forecast_temp_2 = new JTextPane();
		low_forecast_temp_2.setEditable(false);
		low_forecast_temp_2.setBounds(20, 305, 200, 25);
		panel_2.add(low_forecast_temp_2);

		JTextPane high_forecast_temp_2 = new JTextPane();
		high_forecast_temp_2.setEditable(false);
		high_forecast_temp_2.setBounds(20, 340, 200, 25);
		panel_2.add(high_forecast_temp_2);

		JTextPane RainTextPane_3 = new JTextPane();
		RainTextPane_3.setEditable(false);
		RainTextPane_3.setBounds(20, 375, 200, 25);
		panel_2.add(RainTextPane_3);

		JTextPane WindTextPane_3 = new JTextPane();
		WindTextPane_3.setEditable(false);
		WindTextPane_3.setBounds(20, 410, 200, 25);
		panel_2.add(WindTextPane_3);

		JTextPane sunrise_2 = new JTextPane();
		sunrise_2.setEditable(false);
		sunrise_2.setBounds(20, 445, 200, 25);
		panel_2.add(sunrise_2);

		JTextPane sunset_2 = new JTextPane();
		sunset_2.setEditable(false);
		sunset_2.setBounds(20, 480, 200, 25);
		panel_2.add(sunset_2);

		JTextPane DateTextPane_3 = new JTextPane();
		DateTextPane_3.setEditable(false);
		DateTextPane_3.setBounds(20, 11, 200, 25);
		panel_2.add(DateTextPane_3);

		JLabel icon_3 = new JLabel("");
		icon_3.setBounds(20, 60, 200, 200);
		panel_2.add(icon_3);
		
		apiKeyTextField = new JTextField();
		apiKeyTextField.setColumns(10);
		apiKeyTextField.setBorder(new LineBorder(new Color(192, 192, 192)));
		apiKeyTextField.setBackground(Color.WHITE);
		apiKeyTextField.setBounds(260, 62, 353, 25);
		contentPane.add(apiKeyTextField);
		
		JLabel lblNewLabel = new JLabel("City");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 20, 240, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblApiKey = new JLabel("Api Key");
		lblApiKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblApiKey.setBounds(260, 20, 353, 25);
		contentPane.add(lblApiKey);

		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// current
				String cautare = SearchTextField.getText();
				String apiKey = apiKeyTextField.getText();
				 if (cautare.isEmpty() || apiKey.isEmpty()) {
					 
					 JOptionPane.showOptionDialog(null, "Search Failed because City or Api key is empty", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
					 return;
				 }
				 
				 try {
						OpenWeatherApi owa = new OpenWeatherApi();
						owa.OpenWeatherApiResults(cautare, apiKey);
						Current ts = new Current();
						String data = ts.data();
						String iconIdCurrent = ts.iconCurrent();
						String iconPathCurrent = "/resources/" + iconIdCurrent + "@4x.png";
						ImageIcon pozaCurrent = new ImageIcon(getClass().getResource(iconPathCurrent));
						String stareaVremii = ts.description();
						String temperatura = ts.currentTemp();
						String tempResimtita = ts.feelsLike();
						String precipitatii = ts.precipitation();
						String vant = ts.wind();
						String pm2_5 = ts.pm2_5();
						String pm10 = ts.pm10();
						DateTextPane.setText(data);
						MaintextPane.setText(stareaVremii);
						CurrentTempTextPane.setText(temperatura);
						FeelsLikeTempTextPane.setText(tempResimtita);
						RainTextPane.setText(precipitatii);
						WindTextPane.setText(vant);
						PM2_5TextPane.setText(pm2_5);
						PM10TextPane.setText(pm10);
						icon.setIcon(pozaCurrent);

						// forecast day 1
						ForecastDay1 fc = new ForecastDay1();
						String dateForecast = fc.data_forecast();
						String iconIdForecastDay1 = fc.iconForecastDay1();
						String iconPathForecastDay1 = "/resources/" + iconIdForecastDay1 + "@4x.png";
						ImageIcon pozaForecastDay1 = new ImageIcon(getClass().getResource(iconPathForecastDay1));
						String stareaVremiiPrognoza = fc.weatherCondition();
						String low = fc.lowest_temp();
						String high = fc.highest_temp();
						String precipitation_forecast_day1 = fc.precipitation_forecast_day1();
						String windSpeed = "low " + fc.lowest_wind_speed() + " - " + "high " + fc.highest_wind_speed();
						String sr = fc.sunrise();
						String ss = fc.sunset();
						DateTextPane_2.setText(dateForecast);
						MaintextPane_2.setText(stareaVremiiPrognoza);
						low_forecast_temp.setText(low);
						high_forecast_temp.setText(high);
						sunrise.setText(sr);
						sunset.setText(ss);
						RainTextPane_2.setText(precipitation_forecast_day1);
						WindTextPane_2.setText(windSpeed);
						icon_2.setIcon(pozaForecastDay1);

						// forecast day 2
						ForecastDay2 fcDay2 = new ForecastDay2();
						String dateForecastDay2 = fcDay2.data_forecastDay2();
						String iconIdForecastDay2 = fcDay2.iconForecastDay2();
						String iconPathForecastDay2 = "/resources/" + iconIdForecastDay2 + "@4x.png";
						ImageIcon pozaForecastDay2 = new ImageIcon(getClass().getResource(iconPathForecastDay2));
						String stareaVremiiPrognozaDay2 = fcDay2.weatherConditionDay2();
						String lowDay2 = fcDay2.lowest_tempDay2();
						String highDay2 = fcDay2.highest_tempDay2();
						String precipitation_forecast_day2 = fcDay2.precipitation_forecast_day2();
						String windSpeedDay2 = "low " + fcDay2.lowest_wind_speedDay2() + " - " + "high "+ fcDay2.highest_wind_speedDay2();
						String srDay2 = fcDay2.sunriseDay2();
						String ssDay2 = fcDay2.sunsetDay2();
						DateTextPane_3.setText(dateForecastDay2);
						MaintextPane_3.setText(stareaVremiiPrognozaDay2);
						low_forecast_temp_2.setText(lowDay2);
						high_forecast_temp_2.setText(highDay2);
						RainTextPane_3.setText(precipitation_forecast_day2);
						WindTextPane_3.setText(windSpeedDay2);
						sunrise_2.setText(srDay2);
						sunset_2.setText(ssDay2);
						icon_3.setIcon(pozaForecastDay2);
				 }
				 catch(Exception e) {
					 JOptionPane.showOptionDialog(null, "Search Failed", "Search Failed", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
				 }

			}
		});
	}
}
