package com.isupov.springmvc.model;

public class Product {
    private long id;
    private String title;
    public double cost;

    public Product(long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + cost + " ";
    }
    //    Задание
//1. Разобраться с примером проекта на Spring MVC;
//2. Создать класс Товар (Product), с полями id, title, cost;
//3. Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары).
//    Репозиторий должен уметь выдавать список всех товаров и товар по id;
//4. Сделать форму для добавления товара в репозиторий и логику работы этой формы;
//5. Сделать страницу, на которой отображаются все товары из репозитория.
//    Дополнительные материалы
}
