package com.uniq.lostmarket.api.models

import com.uniq.lostmarket.api.models.MarketItem

data class MarketList(
    var PageNo: Int? = null,
    var PageSize: Int? = null,
    var TotalCount: Int? = null,
    var Items: List<MarketItem>? = null,
)
