package cpts132.sudoku;

import java.util.Arrays;
import java.util.Iterator;

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
        int cnt = 0;
        RowIterator it = new RowIterator(n);
        //populate the number array
        for(int k =0;k<super.getSize(); k++){
            numbers[k]=k+1;
        }
        
        //run a loop while there is still a number to get
        while(it.hasNext()){
            //record the value that was gotten
            values[cnt] = it.next();
            //check if there is a zero
            if(values[cnt] == 0){
                return State.INCOMPLETE;
            }
            cnt++;
        }
        //check if the values in the row contain all the needed values. 1-size
        if(this.compareArrays(values, numbers)){
            return State.COMPLETE;
        }else{
            //else there is a duplicate
            return State.ERROR;
        }    
    }
    
    /**
     * method to get the state of the column
     * @param n column to check
     * @return the state of the column
     */
    @Override
    public State getColumnState(int n) { 
        int cnt = 0;
        ColIterator it = new ColIterator(n);
        //populate the number array
        for(int k =0;k<super.getSize(); k++){
            numbers[k]=k+1;
        }
        
        //run a loop while there is still a number to get
        while(it.hasNext()){
            //record the value that was gotten
            values[cnt] = it.next();
            //check if there is a zero
            if(values[cnt] == 0){
                return State.INCOMPLETE;
            }
            cnt++;
        }
        System.out.println(Arrays.toString(values));
        //check if the values in the row contain all the needed values. 1-size
        if(this.compareArrays(values, numbers)){
            return State.COMPLETE;
        }else{
            //else there is a duplicate
            return State.ERROR;
        }

    }
    
    /**
     *
     * @param n the region to check
     * @return the state of the region
     */
    @Override
    public State getRegionState(int n) { 

        RegionIterator it = new RegionIterator(n);
        n=1;
        int cnt = 0;
        //populate the number array
        for(int k =0;k<super.getSize(); k++){
            numbers[k]=k+1;
        }
        
        //run a loop while there is still a number to get
        while(it.hasNext() && cnt<getSize()){
            //record the value that was gotten
            values[cnt] = it.next();
            if(values[cnt]==0){
                return State.INCOMPLETE;
            }
            cnt++;
        }
        System.out.println(Arrays.toString(values));
        if(this.compareArrays(values, numbers)){
            return State.COMPLETE;
        }else{
            //else there is a duplicate
            return State.ERROR;
        }
        

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
    
    
    
    java.util.Iterator<Integer> getRowIterator(int n){
        return new RowIterator(n);
    }
    
    
    
    class RowIterator implements java.util.Iterator<Integer>{
            private int col, row;

            public RowIterator(int n){
                col = 0;
                row = n;
            }
                @Override
                public boolean hasNext() {
                    return col<getSize();
                }

                @Override
                public Integer next() {
                   return getValue(row,col++);
                }
                
            @Override
                public void remove(){
                    throw new UnsupportedOperationException("remove not implememnted");
                }


                    
    }
    
    
    class ColIterator implements java.util.Iterator<Integer>{
            private int col, row;

            public ColIterator(int n){
                col = n;
                row = 0;
            }
                @Override
                public boolean hasNext() {
                    return row<getSize();
                }

                @Override
                public Integer next() {
                   return getValue(row++,col);
                }
                
            @Override
                public void remove(){
                    throw new UnsupportedOperationException("remove not implememnted");
                }


                    
            }
    
    class RegionIterator implements java.util.Iterator<Integer>{
        private int col, row;
        
        public RegionIterator(int n){

            row = (n/getRows()) * getRows();
            col = (n%getRows()) * getColumns();
            //System.out.println("Row, Col: " + row+","+col);
            
        }
        @Override
        public boolean hasNext() {
            return col<getSize() && row < getSize();
        }

        @Override
        public Integer next() {
            //System.out.println("Row: "+ row+ " Col: " +col +" Value: " +getValue(row,col));
            if((col+1) % (getColumns()) == 0 && col != 0){
                //System.out.println("Entered col loop: Col= "+col+ "col+1%getcol = "+ (col+1) % (getColumns()-1) );
                 

                // System.out.println("In col if: row: "+ row+" col: "+col);
                int x = getValue(row++, col);
                col = col - (getColumns()-1);
                return x;
            }
            
            if((row+1) % (getRows())==0){
                //System.out.println("in row if, value is: " + getValue(row,col));
                return getValue(row,col++);
            }
            //System.out.println("REturning row, col++: " + getValue(row,col));
            return getValue(row,col++);

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove not implememnted");
        }
    }
}
    
