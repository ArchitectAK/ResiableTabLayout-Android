package com.cogitator.resizabletabs

import android.graphics.drawable.Drawable

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 04/05/2018 (MM/DD/YYYY)
 */
data class ResizableTabItemData(var drawable: Drawable? = null,
                                var activeColor: Int = 0,
                                var inactiveColor: Int = 0,
                                var size: Float = 0f,
                                var space: Int = 0)