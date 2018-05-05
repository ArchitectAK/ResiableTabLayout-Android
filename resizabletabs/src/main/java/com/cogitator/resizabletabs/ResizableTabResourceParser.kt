package com.cogitator.resizabletabs

import android.content.Context
import android.content.res.XmlResourceParser
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import org.xmlpull.v1.XmlPullParserException
import java.util.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 04/05/2018 (MM/DD/YYYY)
 */
class ResizableTabResourceParser(private val context: Context?, xmlRes: Int) {

    private val parser = context?.resources?.getXml(xmlRes)

    private var itemSize: Float = 0.0f
    var space: Float = 0.0f

    fun parse(): List<ResizableTabItemContainer> {
        val tabs: ArrayList<ResizableTabItemContainer> = arrayListOf()
        try {
            var eventType: Int?
            do {
                eventType = parser?.next()
                if (eventType == XmlResourceParser.START_TAG && KEY_TABS == parser?.name) {
                    parseTabsConfig(parser)
                } else if (eventType == XmlResourceParser.START_TAG && KEY_TAB == parser?.name) {
                    val tab: ResizableTabItemContainer = parseSingleTab(parser)
                    tabs.add(tab)
                }
            } while (eventType != XmlResourceParser.END_DOCUMENT)
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
            throw Exception()
        }
        return tabs
    }

    private fun parseTabsConfig(parser: XmlResourceParser) {
        val attributeCount = parser.attributeCount
        for (i in 0 until attributeCount) {
            when (parser.getAttributeName(i)) {
                KEY_SIZE -> itemSize = getDimen(parser, i)
                KEY_SPACE -> space = getDimen(parser, i)
            }
        }
    }

    private fun parseSingleTab(parser: XmlResourceParser): ResizableTabItemContainer {
        val attributeCount = parser.attributeCount
        val singleTab = ResizableTabItemContainer(context!!)
        val singleTabConfig = ResizableTabItemData()
        singleTabConfig.size = itemSize
        singleTabConfig.space = space.toInt()

        for (i in 0 until attributeCount) {
            when (parser.getAttributeName(i)) {
                KEY_INACTIVE_COLOR -> singleTabConfig.inactiveColor = getColor(parser, i)
                KEY_ACTIVE_COLOR -> singleTabConfig.activeColor = getColor(parser, i)
                KEY_DRAWABLE -> singleTabConfig.drawable = getDrawable(parser, i)
            }
        }
        singleTab.setItemConfig(singleTabConfig)
        return singleTab
    }

    private fun getColor(parser: XmlResourceParser, i: Int): Int {
        return ContextCompat.getColor(context!!, parser.getAttributeResourceValue(i, 0))
    }

    private fun getDrawable(parser: XmlResourceParser, i: Int): Drawable? {
        return ContextCompat.getDrawable(context!!, parser.getAttributeResourceValue(i, 0))
    }

    private fun getDimen(parser: XmlResourceParser, i: Int): Float {
        return context!!.resources.getDimension(parser.getAttributeResourceValue(i, 0))
    }

    companion object {
        const val KEY_INACTIVE_COLOR: String = "inactiveColor"
        const val KEY_ACTIVE_COLOR: String = "activeColor"
        const val KEY_DRAWABLE: String = "drawable"
        const val KEY_SIZE: String = "size"
        const val KEY_SPACE: String = "space"

        const val KEY_TAB: String = "tab"
        const val KEY_TABS: String = "tabs"
    }

}