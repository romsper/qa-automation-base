package main.screens.chats.list

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.SelenideElement

open class ChatList(val item: SelenideElement) {
    open var CHAT_CONTACT_NAME = item.find(byId(""))
    open var CHAT_CONTACT_AVATAR = item.find(byId(""))
    open var CAHT_GROUP_CHAT_AVATAR = item.find(byId(""))
    open var CHAT_CONTACT_LAST_MESSAGE_TIME = item.find(byId(""))
}