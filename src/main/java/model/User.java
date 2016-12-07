package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** The persistent class for the BANK_CUSTOMERS database table. */
@Entity
@Table(name = "User")
@NamedQueries({ @NamedQuery(name = "User.findUserById", query = "SELECT * FROM user WHERE id_user = :idUser;"),
		@NamedQuery(name = "User.findUserByMail", query = "SELECT * FROM user WHERE email = :email;"),
		@NamedQuery(name = "User.createUser", query = "INSERT INTO `user` (name, password, email) VALUES ( :name , :password , :email);"),
		@NamedQuery(name = "User.displayShows", query = "SELECT event.artist_name as  artiste, event.date as date, FROM user JOIN  seat ON user.id_user = seat.user_id JOIN  event on set.id_event = event.id_event  WHERE user.id_user = :idUser ;"), })

public class User implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USER")
	private long idUser;

	private String password;
	private String username;
	private String email;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy = "seat")
	private List<Seat> seats;

	public User(String name, String password)
	{

	}

	public long getIdUser()
	{
		return this.idUser;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<Seat> getSeats()
	{
		return this.seats;
	}

	public void setSeats(List<Seat> seats)
	{
		this.seats = seats;
	}

	public Seat addSeat(Seat seat)
	{
		getSeats().add(seat);
		seat.setUser(this);
		return seat;
	}

	public Seat removeSeat(Seat seat)
	{
		getSeats().remove(seat);
		seat.setUser(null);
		return seat;
	}

}