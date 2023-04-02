package cz.mendelu.proj1actual;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.util.GeometricShapeFactory;

import javax.management.Query;
import java.util.List;


public class GeometryFactory{
        double vypocet() {
                double y1 = -8 * 60 * 1.852;
                double x1 = 178 * 60 * 1.852 / (Math.cos(-8));
                double y2 = -20 * 60 * 1.852;
                double x2 = -175 * 60 * 1.852 / (Math.cos(-20));
                double d = Math.sqrt((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
                return d;
        }
}