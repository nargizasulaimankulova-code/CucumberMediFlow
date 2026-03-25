package pojo;

public class CreatePatientRequest {

    private String first_name;
    private String last_name;
    private String dob;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String emergency_contact_name;
    private String emergency_contact_phone;
    private String insurance_provider;
    private String insurance_policy_number;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergency_contact_name() {
        return emergency_contact_name;
    }

    public void setEmergency_contact_name(String emergency_contact_name) {
        this.emergency_contact_name = emergency_contact_name;
    }

    public String getEmergency_contact_phone() {
        return emergency_contact_phone;
    }

    public void setEmergency_contact_phone(String emergency_contact_phone) {
        this.emergency_contact_phone = emergency_contact_phone;
    }

    public String getInsurance_provider() {
        return insurance_provider;
    }

    public void setInsurance_provider(String insurance_provider) {
        this.insurance_provider = insurance_provider;
    }

    public String getInsurance_policy_number() {
        return insurance_policy_number;
    }

    public void setInsurance_policy_number(String insurance_policy_number) {
        this.insurance_policy_number = insurance_policy_number;
    }
}
