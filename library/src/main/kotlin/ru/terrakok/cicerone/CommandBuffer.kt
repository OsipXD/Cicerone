/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone

import ru.terrakok.cicerone.commands.Command
import java.util.*

/**
 * Passes navigation command to an active [Navigator]
 * or stores it in the pending commands queue to pass it later.
 */
internal class CommandBuffer : NavigatorHolder {

    private var navigator: Navigator? = null
    private val pendingCommands = LinkedList<Array<out Command>>()

    override fun setNavigator(navigator: Navigator?) {
        this.navigator = navigator

        while (!pendingCommands.isEmpty()) {
            if (navigator == null) break
            executeCommands(pendingCommands.poll())
        }
    }

    override fun removeNavigator() {
        this.navigator = null
    }

    /**
     * Passes [commands] to the [Navigator] if it available.
     * Else puts it to the pending commands queue to pass it later.
     *
     * @param commands navigation commands array
     */
    fun executeCommands(commands: Array<out Command>) {
        navigator?.applyCommands(commands) ?: pendingCommands.add(commands)
    }
}
