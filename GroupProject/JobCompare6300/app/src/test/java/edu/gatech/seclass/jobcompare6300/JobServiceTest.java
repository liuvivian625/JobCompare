package edu.gatech.seclass.jobcompare6300;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class JobServiceTest {
    @Mock
    private JobCompareDatabase mockJobCompareDatabase;

    private JobService jobService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        jobService = new JobService(mockJobCompareDatabase);
    }

    @Test
    public void testAddCurrentJob_AdjustedYearlySalaryCalculation() {
        float costOfLiving = 120f;
        float yearlySalary = 120000f;
        float expectedAdjustedYearlySalary = yearlySalary * 100 / costOfLiving;

        doAnswer(invocation -> {
            Job job = invocation.getArgument(0);
            assertEquals(expectedAdjustedYearlySalary, job.getAdjustedYearlySalary(), 0.01);
            return null;
        }).when(mockJobCompareDatabase).addJob(any(Job.class));

        jobService.addCurrentJob("Software Engineer", "Tech Corp", "Atlanta", "GA", costOfLiving, yearlySalary, 10000f, 100, 10f, 15, 50f);
    }

    @Test
    public void testAddJobOffer_AdjustedYearlyBonusCalculation() {
        float costOfLiving = 130f;
        float yearlyBonus = 10000f;
        float expectedAdjustedYearlyBonus = yearlyBonus * 100 / costOfLiving;

        doAnswer(invocation -> {
            Job job = invocation.getArgument(0);
            assertEquals(expectedAdjustedYearlyBonus, job.getAdjustedYearlyBonus(), 0.01);
            return null;
        }).when(mockJobCompareDatabase).addJob(any(Job.class));

        jobService.addJobOffer("Data Scientist", "DataCorp", "San Francisco", "CA", costOfLiving, 150000f, yearlyBonus, 200, 15f, 20, 75f);
    }

}
