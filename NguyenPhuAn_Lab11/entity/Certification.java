package entity;

public class Certification {
    private String empCode;
    private int planeCode;

    public Certification() {
    }

    public Certification(String empCode, int planeCode) {
        this.empCode = empCode;
        this.planeCode = planeCode;
    }

    public String getEmpCode() {
        return this.empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public int getPlaneCode() {
        return this.planeCode;
    }

    public void setPlaneCode(int planeCode) {
        this.planeCode = planeCode;
    }
}

