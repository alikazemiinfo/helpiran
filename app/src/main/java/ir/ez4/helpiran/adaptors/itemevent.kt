package ir.ez4.helpiran.adaptors

import ir.ez4.helpiran.data.Itempost

interface Itemevent {
    fun onitemclicked(itempost: Itempost)
}