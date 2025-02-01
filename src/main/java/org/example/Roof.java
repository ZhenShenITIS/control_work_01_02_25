package org.example;

public class Roof extends Stage{
    public Roof(int cost, String dateStart, String dateFinish, String description) {
        super(cost, dateStart, dateFinish, description);
    }

    @Override
    public String getStageName() {
        return "Крыша";
    }
}
