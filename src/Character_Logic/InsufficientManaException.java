package Character_Logic;

public class InsufficientManaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int need;

	public InsufficientManaException(int need){
	      this.need = need;
	   }

	public int getAmount() {
		return need;
	}
}
