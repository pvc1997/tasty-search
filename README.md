Steps for the execution of the project :-

  1. After cloning the project, please download the dataset from https://drive.google.com/file/d/0B8_VSW2-5XmpSTNlZXV4cVdLRUE/view and copy the foods.txt file inside the tasty-search project directory.

  2. This project is using Java with Spring Boot, you can run it on either IntelliJ IDEA or Eclipse STS as Spring Boot comes with an Embedded Tomcat server. Else, you can also use Eclipse IDE and deploy the JAR on a Tomcat Server.

  3. After you successfully run the project on a Tomcat Server, you can access the below API endpoints:-
      a. http://localhost:8080/init :- This endpoint takes in an HTTP GET request and in the output, mentions the status of the request.
      This API basically initializes the inverted index.

      b. http://localhost:8088/getReviews :- This endpoint takes in an HTTP POST request with a set of tokens and returns the list of           reviews related with those tokens. Please checkout the format of the JSON for the input below:-

      {
        "tokens" : [
          "spicy", "hot", "sizzling", "sensational"
        ]
      }

      As you can see above, ["spicy", "hot", "sizzling", "sensational"] are the set of tokens.
  
Working methodology of the project :-

  1. In this project, we are using the the concept of inverted index using a HashMap. We will index the sampled documents and the tokens     that those documents have in a key-value format where key is the token and value is a set of documents which have this token.
  
  2. After we encounter a POST request for getReviews, if the inverted index isn't initialized it'll get initialized and populated and       then the query based on the tokens will be solved.
  
  3. It's good to call the GET request init before the POST requests because we first need to initialize the inverted index before solving   any query. If we don't then the first POST request will handle the initialization and hence could take a while to give a response.
  
