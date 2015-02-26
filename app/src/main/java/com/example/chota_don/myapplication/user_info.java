package com.example.chota_don.myapplication;

/**
 * Created by chota_don on 15-02-19.
 */
public class user_info {
    private String user_name;
    private String name;
    private String password;
    private String mail;
    //private Map<String,List<String>> map_user=new HashMap<String,List<String>>();
   // private static List<user_info> user_list=new ArrayList<user_info>();
    public user_info(String user_name,String name,String password,String mail){
        this.user_name=user_name;
        this.name=name;
        this.password=password;
        this.mail=mail;
//        List<String> temp=new ArrayList<String>();
//        temp.add(this.name);
//        temp.add(this.password);
//        temp.add(this.mail);
//        map_user.put(user_name,temp);

    }
//    public boolean user_function(String user_name,String name,String password,String mail){
//        if(map_user.containsKey(user_name)){
//            return false;
//        }
//        else{
//            user_list.add(new user_info(user_name,name,password,mail));
//            return true;
//        }
//
//
//    }

//    //public Map<String,List<String>> return_map(){
//        return this.map_user;
//    }

//    //public static List<user_info> return_list(){
//        return user_list;
//    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
