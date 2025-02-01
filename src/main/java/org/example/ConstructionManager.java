package org.example;

public class ConstructionManager implements Construction{
    private Stage firstStage;

    public ConstructionManager() {

        Stage project = new Project(10000, "01.01.2021", "10.01.2021", "Проектирование");
        Stage foundation = new Foundation(20000, "11.01.2021", "20.01.2021", "Заливка фундамента");
        Stage walls = new Walls(30000, "21.01.2021", "30.01.2021", "Возведение стен");
        Stage roof = new Roof(15000, "31.01.2021", "05.02.2021", "Установка крыши");
        Stage finishing = new Finishing(25000, "06.02.2021", "15.02.2021", "Отделка");

        // Организуем двунаправленную связь между этапами
        project.setNextStage(foundation);
        foundation.setPrevStage(project);

        foundation.setNextStage(walls);
        walls.setPrevStage(foundation);

        walls.setNextStage(roof);
        roof.setPrevStage(walls);

        roof.setNextStage(finishing);
        finishing.setPrevStage(roof);

        firstStage = project;
    }

    @Override
    public boolean startConstruction() {
        Stage currentStage = firstStage;
        while (currentStage != null) {
            currentStage.start();
            if (currentStage.getStatus() == StageStatus.REJECTED) {
                // Если этап забракован, проверяем: если проект – отмена строительства, иначе возвращаемся к предыдущему этапу.
                if (currentStage.prev() == null) {
                    System.out.println("Проект забракован. Стройка отменяется.");
                    return false;
                } else {
                    currentStage = currentStage.prev();
                    System.out.println("Возврат к предыдущему этапу: " + currentStage.getStageName());
                    continue; // переходим к следующей итерации цикла
                }
            }
            // Если этап завершён успешно, переходим к следующему.
            currentStage = currentStage.next();
        }
        finishConstruction();
        return true;
    }

    @Override
    public void finishConstruction() {
        System.out.println("Стройка успешно завершена!");
    }
}

