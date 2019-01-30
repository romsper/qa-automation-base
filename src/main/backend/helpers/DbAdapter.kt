package main.backend.helpers

import org.apache.commons.dbutils.QueryRunner
import org.apache.commons.dbutils.handlers.BeanHandler
import org.apache.commons.dbutils.handlers.BeanListHandler
import java.sql.DriverManager

//---DB CREDENTIALS---
val DB_HOST = "HOST"
val DB_PORT = 5432
val DB_NAME = "NAME"
val DB_USER = "USER"
val DB_PASS = "PASS"

val JDBC_DRIVER = "org.postgresql.Driver"
val JDBC_URL = "jdbc:postgresql://$DB_HOST:$DB_PORT/$DB_NAME"
//--------------------


fun dbConnection() = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)

inline fun <reified T> QueryRunner.getUserByEmail(email: String): T {
    return BeanHandler(T::class.java).run { query(dbConnection(), "SELECT * FROM public.user WHERE email = \'$email\'", this) }
}

inline fun <reified T> QueryRunner.getUserById(id: Int): T {
    return BeanHandler(T::class.java).run { query(dbConnection(), "SELECT * FROM public.user WHERE id = $id", this) }
}

inline fun <reified T> QueryRunner.getUsers(): MutableList<T> {
    return BeanListHandler(T::class.java).run { query(dbConnection(), "SELECT * FROM public.user", this) }
}

inline fun <reified T> QueryRunner.getResetCodeByUserId(userId: Int): T {
    return BeanHandler(T::class.java).run { query(dbConnection(), "SELECT * FROM public.password_reset WHERE \"userId\" = $userId", this) }
}

fun deleteTetVideo() = QueryRunner().execute(dbConnection(), "DELETE FROM file_video WHERE \"fileName\" = \'test-video\'")