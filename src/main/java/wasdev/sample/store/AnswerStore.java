/******************************************************************************
 * Copyright IBM Corp. 2018                                                   *
 *                                                                            *
 * Licensed under the Apache License, Version 2.0 (the "License");            *
 * you may not use this file except in compliance with the License.           *
 * You may obtain a copy of the License at                                    *
 *                                                                            *
 *    http://www.apache.org/licenses/LICENSE-2.0                              *
 *                                                                            *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 ******************************************************************************/
package wasdev.sample.store;

import java.util.Collection;

import wasdev.sample.Answer;

/**
 * Defines the API for a ToDo store.
 *
 */
public interface AnswerStore {

    /**
     * Get the target db object.
     * 
     * @return Database.
     * @throws Exception 
     */
    public Object getDB();

  
    /**
     * Gets all Answers from the store.
     * 
     * @return All Answers.
     * @throws Exception 
     */
    public Collection<Answer> getAll();

    /**
     * Gets an individual ToDo from the store.
     * @param id The ID of the ToDo to get.
     * @return The ToDo.
     */
    public Answer get(String id);

    /**
     * Persists a Answer to the store.
     * @param td The ToDo to persist.
     * @return The persisted ToDo.  The ToDo will not have a unique ID..
     */
    public Answer persist(Answer vi);

    /**
     * Updates a ToDo in the store.
     * @param id The ID of the Answer to update.
     * @param td The Answer with updated information.
     * @return The updated Answer.
     */
    public Answer update(String id, Answer vi);

    /**
     * Deletes a ToDo from the store.
     * @param id The ID of the Answer to delete.
     */
    public void delete(String id);
  
    /**
     * Counts the number of Answers
     * @return The total number of Answers.
     * @throws Exception 
     */
    public int count() throws Exception;
}
