package org.example;

import java.util.regex.Pattern;

// Забраковать - этот метод запускается с шансом 10% и возращает стройку на предыдущий этап
// Если стройка была забракована на этапе проекта, то она отменяется
public abstract class Stage implements StageControl{
    int cost;
    String dateStart;
    String dateFinish;
    String description;
    StageStatus status = StageStatus.PLANNED;
    Stage nextStage;
    Stage prevStage;

    private static Pattern date = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4}$");

    public Stage(int cost, String dateStart, String dateFinish, String description) {
        if (!date.matcher(dateStart).matches()) {
            throw new InvalidDateFormatException("Неверный формат даты начала: " + dateStart);
        }
        if (!date.matcher(dateFinish).matches()) {
            throw new InvalidDateFormatException("Неверный формат даты завершения: " + dateFinish);
        }
        this.cost = cost;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.description = description;
        this.status = StageStatus.PLANNED;
    }

    @Override
    public Stage next(){
        return nextStage;
    };

    @Override
    public Stage prev(){
        return prevStage;
    };

    public void setNextStage(Stage next) {
        this.nextStage = next;
    }

    public void setPrevStage(Stage prev) {
        this.prevStage = prev;
    }

    public void reject(){
        this.status = StageStatus.REJECTED;
        System.out.println(getStageName() + " забракован.");
    }

    @Override
    public void start(){
        System.out.println("Начало этапа: " + getStageName());
        this.status = StageStatus.IN_PROGRESS;
        // Симуляция: 10% вероятность брака этапа
        if (Math.random() < 0.1) {
            reject();
            return;
        }
        stop();
    };

    @Override
    public void stop(){
        this.status = StageStatus.COMPLETED;
        System.out.println("Этап " + getStageName() + " успешно завершен.");
    };

    public StageStatus getStatus() {
        return this.status;
    }

    public abstract String getStageName();
}
