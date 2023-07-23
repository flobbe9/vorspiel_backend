package com.example.vorspiel.documentParts;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Class holding necessary table information.
 * 
 * @since 0.0.1
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableConfig {

    @NotNull(message = "'numColumns' cannot be null.")
    @Min(value = 1, message = "'numColumns' has to be greater than equal 1.")
    private Integer numColumns;
    
    @NotNull(message = "'numRows' cannot be null.")
    @Min(value = 1, message = "'numRows' has to be greater than equal 1.")
    private Integer numRows;
    
    /** The index in content list with the first table element. */
    @NotNull(message = "'startIndex' cannot be null.")
    @Min(value = 0, message = "'startIndex' has to be greater than equal 0.")
    private Integer startIndex;
    
    /** The index in content list with the last table element. */
    @NotNull(message = "'endIndex' cannot be null.")
    @Min(value = 0, message = "'endIndex' has to be greater than equal 0.")
    private Integer endIndex;
    
    
    /**
     * Calls all neccessary validation methods on fields.
     * 
     * @return true if all fields are valid
     */
    @AssertTrue(message = "Invalid 'tableConfig'. Not enough cells for content.")
    public boolean isValid() {
        
        return isTableBigEnough();
    }
    
    
    /**
     * Checks that product of table columns and rows is greater equal than the number of cells that will 
     * actually be filled.
     * 
     * @return true if table has enough cells
     */
    private boolean isTableBigEnough() {
        
        int numTableCells = getNumColumns() * getNumRows();
        int numFilledCells = getEndIndex() - getStartIndex() + 1;
        
        // should at least as many table cells as input cells
        return numTableCells >= numFilledCells;
    }
}