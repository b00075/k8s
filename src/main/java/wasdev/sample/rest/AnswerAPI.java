/******************************************************************************
 * Copyright (c) 2018 IBM Corp.                                               *
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
package wasdev.sample.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import com.google.gson.Gson;

import wasdev.sample.Answer;
import wasdev.sample.store.AnswerStore;
import wasdev.sample.store.AnswerStoreFactory;

@ApplicationPath("api")
@Path("/answers")
public class AnswerAPI extends Application {

    //Our database store
    AnswerStore store = AnswerStoreFactory.getInstance();

    /**
     * Gets all Answers.
     * REST API example:
     * <code>
     * GET http://localhost:9080/GetStartedJava/api/Answers
     * </code>
     * 
     * Response:
     * <code>
     * [ "Bob", "Jane" ]
     * </code>
     * @return A collection of all the Answers
     */
    @GET
    @Path("/")
    @Produces({"application/json"})
    public String getAnswers() {

        if (store == null) {
            return "[]";
        }

        List<String> answers = new ArrayList<String>();
        for (Answer doc : store.getAll()) {
            String answer = doc.getAnswer();
            if (answer != null){
                answers.add(answer);
            }
        }
        return new Gson().toJson(answers);
    }
    
    /**
     * Creates a new Answer.
     * 
     * REST API example:
     * <code>
     * POST http://localhost:9080/GetStartedJava/api/Answers
     * <code>
     * POST Body:
     * <code>
     * {
     *   "answer":"Bob"
     * }
     * </code>
     * Response:
     * <code>
     * {
     *   "id":"123",
     *   "answer":"Bob"
     * }
     * </code>
     * @param Answer The new Answer to create.
     * @return The Answer after it has been stored.  This will include a unique ID for the Answer.
     */
    @POST
    @Produces("application/text")
    @Consumes("application/json")
    public String newToDo(Answer answer) {
        if(store == null) {
            return String.format("Hello %s!", answer.getAnswer());
        }
        store.persist(answer);
        return String.format("Hello %s! I've added you to the database.", answer.getAnswer());
    }
}
