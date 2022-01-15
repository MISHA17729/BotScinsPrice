package com.company;

import com.company.services.PhraseGenerator;
import lombok.SneakyThrows;
import com.company.services.Baterfly;
import com.company.services.PasswordGenerator;
import com.company.services.ObjMass;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.Optional;

public class Bot extends TelegramLongPollingBot {
    private final Baterfly baterfly = new Baterfly();
    public Bot() {
    }

    @Override
    public String getBotUsername() {
        return "@Bot17729_bot";
    }

    @Override

    public String getBotToken() {
        return "5057917759:AAEn_JcxFX_KYZ_rCIfd_ADDVCVEqoMWNzo";
    }

    public static void main(String[] args) throws TelegramApiException {
        Bot bot = new Bot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            handleMessage(update.getMessage());
        }
    }
    @SneakyThrows
    private void handleMessage(Message message) throws TelegramApiException, IOException {
        String phrase = null;
        String buterflyPrice = null;
        String url = null;
        InputFile imageUrl = new InputFile();
        if(message.hasText() && message.hasEntities()){
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if(commandEntity.isPresent()){
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                switch (command) {
                    case "/phrase":
                        execute(SendMessage.builder().text(PhraseGenerator.PhraseGenerator(phrase)).chatId(message.getChatId().toString()).build());
                        return;
                    case "/generate_random_password":
                            PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                                    .useDigits(true)
                                    .useLower(true)
                                    .useUpper(true)
                                    .build();
                            String password = passwordGenerator.generate(8);
                            execute(SendMessage.builder().text(password).chatId(message.getChatId().toString()).build());
                            return;
                    case "/get_knife_and_gloves_price":
                        execute(SendMessage.builder().text("Цена Бабочки:" + baterfly.getPrice(buterflyPrice, ObjMass.main(url, 0))).chatId(message.getChatId().toString()).build());
                        execute(SendPhoto.builder().photo(ObjMass.getImage(imageUrl, 3)).chatId(message.getChatId().toString()).build());
                        execute(SendMessage.builder().text("Цена Перчаток:" + baterfly.getPrice(buterflyPrice, ObjMass.main(url, 1))).chatId(message.getChatId().toString()).build());
                        execute(SendPhoto.builder().photo(ObjMass.getImage(imageUrl, 4)).chatId(message.getChatId().toString()).build());
                        execute(SendMessage.builder().text("Цена AWP:" + baterfly.getPrice(buterflyPrice,ObjMass.main(url, 2))).chatId(message.getChatId().toString()).build());
                        execute(SendPhoto.builder().photo(ObjMass.getImage(imageUrl, 5)).chatId(message.getChatId().toString()).build());
                        return;
                }
            }
        }
    }
}

