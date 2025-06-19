package it.vito.progettoDistributori.Util;

import it.vito.progettoDistributori.model.Point;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class UtilsPoint {

    static final double RAGGIO_MEDIA_TERRA = 6371e3; //in km

    public static boolean pointInPolygon(Point point, List<Point> polygon) {
        Path2D path = new Path2D.Double();

        // Move to the first point in the polygon
        path.moveTo(polygon.get(0).getX(), polygon.get(0).getY());

        // Connect the points in the polygon
        for (int i = 1; i < polygon.size(); i++) {
            path.lineTo(polygon.get(i).getX(), polygon.get(i).getY());
        }

        // Close the path
        path.closePath();

        // Create a Point2D object for the test point
        Point2D testPoint = new Point2D.Double(point.getX(), point.getY());

        // Check if the test point is inside the polygon
        return path.contains(testPoint);

    }

    public static double calculateDistanceBetweenPoints(Point point1, Point point2) {

        return Math.sqrt((point2.getY() - point1.getY()) * (point2.getY() - point1.getY()) + point2.getX() - point1.getX() * point2.getX() - point1.getX());
    }


    public static double calculateDistanceBetweenPointsFromHaversineFormula(Point point1, Point point2) {

        Double lat1 = point1.getX();
        Double lon1 = point1.getY();
        Double lat2 = point2.getX();
        Double lon2 = point2.getY();

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

    public static List<Point> pointsFromCenter(Point point, Double radius) {

        // radius m - the following code is an approximation that stays reasonably accurate for distances < 100km
        Double lat0 = point.getY(); // latitude of circle center, decimal degrees
        Double lon0 = point.getX(); // Longitude of circle center, decimal degrees

        // parameters
        int N = 10; // number of discrete sample points to be generated along the circle

        // generate points
        List<Point> circlePoints = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            //compute
            double angle = Math.PI * 2 * i / N;
            double dx = radius * Math.cos(angle);
            double dy = radius * Math.sin(angle);
            Point pointCircle = new Point();
            pointCircle.setY(lat0 + (180 / Math.PI) * (dy / 6378137));
            pointCircle.setX(lon0 + (180 / Math.PI) * (dx / 6378137) / Math.cos(lat0 * Math.PI / 180));
            //add to list
            circlePoints.add(pointCircle);
        }
        return circlePoints;
    }

}
