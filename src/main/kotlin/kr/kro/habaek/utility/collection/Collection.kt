package kr.kro.habaek.utility.collection

fun Collection<Any>.toStirngList(): List<String> {
    val list = mutableListOf<String>()
    for (a in this) list.add(a.toString())
    return list.toList()
}