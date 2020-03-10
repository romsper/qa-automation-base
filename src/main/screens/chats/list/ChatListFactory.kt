package main.screens.chats.list

import com.codeborne.selenide.Selenide.page
import com.codeborne.selenide.SelenideElement
import main.helpers.AndroidPageFactory
import main.helpers.IOSPageFactory
import main.helpers.InitDriverProvider
import org.junit.jupiter.api.fail

class ChatListFactory {
    fun get(item: SelenideElement): ChatList = when (InitDriverProvider().platform) {
        "Android" -> ChatListAndroid(item)
        "iOS" -> ChatListIOS(item)
        else -> fail("Wrong PLATFORM")
    }
}