package ru.gasu;

import org.telegram.telegrambots.bots.DefaultBotOptions;

import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.abilitybots.api.util.AbilityExtension;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.telegrambots.bots.DefaultBotOptions;
//import java.util.Profile;
//import java.util.Description;

public class MyAbility implements AbilityExtension {
    private SilentSender silent;
    DBContext db;

    public MyAbility(SilentSender silent, DBContext db) {
        this.silent = silent;
        this.db = db;
    }

    public MyAbility(String BOT_TOKEN, String BOT_NAME, DefaultBotOptions botOptions) {

    }

    public Ability start() {
        return Ability
                .builder()
                .name("start")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .input(0)
                .action(ctx -> {
                    silent.send("Добрый день!.", ctx.chatId());
                    silent.send("Для начала работы необходимо выбрать команду /NewUser", ctx.chatId());
                })
                .build();
    }

    public Ability NewUser() {
        return Ability
                .builder()
                .name("join")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .input(0)
                .action(ctx -> {
                    silent.send(String.format("User %s join this account", ctx.user().getLastName()), ctx.chatId());
                })
                .build();
    }

    public Ability showPeople() {
        return Ability
                .builder()
                .name("members")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {
                    String message = "Members:";
                    silent.send(message, ctx.chatId());
                })
                .build();
    }

    public Ability stop() {
        return Ability
                .builder()
                .name("stop")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {
                    silent.send("Account was cleared", ctx.chatId());
                })
                .build();
    }
}
