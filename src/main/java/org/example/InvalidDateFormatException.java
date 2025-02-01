package org.example;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException(String message) {
        super(message);
    }

  public InvalidDateFormatException() {
    super("Неверный формат даты");
  }
}
