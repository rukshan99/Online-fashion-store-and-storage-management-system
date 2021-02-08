package com.OnlineFashionStore.customer.jpa;


import javax.persistence.*;


@Entity
public class Rating {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="RateId")
	private long RateId;
	
	@Column(name="Name")
    private String Name;

    @Column(name="Email")
    private String email;

    @Column(name="rate")
    private String rate;
      
    @Column(name="Comment")
    private String Comment;





	public long getRateId() {
		return RateId;
	}

	public void setRateId(long rateId) {
		this.RateId = rateId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	@Override
	public String toString() {
		return "Rating [RateId=" + RateId + ", Name=" + Name + ", email=" + email + ", rate=" + rate + ", Comment="
				+ Comment + "]";
	}
	


	

	
	

}
