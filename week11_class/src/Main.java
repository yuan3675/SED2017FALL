import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        USWeatherData usWeatherData = new USWeatherData();
        AsiaWeatherData asiaWeatherData = new AsiaWeatherData();

        while((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            String command = info[0];

            if (command.equals("data")) {
                Data data = new Data(Double.parseDouble(info[2]), Double.parseDouble(info[3]), Double.parseDouble(info[4]));
                if (info[1].equals("US")) {
                    usWeatherData.addData(data);
                    usWeatherData.notifyDisplay();
                }
                else if (info[1].equals("Asia")) {
                    asiaWeatherData.addData(data);
                    asiaWeatherData.notifyDisplay();
                }
            }
            else if (command.equals("attach")) {
                if (info[1].equals("US")) {
                    if (info[2].equals("Current")) {
                        Current current = new Current();
                        usWeatherData.attach(current);
                    }
                    else if (info[2].equals("Statistics")) {
                        Statistic statistic = new Statistic();
                        usWeatherData.attach(statistic);
                    }
                    else if (info[2].equals("Forecast")) {
                        Forecast forecast = new Forecast();
                        usWeatherData.attach(forecast);
                    }
                }
                else if (info[1].equals("Asia")) {
                    if (info[2].equals("Current")) {
                        Current current = new Current();
                        asiaWeatherData.attach(current);
                    }
                    else if (info[2].equals("Statistics")) {
                        Statistic statistic = new Statistic();
                        asiaWeatherData.attach(statistic);
                    }
                    else if (info[2].equals("Forecast")) {
                        Forecast forecast = new Forecast();
                        asiaWeatherData.attach(forecast);
                    }
                }

            }
            else if (command.equals("detach")) {
                if (info[1].equals("US")) {
                    usWeatherData.detach(info[2]);
                }
                else if (info[1].equals("Asia")) {
                    asiaWeatherData.detach(info[2]);
                }
            }
        }
    }
}
