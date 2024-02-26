import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class City {
    int id;
    double x;
    double y;

    public City(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;

    }

    public double distanceTo(City other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public int visit() {

        return this.id;
    }

    @Override
    public String toString() {

        return "City [id=" + id + "]";
    }

    public static ArrayList<City> fetchCities(String filename) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();

        while (!line.equals("NODE_COORD_SECTION")) {
            line = reader.readLine();
        }
        line = reader.readLine();

        ArrayList<City> coordinates = new ArrayList<>();

        while (!line.equals("EOF")) {

            String[] values = line.split(" ");
            coordinates.add(new City(Integer.parseInt(values[0]), Double.parseDouble(values[1]),
                    Double.parseDouble(values[2])));
            line = reader.readLine();
        }
        reader.close();

        return coordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}