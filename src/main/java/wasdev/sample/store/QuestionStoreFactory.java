package wasdev.sample.store;

public class QuestionStoreFactory {
	private static QuestionStore instance;
    static {
        // Only use MongoDB if credentials are available.
       
            CloudantQuestionStore cvif = new CloudantQuestionStore();
            if (cvif.getDB() != null) {
                instance = cvif;
            }
        
        
    }

    public static QuestionStore getInstance() {
        return instance;
    }
}
