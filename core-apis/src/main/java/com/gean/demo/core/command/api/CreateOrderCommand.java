
package com.gean.demo.core.command.api;

import java.io.Serializable;
import java.math.BigDecimal;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateOrderCommand implements Serializable {

	private static final long serialVersionUID = -460581743066290993L;

	@TargetAggregateIdentifier
	private String orderId;

	private String itemType;

	private BigDecimal price;

	private String currency;

	private String orderStatus;

	public CreateOrderCommand() {}

	public CreateOrderCommand(final String orderId,
	        final String itemType,
	        final BigDecimal price,
	        final String currency,
	        final String orderStatus) {
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(final String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(final String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (currency == null ? 0 : currency.hashCode());
		result = prime * result + (itemType == null ? 0 : itemType.hashCode());
		result = prime * result + (orderId == null ? 0 : orderId.hashCode());
		result = prime * result + (orderStatus == null ? 0 : orderStatus.hashCode());
		result = prime * result + (price == null ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CreateOrderCommand other = (CreateOrderCommand) obj;
		if (currency == null) {
			if (other.currency != null) {
				return false;
			}
		} else if (!currency.equals(other.currency)) {
			return false;
		}
		if (itemType == null) {
			if (other.itemType != null) {
				return false;
			}
		} else if (!itemType.equals(other.itemType)) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (orderStatus == null) {
			if (other.orderStatus != null) {
				return false;
			}
		} else if (!orderStatus.equals(other.orderStatus)) {
			return false;
		}
		if (price == null) {
			if (other.price != null) {
				return false;
			}
		} else if (!price.equals(other.price)) {
			return false;
		}
		return true;
	}

}
