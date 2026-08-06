package model;

public class Incident {

    private String short_description;
    private String description;

    public Incident() {
    }

    public Incident(String short_description, String description) {
        this.short_description = short_description;
        this.description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}