package Utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Amy\",\n" +
                "  \"emp_lastname\": \"Smith\",\n" +
                "  \"emp_middle_name\": \"G\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2005-07-25\",\n" +
                "  \"emp_status\": \"happy\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeJsonPayload(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Any");
        obj.put("emp_lastname","Smith");
        obj.put("emp_middle_name","G");
        obj.put("emp_gender","F");
        obj.put("emp_birthday","2005-07-25");
        obj.put("emp_status","happy");
        obj.put("emp_job_title","QA");
        return obj.toString();
    }

    public static String createEmployeeJsonPayloadDynamic
            (String fn, String ln, String mn, String gender,
             String dob, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", fn);
        obj.put("emp_lastname", ln);
        obj.put("emp_middle_name", mn);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }

    public static String partialEmployeeUpdatePayload(){
        String partialEmployeeUpdatePayload = "{\n" +
                "  \"employee_id\": \"88332A\",\n" +
                "  \"emp_firstname\": \"Emmy\",\n" +
                "  \"emp_lastname\": \"Black\",\n" +
                "  \"emp_middle_name\": \"K\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"2023-04-01\",\n" +
                "  \"emp_status\": \"Vacationing\",\n" +
                "  \"emp_job_title\": \"LifeTime Vacation\"\n" +
                "}";
        return partialEmployeeUpdatePayload;
    }
}
