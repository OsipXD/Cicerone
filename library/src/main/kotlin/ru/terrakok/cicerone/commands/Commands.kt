/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone.commands


/**
 * Rolls back the last transition from the screens chain.
 */
class Back : Command


/**
 * Rolls back to the needed screen from the screens chain.
 *
 * Behavior in the case when no needed screens found depends on an implementation of the [ru.terrakok.cicerone.Navigator].
 * But the recommended behavior is to return to the root.
 *
 * @param screenKey screen key or null if you need back to root screen
 */
class BackTo(val screenKey: String?) : Command


/**
 * Opens new screen.
 *
 * @param screenKey      screen key
 * @param transitionData initial data, can be null
 */
class Forward(override val screenKey: String, override val transitionData: Any?) : CreationalCommand


/**
 * Replaces the current screen.
 *
 * @param screenKey      screen key
 * @param transitionData initial data, can be null
 */
class Replace(override val screenKey: String, override val transitionData: Any?) : CreationalCommand


/**
 * Shows system message.
 *
 * @param message message text
 */
class SystemMessage(val message: String) : Command
