package com.uniq.lostmarket.api.models

data class MarketList(
    var PageNo: Int? = null,
    var PageSize: Int? = null,
    var TotalCount: Int? = null,
    var Items: List<MarketItem>? = null,
)
