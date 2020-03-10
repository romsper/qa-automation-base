package main.screens.chats

import com.codeborne.selenide.Condition.appear
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.byClassName
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import main.enums.StringsEnum
import main.helpers.longTap
import main.helpers.screen
import main.screens.chat.ChatScreen
import main.screens.chat.ChatScreenIOS
import main.screens.chats.list.ChatListFactory
import org.junit.jupiter.api.fail

open class ChatsScreen {
    protected open var CHAT_ADD = element(byId(""))
    protected open var CHAT_OPTIONS_DROPDOWN = elements(byClassName(""))
    protected open var CHATS_USER_SETTINGS_BUTTON = element(byId(""))
    protected open var CHAT_LIST = elements(byId(""))

    protected open var CHATS_BROADCAST_MSG_BUTTON = element(byId(""))
    protected open var CHATS_SUBMIT_BROADCAST_BUTTON = element(byId(""))

    protected open var CHATS_GROUP_CHAT_BUTTON = element(byId(""))
    protected open var CHATS_SUBMIT_GROUP_CHAT_BUTTON = element(byId(""))
    protected open var CHATS_GROUP_TITLE_FIELD = element(byId(""))
    protected open var CHATS_GROUP_EXPIRE_TIME_SELECTOR = element(byId(""))
    protected open var CHATS_START_GROUP_CHAT_BUTTON = element(byId(""))

    private fun convertListToObject(): List<ChatItem>? {
        return when (CHAT_LIST.first().isDisplayed) {
            false -> null
            else -> CHAT_LIST.map { ChatListFactory().get(it) }
                    .map {
                        ChatItem(
                                title = it.CHAT_CONTACT_NAME.text,
                                avatar = it.CHAT_CONTACT_AVATAR,
                                groupChatAvatar = it.CAHT_GROUP_CHAT_AVATAR,
                                lastMsgTime = it.CHAT_CONTACT_LAST_MESSAGE_TIME.text)
                    }
        }
    }

    @Step("Tap to user settings button")
    fun tapUserAvatarButton(): ChatsScreen {
        CHATS_USER_SETTINGS_BUTTON.shouldBe(appear)
        CHATS_USER_SETTINGS_BUTTON.click()
        return this
    }

    @Step("Is chat exist")
    fun isChatExist(chat: String): Boolean {
        return when (convertListToObject().isNullOrEmpty()) {
            true -> false
            false -> convertListToObject()?.find { it.title.contains(chat) } != null
        }
    }

    @Step("Add chat button is appear")
    fun addChatButtonIsAppear(): Boolean {
        CHAT_ADD.shouldBe(appear)
        return CHAT_ADD.isDisplayed
    }

    @Step("Tap to add chat button")
    fun tapAddChatButton(): ChatsScreen {
        CHAT_ADD.shouldBe(appear)
        CHAT_ADD.click()
        return this
    }

    @Step("Tap to chat by title")
    fun tapChatItem(title: String): ChatsScreen {
        CHAT_LIST.first().shouldBe(appear)
        val item = convertListToObject()?.find { it.title.contains(title) }!!
        when (item.avatar?.isDisplayed) {
            false -> item.groupChatAvatar?.click()
            true -> item.avatar.click()
            else -> println("Something wrong with avatar")
        }
        return this
    }

    @Step("Choose option for chat")
    fun chooseChatOption(option: String): ChatsScreen {
        CHAT_OPTIONS_DROPDOWN.first().shouldBe(appear)
        CHAT_OPTIONS_DROPDOWN.first { it.text.contains(option) }.click()
        return this
    }

    @Step("Long tap to chat")
    fun longTapChat(title: String): ChatsScreen {
        CHAT_LIST.first().shouldBe(appear)
        val item = convertListToObject()?.find { it.title.contains(title) }!!
        when (item.avatar?.isDisplayed) {
            false -> item.groupChatAvatar?.longTap()
            true -> item.avatar.longTap()
            else -> fail("Can't tap to avatar")
        }
        return this
    }

    @Step("Tap to add group chat button")
    fun tapAddGroupChatButton(): ChatsScreen {
        CHATS_GROUP_CHAT_BUTTON.shouldBe(appear)
        CHATS_GROUP_CHAT_BUTTON.click()
        return this
    }

    @Step("Tap to submit group chat button")
    fun tapSubmitGroupChatButton(): ChatsScreen {
        CHATS_SUBMIT_GROUP_CHAT_BUTTON.shouldBe(appear)
        CHATS_SUBMIT_GROUP_CHAT_BUTTON.click()
        return this
    }

    @Step("Type group chat title")
    fun typeGroupChatTitle(title: String): ChatsScreen {
        CHATS_GROUP_TITLE_FIELD.shouldBe(appear)
        CHATS_GROUP_TITLE_FIELD.value = title
        return this
    }

    @Step("Tap to start group chat button")
    fun tapStartGroupChatButton(): ChatsScreen {
        CHATS_START_GROUP_CHAT_BUTTON.shouldBe(appear)
        CHATS_START_GROUP_CHAT_BUTTON.click()
        return this
    }


    //---

    @Step("Get chat item by title")
    fun getChatItemByTitle(chat: String): ChatItem? {
        return convertListToObject()?.first { it.title.contains(chat) }
    }

    @Step("Start chat and go back")
    fun startChatAndGoBack(contact: String): ChatsScreen {
        tapAddChatButton()
        screen.contacts.tapContact(contact)
        screen.chat.sendMessage(StringsEnum.TEXT_MESSAGE.txt)
        screen.topNavigation.tapBackButton()
        return this
    }

    @Step("Start group chat and go back")
    fun startGroupChatAndGoBack(title: String, contacts: List<String>): ChatsScreen {
        tapAddChatButton()
        tapAddGroupChatButton()
        contacts.forEach { screen.contacts.tapContact(it) }
        tapSubmitGroupChatButton()
        typeGroupChatTitle(title)
        tapStartGroupChatButton()
        screen.chat.sendMessage(StringsEnum.TEXT_MESSAGE.txt)
        screen.topNavigation.tapBackButton()
        return this
    }

    @Step("Start group chat")
    fun startGroupChat(title: String, contacts: List<String>): ChatsScreen {
        tapAddChatButton()
        tapAddGroupChatButton()
        contacts.forEach { screen.contacts.tapContact(it) }
        tapSubmitGroupChatButton()
        typeGroupChatTitle(title)
        tapStartGroupChatButton()
        screen.chat.sendMessage(StringsEnum.TEXT_MESSAGE.txt)
        return this
    }

    @Step("Delete chat by title")
    fun deleteChatByTitle(title: String): ChatsScreen {
        longTapChat(title)
        chooseChatOption("Delete")
        return this
    }

    @Step("Save chat by title")
    fun saveChatByTitle(title: String): ChatsScreen {
        longTapChat(title)
        chooseChatOption("Save")
        return this
    }
}

data class ChatItem(
        val title: String,
        val avatar: SelenideElement?,
        val groupChatAvatar: SelenideElement?,
        val lastMsgTime: String
)