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


import wasdev.sample.Question;
import wasdev.sample.store.QuestionStore;
import wasdev.sample.store.QuestionStoreFactory;

@ApplicationPath("api")
@Path("/questions")
public class QuestionAPI extends Application {
	
    //Our database store
    QuestionStore store = QuestionStoreFactory.getInstance();

    /**
     * Gets all Questions.
     * REST API example:
     * <code>
     * GET http://localhost:9080/GetStartedJava/api/questions
     * </code>
     * 
     * Response:
     * <code>
     * [ "Bob", "Jane" ]
     * </code>
     * @return A collection of all the Questions
     */
    @GET
    @Path("/")
    @Produces({"application/json"})
    public String getQuestions() {

        if (store == null) {
            return "[]";
        }

        List<String> questions = new ArrayList<String>();
        for (Question doc : store.getAll()) {
            String ques = doc.getQues();
            String opt1 = doc.getOpt1();
            String opt2 = doc.getOpt2();
            String opt3 = doc.getOpt3();
            String opt4 = doc.getOpt4();
            String correctAns = doc.getCorrectAns();
            
            
            if (questions != null){
                questions.add(ques);
                questions.add(opt1);
                questions.add(opt2);
                questions.add(opt3);
                questions.add(opt4);
                questions.add(correctAns);
                
            }
        }
        return new Gson().toJson(questions);
    }
    
    /**
     * Creates a new Answer.
     * 
     * REST API example:
     * <code>
     * POST http://localhost:9080/GetStartedJava/api/Questions
     * <code>
     * POST Body:
     * <code>
     * {
     *   "ques":"What is not found in master node?",
     *   "opt1":"etcd",
     *   "opt2":"scheduler",
     *   "opt3":"kubelet",
     *   "opt4":"none of above",
     *   "correctAns":"none of above"
     * }
     * </code>
     * Response:
     * <code>
     * {
     *   "id":"123",
     *   "ques":"What is not found in master node?",
     *   "opt1":"etcd",
     *   "opt2":"scheduler",
     *   "opt3":"kubelet",
     *   "opt4":"none of above",
     *   "correctAns":"none of above"
     * }
     * </code>
     * @param Question The new Question to create.
     * @return The Question after it has been stored.  This will include a unique ID for the Question.
     */
    @POST
    @Produces("application/text")
    @Consumes("application/json")
    public String newToDo(Question ques) {
        
        store.persist(ques);
        return String.format("The following Question: %s! has been added to the database.", ques.getQues());
    }

    /*@PUT
    @Produces("application/text")
    @Consumes("application/json")
    public String newToDo(Question ques) {
        
        store.persist(ques);
        return String.format("The following Question: %s! has been added to the database.", ques.getQues());
    }*/

    /*@DELETE
    @Produces("application/text")
    @Consumes("application/json")
    public String RemoveFromDB(String id){
        
        store.delete(id);
        return String.format("The following id: %s! has been removed from the database.", id);
    }*/

}
