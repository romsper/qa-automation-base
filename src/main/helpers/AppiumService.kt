package main.helpers

import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import io.appium.java_client.service.local.flags.GeneralServerFlag
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.io.IOException
import java.net.ServerSocket
import java.util.*


class AppiumService {

    lateinit var service: AppiumDriverLocalService
    lateinit var builder: AppiumServiceBuilder
    lateinit var cap: DesiredCapabilities

    fun startServer() {
        val environment: HashMap<String?, String?> = HashMap()
        environment["PATH"] = "/usr/local/bin:${System.getenv("PATH")}"
        environment["ANDROID_HOME"] = "/Users/${System.getenv("USER")}/Library/Android/sdk"
        environment["JAVA_HOME"] = "/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/"

        cap = DesiredCapabilities()
                .apply {  setCapability("noReset", "true") }

        builder = AppiumServiceBuilder()
                .apply {
                    withAppiumJS(File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    withIPAddress("0.0.0.0")
                    withEnvironment(environment)
                    usingPort(4723)
                    withCapabilities(cap)
                    withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                    withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                }

        service = AppiumDriverLocalService.buildService(builder)
        service.start()
        println("Server is running: ${service.isRunning}")
    }

    fun stopServer() {
        service.stop()
        println("Server is running: ${service.isRunning}")
    }

    fun checkIfServerIsRunning(port: Int): Boolean {
        var isServerRunning = false
        val serverSocket: ServerSocket?
        try {
            serverSocket = ServerSocket(port)
            serverSocket.run { close() }
        } catch (e: IOException) {
            isServerRunning = true
        }
        return isServerRunning
    }
}