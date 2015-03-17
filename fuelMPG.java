/**
 * Created by bubba on 3/10/2015.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class fuelMpg {
    private double _overallMpg;
    private double averageCostPerGallon;
    private double _tankMpg;
    private double _tankMiles;
    private double _totalMiles;
    private double _costPerGallon;
    private double _costThisFillUp;
    private String _gasStationName;

    public void fuelMpg() {
        _costPerGallon = 0.0;
        _costThisFillUp = 0.0;
        _gasStationName = "";
        _overallMpg = 0.0;
        _tankMiles = 0.0;
        _totalMiles = 0.0;
        _tankMpg = 0.0;

    }

    public void fillUp(double newMiles, double newCost, double gallonsThisFillUp, String gasStation) {
        _tankMiles = newMiles;
        _costThisFillUp = newCost;
        _gasStationName = gasStation;
        _tankMpg = newMiles / gallonsThisFillUp;
        _costPerGallon = newMiles / newCost;
    }

    public void setTankMpg(double milesThisTank, double gallonsThisTank) {
        _tankMpg = milesThisTank / gallonsThisTank;
        _totalMiles = +milesThisTank;
    }

    public void setGasStationName(String gasStation) {
        _gasStationName = gasStation;
    }

    public double get_overallMpg() {
        return _overallMpg;
    }a

    public double get_tankMpg() {
        return _tankMpg;
    }

    public double get_tankMiles() {
        return _tankMiles;
    }

    public double get_totalMiles() {
        return _totalMiles;
    }

    public boolean writeToFile() {
        String dataToWrite = new String();
        Date todaysFillup;
        todaysFillup = new Date();

        dataToWrite += todaysFillup.toString() + ":" + _costPerGallon + ":" + _costThisFillUp + ":" +
                _gasStationName + ":" + _overallMpg + ":" + _tankMiles + ":" + _totalMiles + ":" + _tankMpg;

        try {
            File file = new File("trackMpg.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(dataToWrite);
            output.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }
}
