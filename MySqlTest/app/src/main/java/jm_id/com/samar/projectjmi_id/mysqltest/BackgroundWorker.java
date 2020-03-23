package jm_id.com.samar.projectjmi_id.mysqltest;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,String,String> {

    AlertDialog alertDialog;
   // String result;


    Context context;

    BackgroundWorker(Context context){
        this.context=context;
    }


    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        String login_url = "http://softex4u.000webhostapp.com/connect.php";


        String result = null;
        if (type.equals("login")) {
            try {
                String user = params[1];
                String pass = params[2];
                URL url = new URL(login_url);
                URLConnection https1 = (URLConnection) url.openConnection();
                //https.setRequestMethod("POST");
                https1.setDoOutput(true);
                https1.setDoInput(true);
                OutputStream outputStream = https1.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8") + "&" + URLEncoder.encode("pass_word", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                //bufferedWriter.close();
                //outputStream.close();
                InputStream inputStream = https1.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String line = null;
                result = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                //bufferedReader.close();
                //inputStream.close();


                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*Toast.makeText(context,type+"",Toast.LENGTH_LONG).show();*/
        return null;
    }

    @Override
    protected void onPreExecute() {

        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String aVoid) {
        alertDialog.setMessage(aVoid);
        alertDialog.show();
    }
}
