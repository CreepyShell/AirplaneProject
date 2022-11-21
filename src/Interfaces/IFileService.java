package Interfaces;

import org.json.simple.JSONObject;

public interface IFileService {
    public String getLocationFile();

    public String getRouteFile();

    public String getTicketFile();

    public String getPlaneFile();

    public String getUserFile();

    boolean writeInFile(String text, String fileName);

    String readFromFile(String fileName);
}
