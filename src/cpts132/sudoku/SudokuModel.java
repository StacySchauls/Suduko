package cpts132.sudoku;

import java.util.Arrays;

public class SudokuModel extends SudokuCore {
     //array for each number that should be. 1-size
        private int[] numbers = new int[super.getSize()];
        //array of values in the row
        private int[] values = new int[super.getSize()];
        
    
    public SudokuModel(int r, int c) {
        super(r, c);
    }
    
    /**
     * method to get the state of a specified row
     * @param n the row to check
     * @return the state of the row
     */
    @Override
    public State getRowState(int n) {
        //populate the number array
        for(int k =0;k<super.getSize(); k++){
           // numbers[k]=k+1;
        }
        //populate the value array
       for(int i = 0; i<super.getSize();i++){
            for(int j=0; j<super.getSize(); j++){
                values[j] = super.getValue(i, j);
                //check if the array contains a zero, retrun incomplete if so
                if(values[j]==0){
                    return State.INCOMPLETE;
                }
            }
            //System.out.println("values: Row: " +i+ ": " + Arrays.toString(values));
            //check if the arrays contain the same values. if so return complete
            if(this.compareArrays(numbers, values)){
                return State.COMPLETE;
            }

        }
     
        //check for duplicates in the rows, return error if so
        for(int i=0;i<values.length;i++){
               for(int j=i;j<values.length-1;j++){
                   if(values[i] == values[j+1]){
                       return State.ERROR;
                   }
               } 
            }
        //default
        return State.INCOMPLETE;
    }
    
    /**
     * method to get the state of the column
     * @param n column to check
     * @return the state of the column
     */
    @Override
    public State getColumnState(int n) { 
        //populate the number array
        for(int k =0;k<super.getSize(); k++){
            numbers[k]=k+1;       
        }

        
        //populate the value array
       for(int i = 0; i<super.getSize();i++){
            for(int j=0; j<super.getSize(); j++){
                values[j] = super.getValue(j, i);
                
                //check if the array contains a zero, retrun incomplete if so
                if(values[j]==0){
                    return State.INCOMPLETE;
                }
            }
           // System.out.println(Arrays.toString(numbers));
           //System.out.println("column: " +i+ ": " + Arrays.toString(values));
        }
       //check if the arrays contain the same values. if so return complete
       if(this.compareArrays(numbers, values)){
                return State.COMPLETE;
            }
       
       //check for duplicates in the rows, return error if so
        for(int i=0;i<values.length;i++){
               for(int j=i;j<values.length-1;j++){
                   if(values[i] == values[j+1]){
                       return State.ERROR;
                   }
               } 
            }
        //default
        return State.INCOMPLETE;
    }
    
    /**
     *
     * @param n the region to check
     * @return the state of the region
     */
    @Override
    public State getRegionState(int n) { 
        return State.ERROR; 
    }
    
    /**
     * Helper method to check if two arrays contain the same values
     * @param arr1 the first array passed in
     * @param arr2 the second array passed in
     * @return true if the two contain the same values
     */
    public boolean compareArrays(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
       // System.out.println("NUMBERS: "+Arrays.toString(arr1)+ "\n" + "VALUES: " 
               // +Arrays.toString(arr2));
        if(Arrays.equals(arr1, arr2)){
            //System.out.println("SAME");
        }else{
           // System.out.println("FASLE");
        } 

        return Arrays.equals(arr1, arr2);
    }
}