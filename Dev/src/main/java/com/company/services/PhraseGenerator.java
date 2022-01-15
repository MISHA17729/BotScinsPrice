package com.company.services;

public final class PhraseGenerator {
    public static String PhraseGenerator(String Phrase){
        String[] wordListOne = {"30000-футовый", "взаимный" , "обоюдный выигрыш", "фронтэнд", "круглосуточный", "на основе веб-технологий", "проникающий" , "умный", "динамичный", "шесть сигм", "метод критического пути"};
        String[] wordListTwo = {"уполномоченный", "трудый", "чистьй продукт" , "ориентированный", "центральный", "распределенный", "кластеризованный", "фирменный", "нестандартный ум", "позиционированный", "сетевой", "сфокусированный", "использованный с выгодой", "выровненный", "нацеленный на", "общий", "совместный", "ускоренный"};
        String[] wordListThree = {"процесс", "пункт разгрузки","выход из положения", "тип структуры", "талант", "подход","уровень завоеванного внимания", "портал" , "период времени","обзор", "образец", "пункт следования"};
        int oneLenght = wordListOne.length;
        int twoLenght = wordListTwo.length;
        int threeLenght = wordListThree.length;
        int rand1 = (int) (Math.random() * oneLenght);
        int rand2 = (int) (Math.random() * twoLenght);
        int rand3 = (int) (Math.random() * threeLenght);
        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3] + " ";
        return phrase;
    }
}
