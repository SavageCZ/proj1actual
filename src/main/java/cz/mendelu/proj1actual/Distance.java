package cz.mendelu.proj1actual;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Distance {

    protected double rectangle2;

    public double distance(double lat1, double lon1, double lat2, double lon2, char unit) {

        double theta = lon1 - lon2;

        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);

        dist = rad2deg(dist);

        dist = dist * 60 * 1.1515;

        if (unit == 'K') {

            dist = dist * 1.609344;

        } else if (unit == 'N') {

            dist = dist * 0.8684;

        }

        return (dist);

    }

        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

        /*::  This function converts decimal degrees to radians             :*/

        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

    private double deg2rad(double deg) {

        return (deg * Math.PI / 180.0);

    }


        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

        /*::  This function converts radians to decimal degrees             :*/

        /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/

    private double rad2deg(double rad) {

        return (rad * 180.0 / Math.PI);

    }


    public double rectangle(double lat, double lng){
        double c;
        c = Math.sqrt(abs(lat*lat)+abs(lng*lng));

        return c;
    }

    /*
    public void rectangle2(){
        double[] c = new double[250];
        double[] lat = new double[250];
        double[] lng = new double[250];
        Scanner scanner = new Scanner(System.in);

        //Foreach index of the array ask the user for a number.
        // And then change that index to the input
        for(int index= 0; index < lat.length; index++) {
            double lat2 = scanner.nextInt();
            double lng2 = scanner.nextInt();
            lat[index] = lat2;
            lng[index] = lng2;
            System.out.println(c[index] = Math.sqrt((lat[index]*lat[index])+(lng[index]*lng[index])));
        }
    }
     */


        //System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");

        //System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " Kilometers\n");

        //System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
}
