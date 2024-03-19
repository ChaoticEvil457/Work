
import java.util.LinkedList;

class Programme {

	LinkedList<Movie> matinee;
	LinkedList<Movie> primetime;
	LinkedList<Movie> soiree;

	Programme() {
		this.matinee = new LinkedList<Movie>();
		this.primetime = new LinkedList<Movie>();
		this.soiree = new LinkedList<Movie>();
	}

	Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree) {
		this.matinee = matinee;
		this.primetime = primetime;
		this.soiree = soiree;
	}

	public boolean equals(Programme p) {
		if (p == this)
			return true;
		if (this.matinee.size() == p.matinee.size() && this.primetime.size() == p.primetime.size()
				&& this.soiree.size() == p.soiree.size()) {
			for (int i = 0; i < p.matinee.size(); i++) {
				if (!p.matinee.get(i).equals(this.matinee.get(i))) {
					return false;
				}
			}
			for (int i = 0; i < p.primetime.size(); i++) {
				if (!p.primetime.get(i).equals(this.primetime.get(i))) {
					return false;
				}
			}
			for (int i = 0; i < p.soiree.size(); i++) {
				if (!p.soiree.get(i).equals(this.soiree.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
