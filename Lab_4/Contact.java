/*Лёгкий Андрей, 2 курс 5 группа.

Задача: Модифицировать условие задачи учитывая свои пожелания
Возможно  авторское условие задачи
Использовать контейнеры:
 Vector, ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap.)

1) Задача "контакты"
а) разработать класс Контакт, определяющий запись в электронной книге мобильного
телефона и содержащий по меньшей мере следующие поля:
- *Наименование (имя человека или организации)
- *Номер телефона мобильного
- Номер телефона рабочего
- Номер телефона (домашнего)
- Адрес электронной почты
- Адрес веб-страницы
- Адрес

Обязательными является поля помеченные *, остальные поля могут быть пустыми

б) класс Контакт должен реализовать:
-интерфейс Comparable и Comparator с возможностью выбора одного из полей для сравнения
-интерфейс Iterator - индексатор по всем полям объекта Контакт
-метод для сохранения значений всех полей в строке текста (переопределить toString())
-конструктор или метод для инициализации объекта из строки текста

в) Для тестирования класса Контакт, создать консольное приложение позволяющее
создать небольшой массив контактов и напечатать отсортированными по
выбранному полю.*/
package org.example;
import java.util.*;
public class Contact implements Comparable<Contact>, Iterable<String> {
    private String name;
    private String mobile;
    private String workPhone;
    private String homePhone;
    private String email;
    private String website;
    private String address;

    public Contact(String name, String mobile, String workPhone, String homePhone, String email, String website, String address) {
        this.name = name;
        this.mobile = mobile;
        this.workPhone = workPhone;
        this.homePhone = homePhone;
        this.email = email;
        this.website = website;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Mobile: %s, Work: %s, Home: %s, Email: %s, Website: %s, Address: %s",
                name, mobile, workPhone, homePhone, email, website, address);
    }

    public static Contact fromString(String data) {
        String[] fields = data.split(", ");
        return new Contact(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            private final String[] fields = {name, mobile, workPhone, homePhone, email, website, address};

            @Override
            public boolean hasNext() {
                return index < fields.length;
            }

            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                return fields[index++];
            }
        };
    }
}
class NameComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getName().compareTo(c2.getName());
    }
}

class MobileComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact c1, Contact c2) {
        return c1.getMobile().compareTo(c2.getMobile());
    }
}


