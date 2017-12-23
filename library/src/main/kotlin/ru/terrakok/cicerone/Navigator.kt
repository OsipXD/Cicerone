/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone

import ru.terrakok.cicerone.commands.Command

/**
 * The low-level navigation interface.
 * Navigator is the one who actually performs any transition.
 */
interface Navigator {

    /**
     * Performs transition described by navigation commands
     *
     * @param commands navigation commands array to apply per single transaction
     */
    fun applyCommands(commands: Array<out Command>)
}
