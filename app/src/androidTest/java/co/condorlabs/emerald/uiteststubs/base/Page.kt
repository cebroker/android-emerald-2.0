package co.condorlabs.emerald.uiteststubs.base

import androidx.compose.ui.test.junit4.ComposeTestRule

open class Page {
    companion object {
        inline fun <reified T : Page> on(): T {
            return Page().on()
        }
        inline fun <reified T : Page> on(composeRule: ComposeTestRule): T {
            return Page().on(composeRule)
        }
    }

    inline fun <reified T : Page> on(composeRule: ComposeTestRule? = null): T {
        val page: T = when (composeRule.isNull) {
            true -> T::class.constructors.first().call()
            false -> T::class.constructors.first().call(composeRule)
        }
        return page
    }

    fun wait(seconds: Int): Page {
        Thread.sleep(seconds * 1000L)
        return this
    }
}

val Any?.isNull: Boolean get() = this == null