
package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    // Генирируем дату
    public static String generateDate(int shift) {

        LocalDate date = LocalDate.now().plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }

    // Генерируем город, создаем массив городов и выбираем рандомный город с помощью класса Random.
    public static String generateCity(String locale) {
        String[] cities = new String[]

                {"Москва", "Санкт-Петербург", "Казань", "Нижний Новгород", "Екатеринбург", "Челябинск",
                        "Омск", "Ростов-на-Дону", "Уфа", "Красноярск", "Воронеж", "Саратов", "Самара",
                        "Иркутск", "Томск", "Хабаровск", "Владивосток", "Архангельск", "Калуга", "Ярославль",
                        "Краснодар", "Тула", "Пенза", "Тюмень", "Чебоксары", "Астрахань",
                        "Ульяновск", "Петрозаводск", "Великий Новгород", "Саранск", "Орёл", "Липецк",
                        "Курск", "Киров", "Рязань", "Смоленск", "Благовещенск", "Иваново", "Таганрог",
                        "Батайск", "Ставрополь", "Нальчик", "Махачкала", "Назрань", "Грозный", "Астрахань", "Владимир", "Волгоград"};
        return cities[new Random().nextInt(cities.length)];
    }

    // Генерируем имя пользователя с использованием Faker
    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));

        return faker.name().lastName() + " " + faker.name().firstName();
    }

    // Генерируем номер телефона с использованием Faker
    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        // Генерируем пользователя используя методы
        public static UserInfo generateUser(String locale) {

            String city = DataGenerator.generateCity(locale);
            String name = DataGenerator.generateName(locale);
            String phone = DataGenerator.generatePhone(locale);
            return new UserInfo(city, name, phone);
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}


