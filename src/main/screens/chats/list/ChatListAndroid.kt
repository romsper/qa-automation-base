package main.screens.chats.list

import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.SelenideElement

class ChatListAndroid(val newItem: SelenideElement) : ChatList(newItem){
    override var CHAT_CONTACT_NAME = item.find(byId("contactName"))
    override var CHAT_CONTACT_AVATAR = item.find(byId("contactProfilePicture"))
    override var CAHT_GROUP_CHAT_AVATAR = item.find(byId("groupContactProfilePictureTop"))
    override var CHAT_CONTACT_LAST_MESSAGE_TIME = item.find(byId("lastMessageDate"))
}