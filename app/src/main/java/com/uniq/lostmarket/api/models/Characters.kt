package com.uniq.lostmarket.api.models

data class Characters(
    var ServerName: String? = null,
    var CharacterName: String? = null,
    var CharacterLevel: Int? = null,
    var CharacterClassName: String? = null,
    var ItemAvgLevel: String? = null,
    var ItemMaxLevel: String? = null,
)
