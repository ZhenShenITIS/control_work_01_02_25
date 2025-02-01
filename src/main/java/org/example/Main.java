package org.example;

public class Main {
    public static void main(String[] args) {
        int n = 1000;
        int successCount = 0;
        for (int i = 0; i < n; i++) {
            ConstructionManager manager = new ConstructionManager();
            boolean success = manager.startConstruction();
            if (success) {
                successCount++;
            }
            System.out.println();
        }
        double percent = (successCount/(double)n)*100;
        System.out.println("Вероятность успешного завершения: " + percent + " процентов");

        testInvalidDateFormat();
    }

    private static void testInvalidDateFormat() {
        System.out.println("Тестирование неверного формата даты:");
        try {
            Stage testStage = new Project(10000, "32.01.2021", "100.01.2021", "Тестовый проект");
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }
}