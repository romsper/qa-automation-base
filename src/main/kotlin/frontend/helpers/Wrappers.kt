package frontend.helpers

import com.codeborne.selenide.Selectors
import org.openqa.selenium.By

class Wrappers {

    companion object {
        fun byDataTarget(target: String): By {
            return Selectors.by("data-autotest-target", target)
        }

        fun byDataTargetId(target: String): By {
            return Selectors.by("data-autotest-target-id", target)
        }
    }
}