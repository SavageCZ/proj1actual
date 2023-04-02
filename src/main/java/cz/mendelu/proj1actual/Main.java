package cz.mendelu.proj1actual;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Distance {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        var con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/proj1",
                "root",
                "secret");

        Distance distance = new Distance();
        GeometryFactory geometry = new GeometryFactory();
        System.out.println(con);
        System.out.println(distance.distance(-13, 34, 46, 25, 'K') + " Kilometers\n");
        System.out.println(distance.rectangle(-8,178));
        System.out.println(geometry.vypocet());
        System.out.println(LatLng.getAllCustomer());
    }
    /*
    function findPath(startVertex, endVertex, verticesToBeVisited, currentPath)

    // check if we have reached the destination
    if startVertex == endVertex:
     */
          /*
           * there are multiple ways of reaching the destination
           * calculate the length of the past (also called the cost)
           * if the cost is lower than the current minimum, store the path
           */
    /*
    cost = calculateCost(currentPath)
          if cost  < currentMinCost:
    currentMinCost = cost
            currentMinPath = currentPath

    else:
     */
            /*
             * if we have not reached the destination
             * we need to try all possible next hops
             * this algorithm uses recursion to do so
             */
    /*
            for every vertex Vn that is a neighbour of startVertex:

            /*
             * this check prevents us from going
             * Paris --> Rome --> Paris --> Rome (endlessly)
             */
    /*
            if currentPath contains Vn:
            continue

    // add the next hop to our path
    currentPath += Vn

    // if this vertex needed to be visited, cross it out in the list
            if verticesToBeVisited contains Vn:
    verticesToBeVisited -= Vn

        // recursion
    findPath(Vn, endVertex, verticesToBeVisited, currentPath)

    // clean up
            if verticesToBeVisited contained Vn:
    verticesToBeVisited += Vn

    currentPath -= Vn
     */
}
