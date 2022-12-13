package entity;

public class Plane {
    private int planeCode;
    private int flight;
    private String type;

    public Plane() {
    }

    public Plane(int planeCode, int flight, String type) {
        this.planeCode = planeCode;
        this.flight = flight;
        this.type = type;
    }

    public int getPlaneCode() {
        return this.planeCode;
    }

    public void setPlaneCode(int planeCode) {
        this.planeCode = planeCode;
    }

    public int getFlight() {
        return this.flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
