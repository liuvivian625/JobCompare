package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.*;
import org.junit.Test;

public class UtilsTest {
    @Test
    public void testValidateStringInput_ValidInput() {
        assertTrue(Utils.ValidateStringInput("ValidInput"));
    }

    @Test
    public void testValidateStringInput_EmptyInput() {
        assertFalse(Utils.ValidateStringInput(""));
    }

    @Test
    public void testValidateHomeBuyingFundPercentage_LessThanFifteen() {
        assertTrue(Utils.validateHomeBuyingFundPercentage(10));
    }

    @Test
    public void testValidateHomeBuyingFundPercentage_EqualToFifteen() {
        assertTrue(Utils.validateHomeBuyingFundPercentage(15));
    }

    @Test
    public void testValidateHomeBuyingFundPercentage_MoreThanFifteen() {
        assertFalse(Utils.validateHomeBuyingFundPercentage(20));
    }

    @Test
    public void testValidateCostOfLiving_PositiveValue() {
        assertTrue(Utils.validateCostOfLiving(1000));
    }

    @Test
    public void testValidateCostOfLiving_NegativeValue() {
        assertFalse(Utils.validateCostOfLiving(-500));
    }

    @Test
    public void testValidatePersonalHolidays_ValidInput() {
        assertTrue(Utils.validatePersonalHolidays(10));
    }

    @Test
    public void testValidatePersonalHolidays_LowerBound() {
        assertTrue(Utils.validatePersonalHolidays(0));
    }

    @Test
    public void testValidatePersonalHolidays_UpperBound() {
        assertTrue(Utils.validatePersonalHolidays(20));
    }

    @Test
    public void testValidatePersonalHolidays_OutOfRange() {
        assertFalse(Utils.validatePersonalHolidays(25));
    }

    @Test
    public void testValidateMonthlyInternetStipend_ValidInput() {
        assertTrue(Utils.validateMonthlyInternetStipend(50));
    }

    @Test
    public void testValidateMonthlyInternetStipend_LowerBound() {
        assertTrue(Utils.validateMonthlyInternetStipend(0));
    }

    @Test
    public void testValidateMonthlyInternetStipend_UpperBound() {
        assertTrue(Utils.validateMonthlyInternetStipend(75));
    }

    @Test
    public void testValidateMonthlyInternetStipend_OutOfRange() {
        assertFalse(Utils.validateMonthlyInternetStipend(80));
    }
}
