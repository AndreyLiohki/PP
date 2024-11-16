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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.Contact.*;
public class Main {
    public static void main(String[] args) {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Oliver", "1-123-45-67", "1-21-34", "1-98-76", "oliver@example.com", "www.oliver.com", "Main St, 101"));
        contactList.add(new Contact("Liam", "2-234-56-78", "2-32-45", "2-87-65", "liam@example.com", "www.liam.com", "Second St, 202"));
        contactList.add(new Contact("Emma", "3-345-67-89", "3-43-56", "3-76-54", "emma@example.com", "www.emma.com", "Third St, 303"));

        System.out.println("Contacts before sorting:");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }

        Collections.sort(contactList, new NameComparator());

        System.out.println("\nContacts sorted by name:");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }

        Collections.sort(contactList, new MobileComparator());

        System.out.println("\nContacts sorted by mobile number:");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }

    }
}