package main.helpers

import main.elements.contacts.contactsHelper.ContactHelper
import main.elements.contacts.contactsHelper.ContactHelperAndroid
import main.elements.contacts.contactsHelper.ContactHelperIOS
import main.elements.header.TopNavigationElems
import main.elements.header.TopNavigationElemsAndroid
import main.elements.header.TopNavigationElemsIOS
import main.elements.navigation.BottomNavigationElems
import main.elements.navigation.BottomNavigationElemsAndroid
import main.elements.navigation.BottomNavigationElemsIOS
import main.screens.authorization.LoginScreen
import main.screens.authorization.LoginScreenAndroid
import main.screens.authorization.LoginScreenIOS
import main.screens.chat.ChatScreen
import main.screens.chat.ChatScreenAndroid
import main.screens.chat.ChatScreenIOS
import main.screens.chat.settings.SoloChatSettingsScreen
import main.screens.chat.settings.SoloChatSettingsScreenAndroid
import main.screens.chat.settings.SoloChatSettingsScreenIOS
import main.screens.chats.ChatsScreen
import main.screens.chats.ChatsScreenAndroid
import main.screens.chats.ChatsScreenIOS
import main.screens.contacts.ContactsScreen
import main.screens.contacts.ContactsScreenAndroid
import main.screens.contacts.ContactsScreenIOS
import main.screens.contacts.add.AddContactScreen
import main.screens.contacts.add.AddContactScreenAndroid
import main.screens.contacts.add.AddContactScreenIOS
import main.screens.contacts.categories.CategoriesScreen
import main.screens.contacts.categories.CategoriesScreenAndroid
import main.screens.contacts.categories.CategoriesScreenIOS
import main.screens.contacts.invitation.InvitationScreen
import main.screens.contacts.invitation.InvitationScreenAndroid
import main.screens.contacts.invitation.InvitationScreenIOS
import main.screens.groupChat.GroupChatSettingsScreen
import main.screens.groupChat.GroupChatSettingsScreenAndroid
import main.screens.groupChat.GroupChatSettingsScreenIOS
import main.screens.settings.SettingsScreen
import main.screens.settings.SettingsScreenAndroid
import main.screens.settings.SettingsScreenIOS
import main.screens.settings.block.BlockScreen
import main.screens.settings.block.BlockScreenAndroid
import main.screens.settings.block.BlockScreenIOS
import main.screens.vault.authorization.VaultLoginScreen
import main.screens.vault.authorization.VaultLoginScreenAndroid
import main.screens.vault.authorization.VaultLoginScreenIOS
import main.screens.vault.chats.VaultChatsScreen
import main.screens.vault.chats.VaultChatsScreenAndroid
import main.screens.vault.chats.VaultChatsScreenIOS
import main.screens.vault.image.VaultImageScreen
import main.screens.vault.image.VaultImageScreenAndroid
import main.screens.vault.image.VaultImageScreenIOS
import org.junit.jupiter.api.fail

val screen = when (InitDriverProvider().platform) {
    "Android" -> AndroidPageFactory
    "iOS" -> IOSPageFactory
    else -> fail("Wrong page")
}

interface PageFactory {
    val login: LoginScreen
    val topNavigation: TopNavigationElems
    val bottomNavigation: BottomNavigationElems
    val settings: SettingsScreen
    val block: BlockScreen
    val chats: ChatsScreen
    val chat: ChatScreen
    val soloChatSettings: SoloChatSettingsScreen
    val groupChatSettings: GroupChatSettingsScreen
    val contacts: ContactsScreen
    val addContact: AddContactScreen
    val categories: CategoriesScreen
    val invitation: InvitationScreen
    val vaultLogin: VaultLoginScreen
    val vaultChats: VaultChatsScreen
    val vaultImage: VaultImageScreen

    val contactHelper: ContactHelper
}

object AndroidPageFactory : PageFactory {
    override val login = LoginScreenAndroid()
    override val topNavigation = TopNavigationElemsAndroid()
    override val bottomNavigation = BottomNavigationElemsAndroid()
    override val settings = SettingsScreenAndroid()
    override val block = BlockScreenAndroid()
    override val chats = ChatsScreenAndroid()
    override val chat = ChatScreenAndroid()
    override val soloChatSettings = SoloChatSettingsScreenAndroid()
    override val groupChatSettings = GroupChatSettingsScreenAndroid()
    override val contacts = ContactsScreenAndroid()
    override val addContact = AddContactScreenAndroid()
    override val categories = CategoriesScreenAndroid()
    override val invitation = InvitationScreenAndroid()
    override val vaultLogin = VaultLoginScreenAndroid()
    override val vaultChats = VaultChatsScreenAndroid()
    override val vaultImage = VaultImageScreenAndroid()

    override val contactHelper = ContactHelperAndroid()
}

object IOSPageFactory : PageFactory  {
    override val login = LoginScreenIOS()
    override val topNavigation = TopNavigationElemsIOS()
    override val bottomNavigation = BottomNavigationElemsIOS()
    override val settings = SettingsScreenIOS()
    override val block = BlockScreenIOS()
    override val chats = ChatsScreenIOS()
    override val chat = ChatScreenIOS()
    override val soloChatSettings = SoloChatSettingsScreenIOS()
    override val groupChatSettings = GroupChatSettingsScreenIOS()
    override val contacts = ContactsScreenIOS()
    override val addContact = AddContactScreenIOS()
    override val categories = CategoriesScreenIOS()
    override val invitation = InvitationScreenIOS()
    override val vaultLogin = VaultLoginScreenIOS()
    override val vaultChats = VaultChatsScreenIOS()
    override val vaultImage = VaultImageScreenIOS()

    override val contactHelper = ContactHelperIOS()
}