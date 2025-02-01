package org.example;

public class Foundation extends Stage{
    public Foundation(int cost, String dateStart, String dateFinish, String description) {
        super(cost, dateStart, dateFinish, description);
    }

    @Override
    public String getStageName() {
        return "Фундамент";
    }
}
