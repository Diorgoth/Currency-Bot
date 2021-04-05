import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Mybot extends TelegramLongPollingBot {
   static String  choice1 = " " ;
   static String choice2 = " ";

    @Override
    public String getBotUsername() {
        return "diot_trade_bot";
    }

    @Override
    public String getBotToken() {
        return "1635275087:AAGN8XpL2UUv97oP6PcIXIVjYPZt-3o6siQ";
    }

    @Override
    public void onUpdateReceived(Update update) {

        String text = update.getMessage().getText();
        Long chat_id = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        URL url= null;
        try {
            url = new URL("https://cbu.uz/uz/arkhiv-kursov-valyut/json/");
            URLConnection urlConnection=url.openConnection();
            BufferedReader b=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Type type=new TypeToken<ArrayList<Model>>(){}.getType();
            ArrayList<Model> models=gson.fromJson(b,type);




        if (text.equals("/start")){
            sendMessage.setText("Botga Xush kelibsiz!");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow=new KeyboardRow();
            keyboardRow.add(new KeyboardButton("Continue"));
            keyboard.add(keyboardRow);
            replyKeyboardMarkup.setKeyboard(keyboard);

            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
//        else if (update.getMessage().hasText()){
//            int a = parseInt(text)*3;
//            sendMessage.setText(String.valueOf(a));
//            sendMessage.setChatId(chat_id.toString());
//        }
        else if (text.equals("Continue")){
            sendMessage.setText("Valyuta turini tanlang");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup1=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup1);
            replyKeyboardMarkup1.setSelective(true);
            replyKeyboardMarkup1.setResizeKeyboard(true);
            replyKeyboardMarkup1.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard1=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow1=new KeyboardRow();
            keyboardRow1.add(new KeyboardButton("From USD"));
            keyboardRow1.add(new KeyboardButton("From UZS"));
            keyboardRow1.add(new KeyboardButton("From RUB"));
            keyboard1.add(keyboardRow1);
            replyKeyboardMarkup1.setKeyboard(keyboard1);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        } else   if (  text.equals("From USD")){
            choice1 = "From USD";
            sendMessage.setText("USDni qanday valyuta turiga o'girmoqchisiz?");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup2=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup2);
            replyKeyboardMarkup2.setSelective(true);
            replyKeyboardMarkup2.setResizeKeyboard(true);
            replyKeyboardMarkup2.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard2=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow2.add(new KeyboardButton("To USD"));
            keyboardRow2.add(new KeyboardButton("To UZS"));
            keyboardRow2.add(new KeyboardButton("To RUB"));
            keyboard2.add(keyboardRow2);
            replyKeyboardMarkup2.setKeyboard(keyboard2);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        } else   if (text.equals("To UZS")){
                   choice2 = "To UZS";
            sendMessage.setText("Pul miqdorini kiriting");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup2=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup2);
            replyKeyboardMarkup2.setSelective(true);
            replyKeyboardMarkup2.setResizeKeyboard(true);
            replyKeyboardMarkup2.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard2=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow2.add(new KeyboardButton("To USD"));
            keyboardRow2.add(new KeyboardButton("To UZS"));
            keyboardRow2.add(new KeyboardButton("To RUB"));
            keyboard2.add(keyboardRow2);
            replyKeyboardMarkup2.setKeyboard(keyboard2);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        } else   if (  text.equals("From UZS")){
            choice1 = "From UZS";
            sendMessage.setText("UZSni qanday valyuta turiga o'girmoqchisiz?");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup2=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup2);
            replyKeyboardMarkup2.setSelective(true);
            replyKeyboardMarkup2.setResizeKeyboard(true);
            replyKeyboardMarkup2.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard2=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow2.add(new KeyboardButton("To USD"));
            keyboardRow2.add(new KeyboardButton("To UZS"));
            keyboardRow2.add(new KeyboardButton("To RUB"));
            keyboard2.add(keyboardRow2);
            replyKeyboardMarkup2.setKeyboard(keyboard2);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }else   if (text.equals("To USD")){
            choice2 = "To USD";
            sendMessage.setText("Pul miqdorini kiriting");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup2=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup2);
            replyKeyboardMarkup2.setSelective(true);
            replyKeyboardMarkup2.setResizeKeyboard(true);
            replyKeyboardMarkup2.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard2=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow2.add(new KeyboardButton("To USD"));
            keyboardRow2.add(new KeyboardButton("To UZS"));
            keyboardRow2.add(new KeyboardButton("To RUB"));
            keyboard2.add(keyboardRow2);
            replyKeyboardMarkup2.setKeyboard(keyboard2);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }else   if ( text.equals("From UZS")){
            choice1 = "From UZS";
            sendMessage.setText("UZSni qanday valyuta turiga o'girmoqchisiz?");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup2=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup2);
            replyKeyboardMarkup2.setSelective(true);
            replyKeyboardMarkup2.setResizeKeyboard(true);
            replyKeyboardMarkup2.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard2=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow2.add(new KeyboardButton("To USD"));
            keyboardRow2.add(new KeyboardButton("To UZS"));
            keyboardRow2.add(new KeyboardButton("To RUB"));
            keyboard2.add(keyboardRow2);
            replyKeyboardMarkup2.setKeyboard(keyboard2);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }else   if (text.equals("To RUB")){
            choice2 = "To RUB";
            sendMessage.setText("Pul miqdorini kiriting");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup2=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup2);
            replyKeyboardMarkup2.setSelective(true);
            replyKeyboardMarkup2.setResizeKeyboard(true);
            replyKeyboardMarkup2.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard2=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow2.add(new KeyboardButton("To USD"));
            keyboardRow2.add(new KeyboardButton("To UZS"));
            keyboardRow2.add(new KeyboardButton("To RUB"));
            keyboard2.add(keyboardRow2);
            replyKeyboardMarkup2.setKeyboard(keyboard2);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }else   if ( text.equals("From RUB")){
            choice1 = "From RUB";
            sendMessage.setText("UZSni qanday valyuta turiga o'girmoqchisiz?");
            sendMessage.setChatId(chat_id.toString());

            ReplyKeyboardMarkup replyKeyboardMarkup2=new ReplyKeyboardMarkup();
            sendMessage.setReplyMarkup(replyKeyboardMarkup2);
            replyKeyboardMarkup2.setSelective(true);
            replyKeyboardMarkup2.setResizeKeyboard(true);
            replyKeyboardMarkup2.setOneTimeKeyboard(true);
            List<KeyboardRow> keyboard2=new ArrayList<KeyboardRow>();

            KeyboardRow keyboardRow2=new KeyboardRow();
            keyboardRow2.add(new KeyboardButton("To USD"));
            keyboardRow2.add(new KeyboardButton("To UZS"));
            keyboardRow2.add(new KeyboardButton("To RUB"));
            keyboard2.add(keyboardRow2);
            replyKeyboardMarkup2.setKeyboard(keyboard2);
            try {

                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        } else if (update.getMessage().hasText()){
           models.forEach(model -> {
               if (choice1 == "From USD" && choice2 == "To UZS" && model.getCcy().equals("USD")){
                   int amount = parseInt(text)*model.getRate().intValue();
                     sendMessage.setText(String.valueOf(amount+" so'm"));
                     sendMessage.setChatId(chat_id.toString());
                   ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
                   sendMessage.setReplyMarkup(replyKeyboardMarkup);
                   replyKeyboardMarkup.setSelective(true);
                   replyKeyboardMarkup.setResizeKeyboard(true);
                   replyKeyboardMarkup.setOneTimeKeyboard(true);
                   List<KeyboardRow> keyboard=new ArrayList<KeyboardRow>();

                   KeyboardRow keyboardRow=new KeyboardRow();
                   keyboardRow.add(new KeyboardButton("Continue"));
                   keyboard.add(keyboardRow);
                   replyKeyboardMarkup.setKeyboard(keyboard);
                   try {
                       execute(sendMessage);
                   } catch (TelegramApiException e) {
                       e.printStackTrace();
                   }
               }else  if (choice1 == "From UZS" && choice2 == "To USD" && model.getCcy().equals("USD")){
                   int amount = parseInt(text)/model.getRate().intValue();
                   sendMessage.setText(String.valueOf(amount+" dollar"));
                   sendMessage.setChatId(chat_id.toString());
                   ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
                   sendMessage.setReplyMarkup(replyKeyboardMarkup);
                   replyKeyboardMarkup.setSelective(true);
                   replyKeyboardMarkup.setResizeKeyboard(true);
                   replyKeyboardMarkup.setOneTimeKeyboard(true);
                   List<KeyboardRow> keyboard=new ArrayList<KeyboardRow>();

                   KeyboardRow keyboardRow=new KeyboardRow();
                   keyboardRow.add(new KeyboardButton("Continue"));
                   keyboard.add(keyboardRow);
                   replyKeyboardMarkup.setKeyboard(keyboard);
                   try {
                       execute(sendMessage);
                   } catch (TelegramApiException e) {
                       e.printStackTrace();
                   }
               }else  if (choice1 == "From UZS" && choice2 == "To RUB" && model.getCcy().equals("RUB")){
                   int amount = parseInt(text)/model.getRate().intValue();
                   sendMessage.setText(String.valueOf(amount+" rubl"));
                   sendMessage.setChatId(chat_id.toString());
                   ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
                   sendMessage.setReplyMarkup(replyKeyboardMarkup);
                   replyKeyboardMarkup.setSelective(true);
                   replyKeyboardMarkup.setResizeKeyboard(true);
                   replyKeyboardMarkup.setOneTimeKeyboard(true);
                   List<KeyboardRow> keyboard=new ArrayList<KeyboardRow>();

                   KeyboardRow keyboardRow=new KeyboardRow();
                   keyboardRow.add(new KeyboardButton("Continue"));
                   keyboard.add(keyboardRow);
                   replyKeyboardMarkup.setKeyboard(keyboard);
                   
                   try {
                       execute(sendMessage);
                   } catch (TelegramApiException e) {
                       e.printStackTrace();
                   }

               }else  if (choice1 == "From RUB" && choice2 == "To UZS" && model.getCcy().equals("RUB")){
                   int amount = parseInt(text)*model.getRate().intValue();
                   sendMessage.setText(String.valueOf(amount+" so'm"));
                   sendMessage.setChatId(chat_id.toString());
                   ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
                   sendMessage.setReplyMarkup(replyKeyboardMarkup);
                   replyKeyboardMarkup.setSelective(true);
                   replyKeyboardMarkup.setResizeKeyboard(true);
                   replyKeyboardMarkup.setOneTimeKeyboard(true);
                   List<KeyboardRow> keyboard=new ArrayList<KeyboardRow>();

                   KeyboardRow keyboardRow=new KeyboardRow();
                   keyboardRow.add(new KeyboardButton("Continue"));
                   keyboard.add(keyboardRow);
                   replyKeyboardMarkup.setKeyboard(keyboard);
                   try {
                       execute(sendMessage);
                   } catch (TelegramApiException e) {
                       e.printStackTrace();
                   }
               }







           });


        }


        System.out.println(choice1);
        System.out.println(choice2);




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
