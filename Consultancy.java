import java.io.Serializable;

// Class to represent Consultancy details
public class Consultancy implements Serializable {
    private String consultancyName;
    private String consultancyId;
    private ConsultancyType consultancyType;
    private String consultancyEmail;
    private String consultancyPhoneNumber;
    private String consultancyOrgName;
    private String consultancyInfo;

    // Constructor
    public Consultancy(String consultancyName, String consultancyId, ConsultancyType consultancyType,
                       String consultancyEmail, String consultancyPhoneNumber, String consultancyOrgName,
                       String consultancyInfo) {
        this.consultancyName = consultancyName;
        this.consultancyId = consultancyId;
        this.consultancyType = consultancyType;
        this.consultancyEmail = consultancyEmail;
        this.consultancyPhoneNumber = consultancyPhoneNumber;
        this.consultancyOrgName = consultancyOrgName;
        this.consultancyInfo = consultancyInfo;
    }

    // Getter methods
    public String getConsultancyName() {
        return consultancyName;
    }

    public String getConsultancyId() {
        return consultancyId;
    }

    public ConsultancyType getConsultancyType() {
        return consultancyType;
    }

    public String getConsultancyEmail() {
        return consultancyEmail;
    }

    public String getConsultancyPhoneNumber() {
        return consultancyPhoneNumber;
    }

    public String getConsultancyOrgName() {
        return consultancyOrgName;
    }

    public String getConsultancyInfo() {
        return consultancyInfo;
    }

    // toString method
    @Override
    public String toString() {
        return "Consultancy{" +
                "consultancyName='" + consultancyName + '\'' +
                ", consultancyId='" + consultancyId + '\'' +
                ", consultancyType=" + consultancyType +
                ", consultancyEmail='" + consultancyEmail + '\'' +
                ", consultancyPhoneNumber='" + consultancyPhoneNumber + '\'' +
                ", consultancyOrgName='" + consultancyOrgName + '\'' +
                ", consultancyInfo='" + consultancyInfo + '\'' +
                '}';
    }
}
