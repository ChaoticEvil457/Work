
class Movie {

	String title;
	double showtime;
	int runtime;
	boolean simulcast;

	public Movie(String title, double showtime, int runtime, boolean simulcast) {
		this.title = title;
		this.showtime = showtime;
		this.runtime = runtime;
		this.simulcast = simulcast;
	}

	public boolean equals(Movie m) {
		if (m == this)
			return true;
		if (this.title.equals(m.title) && this.showtime == m.showtime) {
			return true;
		}
		return false;
	}
}
