package com.example.testandroid.models

enum class Categories(val value: String){
    ALL("All together"),
    WOMEN("For women"),
    MEN("For men"),
    HEALTH("Health & Wellness"),
    ANIMALS("Animals"),
    NATURE("Nature"),
}

fun getAllCategories(): List<Categories>{
    return listOf(
        Categories.ALL,
        Categories.WOMEN,
        Categories.MEN,
        Categories.HEALTH,
        Categories.ANIMALS,
        Categories.NATURE,
    )
}

fun getCategory(value: String): Categories? {
    val map = Categories.values().associateBy(Categories::value)
    return map[value]
}
fun getIndexedCategory(index:Int):Categories?{
    return  Categories.values()[index]
}
