
import java.util.LinkedList;

class MovieManager1 {
	public static Programme p = new Programme();

	MovieManager1() {
	}

	public Programme organizeMovies(LinkedList<Movie> movies) {
		notSimulcast(movies);
		return p;
	}

	public void notSimulcast(LinkedList<Movie> movies) {
		if (movies.isEmpty()) {
			return;
		}
		if (!movies.peek().simulcast) {
			if (movies.peek().showtime >= 700 && movies.peek().showtime < 1200) {
				p.matinee.add(movies.peek());
			} else if (movies.peek().showtime >= 1200 && movies.peek().showtime < 2000) {
				p.primetime.add(movies.peek());
			} else if (movies.peek().showtime >= 2000 && movies.peek().showtime <= 2400 || movies.peek().showtime >= 0 && movies.peek().showtime <= 200) {
				p.soiree.add(movies.peek());
			}
		}
		movies.pop();
		notSimulcast(movies);
	}
}
