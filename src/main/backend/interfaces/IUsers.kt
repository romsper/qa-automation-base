package backend.interfaces

import backend.base.UserBase

interface IUsers {
    val user get() = UserBase()
}