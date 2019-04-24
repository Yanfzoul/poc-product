package com.adobe.poc.core.model.simpleproduct;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"item_id",
"product_id",
"stock_id",
"qty",
"is_in_stock",
"is_qty_decimal",
"show_default_notification_message",
"use_config_min_qty",
"min_qty",
"use_config_min_sale_qty",
"min_sale_qty",
"use_config_max_sale_qty",
"max_sale_qty",
"use_config_backorders",
"backorders",
"use_config_notify_stock_qty",
"notify_stock_qty",
"use_config_qty_increments",
"qty_increments",
"use_config_enable_qty_inc",
"enable_qty_increments",
"use_config_manage_stock",
"manage_stock",
"low_stock_date",
"is_decimal_divided",
"stock_status_changed_auto"
})
public class StockItem {

@JsonProperty("item_id")
private Integer itemId;
@JsonProperty("product_id")
private Integer productId;
@JsonProperty("stock_id")
private Integer stockId;
@JsonProperty("qty")
private Integer qty;
@JsonProperty("is_in_stock")
private Boolean isInStock;
@JsonProperty("is_qty_decimal")
private Boolean isQtyDecimal;
@JsonProperty("show_default_notification_message")
private Boolean showDefaultNotificationMessage;
@JsonProperty("use_config_min_qty")
private Boolean useConfigMinQty;
@JsonProperty("min_qty")
private Integer minQty;
@JsonProperty("use_config_min_sale_qty")
private Integer useConfigMinSaleQty;
@JsonProperty("min_sale_qty")
private Integer minSaleQty;
@JsonProperty("use_config_max_sale_qty")
private Boolean useConfigMaxSaleQty;
@JsonProperty("max_sale_qty")
private Integer maxSaleQty;
@JsonProperty("use_config_backorders")
private Boolean useConfigBackorders;
@JsonProperty("backorders")
private Integer backorders;
@JsonProperty("use_config_notify_stock_qty")
private Boolean useConfigNotifyStockQty;
@JsonProperty("notify_stock_qty")
private Integer notifyStockQty;
@JsonProperty("use_config_qty_increments")
private Boolean useConfigQtyIncrements;
@JsonProperty("qty_increments")
private Integer qtyIncrements;
@JsonProperty("use_config_enable_qty_inc")
private Boolean useConfigEnableQtyInc;
@JsonProperty("enable_qty_increments")
private Boolean enableQtyIncrements;
@JsonProperty("use_config_manage_stock")
private Boolean useConfigManageStock;
@JsonProperty("manage_stock")
private Boolean manageStock;
@JsonProperty("low_stock_date")
private Object lowStockDate;
@JsonProperty("is_decimal_divided")
private Boolean isDecimalDivided;
@JsonProperty("stock_status_changed_auto")
private Integer stockStatusChangedAuto;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("item_id")
public Integer getItemId() {
return itemId;
}

@JsonProperty("item_id")
public void setItemId(Integer itemId) {
this.itemId = itemId;
}

@JsonProperty("product_id")
public Integer getProductId() {
return productId;
}

@JsonProperty("product_id")
public void setProductId(Integer productId) {
this.productId = productId;
}

@JsonProperty("stock_id")
public Integer getStockId() {
return stockId;
}

@JsonProperty("stock_id")
public void setStockId(Integer stockId) {
this.stockId = stockId;
}

@JsonProperty("qty")
public Integer getQty() {
return qty;
}

@JsonProperty("qty")
public void setQty(Integer qty) {
this.qty = qty;
}

@JsonProperty("is_in_stock")
public Boolean getIsInStock() {
return isInStock;
}

@JsonProperty("is_in_stock")
public void setIsInStock(Boolean isInStock) {
this.isInStock = isInStock;
}

@JsonProperty("is_qty_decimal")
public Boolean getIsQtyDecimal() {
return isQtyDecimal;
}

@JsonProperty("is_qty_decimal")
public void setIsQtyDecimal(Boolean isQtyDecimal) {
this.isQtyDecimal = isQtyDecimal;
}

@JsonProperty("show_default_notification_message")
public Boolean getShowDefaultNotificationMessage() {
return showDefaultNotificationMessage;
}

@JsonProperty("show_default_notification_message")
public void setShowDefaultNotificationMessage(Boolean showDefaultNotificationMessage) {
this.showDefaultNotificationMessage = showDefaultNotificationMessage;
}

@JsonProperty("use_config_min_qty")
public Boolean getUseConfigMinQty() {
return useConfigMinQty;
}

@JsonProperty("use_config_min_qty")
public void setUseConfigMinQty(Boolean useConfigMinQty) {
this.useConfigMinQty = useConfigMinQty;
}

@JsonProperty("min_qty")
public Integer getMinQty() {
return minQty;
}

@JsonProperty("min_qty")
public void setMinQty(Integer minQty) {
this.minQty = minQty;
}

@JsonProperty("use_config_min_sale_qty")
public Integer getUseConfigMinSaleQty() {
return useConfigMinSaleQty;
}

@JsonProperty("use_config_min_sale_qty")
public void setUseConfigMinSaleQty(Integer useConfigMinSaleQty) {
this.useConfigMinSaleQty = useConfigMinSaleQty;
}

@JsonProperty("min_sale_qty")
public Integer getMinSaleQty() {
return minSaleQty;
}

@JsonProperty("min_sale_qty")
public void setMinSaleQty(Integer minSaleQty) {
this.minSaleQty = minSaleQty;
}

@JsonProperty("use_config_max_sale_qty")
public Boolean getUseConfigMaxSaleQty() {
return useConfigMaxSaleQty;
}

@JsonProperty("use_config_max_sale_qty")
public void setUseConfigMaxSaleQty(Boolean useConfigMaxSaleQty) {
this.useConfigMaxSaleQty = useConfigMaxSaleQty;
}

@JsonProperty("max_sale_qty")
public Integer getMaxSaleQty() {
return maxSaleQty;
}

@JsonProperty("max_sale_qty")
public void setMaxSaleQty(Integer maxSaleQty) {
this.maxSaleQty = maxSaleQty;
}

@JsonProperty("use_config_backorders")
public Boolean getUseConfigBackorders() {
return useConfigBackorders;
}

@JsonProperty("use_config_backorders")
public void setUseConfigBackorders(Boolean useConfigBackorders) {
this.useConfigBackorders = useConfigBackorders;
}

@JsonProperty("backorders")
public Integer getBackorders() {
return backorders;
}

@JsonProperty("backorders")
public void setBackorders(Integer backorders) {
this.backorders = backorders;
}

@JsonProperty("use_config_notify_stock_qty")
public Boolean getUseConfigNotifyStockQty() {
return useConfigNotifyStockQty;
}

@JsonProperty("use_config_notify_stock_qty")
public void setUseConfigNotifyStockQty(Boolean useConfigNotifyStockQty) {
this.useConfigNotifyStockQty = useConfigNotifyStockQty;
}

@JsonProperty("notify_stock_qty")
public Integer getNotifyStockQty() {
return notifyStockQty;
}

@JsonProperty("notify_stock_qty")
public void setNotifyStockQty(Integer notifyStockQty) {
this.notifyStockQty = notifyStockQty;
}

@JsonProperty("use_config_qty_increments")
public Boolean getUseConfigQtyIncrements() {
return useConfigQtyIncrements;
}

@JsonProperty("use_config_qty_increments")
public void setUseConfigQtyIncrements(Boolean useConfigQtyIncrements) {
this.useConfigQtyIncrements = useConfigQtyIncrements;
}

@JsonProperty("qty_increments")
public Integer getQtyIncrements() {
return qtyIncrements;
}

@JsonProperty("qty_increments")
public void setQtyIncrements(Integer qtyIncrements) {
this.qtyIncrements = qtyIncrements;
}

@JsonProperty("use_config_enable_qty_inc")
public Boolean getUseConfigEnableQtyInc() {
return useConfigEnableQtyInc;
}

@JsonProperty("use_config_enable_qty_inc")
public void setUseConfigEnableQtyInc(Boolean useConfigEnableQtyInc) {
this.useConfigEnableQtyInc = useConfigEnableQtyInc;
}

@JsonProperty("enable_qty_increments")
public Boolean getEnableQtyIncrements() {
return enableQtyIncrements;
}

@JsonProperty("enable_qty_increments")
public void setEnableQtyIncrements(Boolean enableQtyIncrements) {
this.enableQtyIncrements = enableQtyIncrements;
}

@JsonProperty("use_config_manage_stock")
public Boolean getUseConfigManageStock() {
return useConfigManageStock;
}

@JsonProperty("use_config_manage_stock")
public void setUseConfigManageStock(Boolean useConfigManageStock) {
this.useConfigManageStock = useConfigManageStock;
}

@JsonProperty("manage_stock")
public Boolean getManageStock() {
return manageStock;
}

@JsonProperty("manage_stock")
public void setManageStock(Boolean manageStock) {
this.manageStock = manageStock;
}

@JsonProperty("low_stock_date")
public Object getLowStockDate() {
return lowStockDate;
}

@JsonProperty("low_stock_date")
public void setLowStockDate(Object lowStockDate) {
this.lowStockDate = lowStockDate;
}

@JsonProperty("is_decimal_divided")
public Boolean getIsDecimalDivided() {
return isDecimalDivided;
}

@JsonProperty("is_decimal_divided")
public void setIsDecimalDivided(Boolean isDecimalDivided) {
this.isDecimalDivided = isDecimalDivided;
}

@JsonProperty("stock_status_changed_auto")
public Integer getStockStatusChangedAuto() {
return stockStatusChangedAuto;
}

@JsonProperty("stock_status_changed_auto")
public void setStockStatusChangedAuto(Integer stockStatusChangedAuto) {
this.stockStatusChangedAuto = stockStatusChangedAuto;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}