package managament;

public final class IdManager {

	private static volatile IdManager idManager;

	private int userID;

	private int cardID;

	private IdManager() {

		userID = 0;
		cardID = 0;

	}

	public static synchronized int getUserID() {

		checkInstance();
		
		return (++idManager.userID);
	}

	public static synchronized int getCardID() {

		checkInstance();
		
		return (++idManager.cardID);
	}

	private static synchronized void checkInstance() {

		if (idManager == null) {

			idManager = new IdManager();

		}

	}
	
	//per testing
	public static void clear(){
		
		idManager = null;
		
	}

}
