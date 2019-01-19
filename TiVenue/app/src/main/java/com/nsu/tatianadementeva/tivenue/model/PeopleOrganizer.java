package com.nsu.tatianadementeva.tivenue.model;

import java.util.ArrayList;

public final class PeopleOrganizer {

    public PeopleOrganizer() {

    }

    public ArrayList<Person> peoples() {
        Person person1 = new Person("Татьяна Дементьева", "t.dementeva@g.nsu.ru", "hfjkbfh");
        Person person2 = new Person("Юлия Гуля", "i.gulia@g.nsu.ru", "jhdfnvbndk");
        Person person3 = new Person("Юлия Красник", "i.krasnic@g.nsu.ru", "gvjfhdbn");

        ArrayList<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);

        return people;
    }
}
