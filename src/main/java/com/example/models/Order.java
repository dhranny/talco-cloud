package com.example.models;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
/**This class is basically a bean
 * but the getters and setters are
 * provided by lombok
 */
@Slf4j
@Data
@Entity
@Table(name = "Taco_Order")
public class Order {

	@Id
	public long id;
	
	private Date placedAt;
	
	@NotBlank(message = "Name can not be blank") //Validator to prevent blank input
	public String name;
	
	@NotBlank(message = "Street can not be empty")//Validator to prevent blank input
	public String street;
	
	@NotBlank(message = "City can not be empty")//Validator to prevent blank input
	public String city;
	
	@NotBlank(message = "State can not be empty")//Validator to prevent blank input
	public String state;
	
	@NotBlank(message = "Zip can not be empty")//Validator to prevent blank input
	public String zip;
	
	@CreditCardNumber(message = "Must be a credit card number") //Validator for credit card number
	public String ccNumber;
	
	@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
			message="Must be formatted MM/YY")//Validator to prevent invalid input
	public String ccExpiration;
	
	@Digits(integer=3, fraction=0, message="Invalid CVV")//Validator to prevent invalid input
	public String ccCVV;
	
	@ManyToMany(targetEntity=Taco.class)
	private List<Taco> tacos = new ArrayList<>();
	
	public void addDesign(Taco design) {
	this.tacos.add(design);
	}
	
	@PrePersist
	void placeAt() {
		placedAt = new Date();
	}

}
