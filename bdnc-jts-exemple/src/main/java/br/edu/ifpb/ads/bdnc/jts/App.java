package br.edu.ifpb.ads.bdnc.jts;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 * @version 1.0
 * @author Wensttay de Sousa Alencar <yattsnew@gmail.com>
 * @date 07/01/2017 - 12:01:31
 */
public class App {

    public static void main(String[] args) throws ParseException {
        WKTReader kTReader = new WKTReader();
        Geometry g1 = kTReader.read("Point(1 1)");
        Geometry g2 = kTReader.read("Polygon((1 1, 1 2 , 2 2, 2 1, 1 1))");
        System.out.println(g1.touches(g2));
    }
}
