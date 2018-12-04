package Character_Logic;

public class InsufficientManaException extends Exception {
	private int need;

	public InsufficientManaException(int need){
	      this.need = need;
	   }

	public int getAmount() {
		return need;
	}
}
