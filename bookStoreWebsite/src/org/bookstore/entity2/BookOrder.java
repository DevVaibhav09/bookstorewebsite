package org.bookstore.entity2;
// Generated 19 May, 2019 11:45:01 PM by Hibernate Tools 5.2.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BookOrder generated by hbm2java
 */
@Entity
@Table(name = "book_order", catalog = "bookstoredb")
public class BookOrder implements java.io.Serializable {

	private int orderId;
	private Customer customer;
	private Date orderDate;
	private String shippingAddress;
	private String recipientFirstName;
	private String recipientLastName;
	private String recipientPhone;
	private String paymentMethod;
	private float total;
	private String status;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public BookOrder() {
	}

	public BookOrder(int orderId, Customer customer, Date orderDate, String shippingAddress, String recipientFirstName,
			String recipientLastName, String recipientPhone, String paymentMethod, float total, String status) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.recipientFirstName = recipientFirstName;
		this.recipientLastName = recipientLastName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
	}

	public BookOrder(int orderId, Customer customer, Date orderDate, String shippingAddress, String recipientFirstName,
			String recipientLastName, String recipientPhone, String paymentMethod, float total, String status,
			Set<OrderDetail> orderDetails) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.recipientFirstName = recipientFirstName;
		this.recipientLastName = recipientLastName;
		this.recipientPhone = recipientPhone;
		this.paymentMethod = paymentMethod;
		this.total = total;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	@Id

	@Column(name = "order_id", unique = true, nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "shipping_address", nullable = false, length = 256)
	public String getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "recipient_first_name", nullable = false, length = 45)
	public String getRecipientFirstName() {
		return this.recipientFirstName;
	}

	public void setRecipientFirstName(String recipientFirstName) {
		this.recipientFirstName = recipientFirstName;
	}

	@Column(name = "recipient_last_name", nullable = false, length = 45)
	public String getRecipientLastName() {
		return this.recipientLastName;
	}

	public void setRecipientLastName(String recipientLastName) {
		this.recipientLastName = recipientLastName;
	}

	@Column(name = "recipient_phone", nullable = false, length = 15)
	public String getRecipientPhone() {
		return this.recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Column(name = "payment_method", nullable = false, length = 20)
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Column(name = "total", nullable = false, precision = 12, scale = 0)
	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Column(name = "status", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookOrder")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
