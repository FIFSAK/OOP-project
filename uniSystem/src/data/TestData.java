package data;

import users.*;
import researcher.*;
import enums.*;



public class TestData {

	public static void main(String[] args) {
        // Создаем несколько объектов для тестирования
        User user1 = new User("user1", "password1");
        Student student1 = new Student("student1", "password1");
        Teacher teacher1 = new Teacher("teacher1", "password1");

        // Получаем экземпляр Data
        Data data = Data.getInstance();

        // Добавляем объекты в базу данных
        data.getAllUsers().add(user1);
        data.getAllStudent().add(student1);
        data.getAllTeacher().add(teacher1);
        
     // Выводим информацию о пользователях после десериализации
        System.out.println("Users after deserialization:");
        for (User user : data.getAllUsers()) {
            System.out.println(user);
        }

        // Попробуем также получить всех студентов и преподавателей
        System.out.println("\nStudents after deserialization:");
        for (Student student : data.getAllStudent()) {
            System.out.println(student);
        }

        System.out.println("\nTeachers after deserialization:");
        for (Teacher teacher : data.getAllTeacher()) {
            System.out.println(teacher);
        }

        // Сохраняем в файл
        data.saveToFile("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\datas.out");

        // Обнуляем экземпляр Data, чтобы проверить восстановление
        data = null;

        // Загружаем из файла
        data = Data.loadFromFile("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\datas.out");

        // Выводим информацию о пользователях после десериализации
        System.out.println("Users after deserialization:");
        for (User user : data.getAllUsers()) {
            System.out.println(user);
        }

        // Попробуем также получить всех студентов и преподавателей
        System.out.println("\nStudents after deserialization:");
        for (Student student : data.getAllStudent()) {
            System.out.println(student);
        }

        System.out.println("\nTeachers after deserialization:");
        for (Teacher teacher : data.getAllTeacher()) {
            System.out.println(teacher);
        }
    }
}
