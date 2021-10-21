package main.backend.helpers

import java.text.SimpleDateFormat
import java.util.Properties

// It's just an example!

@Suppress("JAVA_CLASS_ON_COMPANION")
class Properties {

    companion object {
        fun properties(): Props {
            val prop = Properties()
            System.setProperty("prop_file", "qa-gcp-1.properties")
            prop.load(this.javaClass.classLoader.getResourceAsStream(System.getProperty("prop_file")))

            return Props(
                browserName = prop.getProperty("browser.name"),
                browserVersion = prop.getProperty("browser.version"),
                serverHostname = prop.getProperty("servers.hostname"),
                serversUrl = prop.getProperty("servers.url"),
                adminId = prop.getProperty("admin.id").toLong(),
                adminEmail = prop.getProperty("admin.email"),
                adminPassword = prop.getProperty("admin.password"),
                companyId = prop.getProperty("company.id").toLong(),
                locationId = prop.getProperty("company.locationId").toLong()
            )
        }
    }

    data class Props(
        val dateWithTimeZone: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        var browserName: String,
        var browserVersion: String,
        var serverHostname: String,
        var serversUrl: String,
        var adminId: Long,
        var adminEmail: String,
        var adminPassword: String,
        var companyId: Long,
        var locationId: Long,
    )
}
