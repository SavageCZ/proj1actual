package cz.mendelu.proj1actual;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.*;

public class LatLng {
    public static void main(String[] args) throws Exception {
        // A random lat/long
        double[] target = randLatLong();
        // Transform to ECEF vector
        double[] targetv = toEcef(target);
        // 250 random candidates
        List<double[]> b = new ArrayList<>();
        for (long count = 250; count > 0; count--) {
            double[] doubles = randLatLong();
            b.add(doubles);
        }
        // Transform candidates to ECEF representation
        List<double[]> bv = b.stream().map(LatLng::toEcef).collect(Collectors.toList());

        // Find the closest candidate to the target
        int i = closest(targetv, bv);

        System.out.println("Closest point to " + target[0] + ", " + target[1] + " is " + b.get(i)[0] + ", " + b.get(i)[1]);
    }

    // index of closest vector to target from list of candidates
    public static int closest(double[] target, List<double[]> candidates) {
        double p = Double.MIN_VALUE;
        int closest = -1;
        for (int i = 0; i < candidates.size(); i++) {
            double next = dotProduct(target, candidates.get(i));
            if (next > p) {
                p = next;
                closest = i;
            }
        }
        return closest;
    }

    // dot product of two 3vectors
    public static double dotProduct(double[] v1, double[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
    }

    // lat/long in degrees to normalised ECEF vector
    public static double[] toEcef(double[] latLong) {
        return toEcef(toRadians(latLong[0]), toRadians(latLong[1]));
    }

    // lat/long in radians to normalised ECEF vector
    public static double[] toEcef(double φ, double λ) {
        return new double[] {cos(φ) * cos(λ), cos(φ) * sin(λ), sin(φ)};
    }

    // A random lat/long
    public static double[] randLatLong() throws SQLException, ClassNotFoundException {

        return new double[] {Math.random() * 180 - 90, Math.random() * 360 - 180};
    }

    public static ArrayList<Countries> getAllCustomer() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        var con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/proj1",
                "root",
                "secret");
        Statement stm;
        stm = con.createStatement();
        String sql = "Select * From countries";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Countries> customerList = new ArrayList<>();
        while (rst.next()) {
            Countries customer = new Countries(rst.getDouble("lat"), rst.getDouble("lng"));
            customerList.add(customer);
        }
        return customerList;
    }

}