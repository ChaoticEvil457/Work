
import java.util.LinkedList;

class MovieManager2 {

	MovieManager2() {
	}

	public Programme organizeMovies(LinkedList<Movie> movies) {
		Programme p = new Programme();
		for (int i = 0; i < movies.size(); i++) {
			if (!movies.get(i).simulcast) {
				if (movies.get(i).showtime >= 700 && movies.get(i).showtime < 1200) {
					p.matinee.add(movies.get(i));
				} else if (movies.get(i).showtime >= 1200 && movies.get(i).showtime < 2000) {
					p.primetime.add(movies.get(i));
				} else if (movies.get(i).showtime >= 2000 && movies.get(i).showtime < 0
						|| movies.get(i).showtime >= 0 && movies.get(i).showtime < 200) {
					p.soiree.add(movies.get(i));
				}
			}
		}
		return p;
	}

}
