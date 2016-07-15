package com.abstractlabs.oefen.database;

import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.abstractlabs.oefen.User;

@SuppressWarnings("unchecked")
public class DB {
	public static final String COLLECTION = "accounts";

    /**
     * Create 2 JSON Objects and add them to the collection
     * @param client restDB client
     */
	public static void postRequest(final RestDBClient client) {
        JSONObject woobly = new JSONObject();
        woobly.put("title", "Wobbly bubbles");
        woobly.put("description", "They are the best");
        woobly.put("count", 4);
        woobly.put("email", "wobble@wobble.com");


        JSONObject snuttgly = new JSONObject();
        snuttgly.put("title", "Snuggly snuggles");
        snuttgly.put("description", "They are the worst");
        snuttgly.put("count", 8);
        snuttgly.put("email", "snuggle@snuggle.com");

        String resultWoobly = client.post(COLLECTION, woobly.toJSONString());

        System.out.println("result Woobly postRequest : " + resultWoobly);
        String resultSnuttgly = client.post(COLLECTION, snuttgly.toJSONString());
        System.out.println("result Snuttgly postRequest : " + resultSnuttgly);

        // call Garbage collection
        snuttgly = null;
        woobly = null;
    }

    /**
     *  Get the list of items in the collection
     * @param client RestDBClient
     * @return list of items in the collection, String format
     */
    public static String getRequest(final RestDBClient client) {
        String result = client.get(COLLECTION);
        System.out.println("result getRequest : " + result);
        return result;
    }
    
    public static String getName(final RestDBClient client) {
    	try {
    		JSONParser parser = new JSONParser();
        	String str = client.get(COLLECTION);
			JSONArray users = (JSONArray)parser.parse(str);
			JSONObject user = (JSONObject)users.get(0);
			String name = (String)user.get("username");
			System.out.println(users);
			System.out.println(user);
			return name;
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
    }
    
    public static String getRandomName(final RestDBClient client) {
    	try {
    		Random rand = new Random();
    		JSONParser parser = new JSONParser();
        	String str = client.get(COLLECTION);
			JSONArray users = (JSONArray)parser.parse(str);
			JSONObject user = (JSONObject)users.get(rand.nextInt(10));
			String name = (String)user.get("username");
//			System.out.println(users);
//			System.out.println(user);
			return name;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static User getRandomUser(final RestDBClient client) {
    	try {
    		Random rand = new Random();
    		JSONParser parser = new JSONParser();
        	String str = client.get(COLLECTION);
			JSONArray users = (JSONArray)parser.parse(str);
			JSONObject user = (JSONObject)users.get(rand.nextInt(60)+20);
			System.out.println(user);
			String name = (String)user.get("username");
			JSONArray cardsa = (JSONArray)user.get("deck1");
			Object[] cardso = cardsa.toArray();
			int[] cards = new int[cardso.length];
			int exp = Math.toIntExact((Long)user.get("exp"));
			int elo = Math.toIntExact((Long)user.get("elo"));
			
			for(int i=0; i<cardso.length; i++) {
				cards[i] = Math.toIntExact((Long) cardso[i]);
			}

			return new User(name, exp, elo, cards, "Blue");
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static User getUser(final RestDBClient client, String username) {
    	try {
    		JSONParser parser = new JSONParser();
        	String str = client.get(COLLECTION);
			JSONArray users = (JSONArray)parser.parse(str);
			
			for(int i=0; i<users.size(); i++) {
				JSONObject user = (JSONObject)users.get(i);
				String name = (String)user.get("username");
				if(name.equalsIgnoreCase(username)) {
					JSONArray cardsa = (JSONArray)user.get("deck1");
					Object[] cardso = cardsa.toArray();
					int[] cards = new int[cardso.length];
					for(int j=0; j<cardso.length; j++) {
						cards[j] = Math.toIntExact((Long) cardso[j]);
					}
					int exp = Math.toIntExact((Long)user.get("exp"));
					int elo = Math.toIntExact((Long)user.get("elo"));
					return new User(name, exp, elo, cards, "Blue");
				}
			}
		} catch (ParseException e) {}
		return null;
    }
    
    /**
     *  Get the list of items in the collection where count = 0
     *  More info about the parameters of the queries here : https://restdb.io/docs/querying-with-the-api
     * @param client RestDBClient
     * @return list of items in the collection, String format
     */
    public static String getRequestWithFilter(final RestDBClient client) {
        JSONObject jsonQuery = new JSONObject();
        jsonQuery.put("count", 8);
        String query = "?q=" + jsonQuery.toJSONString();
        String result = client.get(COLLECTION + query);
        System.out.println("result getRequestWithFilter : " + result);
        return result;
    }

    /**
     * Update an item from a collection given its ID
     * @param client RestDBClient
     * @param resultGetAll list of items from the collection
     * @return ID of the updated item
     */
    public static String putRequest(final RestDBClient client, final String resultGetAll) {
        JSONParser parser = new JSONParser();
        Object obj = null;
        String id = null;
        try {
            obj = parser.parse(resultGetAll);
            JSONArray results = (JSONArray)(obj);
            if (!resultGetAll.isEmpty() && results.size() > 0)
            {
                JSONObject firstOne = (JSONObject)results.get(0); // take first item
                System.out.println(firstOne.toJSONString());
                firstOne.put("title", "updated title");
                id = (String)firstOne.get("_id");
                String resultPut = client.put(COLLECTION + "/" + id, firstOne.toJSONString());
                System.out.println(resultPut);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     *  Delete item from a collection by aa given ID
     * @param client RestDBCliet
     * @param id ID of the item to delete from the collection
     */
    public static void deleteRequest(final RestDBClient client, final String id) {
        String resultDelete = client.delete(COLLECTION + "/" + id);
        System.out.println(resultDelete);
    }
}