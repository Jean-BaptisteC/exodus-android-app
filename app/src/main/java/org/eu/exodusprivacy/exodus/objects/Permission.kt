package org.eu.exodusprivacy.exodus.objects

data class Permission(
    val shortName: String = String(),
    val longName: String = String(),
    val label: String = String(),
    val description: String = String()
)
