package com.lab1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner read = new Scanner(System.in);
        MyList<Person> persons = new MyArrayList<>();
        persons.add(new Person("John", 25));
        persons.add(new Person("Mary", 16));
        persons.add(new Person("Anna", 25));
        persons.add(new Person("Zayn", 35));

        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Person("John", 25));
        persons1.add(new Person("Mary", 16));
        persons1.add(new Person("Anna", 25));
        persons1.add(new Person("Zayn", 35));
        ArrayList<Person> p=new ArrayList<>();

        while (flag) {
            System.out.println("\n 1 - Add new person \n 2 - Show the list of persons \n 3 - Remove person" +
                    "\n 4 - Get person \n 5 - Set person \n 6 - Get list of persons in the interval" +
                    "\n 7 - Get index of person \n 8 - Get the last index of person \n 9 - Check emptiness of the list" +
                    "\n 10 - Check the availability \n 11 - Check speed \n 12 - Exit");
            String choice = read.next();
            switch (choice) {
                case "1":
                    System.out.println("Name: ");
                    String name = read.next();
                    System.out.println("Age: ");
                    String age = read.next();
                    if (isDigit(age)) {
                        persons.add(new Person(name, Integer.parseInt(age)));
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "2":
                    for (int i = 0; i < persons.size(); i++) {
                        System.out.println(persons.get(i).getName() + " " + persons.get(i).getAge());
                    }
                    break;
                case "3":
                    System.out.println("Enter index: ");
                    String ind = read.next();
                    if (isDigit(ind)) {
                        persons.remove(Integer.parseInt(ind));
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "4":
                    System.out.println("Enter index: ");
                    ind = read.next();
                    if (isDigit(ind)) {
                        System.out.println(persons.get(Integer.parseInt(ind)).getName()+" "
                                +persons.get(Integer.parseInt(ind)).getAge());
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "5":
                    System.out.println("Enter index: ");
                    ind = read.next();
                    if (isDigit(ind)) {
                        System.out.println("Name: ");
                        String name1 = read.next();
                        System.out.println("Age: ");
                        age = read.next();
                        if (isDigit(age)) {
                            persons.set(Integer.parseInt(ind), new Person(name1, Integer.parseInt(age)));
                        } else {
                            System.out.println("Entered value  is not a digit");
                        }
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "6":
                    System.out.println("Enter first index: ");
                    ind = read.next();
                    if (isDigit(ind)) {
                        System.out.println("Enter last index: ");
                        String ind1 = read.next();
                        if (isDigit(ind1)) {
                            MyList<Person> newList = persons.subList(Integer.parseInt(ind), Integer.parseInt(ind1));
                            for (int i = 0; i < newList.size(); i++) {
                                System.out.println(newList.get(i).getName() + " " + newList.get(i).getAge());
                            }
                        } else {
                            System.out.println("Entered value  is not a digit");
                        }
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "7":
                    System.out.println("Name: ");
                    name = read.next();
                    System.out.println("Age: ");
                    age = read.next();
                    if (isDigit(age)) {
                        System.out.println(persons.indexOf(new Person(name, Integer.parseInt(age))));
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "8":
                    System.out.println("Name: ");
                    name = read.next();
                    System.out.println("Age: ");
                    age = read.next();
                    if (isDigit(age)) {
                        System.out.println(persons.lastIndexOf(new Person(name, Integer.parseInt(age))));
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "9":
                    if (persons.isEmpty()) {
                        System.out.println("The list is empty");
                    } else {
                        System.out.println("The list is not empty");
                    }
                    break;
                case "10":
                    System.out.println("Name: ");
                    name = read.next();
                    System.out.println("Age: ");
                    age = read.next();
                    if (isDigit(age)) {
                        if (persons.contains(new Person(name, Integer.parseInt(age)))) {
                            System.out.println("Contains");
                        } else {
                            System.out.println("Doesn't contain");
                        }
                    } else {
                        System.out.println("Entered value  is not a digit");
                    }
                    break;
                case "11":
                    //Search by index
                    long start = System.currentTimeMillis();
                    for (int i = 0; i < 1000; i++) {
                        persons.get(1);
                    }
                    long res1 = System.currentTimeMillis() - start;
                    //ArrayList
                    long startArr = System.currentTimeMillis();
                    persons1.get(1);
                    long res2 = System.currentTimeMillis() - startArr;
                    //Add by index
                    long startAdd = System.currentTimeMillis();
                    persons.add(2, new Person("Jim", 18));
                    long res3 = System.currentTimeMillis() - startAdd;
                    //ArrayList
                    long startAddArr = System.currentTimeMillis();
                    persons1.add(2, new Person("Jim", 18));
                    long res4 = System.currentTimeMillis() - startAddArr;
                    System.out.println("Search by index:");
                    System.out.println("MyArrayList = " + res1);
                    System.out.println("ArrayList = " + res2);
                    System.out.println("Add by index:");
                    System.out.println("MyArrayList = " + res3);
                    System.out.println("ArrayList = " + res4);
                    break;
                case "12":
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    public static boolean isDigit(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
