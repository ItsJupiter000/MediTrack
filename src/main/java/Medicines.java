public class Medicines {

	private int id;
	private int medi_id;
	private String name;
	private int doses;
	private int age;
	
	@Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", medi_id'" + medi_id + '\''+
                ", name='" + name + '\'' +
                ", doses='" + doses + '\'' +
                ", age=" + age +
                '}';
    }
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getMedi_id() {
		return medi_id;
	}


	public void setMedi_id(int medi_id) {
		this.medi_id = medi_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDoses() {
		return doses;
	}


	public void setDoses(int doses) {
		this.doses = doses;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Medicines(int id, int medi_id, String name, int doses, int age) {
		super();
		this.id = id;
		this.medi_id = medi_id;
		this.name = name;
		this.doses = doses;
		this.age = age;
	}
	
	

}