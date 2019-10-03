package com.example.shihab.freedomfighter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;


public class AllListSearchShowAFragment extends Fragment {

    ListView list;
    public String [] name ;// = new String[7];
    String [] place_birth ;// = new String[7];
    String [] work_edu ;// = new String[7];
    String [] role_war ;// = new String[7];
    String [] award ;// = new String[7];
    int [] image;// = new int[7];
    String sql ;

    String searchName=" ";

    Button btSearch;
    EditText editTextSearch;
    String searchKey = "Search";

    public AllListSearchShowAFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_all_list_search_show_a, container, false);


        Log.d("searchKey ", "Start");

        sql = "SELECT * FROM fighter ";

        list = (ListView)  v.findViewById(R.id.listSearchResult);
        btSearch = (Button) v.findViewById (R.id.buttonSearch);
        editTextSearch = (EditText) v.findViewById(R.id.editTextSearchName);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchName = editTextSearch.getText().toString();
                sql = "SELECT * FROM fighter where name like \'%"+searchName+"%\'";
                Log.d("searchKey_From ", sql);
                initialDisplay();
            }
        });


        initialDisplay();


        return  v ;
    }



    private  void initialDisplay() {
        //Start Copy
        Log.d("myLog", "*********** Database Start *************");
        dbCopy mydb = new dbCopy(getActivity());
        String dbPath = mydb.DB_PATH+"/Freedom.db";
        try {
            mydb.createDataBase();
            Log.d("myLog", "Database Create");
        } catch (IOException e) {
            Log.d("myLog", "Database Not Create");
            e.printStackTrace();
        }

// String dbPath = "/data/data/com.example.diu.listviewwithimage/databases/";



        SQLiteDatabase myDatabase = null;

        Log.d("DB PAth" ,dbPath +"\n"+mydb.DB_PATH );

        try {
            myDatabase = SQLiteDatabase.openDatabase(dbPath, null,
                    SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception e) {
            Log.d("myLog", "Database Open Problem menu");
        }

        Log.d("sql ", sql);


        Cursor c=null;// d = null;

        try {
            c= myDatabase.rawQuery(sql, null);
            Log.d("myLog", "raw query not error in menu");
        } catch (Exception e) {
            Log.d("myLog", "raw query error in menu");
            e.printStackTrace();
        }

       // Log.d("myLog", String.valueOf(c.getCount()));
        variableInatial(c.getCount());


        int i = 0;
        String a;

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

            a =  c.getString(c.getColumnIndex("image"));
            image[i] = getResources().getIdentifier(a, "drawable", getActivity().getPackageName());
            name[i] = c.getString(c.getColumnIndex("name"));
            place_birth [i] = c.getString(c.getColumnIndex("place_birth"));
            work_edu [i] = c.getString(c.getColumnIndex("work_edu"));
            role_war [i] = c.getString(c.getColumnIndex("role_war"));
            award [i++] = c.getString(c.getColumnIndex("award"));

        }


        myDatabase.close();



        MakeAdapte objMakeAdapter = new MakeAdapte(getActivity(),name,image);
        list.setAdapter(objMakeAdapter);

    }



    private void variableInatial(int valu){
        Log.d("Variable Inatial", "method Start valu is "+valu);
        name  = new String[valu];
        place_birth  = new String[valu];
        work_edu  = new String[valu];
        role_war  = new String[valu];
        award  = new String[valu];
        image = new int[valu];
        Log.d("Variable Inatial", "method End");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {

                // Intent i=new Intent(getActivity(),detailsInfo_activity.class);
                Log.d("Variable Inatial", "method :::::: "+position1);

                detailsInfoFragment objdetailInfoFragment = new detailsInfoFragment();
                Bundle args = new Bundle();

                args.putString("name",name[position1]);
                args.putInt("image",image[position1]);
                args.putString("place_birth",place_birth[position1]);
                args.putString("work_edu",work_edu[position1]);
                args.putString("role_war",role_war[position1]);
                args.putString("award",award[position1]);
                //args.putString("searchKey",searchKey);

                objdetailInfoFragment.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame,objdetailInfoFragment).commit();
                // fragmentManager.beginTransaction().add(R.id.frame, objdetailInfoFragment).replace(R.id.frame, objdetailInfoFragment).commit();


            }
        });
    }


}
