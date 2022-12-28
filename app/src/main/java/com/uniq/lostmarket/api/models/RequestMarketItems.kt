package com.uniq.lostmarket.api.models

data class RequestMarketItems(
    var Sort: String? = "GRADE",
    var CategoryCode: Int? = 40000,
    var CharacterClass: String? = "기상술사",
    var ItemTier: Int? = 0,
    var ItemGrade: String? = "",
    var ItemName: String? = "",
    var PageNo: Int? = 0,
    var SortCondition: String? = "ASC",
)
