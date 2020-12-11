package comBankingApp.AOOPProject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="worker_Information")
public class workerClass {
	

	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	

	@Column(name="worker_Id_number")
	private int workerIdNumbere;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="workers_id_geneartion")
	private workerLlogin workerLog;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public workerLlogin getWorkerLog() {
		return workerLog;
	}


	public void setWorkerLog(workerLlogin workerLog) {
		this.workerLog = workerLog;
	}


	public workerClass(int id, String firstName, String lastName, workerLlogin workerLog) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workerLog = workerLog;
	}
	
	
	
	public workerClass() {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workerLog = workerLog;
	}


	public int getWorkerIdNumbere() {
		return workerIdNumbere;
	}


	public void setWorkerIdNumbere(int workerIdNumbere) {
		this.workerIdNumbere = workerIdNumbere;
	}
	
	
}
