package ClientDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project_table")
public class Project {

	@Id
	@Column(name="project_id")
	private int id;
	@Column(name="project_name",nullable=false)
	private String name;
	@Column(name="project_duration",nullable=false)
	private int duration;
	@Column(name="project_budget",nullable=false)
	private double budget;
	@Column(name="project_teamlead",nullable=false)
	private String teamlead;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getTeamlead() {
		return teamlead;
	}
	public void setTeamlead(String teamlead) {
		this.teamlead = teamlead;
	}
	
	
	
}
