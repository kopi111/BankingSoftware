package comBankingApp.AOOPProject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_Address")
public class customerAddress {
	
	@Id
	@Column(name="Address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	
	@Column(name="account_number")
	private int accountNumber;

	@Column(name="street_name")
	private String streetName;
	
	@Column(name="community")
	private String community;
	

	@Column(name="Parish")
	private String parish;
	
	@OneToOne(mappedBy="address",cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="address_id_geneartion")
	private customerInformation customer;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getstreetName() {
		return streetName;
	}

	public void setstreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getParish() {
		return parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}

	public customerInformation getCustomer() {
		return customer;
	}

	public void setCustomer(customerInformation customer) {
		this.customer = customer;
	}

	public customerAddress(int addressId, String streetName, String community, String parish,
			customerInformation customer) {
		
		this.addressId = addressId;
		this.streetName = streetName;
		this.community = community;
		this.parish = parish;
		this.customer = customer;
	}
		
	
	public customerAddress(int addressId, String streetName, String community, String parish
			) 
	{
		
		this.addressId = addressId;
		this.streetName = streetName;
		this.community = community;
		this.parish = parish;
		
	}
    
	public customerAddress() {
		
		this.addressId = addressId;
		this.streetName = streetName;
		this.community = community;
		this.parish = parish;
		this.customer = customer;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public customerAddress(int addressId, int accountNumber, String streetName, String community, String parish,
			customerInformation customer) {
		
		this.addressId = addressId;
		this.accountNumber = accountNumber;
		this.streetName = streetName;
		this.community = community;
		this.parish = parish;
		this.customer = customer;
	}

	

}
