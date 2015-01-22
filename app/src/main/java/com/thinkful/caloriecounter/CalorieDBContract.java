package com.thinkful.caloriecounter;

import android.provider.BaseColumns;

/**
 * This is the database contract. It specifies the names used in the database as well
 * as the full schema.
 * Created by Vincent on 1/22/15.
 */
public class CalorieDBContract {

    /*Empty constructor*/
    public CalorieDBContract() {}

    /*When you change the schema you need to update the version number*/
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "caloriedb";

    /*CREATE TABLE Statements*/
    public static final String SQL_CREATE_FOOD = String.format(
            "CREATE TABLE %s ( %s TEXT, %s INTEGER)",
            Food.TABLE_NAME, Food.COLUMN_NAME_DESCRIPTION, Food.COLUMN_NAME_CALORIES);

    public static final String SQL_CREATE_MEAL = String.format(
            "CREATE TABLE %s ( %s DATETIME, %s INTEGER, %s INTEGER)",
            Meal.TABLE_NAME, Meal.COLUMN_NAME_MEAL_DATE,
            Meal.COLUMN_NAME_FOOD_ID, Meal.COLUMN_NAME_MEAL_TYPE_ID);

    public static final String SQL_CREATE_MEAL_TYPE = String.format(
            "CREATE TABLE %s ( %s TEXT)",
            MealType.TABLE_NAME, MealType.COLUMN_NAME_NAME);

    /*DROP TABLE Statements*/
    public static final String SQL_DELETE_FOOD =
            String.format("DROP TABLE IF EXISTS %s", Food.TABLE_NAME);

    public static final String SQL_DELETE_MEAL =
            String.format("DROP TABLE IF EXISTS %s", Meal.TABLE_NAME);

    public static final String SQL_DELETE_MEAL_TYPE =
            String.format("DROP TABLE IF EXISTS %s", MealType.TABLE_NAME);


    /* Inner class that defines the food table */
    public static abstract class Food implements BaseColumns {
        public static final String TABLE_NAME = "food";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_CALORIES = "calories";
    }

    /* Inner class that defines the meal table */
    public static abstract class Meal implements BaseColumns {
        public static final String TABLE_NAME = "meal";
        public static final String COLUMN_NAME_MEAL_DATE = "meal_date";
        public static final String COLUMN_NAME_FOOD_ID = "food_id";
        public static final String COLUMN_NAME_MEAL_TYPE_ID = "meal_type_id";
    }

    /* Inner class that defines the meal_type table*/
    public static abstract class MealType implements BaseColumns {
        public static final String TABLE_NAME = "meal_type";
        public static final String COLUMN_NAME_NAME = "name";
    }

}
