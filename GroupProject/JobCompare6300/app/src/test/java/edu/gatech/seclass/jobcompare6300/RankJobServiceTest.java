package edu.gatech.seclass.jobcompare6300;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class RankJobServiceTest {
    @Mock
    private JobCompareDatabase mockJobCompareDatabase;

    private RankJobService rankJobService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        rankJobService = new RankJobService(mockJobCompareDatabase);
    }

    @Test
    public void testComputeScore() {
        rankJobService.adjustComparisonSettings(2, 2, 1, 1, 1, 2);
        Job sampleJob = new Job("Software Engineer", "Tech Corp", new Location("Atlanta", "GA"), 100f,
                90000f, 90000f / 100, 5000f, 5000f / 100, 100, 10f, 15, 50f, 1);

        System.out.println(rankJobService.computeScore(sampleJob));

        assertEquals(rankJobService.computeScore(sampleJob), rankJobService.computeScore(sampleJob), 0.01);
    }

    @Test
    public void testRankJobOffers() throws NoJobException {
        rankJobService.adjustComparisonSettings(2, 2, 1, 1, 1, 2);

        List<Job> mockedJobs = new ArrayList<>();
        mockedJobs.add(new Job("Job1", "Company1", new Location("City1", "State1"), 100f, 80000f, 80000f / 100, 4000f, 4000f / 100, 100, 10f, 15, 45f, 0));
        mockedJobs.add(new Job("Job2", "Company2", new Location("City2", "State2"), 120f, 95000f, 95000f / 120, 7000f, 7000f / 120, 150, 12f, 18, 60f, 0));
        mockedJobs.add(new Job("Job3", "Company3", new Location("City3", "State3"), 100f,90000f, 90000f / 100, 5000f, 5000f / 100, 100, 10f, 15, 50f, 1));

        when(mockJobCompareDatabase.fetchAllJobs()).thenReturn(mockedJobs);

        List<Job> rankedJobs = rankJobService.rankJobOffers();

        assertEquals("Job2", rankedJobs.get(0).getJobTitle());
        assertEquals("Job3", rankedJobs.get(1).getJobTitle());
        assertEquals("Job1", rankedJobs.get(2).getJobTitle());
    }
}
