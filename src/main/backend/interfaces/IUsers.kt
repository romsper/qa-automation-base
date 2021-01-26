package main.backend.interfaces

import main.backend.base.UserBase

interface IUsers {
    val user get() = UserBase()
}