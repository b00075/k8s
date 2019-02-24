package wasdev.sample;

public class Question {
	 private String _id;
	 private String _rev;
	 private String ques = null;
	 private String opt1 = null;
	 private String opt2 = null;
	 private String opt3 = null;
	 private String opt4 = null;
	 private String correctAns = null;
	 
	 public Question() {
		 this.ques="";
		 this.opt1 = "";
		 this.opt2 = "";
		 this.opt3 = "";
		 this.opt4 = "";
		 this.correctAns = "";
	 }
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}
	 
	 
}
