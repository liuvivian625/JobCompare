package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class JobCompareDatabase extends SQLiteOpenHelper
{
    //fields for creating the db
    private Context context;
    public static final String DATABASE_NAME = "JobCompare.db";
    public static final int DATABASE_VERSION = 1;

    //table name
    public static final String TABLE_NAME = "job_details";

    // Attributes of the table job_details.
    public static final String COLUMN_JOB_ID = "job_id";
    public static final String COLUMN_JOB_TITLE = "job_title";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_COST_OF_LIVING = "cost_of_living";
    public static final String COLUMN_YEARLY_SALARY = "yearly_salary";
    public static final String COLUMN_ADJUSTED_YEARLY_SALARY = "adjusted_yearly_salary";
    public static final String COLUMN_YEARLY_BONUS = "yearly_bonus";
    public static final String COLUMN_ADJUSTED_YEARLY_BONUS = "adjusted_yearly_bonus";
    public static final String COLUMN_HOME_BUYING_FUND_PERCENTAGE = "home_buying_fund_percentage";
    public static final String COLUMN_MONTHLY_INTERNET_STIPEND = "monthly_internet_stipend";
    public static final String COLUMN_IS_CURRENT_JOB = "is_current_job";
    public static final String COLUMN_SCORE = "score";


    public JobCompareDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String createDB =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_JOB_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_JOB_TITLE + "TEXT, " +
                        COLUMN_COMPANY + "TEXT, " +
                        COLUMN_CITY + "TEXT, " +
                        COLUMN_STATE + "TEXT, " +
                        COLUMN_COST_OF_LIVING + "REAL, " +
                        COLUMN_YEARLY_SALARY + "REAL, " +
                        COLUMN_ADJUSTED_YEARLY_SALARY + "REAL, " +
                        COLUMN_YEARLY_BONUS + "REAL, " +
                        COLUMN_ADJUSTED_YEARLY_BONUS + "REAL, " +
                        COLUMN_HOME_BUYING_FUND_PERCENTAGE + "REAL, " +
                        COLUMN_MONTHLY_INTERNET_STIPEND + "REAL, " +
                        COLUMN_IS_CURRENT_JOB + "INTEGER, " +
                        COLUMN_SCORE + "REAL);";

        sqLiteDatabase.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addJob()
    {

    }

    public void updateJob()
    {

    }

    public void fetchCurrentJob()
    {

    }

    public void fetchAllJobs()
    {
        
    }
}
