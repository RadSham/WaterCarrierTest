package com.example.watercarriertest.retrofit

import com.google.gson.annotations.SerializedName

data class Goods(
    @SerializedName("status") var status: String? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("TOVARY") var TOVARY: ArrayList<TOVARY> = arrayListOf()
)

data class TOVARY(
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("NAME") var NAME: String? = null,
    @SerializedName("data") var data: ArrayList<Data> = arrayListOf()
)

data class Data(
    @SerializedName("ID") var ID: String? = null,
    @SerializedName("IBLOCK_ID") var IBLOCKID: String? = null,
    @SerializedName("NAME") var NAME: String? = null,
    @SerializedName("DATE_ACTIVE_FROM") var DATEACTIVEFROM: String? = null,
    @SerializedName("DETAIL_PICTURE") var DETAILPICTURE: String? = null,
    @SerializedName("PROPERTY_NEWPRODUCT_VALUE") var PROPERTYNEWPRODUCTVALUE: String? = null,
    @SerializedName("PROPERTY_NEWPRODUCT_ENUM_ID") var PROPERTYNEWPRODUCTENUMID: String? = null,
    @SerializedName("PROPERTY_NEWPRODUCT_VALUE_ID") var PROPERTYNEWPRODUCTVALUEID: String? = null,
    @SerializedName("PROPERTY_PODAROK_VALUE") var PROPERTYPODAROKVALUE: String? = null,
    @SerializedName("PROPERTY_PODAROK_ENUM_ID") var PROPERTYPODAROKENUMID: String? = null,
    @SerializedName("PROPERTY_PODAROK_VALUE_ID") var PROPERTYPODAROKVALUEID: String? = null,
    @SerializedName("PROPERTY_SALELEADER_VALUE") var PROPERTYSALELEADERVALUE: String? = null,
    @SerializedName("PROPERTY_SALELEADER_ENUM_ID") var PROPERTYSALELEADERENUMID: String? = null,
    @SerializedName("PROPERTY_SALELEADER_VALUE_ID") var PROPERTYSALELEADERVALUEID: String? = null,
    @SerializedName("PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE") var PROPERTYTSENAZAEDINITSUTOVARAVALUE: Int? = null,
    @SerializedName("PROPERTY_TSENA_ZA_EDINITSU_TOVARA_VALUE_ID") var PROPERTYTSENAZAEDINITSUTOVARAVALUEID: String? = null,
    @SerializedName("PROPERTY_RATING_VALUE") var PROPERTYRATINGVALUE: Double? = null,
    @SerializedName("PROPERTY_RATING_VALUE_ID") var PROPERTYRATINGVALUEID: String? = null,
    @SerializedName("CATALOG_QUANTITY") var CATALOGQUANTITY: Int? = null,
    @SerializedName("CATALOG_QUANTITY_TRACE") var CATALOGQUANTITYTRACE: String? = null,
    @SerializedName("CATALOG_QUANTITY_TRACE_ORIG") var CATALOGQUANTITYTRACEORIG: String? = null,
    @SerializedName("CATALOG_WEIGHT") var CATALOGWEIGHT: String? = null,
    @SerializedName("CATALOG_VAT_ID") var CATALOGVATID: String? = null,
    @SerializedName("CATALOG_VAT_INCLUDED") var CATALOGVATINCLUDED: String? = null,
    @SerializedName("CATALOG_CAN_BUY_ZERO") var CATALOGCANBUYZERO: String? = null,
    @SerializedName("CATALOG_CAN_BUY_ZERO_ORIG") var CATALOGCANBUYZEROORIG: String? = null,
    @SerializedName("CATALOG_PURCHASING_PRICE") var CATALOGPURCHASINGPRICE: String? = null,
    @SerializedName("CATALOG_PURCHASING_CURRENCY") var CATALOGPURCHASINGCURRENCY: String? = null,
    @SerializedName("CATALOG_QUANTITY_RESERVED") var CATALOGQUANTITYRESERVED: String? = null,
    @SerializedName("CATALOG_SUBSCRIBE") var CATALOGSUBSCRIBE: String? = null,
    @SerializedName("CATALOG_SUBSCRIBE_ORIG") var CATALOGSUBSCRIBEORIG: String? = null,
    @SerializedName("CATALOG_WIDTH") var CATALOGWIDTH: String? = null,
    @SerializedName("CATALOG_LENGTH") var CATALOGLENGTH: String? = null,
    @SerializedName("CATALOG_HEIGHT") var CATALOGHEIGHT: String? = null,
    @SerializedName("CATALOG_MEASURE") var CATALOGMEASURE: String? = null,
    @SerializedName("CATALOG_TYPE") var CATALOGTYPE: String? = null,
    @SerializedName("CATALOG_AVAILABLE") var CATALOGAVAILABLE: String? = null,
    @SerializedName("CATALOG_BUNDLE") var CATALOGBUNDLE: String? = null,
    @SerializedName("CATALOG_PRICE_TYPE") var CATALOGPRICETYPE: String? = null,
    @SerializedName("CATALOG_RECUR_SCHEME_LENGTH") var CATALOGRECURSCHEMELENGTH: String? = null,
    @SerializedName("CATALOG_RECUR_SCHEME_TYPE") var CATALOGRECURSCHEMETYPE: String? = null,
    @SerializedName("CATALOG_TRIAL_PRICE_ID") var CATALOGTRIALPRICEID: String? = null,
    @SerializedName("CATALOG_WITHOUT_ORDER") var CATALOGWITHOUTORDER: String? = null,
    @SerializedName("CATALOG_SELECT_BEST_PRICE") var CATALOGSELECTBESTPRICE: String? = null,
    @SerializedName("CATALOG_NEGATIVE_AMOUNT_TRACE") var CATALOGNEGATIVEAMOUNTTRACE: String? = null,
    @SerializedName("CATALOG_NEGATIVE_AMOUNT_TRACE_ORIG") var CATALOGNEGATIVEAMOUNTTRACEORIG: String? = null,
    @SerializedName("CATALOG_VAT") var CATALOGVAT: String? = null,
    @SerializedName("EXTENDED_PRICE") var EXTENDEDPRICE: ArrayList<EXTENDEDPRICE> = arrayListOf(),
    @SerializedName("MORE_PHOTO") var MOREPHOTO: MOREPHOTO? = MOREPHOTO(),
    @SerializedName("COUTCOMMENTS") var COUTCOMMENTS: String? = null,
    @SerializedName("PROPERTY_ZALOG_VALUE") var PROPERTYZALOGVALUE: Int? = null,
    @SerializedName("FAVORITE") var FAVORITE: Boolean? = null,
    @SerializedName("KOFFICIENT") var KOFFICIENT: Int? = null,
    @SerializedName("NALICHIE") var NALICHIE: String? = null,
    @SerializedName("EDINICAIZMERENIYA") var EDINICAIZMERENIYA: String? = null
)

data class EXTENDEDPRICE(
    @SerializedName("PRICE") var PRICE: Int? = null,
    @SerializedName("OLD_PRICE") var OLDPRICE: Int? = null,
    @SerializedName("QUANTITY_FROM") var QUANTITYFROM: Int? = null,
    @SerializedName("QUANTITY_TO") var QUANTITYTO: Int? = null
)

data class MOREPHOTO(
    @SerializedName("VALUE") var VALUE: ArrayList<String> = arrayListOf()
)
