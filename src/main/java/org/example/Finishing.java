package org.example;

public class Finishing extends Stage{
    public Finishing(int cost, String dateStart, String dateFinish, String description) {
        super(cost, dateStart, dateFinish, description);
    }

    @Override
    public String getStageName() {
        return "Отделка";
    }
}
