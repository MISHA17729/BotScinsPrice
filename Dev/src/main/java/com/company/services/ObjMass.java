package com.company.services;

import org.telegram.telegrambots.meta.api.objects.InputFile;

public final class ObjMass {
    static Cat[] abc = new Cat [6];

    public static String main (String args, int number){
        abc[0] = new Cat("https://steamcommunity.com/market/priceoverview/?currency=5&country=ru&appid=730&market_hash_name=★%20Butterfly%20Knife%20%7C%20Autotronic%20%28Battle-Scarred%29&format=json");
        abc[1] = new Cat("https://steamcommunity.com/market/priceoverview/?currency=5&country=ru&appid=730&market_hash_name=★%20Broken%20Fang%20Gloves%20%7C%20Unhinged%20%28Field-Tested%29&format=json");
        abc[2] = new Cat("https://steamcommunity.com/market/priceoverview/?currency=5&country=ru&appid=730&market_hash_name=AWP%20%7C%20Asiimov%20%28Field-Tested%29&format=json");

        return abc[number].URl;
    }
    public static InputFile getImage(InputFile inputFile, int numberImage){
        abc[3] = new Cat(new InputFile("https://community.akamai.steamstatic.com/economy/image/-9a81dlWLwJ2UUGcVs_nsVtzdOEdtWwKGZZLQHTxDZ7I56KU0Zwwo4NUX4oFJZEHLbXH5ApeO4YmlhxYQknCRvCo04DEVlxkKgpovbSsLQJf0ebcZThQ6tCvq4eYqPXhJ6_UhG1d8fpwn_3O4Z76hl23lBs5Mi-6S9rEMFFrfwrTq1W_wu6-0ce77ZnAwCBn7HVw53rcmke0hR4Zb7Bt0PCYTVmWUadXXP7VeJHX2Rk/360fx360f"));
        abc[4] = new Cat(new InputFile("https://community.akamai.steamstatic.com/economy/image/-9a81dlWLwJ2UUGcVs_nsVtzdOEdtWwKGZZLQHTxDZ7I56KU0Zwwo4NUX4oFJZEHLbXH5ApeO4YmlhxYQknCRvCo04DAR0hwIQFTibi3JAxl3fXJfzp969C5goWYqPjkNqnQgmJe5pQhtfrP9Ifwm1-9pSw-Pzigf-nIJ1JnJAW_pgD8lrvxhpDuuZrBwHcyvSYk5CqLyxO-gx9IZrBoh_OYSQ6YVaZKTvSAAnPRtoczFnuznLWYzA/360fx360f"));
        abc[5] = new Cat(new InputFile("https://community.akamai.steamstatic.com/economy/image/-9a81dlWLwJ2UUGcVs_nsVtzdOEdtWwKGZZLQHTxDZ7I56KU0Zwwo4NUX4oFJZEHLbXH5ApeO4YmlhxYQknCRvCo04DEVlxkKgpot621FAR17PLfYQJD_9W7m5a0mvLwOq7cqWdQ-sJ0xOzAot-jiQa3-hBqYzvzLdSVJlQ3NQvR-FfsxL3qh5e7vM6bzSA26Sg8pSGKJUPeNtY/360fx360f"));
        return abc[numberImage].image;
    }
}

class Cat{
    String URl;
    InputFile image = new InputFile();
    public Cat (String URL){
        this.URl = URL;
    }
    public Cat(InputFile image){
        this.image = image;
    }
}
