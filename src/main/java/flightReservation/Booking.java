package flightReservation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;



@Entity
@Table(name = "booking")
@SequenceGenerator(name = "booking_seq")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
	private Integer id;
	@Column
	@NotNull
	private String bookingNum;
	@Column
	@NotNull
	private String lastname;
	@Column
	@NotNull
	private String firstname;
	@Column
	@NotNull
	private int age;
	@ManyToOne
	private Flight flight;

	public Booking() {
	}

	public Booking(String lastname, String firstname, int age, Flight flight) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
		this.flight = flight;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookingNum() {
		return bookingNum;
	}

	public void setBookingNum() {
		this.bookingNum = (flight.getFlightNumb() + "-" + id);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Flight getFlightId() {
		return flight;
	}

	public void setFlightId(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return bookingNum + "\t\t| " + lastname + "\t| " + firstname + "\t\t| " + age + "\t| " + flight.getFlightNumb();
	}

}
