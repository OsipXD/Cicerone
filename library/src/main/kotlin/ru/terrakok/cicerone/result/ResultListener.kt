/*
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 */

package ru.terrakok.cicerone.result

interface ResultListener {

    /**
     * Received result from screen.
     *
     * @param resultData
     */
    fun onResult(resultData: Any)
}
