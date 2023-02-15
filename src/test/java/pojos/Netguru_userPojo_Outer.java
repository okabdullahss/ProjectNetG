package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Netguru_userPojo_Outer {

   private String createdBy;
   private String createdDate;
   private Integer id;
   private String firstName;
   private String lastName;
   private String birthDate;
   private String phone;
   private String gender;
   private String bloodGroup;
   private String adress;
   private String email;
   private String description;

   private Netguru_userPojo_Inner user;


   private String appointments;
   private String inPatients;
   private String country;
   private String cstate;

   public Netguru_userPojo_Outer(String createdBy, String createdDate, Integer id, String firstName, String lastName, String birthDate, String phone, String gender, String bloodGroup, String adress, String email, String description, Netguru_userPojo_Inner user, String appointments, String inPatients, String country, String cstate) {
      this.createdBy = createdBy;
      this.createdDate = createdDate;
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthDate = birthDate;

      this.phone = phone;
      this.gender = gender;

      this.bloodGroup = bloodGroup;
      this.adress = adress;
      this.email = email;
      this.description = description;
      this.user = user;
      this.appointments = appointments;
      this.inPatients = inPatients;
      this.country = country;
      this.cstate = cstate;
   }


   public Netguru_userPojo_Outer() {
   }

   public String getCreatedBy() {
      return createdBy;
   }

   public void setCreatedBy(String createdBy) {
      this.createdBy = createdBy;
   }

   public String getCreatedDate() {
      return createdDate;
   }

   public void setCreatedDate(String createdDate) {
      this.createdDate = createdDate;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(String birthDate) {
      this.birthDate = birthDate;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public String getBloodGroup() {
      return bloodGroup;
   }

   public void setBloodGroup(String bloodGroup) {
      this.bloodGroup = bloodGroup;
   }

   public String getAdress() {
      return adress;
   }

   public void setAdress(String adress) {
      this.adress = adress;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Netguru_userPojo_Inner getUser() {
      return user;
   }

   public void setUser(Netguru_userPojo_Inner user) {
      this.user = user;
   }

   public String getAppointments() {
      return appointments;
   }

   public void setAppointments(String appointments) {
      this.appointments = appointments;
   }

   public String getInPatients() {
      return inPatients;
   }

   public void setInPatients(String inPatients) {
      this.inPatients = inPatients;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getCstate() {
      return cstate;
   }

   public void setCstate(String cstate) {
      this.cstate = cstate;
   }

   @Override
   public String toString() {
      return "US02_userPojo_Outer{" +
              "createdBy='" + createdBy + '\'' +
              ", createdDate='" + createdDate + '\'' +
              ", id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", birthDate='" + birthDate + '\'' +
              ", phone='" + phone + '\'' +
              ", gender='" + gender + '\'' +
              ", bloodGroup='" + bloodGroup + '\'' +
              ", adress='" + adress + '\'' +
              ", email='" + email + '\'' +
              ", description='" + description + '\'' +
              ", user=" + user +
              ", appointments='" + appointments + '\'' +
              ", inPatients='" + inPatients + '\'' +
              ", country='" + country + '\'' +
              ", cstate='" + cstate + '\'' +
              '}';
   }

/*
    {
    "createdBy": "hastaabdno2",
    "createdDate": "2022-11-19T11:26:24.886507Z",
    "id": 310846,
    "firstName": "hastaAbdNo2",
    "lastName": "lastname",
    "birthDate": null,
    "phone": "333-333-3333",
    "gender": null,
    "bloodGroup": null,
    "adress": null,
    "email": "hastaabdno2@hastaabdno2.com",
    "description": null,
    "user": {
        "createdBy": "anonymousUser",
        "createdDate": "2022-11-19T11:21:58.297153Z",
        "id": 310937,
        "login": "hastaabdno2",
        "firstName": "hastaAbdNo2",
        "lastName": "lastname",
        "email": "hastaabdno2@hastaabdno2.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null,
        "ssn": "500-33-0004"
    },
    "appointments": null,
    "inPatients": null,
    "country": null,
    "cstate": null
}
     */
}
