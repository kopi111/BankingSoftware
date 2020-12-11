package comBankingApp.AOOPProject;

import javax.persistence.*;


@Entity
@Table(name="worker_log")
public class workerLlogin {

	

	@Id
	@Column(name="worker_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workerId;
	

	
	@Column(name="worker_Id_number")
	private int workerIdNumbere;
	
	@Column(name="user_name")
	private String workerUserName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="attempts")
	private int attempts;
	
	@Column(name="message")
	private String message;

	
	@OneToOne
   private workerClass workerclass;


	public int getWorkerId() {
		return workerId;
	}


	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}


	public String getWorkerUserName() {
		return workerUserName;
	}


	public void setWorkerUserName(String workerUserName) {
		this.workerUserName = workerUserName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAttempts() {
		return attempts;
	}


	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public workerClass getWorkerclass() {
		return workerclass;
	}


	public void setWorkerclass(workerClass workerclass) {
		this.workerclass = workerclass;
	}


	public workerLlogin(int workerId, String workerUserName, String password, int attempts, String message,
			workerClass workerclass) {
		
		this.workerId = workerId;
		this.workerUserName = workerUserName;
		this.password = password;
		this.attempts = attempts;
		this.message = message;
		this.workerclass = workerclass;
	}


	public workerLlogin() {
		
		this.workerId = workerId;
		this.workerUserName = workerUserName;
		this.password = password;
		this.attempts = attempts;
		this.message = message;
		this.workerclass = workerclass;
	}


	public int getWorkerIdNumbere() {
		return workerIdNumbere;
	}


	public void setWorkerIdNumbere(int workerIdNumbere) {
		this.workerIdNumbere = workerIdNumbere;
	}
	
	
	
	
	
}
