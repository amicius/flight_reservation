package flightreservation;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flight")
@SequenceGenerator(name = "flight_seq")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
	private Integer id;
	@Column
	@NotNull
	private String flightNumb;
	@Enumerated(EnumType.STRING)
	@NotNull
	private PlaneType planeType;
	@Column
	@NotNull
	private int capacity;
	@Column
	@NotNull
	private String takeOff;
	@Column
	@NotNull
	private String landing;
	@Column
	@NotNull
	private Date takeOffDate;
	@OneToMany(mappedBy = "flight")
	private List<Booking> bookings;

	public Flight() {
	}

	public Flight(String flightNumb, PlaneType planeType, int capacity, String takeOff, String landing,
			Date takeOffDate) {
		this.flightNumb = flightNumb;
		this.planeType = planeType;
		this.capacity = capacity;
		this.takeOff = takeOff;
		this.landing = landing;
		this.takeOffDate = takeOffDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlightNumb() {
		return flightNumb;
	}

	public void setFlightNumb(String flightNumb) {
		this.flightNumb = flightNumb;
	}

	public PlaneType getPlaneType() {
		return planeType;
	}

	public void setPlaneType(PlaneType planeType) {
		this.planeType = planeType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getTakeOff() {
		return takeOff;
	}

	public void setTakeOff(String takeOff) {
		this.takeOff = takeOff;
	}

	public String getLanding() {
		return landing;
	}

	public void setLanding(String landing) {
		this.landing = landing;
	}

	public Date getTakeOffDate() {
		return takeOffDate;
	}

	public void setTakeOffDate(Date takeOffDate) {
		this.takeOffDate = takeOffDate;
	}

	@Override
	public String toString() {
		return flightNumb + "\t| " + planeType + "\t| " + capacity + "\t| " + takeOff + "\t| " + landing + "\t| "
				+ takeOffDate;
	}

}
