RESTful services  implementation of  a checkout counter for an online retail store.



Bill details the products, quantity, total cost,sales tax and the total value of the bill.Data for 6 Products and 1 bill are added during startup.




## Products
*  GET /products - fetches list of all product data
*  GET /products/{id} - fetch a specific product
*  POST /products - Creates a new product based on request JSON



## Bills
*  GET /bills - fetches all bill data
*  GET /bills/{id} - fetches bill of a particular id
*  POST /bills - creates a bill Id. Client has to use this bill Id while adding and removing products

URL:http://localhost:8089/bills 
Sample bill::

[  
   {  
      "id":6,
      "noOfItems":5,
      "totalCost":420.0,
      "totalTax":49.0,
      "totalValue":469.0,
      "billStatus":"RELEASED",
      "lineItems":[  
         {  
            "id":7,
            "product":{  
               "id":1,
               "barCodeId":"abc-0001",
               "name":"product1",
               "productCategory":"A",
               "rate":20.0
            },
            "quantity":2
         },
         {  
            "id":8,
            "product":{  
               "id":2,
               "barCodeId":"abc-0002",
               "name":"product2",
               "productCategory":"B",
               "rate":30.0
            },
            "quantity":1
         },
         {  
            "id":9,
            "product":{  
               "id":3,
               "barCodeId":"abc-0003",
               "name":"product3",
               "productCategory":"C",
               "rate":40.0
            },
            "quantity":2
         },
         {  
            "id":10,
            "product":{  
               "id":4,
               "barCodeId":"abc-0004",
               "name":"product4",
               "productCategory":"A",
               "rate":50.0
            },
            "quantity":3
         },
         {  
            "id":11,
            "product":{  
               "id":5,
               "barCodeId":"abc-0005",
               "name":"product5",
               "productCategory":"B",
               "rate":60.0
            },
            "quantity":2
         }
      ]
   }
]


ID  BAR_CODE_ID  NAME  	PRODUCT_CATEGORY  	RATE  
1	abc-0001	product1	A	20.0
2	abc-0002	product2	B	30.0
3	abc-0003	product3	C	40.0
4	abc-0004	product4	A	50.0
5	abc-0005	product5	B	60.0



SELECT * FROM LINE_ITEM;
ID  	QUANTITY  	PRODUCT_ID  
7	2	1
8	1	2
9	2	3
10	3	4
11	2	5

SELECT * FROM BILLS;
ID  	BILL_STATUS  	NO_OF_ITEMS  	TOTAL_COST  	TOTAL_TAX  	TOTAL_VALUE  
6		RELEASED				5			420.0			49.0	469.0
