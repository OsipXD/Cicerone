/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone

import ru.terrakok.cicerone.commands.Command

/**
 * BaseRouter is an abstract class to implement high-level navigation.
 * Extend it to add needed transition methods.
 */
abstract class BaseRouter {

    internal val commandBuffer = CommandBuffer()

    /**
     * Sends navigation command to [CommandBuffer].
     *
     * @param commands navigation command to execute
     */
    protected fun executeCommands(vararg commands: Command) {
        commandBuffer.executeCommands(commands)
    }
}
