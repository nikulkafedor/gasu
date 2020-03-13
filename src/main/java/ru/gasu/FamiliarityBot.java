package ru.gasu;

//import jdk.jfr.Description;
import org.telegram.abilitybots.api.util.AbilityExtension;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import org.telegram.telegrambots.bots.DefaultBotOptions;
import java.util.ArrayList;
import java.util.List;
//import org.telegram.telegrambots.extensions.bots.commandbot.commands.CommandRegistry;
//import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
//import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;

//public class FamiliarityBot extends TelegramLongPollingBot {

//  private static final String BOT_NAME = "@znakommstvoBot";
// private static final String BOT_TOKEN = System.getenv("TOKEN");

//    List<Description> arrayOfDescription;
//   List<Profile> arrayOfProfile;
//  FamiliarityBot FamiliarityBot;

//   public FamiliarityBot (DefaultBotOptions botOptions) {
//      super(BOT_NAME, botOptions,BOT_TOKEN);
//     super( BOT_NAME,botOptions);
//    this.arrayOfDescription = new ArrayList<Description>();
//   this.arrayOfProfile = new ArrayList<Profile>();
//}

public class FamiliarityBot extends MyAbility {
    private static final String BOT_NAME = "@znakommstvoBot";
    private static final String BOT_TOKEN = System.getenv("BOT_TOKEN");
    List<Description> arrayOfDescription;
   // List<Profile<S>> arrayOfProfile;
    FamiliarityBot FamiliarityBot;

    FamiliarityBot(DefaultBotOptions botOptions) {
        super(BOT_TOKEN, BOT_NAME, botOptions);
        this.arrayOfDescription = new ArrayList<Description>();
      //  this.arrayOfProfile = new ArrayList<Profile<S>>();
    }

    //  public AbilityExtension ability() {
    //    String description = null;
    //   String commandIdentifier = null;
    //  return (AbilityExtension) new MyAbility(silent,db);
    // }
    public void sendMsg(Message message, String text){
        SendMessage sendMessage= new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        setButtons(sendMessage);
        execute(sendMessage);
    }

    private void execute(SendMessage sendMessage) {
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (message.equals("/start")) {
            sendMsg(message, "Добрый день!");
        }

        if (message != null && message.hasText()){
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "Нужна помощь?");
                    break;
                default:
            }
        }
    }

    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

    //    Profile<S> keyboardRowList = new Profile<S>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        keyboardFirstRow.add(new KeyboardButton( "/help"));
        keyboardFirstRow.add(new KeyboardButton("/NewUser"));
        keyboardFirstRow.add(new KeyboardButton("/stop"));
        keyboardFirstRow.add(new KeyboardButton("/showPeople"));
        keyboardFirstRow.add(new KeyboardButton("/Profiles"));
    }

    public int creatorId() {
        return 0;
    }

  //  @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

  //  @Override
    public String getBotToken() {
        return System.getenv("BOT_TOKEN");
    }

    public static void trySendMessage(AbsSender absSender, User user, SendMessage sendMessage) {
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

