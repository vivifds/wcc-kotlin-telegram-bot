package bots

//import com.sun.tools.javac.file.JavacFileManager.getMessage
import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage

import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.io.File

class WCCBot : TelegramLongPollingBot() {


    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "WccVivibot"
    }

    override fun getBotToken(): String {
        // Return bot token from BotFather
        return "2138485972:AAHftPm5hY3XTttqsx2YPIgPAdGXcPigd6Q"
    }

    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val nameSender = update?.message?.from?.firstName
        val chatId = update?.message?.chatId.toString()
        val messageCommand = update?.message?.text

        try {
            when (messageCommand) {
                "/start" -> {
                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = welcome(nameSender)
                        this.document = InputFile().setMedia(File("C:\\Users\\Viviane\\wcc-hello-github\\wcc-kotlin-telegram-bot\\src\\main\\resources\\IMG_20210816_094906.jpg"))
                        this.parseMode = "MarkdownV2"
                    }
                    execute(sendDocument)

                }
                "/baixar" -> {
                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = EmojiParser.parseToUnicode("Currículo enviado :blush:")
                        this.document = InputFile().setMedia(File("C:\\Users\\Viviane\\wcc-hello-github\\wcc-kotlin-telegram-bot\\src\\main\\resources\\Viviane_Currículo.pdf"))
                        this.parseMode = "MarkdownV2"

                    }
                    execute (sendDocument)

                }
                "/info" -> {
                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = EmojiParser.parseToUnicode("Estou à disposição para maiores esclarecimentos! :smiley:")
                        this.document = InputFile().setMedia(File("C:\\Users\\Viviane\\wcc-hello-github\\wcc-kotlin-telegram-bot\\src\\main\\resources\\IMG_20210816_094906.jpg"))
                        this.parseMode = "MarkdownV2"

                    }
                    execute (sendDocument)

                }
                else -> {
                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = EmojiParser.parseToUnicode("Não entendo, tente novamente, por favor! :confuso:")
                        this.document = InputFile().setMedia(File("C:\\Users\\Viviane\\wcc-hello-github\\wcc-kotlin-telegram-bot\\src\\main\\resources\\IMG_20210816_094906.jpg"))
                        this.parseMode = "MarkdownV2"
                    }
                    execute(sendDocument)
                }
            }
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }

        }

    private fun welcome(nameSender: String?) = """
        *Olá, $nameSender, como vai\?*
        \/start \- Meu nome é Viviane\
        \/info \- Este é meu Currículo\!
        \/baixar \- Currículo
        """.trimMargin()



