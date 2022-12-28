package com.uniq.lostmarket.api.models

data class MarketItem(
    var Id: Int? = null,
    var Name: String? = null,
    var Grade: String? = null,
    var Icon: String? = null,
    var BundleCount: Int? = null,
    var TradeRemainCount: Int? = null,
    var YDayAvgPrice: Double? = null,
    var RecentPrice: Int? = null,
    var CurrentMinPrice: Int? = null,
)