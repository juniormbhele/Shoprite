package za.co.shoprite;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DogAPI
{
    @Test (priority = 0)
    public void listAllDogs()
    {
        try
        {
            String post = "https://dog.ceo/api/breeds/list/all";

            Response response = getClient(post);

            System.out.println(response.body().string());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test (priority = 1)
    public void findRetrieverBreed()
    {
        String breed = "retriever";

        findSpecifiedBreed(breed);

    }

    @Test(priority = 2)
    public void findSubBreeds()
    {
       try
       {
           String post = "https://dog.ceo/api/breeds/list/all";

           Response response = getClient(post);

           String breed = "retriever";

           String resStr = response.body().string().toString();
           JSONObject dogsObject = new JSONObject(resStr);

           JSONArray breedFound = dogsObject.getJSONObject("message").getJSONArray(breed);

           if (breedFound.length()>0)
           {
               System.out.println(breedFound);
           }
       }
       catch (Exception ex)
       {
           System.out.println(ex.getMessage());
       }
    }

    @Test(priority = 3)
    public void findAnImage()
    {
        try
        {
            String post = "https://dog.ceo/api/breeds/image/random";

            Response response = getClient(post);

            String resStr = response.body().string().toString();
            JSONObject imageObject = new JSONObject(resStr);

            String message = imageObject.getString("message");

            if (message.contains("“golden”"))
            {
                System.out.println(resStr);
            }
            else
            {
                findAnImage();
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void findSpecifiedBreed(String breed)
    {
        try
        {
            String post = "https://dog.ceo/api/breeds/list/all";

            Response response = getClient(post);

            String resStr = response.body().string().toString();
            JSONObject dogsObject = new JSONObject(resStr);

            JSONArray breedFound = dogsObject.getJSONObject("message").getJSONArray(breed);

            if (breedFound.length()>0)
            {
                System.out.println(breed+" is within the list");
            }


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public Response getClient(String post) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(post)
                .get()
                .addHeader("Host", "dog.ceo")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        assert response.body() != null;
        Assert.assertEquals(response.code(), 200);

        return response;
    }
}
