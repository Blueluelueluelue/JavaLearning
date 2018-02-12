import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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

public class Main extends Application
{
    private Label whenAnswerLabel;
    private Label latlongAnswerLabel;
    private Label magnitudeAnswerLabel;
    private Label detailsAnswerLabel;
    private ArrayList<Quake> earthquakes;
    private int count = 0;
    private SimpleDateFormat df = new SimpleDateFormat("HH:MM");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label whenLabel = new Label("When");
        whenLabel.setMinWidth(50);
        Label latlongLabel = new Label("Latitude / Longitude");
        latlongLabel.setMinWidth(200);
        Label magnitudeLabel = new Label("Magnitude");
        magnitudeLabel.setMinWidth(50);
        Label detailsLabel = new Label("Details");
        detailsLabel.setMinWidth(300);

        whenAnswerLabel = new Label();
        whenAnswerLabel.setMinWidth(50);
        latlongAnswerLabel = new Label();
        latlongAnswerLabel.setMinWidth(200);
        magnitudeAnswerLabel = new Label();
        magnitudeAnswerLabel.setMinWidth(50);
        detailsAnswerLabel = new Label();
        detailsAnswerLabel.setMinWidth(300);

        Button updateButton = new Button("Update Feed");
        updateButton.setOnAction( e -> updateFeed());

        Button clearButton = new Button("Clear Feed");
        clearButton.setOnAction(e -> clearFeed());

        HBox topLabels = new HBox(10);
        topLabels.setAlignment(Pos.CENTER);
        topLabels.setPadding(new Insets(20));
        topLabels.getChildren().addAll(whenLabel,latlongLabel, magnitudeLabel, detailsLabel);

        HBox bottomLabels = new HBox(10);
        bottomLabels.setAlignment(Pos.CENTER);
        bottomLabels.setPadding(new Insets(20));
        bottomLabels.getChildren().addAll(whenAnswerLabel, latlongAnswerLabel, magnitudeAnswerLabel, detailsAnswerLabel);

        HBox buttons = new HBox(20);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(updateButton, clearButton);

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.getChildren().addAll(topLabels, bottomLabels, buttons);

        Scene scene = new Scene(layout, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.show();


        earthquakes = getQuakes("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.atom");
    }


    private void updateFeed() {

        if (count < earthquakes.size()) {
            Quake current = earthquakes.get(count);
            String time = df.format(current.getDate());
            whenAnswerLabel.setText(time + "\n" + whenAnswerLabel.getText());

            String location = current.getLocation();
            latlongAnswerLabel.setText(location + "\n"  + latlongAnswerLabel.getText());

            double magnitude = current.getMagnitude();
            magnitudeAnswerLabel.setText(magnitude + "\n"  + magnitudeAnswerLabel.getText());

            String details = current.getDetails();
            detailsAnswerLabel.setText(details + "\n" + detailsAnswerLabel.getText());

            count++;
        } else {
            AlertBox.display("Run Out", "No more earthquakes to show");
        }
    }

    private void clearFeed() {
        whenAnswerLabel.setText("");
        latlongAnswerLabel.setText("");
        magnitudeAnswerLabel.setText("");
        detailsAnswerLabel.setText("");
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
