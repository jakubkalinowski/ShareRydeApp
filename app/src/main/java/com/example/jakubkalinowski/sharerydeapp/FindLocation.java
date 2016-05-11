package com.example.jakubkalinowski.sharerydeapp; /**
 * Created by Ladimer on 5/11/2016.
 */
/***
 * Locations must be inputed as Address+City+State
 * Origin must be inputed as longitude,latitude
 * Destination must be inputed as longitude,latitude
 *
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class FindLocation {
    private String coordinates;
    private int time;
    private int distance;
    public static double tempX;
    public static double tempY;

    public FindLocation(){
        time = 0;
        distance = 0;
        coordinates = "";
    }

    /**
     * Finds longitude and Latitude of location
     * @param location String location
     * @return coordinates Coordinates of location displayed as xx.xxxxxx,xx.xxxxxxx
     * @throws IOException
     */
    public String findCoordinates(String location) throws IOException{
        String webURL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
        //webURL.concat(location);
        webURL += location ;
        URL loc = new URL(webURL);
        URLConnection yc = loc.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        String inputLine;
        int count = 0;
        while ((inputLine = in.readLine()) != null && count < 2){
            if(inputLine.contains("lat") || inputLine.contains("lng")){
                if(inputLine.contains("lat")){
                    String latitude = inputLine.substring(23);
                    coordinates = latitude;//Y or -121.0
                    tempY = Double.parseDouble(latitude.substring(0, latitude.length() - 1));
                    //System.out.println( "latitue is "+latitude);
                }
                else{
                    String longitude = inputLine.substring(23);
                    tempX = Double.parseDouble(longitude);
                    coordinates.concat(longitude);

                }
                count++;
            }
        }
        in.close();
        return coordinates;
    }
    /**
     * Finds distance to school
     * @param origin longitude and latitude of origin
     * @param destination longitude and latitude of destination
     * @throws IOException
     */
    public void findDistanceTime(String origin, String destination) throws IOException{
        String webURL = "https://maps.googleapis.com/maps/api/distancematrix/json?";
        String originRaw = "origin=" + origin;
        String destRaw = "&destination=" + destination;

        //Create URL string
        webURL.concat(originRaw);
        webURL.concat(destRaw);

        URL url = new URL(webURL);
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;
        int count = 0;
        while((inputLine = in.readLine()) != null){
            if(inputLine.contains("value") && count == 0){
                System.out.println("Distance = " + inputLine.substring(28));
                distance = Integer.parseInt(inputLine.substring(28));
                count++;
            }
            else if(inputLine.contains("value") && count == 1){
                System.out.println("Time = " + inputLine.substring(28));
                time = Integer.parseInt(inputLine.substring(28));
                count++;
            }

        }
    }

    /**
     * Get Distance to Travel from find Distance
     * @return
     */
    public int getDistance(){
        return distance;
    }

    public static double getTempX() {
        return tempX;
    }

    public static void setTempX(double tempX) {
        FindLocation.tempX = tempX;
    }

    public static double getTempY() {
        return tempY;
    }

    public static void setTempY(double tempY) {
        FindLocation.tempY = tempY;
    }

    /**
     * Get Time to travel to desired destination
     * @return
     */
    public int getTime(){
        return time;
    }
}
