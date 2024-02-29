public class Movies {

	private int id;
	private String title;
	private String genre;
	private int releaseYear;
	
	@Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getReleaseYear() {
		return releaseYear;
	}


	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}


	public Movies(int id, String title, String genre, int releaseYear) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}
	
	

}
