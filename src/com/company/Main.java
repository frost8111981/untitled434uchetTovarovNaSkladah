package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage storage1 = new Storage("ашан");
        Storage storage2 = new Storage("глобус");

        Map<Storage, Set<Product>> storageMap = new HashMap<>();
        storageMap.put(storage1,new HashSet<>());   // Добавляем склад и к нему значение котор будет
        storageMap.put(storage2,new HashSet<>());

        Set<Product> productSet = new HashSet<>();   // Создаем обьект

        while (true){
            System.out.println("Добавьте товар: номер, название, цена или нажмите <enter>");
            String inputProduct = sc.nextLine();
            if(inputProduct.equals("")){
                System.out.println("Программа завершена");
                break;
            }
            String[] part = inputProduct.split(" ");
            Product product = new Product(part[0],part[1],part[2]);  // Создаем обьект и к нему части ввода

            productSet.add(product);  // Добавляем обьект в Сет

            System.out.println("Укажите склад размещения товара (ашан, глобус):");
            String inputStorage = sc.nextLine();
            if(inputStorage.equals("ашан")){
                storageMap.get(storage1).add(product); // Находим нужный ключь и добавляем обьект в Сет
            } else if(inputStorage.equals("глобус")) {
                storageMap.get(storage2).add(product);
            }
        }
        System.out.println();
        System.out.println("Вывод");
        for (Storage storage : storageMap.keySet()) {
            System.out.println("- " + storage + ":");
            Set<Product> productSet2 = storageMap.get(storage);
            for (Product product : productSet2) {
                System.out.println(product);
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("Для поиска товара введите его номер");
        String inputSearch = sc.nextLine();


        for (Storage storageSearch : storageMap.keySet()){  // Получаем список всех ключей storageMap( в цикле пробегаем по первому складу)
            Set<Product> productMapSearch = storageMap.get(storageSearch); // в переменную productMapSearch добавляем 1-й склад
            for (Product productSearch : productMapSearch) { // в цикле пробегаем по 1-му складу
                if(productSearch.getId().equals(inputSearch)){ // если находим этот айди то выводим
                    System.out.println("Продукт найден:" + productSearch.getName());
                    break;
                }

            }
        }
    }
}



//        Storage storage1 = new Storage("ашан");     //  разбор Сет в Мап на простом
//        Storage storage2 = new Storage("глобус");
//
//        Product aple = new Product("1", "aple","50");
//        Product orange = new Product("2", "orange","30");
//        Product limon = new Product("3", "limon","40");
//
//        Map<Storage, Set<Product>> storageMap = new HashMap<>();
//
//        Set<Product> productSet = new HashSet<>();
//        productSet.add(aple);
//        productSet.add(orange);
//        Set<Product> productSet2 = new HashSet<>();
//        productSet2.add(limon);
//
//        storageMap.put(storage1,productSet);
//        storageMap.put(storage2,productSet2);
//        storageMap.get(storage1).add(limon);
//
//        System.out.println(storageMap);