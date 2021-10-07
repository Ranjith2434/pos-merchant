package com.pos.merchant.entity;

import java.util.Objects;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "order")
public class OrderDTO {

	@JsonProperty("total")
	public String orderTotal;

	public String getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(orderTotal, other.orderTotal);
	}

	@Override
	public String toString() {
		return "OrderDTO [orderTotal=" + orderTotal + "]";
	}

}
