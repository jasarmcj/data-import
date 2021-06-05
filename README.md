Data Import API  
===============  
APi to read csv file of large size and import data to a database. He an in memory database is used for test application.  
CSV file contains data regarding books which hast o be read and inserted to BOOK table in databse.  
Reading 1000 records from the file and inserting into the database in a transaction. If it is failed at any point the inserted data will be committed.  
The response will give the details of data import.  


Time Taken  
==========  
1000K records (78 MB) - 15 Minutes  


Curl command to test the api  
----------------------------  
curl --location --request POST 'http://localhost:4377/data-import/' \  
--form 'file=@"/C:/myjob/Tools/sts-4.10.0.RELEASE/workspace/data-import/input/input_1000k.csv"'  
  
  
Response - Successfully imported all books
------------------------------------------  
{  
    "status": "SUCCESS",  
    "message": "Successfully imported all books to database.",  
    "details": {  
        "numberOfBooksImported": 999900  
    }  
}  
  
  
Response - Partial import
-------------------------  
{  
    "status": "FAILED",  
    "message": "Failed to import all books to database.",  
    "details": {  
        "numberOfBooksImported": 5000  
    }  
}  

