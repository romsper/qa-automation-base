package main.screens.chats

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements

class ChatsScreenIOS: ChatsScreen() {
    override var CHAT_ADD = element(byId("mainAppScreenFloatingButton"))
    override var CHAT_LIST = elements(byId("chatListItem"))
}