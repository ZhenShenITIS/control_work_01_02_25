package org.example;

public class Project extends Stage{
    public Project(int cost, String dateStart, String dateFinish, String description) {
        super(cost, dateStart, dateFinish, description);
    }

    @Override
    public String getStageName() {
        return "Проект";
    }
}
