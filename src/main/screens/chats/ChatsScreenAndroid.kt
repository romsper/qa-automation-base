package main.screens.chats

import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement

class ChatsScreenAndroid: ChatsScreen() {
    override var CHAT_ADD = element(byId("mainAppScreenFloatingButton"))
    override var CHAT_OPTIONS_DROPDOWN = elements(byClassName("android.widget.TextView"))
    override var CHATS_USER_SETTINGS_BUTTON = element(byId("profilePictureTop"))
    override var CHAT_LIST= elements(byId("chatListItem"))

    override var CHATS_BROADCAST_MSG_BUTTON = element(byId("newBroadcastMessage"))
    override var CHATS_SUBMIT_BROADCAST_BUTTON = element(byId("broadcastFAB"))

    override var CHATS_GROUP_CHAT_BUTTON = element(byId("newGroupChat"))
    override var CHATS_SUBMIT_GROUP_CHAT_BUTTON = element(byId("sendMembersToNamingScreenFAB"))
    override var CHATS_GROUP_TITLE_FIELD = element(byId("groupNameEditText"))
    override var CHATS_GROUP_EXPIRE_TIME_SELECTOR = element(byId("destructionTimeGroupChat"))
    override var CHATS_START_GROUP_CHAT_BUTTON = element(byId("startGroupChatButton"))
}