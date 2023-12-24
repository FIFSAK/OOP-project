package course;

import users.*;
import enums.*;

import java.util.ArrayList;
import java.util.List;

import additional.*;
import course.*;

public class Lesson {
    private LessonType lessonType;
    private int duration; // Продолжительность одного урока (в минутах)
    private int frequency; // Сколько раз в неделю проводится урок
    private List<DayOfWeek> schedule; // Расписание уроков
    private int totalDuration; // Общая продолжительность в неделю (в минутах)

    public Lesson(LessonType lessonType, int duration, int frequency, List<DayOfWeek> schedule) {
        this.lessonType = lessonType;
        this.duration = duration;
        this.frequency = frequency;
        this.schedule = new ArrayList<>(schedule);
        calculateTotalDuration();
    }

    // Геттеры и сеттеры

    public LessonType getLessonType() {
        return lessonType;
    }

    public int getDuration() {
        return duration;
    }

    public int getFrequency() {
        return frequency;
    }

    public List<DayOfWeek> getSchedule() {
        return new ArrayList<>(schedule);
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    // Метод для вычисления общей продолжительности
    private void calculateTotalDuration() {
        totalDuration = duration * frequency;
    }
}