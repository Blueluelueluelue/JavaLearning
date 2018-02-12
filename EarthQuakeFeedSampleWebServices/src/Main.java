import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Main
{
    public static void main(String[] args) {
        ArrayList<Quake> earthquakes = getQuakes("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.atom");

        SimpleDateFormat df = new SimpleDateFormat("HH:MM");
        System.out.printf("%s\t%-35s\t%s\t%s\n","WHEN", "LAT / LONG", "MAGNITUDE", "DETAILS");
        for(Quake q: earthquakes) {
            System.out.printf("%s\t%-35s\t%8.2f\t%s\n", df.format(q.getDate()), q.getLocation(), q.getMagnitude(), q.getDetails());
        }
    }

    /*
    STEP 1 - Make HTTP web request to Earthquake feed
    STEP 2 - Parse the Text response stream as XML
    STEP 3 - Enumerate over XML extracting out the data we need
    STEP 4 - Create Quake object and add it to quakes collection
     */
    private static ArrayList<Quake> getQuakes(String url) {
        ArrayList<Quake> quakes = new ArrayList<>();

        try {
            URL eqCenterUrl = new URL(url);
            URLConnection connection = eqCenterUrl.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection)connection;
            int responseCode = httpConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) {
                InputStream in = httpConnection.getInputStream();

                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();

                Document dom = db.parse(in);
                NodeList nl = dom.getElementsByTagName("entry");

                if(nl != null && nl.getLength() > 0) {
                    for( int i = 0; i < nl.getLength(); i++) {
                        Element entry = (Element) nl.item(i);
                        Element title = (Element) entry.getElementsByTagName("title").item(0);

                        //this stores the latitude and longitude information
                        Element g = (Element) entry.getElementsByTagName("georss:point").item(0);

                        Element when = (Element) entry.getElementsByTagName("updated").item(0);
                        Element link = (Element) entry.getElementsByTagName("link").item(0);

                        String details = title.getFirstChild().getNodeValue();
                        String hostname = "http://earthquake.usgs.gov";
                        String linkString = hostname + link.getAttribute("href");
                        String point = g.getFirstChild().getNodeValue();
                        String dt = when.getFirstChild().getNodeValue();

                        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
                        Date qdate = sdFormat.parse(dt);

                        String[] locationPair = point.split(" ");
                        String location = "Lat: " + locationPair[0] + " Long: " + locationPair[1];

                        String magnitudeString = details.split(" ")[1];
                        double magnitude = Double.parseDouble(magnitudeString);

                        details = details.split("-")[1].trim();

                        Quake q = new Quake(qdate, details, location, magnitude, linkString);
                        quakes.add(q);
                    }
                }

            }
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            System.out.printf("Line 39 gave : %s", e);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.printf("Line 40 or 42 gave : %s", e);
        } catch (ParserConfigurationException e) {
            //e.printStackTrace();
            System.out.printf("Line 48 gave : %s", e);
        } catch (SAXException e) {
            //e.printStackTrace();
            System.out.printf("Line 50 gave : %s", e);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.printf("Line 78 gave : %s", e);
        }

        return quakes;
    }
}
