package de.exxcellent.challenge.dataclasses;

/**
 * This Class provides a POJO (Plain old Java Object) Class for the weather data which is used by the CSV Reader.
 * If your Weather CSV files changes regarding it's template please modify this.
 *
 * We assume that the csv looks like that:
 *  Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP
 *  1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5
 *  2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5
 */
import com.opencsv.bean.CsvBindByName;

public class Weather {

  @CsvBindByName(column = "Day")
  private int day;

  @CsvBindByName(column = "MxT")
  private int maxTemperature;

  @CsvBindByName(column = "MnT")
  private int minTemperature;

  @CsvBindByName(column = "AvT")
  private int averageTemperature;

  @CsvBindByName(column = "AvDP")
  private double averageDewPoint;

  @CsvBindByName(column = "1HrP TPcpn")
  private int oneHourPrecipitation;

  @CsvBindByName(column = "PDir")
  private int precipitationDirection;

  @CsvBindByName(column = "AvSp")
  private double averageSpeed;

  @CsvBindByName(column = "Dir")
  private int direction;

  @CsvBindByName(column = "MxS")
  private int maxSpeed;

  @CsvBindByName(column = "SkyC")
  private double skyCover;

  @CsvBindByName(column = "MxR")
  private int maxRelativeHumidity;

  @CsvBindByName(column = "Mn")
  private int minimum;

  @CsvBindByName(column = "R AvSLP")
  private double averageSeaLevelPressure;


  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMaxTemperature() {
    return maxTemperature;
  }

  public void setMaxTemperature(int maxTemperature) {
    this.maxTemperature = maxTemperature;
  }

  public int getMinTemperature() {
    return minTemperature;
  }

  public void setMinTemperature(int minTemperature) {
    this.minTemperature = minTemperature;
  }

  public int getAverageTemperature() {
    return averageTemperature;
  }

  public void setAverageTemperature(int averageTemperature) {
    this.averageTemperature = averageTemperature;
  }

  public double getAverageDewPoint() {
    return averageDewPoint;
  }

  public void setAverageDewPoint(double averageDewPoint) {
    this.averageDewPoint = averageDewPoint;
  }

  public int getOneHourPrecipitation() {
    return oneHourPrecipitation;
  }

  public void setOneHourPrecipitation(int oneHourPrecipitation) {
    this.oneHourPrecipitation = oneHourPrecipitation;
  }

  public int getPrecipitationDirection() {
    return precipitationDirection;
  }

  public void setPrecipitationDirection(int precipitationDirection) {
    this.precipitationDirection = precipitationDirection;
  }

  public double getAverageSpeed() {
    return averageSpeed;
  }

  public void setAverageSpeed(double averageSpeed) {
    this.averageSpeed = averageSpeed;
  }

  public int getDirection() {
    return direction;
  }

  public void setDirection(int direction) {
    this.direction = direction;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public double getSkyCover() {
    return skyCover;
  }

  public void setSkyCover(double skyCover) {
    this.skyCover = skyCover;
  }

  public int getMaxRelativeHumidity() {
    return maxRelativeHumidity;
  }

  public void setMaxRelativeHumidity(int maxRelativeHumidity) {
    this.maxRelativeHumidity = maxRelativeHumidity;
  }

  public int getMinimum() {
    return minimum;
  }

  public void setMinimum(int minimum) {
    this.minimum = minimum;
  }

  public double getAverageSeaLevelPressure() {
    return averageSeaLevelPressure;
  }

  public void setAverageSeaLevelPressure(double averageSeaLevelPressure) {
    this.averageSeaLevelPressure = averageSeaLevelPressure;
  }
}

