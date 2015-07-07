# ClaimsReserving


# ClaimsReserving project -

  Gets unstructured String data from a comma separated values .txt file.

  Structures each line of input into a Product object

  Groups the Products with identical Product names and Origin years into Triangle objects

  Triangles are then used to aggregate the data about Products over the number of years from the Origin year up to the     most recent development year.

  Aggregated data is then output to another CSV file.

# Stuff to do
  
  Test and implement the OutputDataToCSVFile class
    - data in the Triangles needs to be aggregated
    - CSV format needs to be set to include non changing data
      - such as when a product does not increment from one year to the next
  Test and implement the class to aggregate the data from individual Triangles
    - create array with length in range of earliest year and final development year of product
    - between the earliest year and the Products origin year
      - populate the array with 0
    - when you hit the products origin year
      - put the increment value in the array
    - for each subsequent Product in the product list
      - check if it is one year after the previous Product
        -if it is not
          - populate the array with the current increment value up to the index of (current product development - last             Product development year)
        - if it is
          - put in the array, the current Product incrementValue added to the previous value held in the array
    - return the array
      - which sould be in the format [45.2, 110, 110, 147]
      - this format is compatible with the desired output format

# Libraries -

  JUnit
  Hamcrest
  Lombok 


# Eclipse
 Had been working on project on University computer using Eclipse. When I copied the URL to Eclipse on my home PC to work on this project at home, Eclipse could not compile/run any of the source files.
So all the commits from 2200 ish on 7/7/2015 were made without TDD or even visual testing.
