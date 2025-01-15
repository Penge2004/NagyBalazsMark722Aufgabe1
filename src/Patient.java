import java.time.LocalDate;
import java.util.Objects;

public class Patient {
    private int id;
    private String patientName;
    private String symptoms;
    private String diagnose;
    private LocalDate datum;
    private String hospital;

    public Patient(int id, String patientName, String symptoms, String diagnose,
                   LocalDate datum, String hospital) {
        this.id = id;
        this.patientName = patientName;
        this.symptoms = symptoms;
        this.diagnose = diagnose;
        this.datum = datum;
        this.hospital = hospital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnose='" + diagnose + '\'' +
                ", datum=" + datum +
                ", hospital='" + hospital + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return patientName.equals(patient.patientName); // Compare by Name
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientName); // Hash by Name
    }
}
