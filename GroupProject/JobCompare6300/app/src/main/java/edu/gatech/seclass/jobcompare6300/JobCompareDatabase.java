package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.logging.Level;

import java.util.logging.Logger;

public class JobCompareDatabase extends SQLiteOpenHelper
{
    //fields for creating the db
    private Context context;
    public static final String DATABASE_NAME = "JobCompare.db";
    public static final int DATABASE_VERSION = 1;

    //table name
    public static final String TABLE_NAME = "JOB_DETAILS";

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

    //Queries for getting data
    public static final String QUERY_FETCH_CURRENT_JOB = "SELECT * FROM " + TABLE_NAME + " WHERE IS_CURRENT_JOB = 1;";
    public static final String QUERY_FETCH_ALL_JOBS = "SELECT * FROM " + TABLE_NAME;
    //public static final String QUERY_UPDATE_JOB = "UPDATE " + TABLE_NAME + "SET "

    Logger logger = Logger.getLogger(JobCompareDatabase.class.getName());

    public JobCompareDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String createDB =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_JOB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_JOB_TITLE + " TEXT, " +
                        COLUMN_COMPANY + " TEXT, " +
                        COLUMN_CITY + " TEXT, " +
                        COLUMN_STATE + " TEXT, " +
                        COLUMN_COST_OF_LIVING + " REAL, " +
                        COLUMN_YEARLY_SALARY + " REAL, " +
                        COLUMN_ADJUSTED_YEARLY_SALARY + " REAL, " +
                        COLUMN_YEARLY_BONUS + " REAL, " +
                        COLUMN_ADJUSTED_YEARLY_BONUS + " REAL, " +
                        COLUMN_HOME_BUYING_FUND_PERCENTAGE + " REAL, " +
                        COLUMN_MONTHLY_INTERNET_STIPEND + " REAL, " +
                        COLUMN_IS_CURRENT_JOB + " INTEGER, " +
                        COLUMN_SCORE + " REAL);";

        sqLiteDatabase.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addJob(Job job)
    {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_JOB_TITLE, job.getJobTitle());
        cv.put(COLUMN_COMPANY, job.getCompany());
        cv.put(COLUMN_CITY, job.getLocation().getCity());
        cv.put(COLUMN_STATE, job.getLocation().getState());
        cv.put(COLUMN_COST_OF_LIVING, job.getCostOfLiving());
        cv.put(COLUMN_YEARLY_SALARY, job.getYearlySalary());
        cv.put(COLUMN_ADJUSTED_YEARLY_SALARY, job.getAdjustedYearlySalary());
        cv.put(COLUMN_YEARLY_BONUS, job.getYearlyBonus());
        cv.put(COLUMN_ADJUSTED_YEARLY_BONUS, job.getAdjustedYearlyBonus());
        cv.put(COLUMN_HOME_BUYING_FUND_PERCENTAGE, job.getHomeBuyingFundPercentage());
        cv.put(COLUMN_MONTHLY_INTERNET_STIPEND, job.getMonthlyInternetStipend());
        cv.put(COLUMN_IS_CURRENT_JOB, job.getCurrentJob());
        cv.put(COLUMN_SCORE, job.getScore());

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1)
        {
            logger.log(Level.INFO, "ERROR: Could not insert into db.");
        }
        else
        {
            logger.log(Level.INFO, "Added Successfully");
        }

    }

    public void updateJob()
    {

    }

    public Job fetchCurrentJob()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        Job job = null;

        if (db != null)
        {
            cursor = db.rawQuery(QUERY_FETCH_CURRENT_JOB, null);
        }

        if (cursor != null)
        {
            if (cursor.getCount() == 0)
            {
                logger.log(Level.INFO, "ERROR: NO DATA");
            }
            else
            {
                while (cursor.moveToNext())
                {
                    job.setJobTitle(cursor.getString(1));
                    job.setCompany(cursor.getString(2));
                    job.setLocation(new Location(cursor.getString(3), cursor.getString(4)));
                    job.setCostOfLiving(cursor.getFloat(5));
                    job.setYearlySalary(cursor.getFloat(6));
                    job.setAdjustedYearlySalary(cursor.getFloat(7));
                    job.setYearlyBonus(cursor.getFloat(8));
                    job.setAdjustedYearlyBonus(cursor.getFloat(9));
                    job.setHomeBuyingFundPercentage(cursor.getFloat(10));
                    job.setMonthlyInternetStipend(cursor.getFloat(11));
                    job.setCurrentJob(cursor.getFloat(12));
                    job.setScore(cursor.getFloat(13));
                }
            }
            cursor.close();
        }

        return job;
    }

    public List<Job> fetchAllJobs()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        List<Job> allJobs = null;

        if (db != null)
        {
            cursor = db.rawQuery(QUERY_FETCH_CURRENT_JOB, null);
        }

        if (cursor != null)
        {
            if (cursor.getCount() == 0)
            {
                logger.log(Level.INFO, "ERROR: NO DATA");
            }
            else
            {
                while (cursor.moveToNext())
                {
                    Job job = null;

                    job.setJobTitle(cursor.getString(1));
                    job.setCompany(cursor.getString(2));
                    job.setLocation(new Location(cursor.getString(3), cursor.getString(4)));
                    job.setCostOfLiving(cursor.getFloat(5));
                    job.setYearlySalary(cursor.getFloat(6));
                    job.setAdjustedYearlySalary(cursor.getFloat(7));
                    job.setYearlyBonus(cursor.getFloat(8));
                    job.setAdjustedYearlyBonus(cursor.getFloat(9));
                    job.setHomeBuyingFundPercentage(cursor.getFloat(10));
                    job.setMonthlyInternetStipend(cursor.getFloat(11));
                    job.setCurrentJob(cursor.getFloat(12));
                    job.setScore(cursor.getFloat(13));

                    allJobs.add(job);
                }
            }
            cursor.close();
        }

        return allJobs;
    }
}
