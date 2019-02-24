package wasdev.sample.store;
import java.util.Collection;

import wasdev.sample.Question;

public interface QuestionStore {
	 /**
     * Get the target db object.
     * 
     * @return Database.
     * @throws Exception 
     */
    public Object getDB();

  
    /**
     * Gets all Questions from the store.
     * 
     * @return All Questions.
     * @throws Exception 
     */
    public Collection<Question> getAll();

    /**
     * Gets an individual ToDo from the store.
     * @param id The ID of the ToDo to get.
     * @return The ToDo.
     */
    public Question get(String id);

    /**
     * Persists a Question to the store.
     * @param td The ToDo to persist.
     * @return The persisted ToDo.  The ToDo will not have a unique ID..
     */
    public Question persist(Question vi);

    /**
     * Updates a ToDo in the store.
     * @param id The ID of the Question to update.
     * @param td The Question with updated information.
     * @return The updated Question.
     */
    public Question update(String id, Question vi);

    /**
     * Deletes a ToDo from the store.
     * @param id The ID of the Question to delete.
     */
    public void delete(String id);
  
    /**
     * Counts the number of Questions
     * @return The total number of Questions.
     * @throws Exception 
     */
    public int count() throws Exception;
}
