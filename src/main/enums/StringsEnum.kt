package main.enums

enum class StringsEnum(val txt: String) {

    ECCID_WRONG(txt = "BLABLA"),

    //---NAMES---
    TEXT_CONTACT_NAME_NEW_JOE(txt = "New Joe Montana"),
    TEXT_CONTACT_NAME_NEW_AT_3(txt = "AT_3_"),

    //---Authorization---
    LOGIN_DEFAULT_PASSWORD(txt = "canucks"),
    LOGIN_ATTEMP_PASSWORD(txt = "SKY"),
    LOGIN_WIPE_ERROR(txt = "Next wrong password will wipe this device"),

    //---Contacts---
    CONTACTS_WRONG_ECCID(txt = "Unable to add contact"),

    //---Categories---
    CATEGORY_TITLE_FRIENDS(txt = "Friends"),
    CATEGORY_TITLE_CHAT(txt = "CHAT"),
    CATEGORY_TITLE_NEW_FRIENDS(txt = "New Friends"),

    //---Strings---
    TEXT_TODAY(txt = "Today"),
    TEXT_BLABLABLA(txt = "blablabla"),
    TEXT_MESSAGE(txt = "Message"),
    TEXT_GROUP_CHAT_TITLE(txt = "Group chat"),
    TEXT_GROUP_CHAT_NEW_TITLE(txt = "New group chat"),
    TEXT_MESSAGE_REVOKED(txt = "Message revoked"),
    TEXT_CHAT_TERMINATED(txt = "Chat terminated by an admin"),
    TEXT_TO_ADMIN(txt = "to admin"),
    TEXT_FROM_ADMIN(txt = "from admin"),
    TEXT_REMOVED(txt = "removed"),

    //---Vault---
    VAULT_CHATS_TAB(txt = "CHATS"),

    //---Statuses---
    SETTINGS_STATUS_BUSY(txt = "Busy"),
    SETTINGS_STATUS_AVAILABLE(txt = "Available"),

    //---Chat---
    CHAT_REVOKE_BUTTON(txt = "Revoke"),

    //---Expire---
    GROUP_CHAT_EXPIRE_TIME_1D(txt = "1 day"),

    GROUP_CHAT_EXPIRE_TIME_1D_RESP(txt = "destruction time to 24 hrs")

}