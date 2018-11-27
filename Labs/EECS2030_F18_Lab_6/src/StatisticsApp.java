import java.util.*;

/**
 * A weather statistics app calculates the minimum, maximum, and average
 * temperature read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {

	private WeatherStation station;
	private double temp;
	private double max, min, ave;
	private List<Double> readings = new ArrayList<>();

	/**
	 * Update the reading of this weather observer. Update the current temperature
	 * and the maximum, minimum, and average accordingly.
	 */
	public void update() {
		/* Your Task */
		temp = station.getTemperature();
		readings.add(temp);
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		return this.station;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */
		this.station = ws;
		// ws.subscribe(this);
		// if(!(Arrays.asList(ws.getObservers()).contains(this)))
	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * 
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		/* Your Task */
		this.update();
		Collections.sort(readings);
		return readings.get(0);
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * 
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		/* Your Task */
		this.update();
		Collections.sort(readings);
		return readings.get(readings.size() - 1);
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * 
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		/* Your Task */
		this.update();
		double average = 0;
		for (Double d : readings)
			average += d;
		average /= readings.size();
		return average;
	}
}
