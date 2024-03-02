package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.Objects;
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
    public static final String COLUMN_JOB_ID = "JOB_ID";
    public static final String COLUMN_JOB_TITLE = "JOB_TITLE";
    public static final String COLUMN_COMPANY = "COMPANY";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_STATE = "STATE";
    public static final String COLUMN_COST_OF_LIVING = "COST_OF_LIVING";
    public static final String COLUMN_YEARLY_SALARY = "YEARLY_SALARY";
    public static final String COLUMN_ADJUSTED_YEARLY_SALARY = "ADJUSTED_YEARLY_SALARY";
    public static final String COLUMN_YEARLY_BONUS = "YEARLY_BONUS";
    public static final String COLUMN_ADJUSTED_YEARLY_BONUS = "ADJUSTED_YEARLY_BONUS";
    public static final String COLUMN_HOME_BUYING_FUND_PERCENTAGE = "HOME_BUYING_FUND_PERCENTAGE";
    public static final String COLUMN_MONTHLY_INTERNET_STIPEND = "MONTHLY_INTERNET_STIPEND";
    public static final String COLUMN_IS_CURRENT_JOB = "IS_CURRENT_JOB";
    public static final String COLUMN_SCORE = "SCORE";

    //Queries for getting data
    public static final String QUERY_FETCH_CURRENT_JOB = "SELECT * FROM " + TABLE_NAME + " WHERE IS_CURRENT_JOB = 1";
    public static final String QUERY_FETCH_ALL_JOBS = "SELECT * FROM " + TABLE_NAME;
    public static final String QUERY_UPDATE_CURRENT_JOB = "UPDATE " + TABLE_NAME + " SET "
            + COLUMN_JOB_TITLE + " =? "
            + COLUMN_COMPANY + " =? "
            + COLUMN_CITY + " =? "
            + COLUMN_STATE + " =? "
            + COLUMN_COST_OF_LIVING + " =? "
            + COLUMN_YEARLY_SALARY + " =? "
            + COLUMN_ADJUSTED_YEARLY_SALARY + " =? "
            + COLUMN_YEARLY_BONUS + " =? "
            + COLUMN_ADJUSTED_YEARLY_BONUS + " =? "
            + COLUMN_HOME_BUYING_FUND_PERCENTAGE + " =? "
            + COLUMN_MONTHLY_INTERNET_STIPEND + " =? "
            + COLUMN_IS_CURRENT_JOB + " =? WHERE " + COLUMN_IS_CURRENT_JOB + " = 1;";

    public static final String QUERY_CHECK_JOB_EXISTS = "SELECT * FROM " + TABLE_NAME + " WHERE "
            + COLUMN_JOB_TITLE + " =? AND "
            + COLUMN_COMPANY + " =? AND "
            + COLUMN_CITY + " =? AND "
            + COLUMN_STATE + " =? AND "
            + COLUMN_COST_OF_LIVING + " =? AND "
            + COLUMN_YEARLY_SALARY + " =? AND "
            + COLUMN_ADJUSTED_YEARLY_SALARY + " =? AND "
            + COLUMN_YEARLY_BONUS + " =? AND "
            + COLUMN_ADJUSTED_YEARLY_BONUS + " =? AND "
            + COLUMN_HOME_BUYING_FUND_PERCENTAGE + " =? AND "
            + COLUMN_MONTHLY_INTERNET_STIPEND + " =? AND "
            + COLUMN_IS_CURRENT_JOB + " =?";

    public static final String QUERY_RESET_DB = "DELETE FROM " + TABLE_NAME;

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

    public void updateJob(Job job)
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

        long result = db.update(TABLE_NAME, cv, COLUMN_IS_CURRENT_JOB + " = ?", new String[]{"1"});

        if (result == -1)
        {
            logger.log(Level.INFO, "ERROR: Could not update current job.");
        }
        else
        {
            logger.log(Level.INFO, "Updated Current Job Successfully");
        }
    }

    public Job fetchCurrentJob()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        Job job = new Job();

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
                    job.setCurrentJob(cursor.getInt(12));
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
            cursor = db.rawQuery(QUERY_FETCH_ALL_JOBS, null);
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
                    Job job = new Job();

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
                    job.setCurrentJob(cursor.getInt(12));
                    job.setScore(cursor.getFloat(13));

                    allJobs.add(job);
                }
            }
            cursor.close();
        }

        return allJobs;
    }

    public boolean checkJobExists(Job job)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        boolean jobExists = true;

        //see if new job offer added is in database
        //return false if it doesn't exist

        String[] job_args = {job.getJobTitle(), job.getCompany(), job.getLocation().getCity(), job.getLocation().getState(), job.getCostOfLiving().toString(),
        job.getYearlySalary().toString(), job.getAdjustedYearlySalary().toString(), job.getYearlyBonus().toString(), job.getAdjustedYearlyBonus().toString(),
        job.getHomeBuyingFundPercentage().toString(), job.getMonthlyInternetStipend().toString()};

        Cursor cursor = db.rawQuery(QUERY_CHECK_JOB_EXISTS, job_args);

        if (cursor.getCount() <= 0)
        {
            cursor.close();
            jobExists = false;
        }

        return jobExists;
    }

    public boolean isCurrentJob(Job job)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        boolean isJobCurrent = false;
        Job currentJob = fetchCurrentJob();

        if(currentJob != null)
        {
            isJobCurrent = currentJob.equals(job);
        }

        return isJobCurrent;
    }

    public void resetDb()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(QUERY_RESET_DB);
    }
}
