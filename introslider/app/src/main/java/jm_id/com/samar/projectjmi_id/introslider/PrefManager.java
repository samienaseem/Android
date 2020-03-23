package jm_id.com.samar.projectjmi_id.introslider;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        Toast.makeText(context,"PrefManager costrivtor",Toast.LENGTH_SHORT).show();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
        Toast.makeText(_context,"PrefManager SetFirstTime",Toast.LENGTH_SHORT).show();
    }

    public boolean isFirstTimeLaunch() {
        Toast.makeText(_context,"PrefManager isFirstTime",Toast.LENGTH_SHORT).show();
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);



    }
}