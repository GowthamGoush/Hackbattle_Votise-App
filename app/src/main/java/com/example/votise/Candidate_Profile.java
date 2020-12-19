package com.example.votise;

public class Candidate_Profile {
    private String Name;
    private String Gender;
    private String Party;
    private String Info1;
    private String Info2;
    private String Info3;
    private String ImageUrl;
    private Boolean Expanded;

    public Candidate_Profile(String name, String gender, String party, String info1, String info2, String info3, String imageUrl) {
        Name = name;
        Party = party;
        Gender = gender;
        Info1 = info1;
        Info2 = info2;
        Info3 = info3;
        ImageUrl = imageUrl;
        Expanded = false;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getParty() {
        return Party;
    }

    public void setParty(String party) {
        Party = party;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getInfo1() {
        return Info1;
    }

    public void setInfo1(String info1) {
        Info1 = info1;
    }

    public String getInfo2() {
        return Info2;
    }

    public void setInfo2(String info2) {
        Info2 = info2;
    }

    public String getInfo3() {
        return Info3;
    }

    public void setInfo3(String info3) {
        Info3 = info3;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Boolean getExpanded() {
        return Expanded;
    }

    public void setExpanded(Boolean expanded) {
        Expanded = expanded;
    }
}
