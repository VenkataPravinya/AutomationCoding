package stepdefinitionfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import reusable.BrowserInvocation;

public class ExercisesValidationSteps {

    int [] array;

    @Given("an array with many values")
    public void anArrayWithManyValues() {

        array = new int[]{90, 89, 34, 45, 56};
        //for(int i=0; i<array.length ; i++)
       // System.out.println(array[i]);
    }

    @Then("Add all the values of an array")
    public void addAllTheValuesOfAnArray() {
        int sumOfValues =0;
        for(int i =0; i<array.length; i++ ){
            sumOfValues = sumOfValues + array[i];
        }
        System.out.println("Sum =" + sumOfValues);
    }

    @Then("find the minimum number.")
    public void findTheMinimumNumber() {
        int i;
        int minNumber = array[0];
        for(i=0;i<array.length; i++){
            if(minNumber > array[i]){
                minNumber = array[i];
            }
        }
        System.out.println("Minimum number = " + minNumber);
    }

    @Then("find the maximum number.")
    public void findTheMaximumNumber() {

        int maxNumber =0;
        for(int i=0; i<array.length ; i++){
            if(maxNumber < array[i]){
                maxNumber = array[i];
            }
        }
        System.out.println("Maximum number = " + maxNumber);

    }
    @And("sort an array in the increasing order")
    public void sortArray(){
        int [] sorted;

        for(int i=0; i<array.length; i++){
            for(int j=0; j<i+1 ; j++)
            {
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }
        }
        for(int k=0; k<array.length; k++)
        System.out.println(array[k]);
    }

    @Then("find the second Maximum number.")
    public void findTheSecondMaximumNumber() {
        System.out.println("Second Maximum=" + array[array.length-2]);
    }


}
