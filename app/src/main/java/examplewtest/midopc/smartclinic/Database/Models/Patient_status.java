package examplewtest.midopc.smartclinic.Database.Models;

/**
 * Created by Mido PC on 4/16/2016.
 */


//next_visit TEXT,FOREIGN KEY(p_Id) REFERENCES Patients(id))");

public class Patient_status {

    private int id;
    private int pId;
    private String sDate;
    private String sTime;
    private String bloodPressure;
    private String diabetesRate;
    private String weight;
    private String temp;
    private String doctorNotes;
    private String reqAnalyzes;
    private String xRayReq;
    private String drug;
    private String nextVisit;

    public String getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(String nextVisit) {
        this.nextVisit = nextVisit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getDiabetesRate() {
        return diabetesRate;
    }

    public void setDiabetesRate(String diabetesRate) {
        this.diabetesRate = diabetesRate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public String getReqAnalyzes() {
        return reqAnalyzes;
    }

    public void setReqAnalyzes(String reqAnalyzes) {
        this.reqAnalyzes = reqAnalyzes;
    }

    public String getxRayReq() {
        return xRayReq;
    }

    public void setxRayReq(String xRayReq) {
        this.xRayReq = xRayReq;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }
}
