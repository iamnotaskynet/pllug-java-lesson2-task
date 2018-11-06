package com.company;

import com.company.model.*;

/*
Реалізувати Java програму для опису роботи онлайн магазину. Програма повинна складатися із декількох класів, а саме:

клас Person - описує загальні дані про користувача
клас User - описує дані про користувача сайту
клас Seller - описує дані про продавця сайту
клас Purchase - описує дані про покупку користувачів
клас Market - який містить перелік користувачів, продавців та поточних покупок.
Необхідно згенерувати тестові дані про користувачів, продавців та зроблені покупки. Зберегти дані у класі Market
реалізувати у класі Market метод для виведення у консоль дани про користувачів, продавців та зроблені покупки.
Обчислити загальну суму зроблених покупок та прибуток від комісії у 5%. Вивести результат у консолю.
 */
public class Main {

    public static void main(String[] args) {
        //to test, just uncomment commented strings of code

        Person customer = new User("John", "Johnson", 40);
        Person seller = new Seller("Abraham", "Moisha", 40);

        Market market = Market.getInstance();

        //show( market.getPurchase(1) ); //does not exist yet

        market.addPurchase(customer, customer.getUuId(), seller, seller.getUuId(), "Matzo", 10L, 5L);

        //show( market.getPurchase(1) ); //now it exist

        market.addPurchase(customer, customer.getUuId(), seller, seller.getUuId(), "Kippah", 35L, 2L);

        show( market.getAllPurchases() );

        //show( market.getTotalPriceOfAllPurchases() );

        //show( market.getTotalPriceOfAllCommission() );
    }

    public static void show(String str) {
        System.out.print(str);
    }
}
