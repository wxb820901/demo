package com.bill.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;


@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName, GroupXXX groupXXX) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.groupXXX = groupXXX;
	}

	public Person(String firstName, String lastName, GroupXXX groupXXX, Person leader, Collection<Person> members) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.groupXXX = groupXXX;
		this.leader = leader;
		this.members = members;
	}

	public Person(){}

	@ManyToOne
	private GroupXXX groupXXX;


	//self join begin
	@ManyToOne
	private Person leader;

	@OneToMany(mappedBy="leader", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Person> members;
	//self join end


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GroupXXX getGroupXXX() {
		return groupXXX;
	}

	public void setGroupXXX(GroupXXX groupXXX) {
		this.groupXXX = groupXXX;
	}

	public Person getLeader() {
		return leader;
	}

	public void setLeader(Person leader) {
		this.leader = leader;
	}

	public Collection<Person> getMembers() {
		return members;
	}

	public void setMembers(Collection<Person> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", groupXXX=" + groupXXX +
//				", leader=" + leader +
//				", members=" + members +
				'}';
	}
}
