package org.example;

public class Walls extends Stage{
    public Walls(int cost, String dateStart, String dateFinish, String description) {
        super(cost, dateStart, dateFinish, description);
    }

    @Override
    public String getStageName() {
        return "Стены";
    }
}
