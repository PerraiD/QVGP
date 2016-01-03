# QVGP
Qui veux gagner des plugins.

FORMAT: 1A
HOST: http://rib-api.apiblueprint.org/

# rib-api

L'api RIB (Race 2 International Business) permet de créer, récupérer, modifier, supprimer toutes les entités qui constituent le serious game éponyme.

## Authentication [/authentification/auth]

### Authenticate [POST]

+ Request (application/json)

        {
            "login": "Team1",
            "password":"mypassword"
        }

+ Response 201 (application/json)

    + Body

            {
                "login": "Team1",
                "password": "mypassword" ,
                "isAdmin": false
            }

## Teams [/teams]

### List All Teams [GET]

+ Response 200 (application/json)

        [
            {
                "_id": "aze153dsfsdfa1ea53",
                "name": "team1",
                "session": "ab512354c354e5b54f5c3a",
                "created": "2015-08-05T08:40:51.620Z",
                "members": [
                    {
                        "firstname": "Taylor",
                        "lastname": "Swift",
                        "email": "taylor.swift@gmail.com",
                        "institution":"university"
                    }, {
                        "firstname": "Nicolas",
                        "lastname": "Loyd",
                        "email": "nicolas.loyd@gmail.com"
                    }, {
                        "firstname": "Paul",
                        "lastname": "Klein",
                        "email": "paul.klein@gmail.com"
                    }, {
                        "firstname": "Alwin",
                        "lastname": "Vouix",
                        "email": "alwin.vouix@gmail.com"
                    }
                ]
            },
            {
                "_id": "hgfhfg4fdgsfd12",
                "name": "JackTeam",
                "session": "ab512354c354e5b54f5c3a",
                "created": "2015-08-05T08:40:51.620Z",
                "members": [
                    {
                        "firstname": "Jacques",
                        "lastname": "Black",
                        "email": "jacques.black@gmail.com"
                    }, {
                        "firstname": "Jack",
                        "lastname": "Brel",
                        "email": "jack.brel@gmail.com"
                    }, {
                        "firstname": "Jake",
                        "lastname": "Dexter",
                        "email": "jake.dexter@gmail.com"
                    }, {
                        "firstname": "Jak",
                        "lastname": "Three",
                        "email": "jak.three@gmail.com"
                    }
                ]
            }
        ]

### Create a New Team [POST]

+ Request (application/json)

        {
            "name": "Team1",
            "session":"ab512354c354e5b54f5c3a"
        }

+ Response 201 (application/json)

    + Headers

            Location: /teams/5
            Authorization: Bearer az5e64gfc3sfb2g1d65sf3g2fd1fg

    + Body

            {
                "_id": "5",
                "name": "team1",
                "session": "ab512354c354e5b54f5c3a",
                "created": "2015-08-05T08:40:51.620Z",
                "members": []
            }




## Team [/teams/:id]
### List a Team Details [GET]

+ Response 200 (application/json)
        
            {
                "_id": :id,
                "name": "team1",
                "session": "ab512354c354e5b54f5c3a",
                "created": "2015-08-05T08:40:51.620Z",
                "members": [
                    {
                        "firstname": "Taylor",
                        "lastname": "Swift",
                        "email": "taylor.swift@gmail.com"
                    }, {
                        "firstname": "Nicolas",
                        "lastname": "Loyd",
                        "email": "nicolas.loyd@gmail.com"
                    }, {
                        "firstname": "Paul",
                        "lastname": "Klein",
                        "email": "paul.klein@gmail.com"
                    }, {
                        "firstname": "Alwin",
                        "lastname": "Vouix",
                        "email": "alwin.vouix@gmail.com"
                    }
                ]
            }

### Update a Team [POST]

+ Request (application/json)

            { 
                "name": "Team1",
                "session": "aeazefezfez",
                "created": "10:12:20134:121",
                "members": [{
                    "firstname": thomas,
                    "lastname": toto,
                    "email": thomas.toto@gmail.com
                }]
            }
+ Response 201 (application/json)

## Team Members [/teams/:id/members]
### Add a team member [POST]

+ Request (application/json)

        {
            "firstname": "Taylor",
            "lastname":"Swift",
            "email":"taylor.swift@gmail.com"
        }

+ Response 201 (application/json)

    + Headers

            Location: /teams/:id

    + Body

            {
                "_id": "aze153dsfsdfa1ea53",
                "name": "team1",
                "session": "ab512354c354e5b54f5c3a",
                "created": "2015-08-05T08:40:51.620Z",
                "members": [
                    {
                        "firstname": "Taylor",
                        "lastname":"Swift",
                    "email":"taylor.swift@gmail.com"
                    }
                ]
            }
            
## Market [/markets/]

### Get markets [GET]

+ Response 201 (application/json)

    + Body

            [{
                "_id":sdf4563sd4f653421dsf324de,
                "name": Produit1,
                "paymentDelay": [{
                    "index": 1,
                    "delay": "30j fdm"
                }],
                "merchandiser": [{
                    "nbMerchandiser": 1,
                    "index": 0.2
                }]
            },
            {   
                "_id":f653421dsf324desdf4563sd4,
                "name": Produit2,
                "paymentDelay": [{
                    "index": 1,
                    "delay": "30j fdm"
                },
                {
                    "index": 2,
                    "delay": "30j"  
                }],
                "merchandiser": [{
                    "nbMerchandiser": 1,
                    "index": 1.0
                },
                {
                    "nbMerchandiser": 2,
                    "index": 3.0
                }]
            }]

### Add a market [POST]

+ Request (application/json)

        {
            "_id":sdf4563sd4f653421dsf324de,
            "name": Produit4,
            "paymentDelay": [{
                "index": 1,
                "delay": "30j"
            }],
            "merchandiser": [{
                "nbMerchandiser": 1,
                "index": 0.2
            }]
        }
        
+ Response 201 (application/json)

## Market [/market/:id]
### Get a market [GET]
+ Response 201 (application/json)
    + Body
    
            {           
                "_id":sdf4563sd4f653421dsf324de,
                "created": "2015-08-05T08:40:51.620Z",
                "name": "Coffee",
                "paymentDelay":[
                    {"index":0,"delay":"0"},
                    {"index":0.95,"delay":"30j"},
                    {"index":1.00,"delay":"30j fdm"}
                ],
                "merchandiser":[
                    {"index":0.30,"nbMerchandiser":0},
                    {"index":0.60,"nbMerchandiser":1},
                    {"index":0.8,"nbMerchandiser":2}
                ]
            }

### Edit a market [PUT]
+ Request (application/json)

        {
            "name": "Champagne",
            "paymentDelay":[
                {"index":0,"delay":"0"},
                {"index":0.95,"delay":"30j"},
                {"index":1.00,"delay":"30j fdm"}
            ],
            "merchandiser":[
                {"index":0.30,"nbMerchandiser":0},
                {"index":0.60,"nbMerchandiser":1},
                {"index":0.8,"nbMerchandiser":2}
            ]
        }
+ Response 201 (application/json)

    + Body
    
            {
                "_id": "oneId",
                "name": "Champagne",
                "paymentDelay":[
                    {"index":0,"delay":"0"},
                    {"index":0.95,"delay":"30j"},
                    {"index":1.00,"delay":"30j fdm"}
                ],
                "merchandiser":[
                    {"index":0.30,"nbMerchandiser":0},
                    {"index":0.60,"nbMerchandiser":1},
                    {"index":0.8,"nbMerchandiser":2}
                ]
            }

## Products [/market/:id/products]

### Get all products [GET]

+ Response 201 (application/json)

    + Body

            [{
                "name": "Champagne",
                "priceIndex": [{
                    "index": 0.5,
                    "price": 1.0
                }],
                "advertising": [{
                    "index": 1.1,
                    "sensibility": 1.5 
                }]
            },
            {
                "name": "mousseux",
                "priceIndex": [{
                    "index": 0.5,
                    "price": 1.0
                }],
                "advertising": [{
                    "index": 1.1,
                    "sensibility": 1.5 
                }]
            }]
            
### Add a product [POST]

+ Request (application/json)

        {
            "name": "Champagne",
            "priceIndex": [{
                "index": 0.5,
                "price": 1.0
            }],
            "advertising": [{
                "index": 1.1,
                "sensibility": 1.5 
            }]
        }
        
+ Response 201 (application/json)

    + Headers
    
            Location: /products/:id
    
    + Body

            {
                "_id": "oneId",
                "created": "2015-08-05T08:40:51.620Z",
                "name": "Champagne",
                "priceIndex": [{
                    "index": 0.5,
                    "price": 1.0
                }],
                "advertising": [{
                    "index": 1.1,
                    "sensibility": 1.5 
                }]
            }
        
## Products [/market/:id/products/:id]       
### Get a product details [GET]

+ Response 201 (application/json)

    + Body

            [{
                "_id": "oneId",
                "name": "Champagne",
                "priceIndex": [{
                    "index": 0.5,
                    "price": 1.0
                }],
                "advertising": [{
                    "index": 1.1,
                    "sensibility": 1.5 
                }]
            }]
            
## Sessions [/sessions/]
### Create a session [POST]

+ Request (application/json)

        {
            "name": "Session Nantes 2015",
            "nbYears": 5,
            "market": "sdf4563sd4f653421dsf324de",
            "products": [
                0,
                1,
                2
            ],
            "members": [
                "taylor.swift@gmail.com",
                "nicolas.loyd@gmail.com",
                "paul.klein@gmail.com",
                "alwin.vouix@gmail.com"
            ]
        }
        
+ Response 201 (application/json)

    + Headers
    
            Location: /sessions/:id
            
    + Body
    
            {
                "_id": "sdf4563sd8ty53421dsf324df",
                "created": "2015-08-05T08:40:51.620Z",
                "name": "Session Nantes 2015",
                "nbYears": 5,
                "market": "sdf4563sd4f653421dsf324de",
                "products": [
                    0,
                    1,
                    2
                ],
                "members": [
                    "taylor.swift@gmail.com",
                    "nicolas.loyd@gmail.com",
                    "paul.klein@gmail.com",
                    "alwin.vouix@gmail.com"
                ]
            }


### Get all sessions [GET]

+ Response 201 (application/json)

 + Body
    
            [{
                "_id": "sdf4563sd8ty53421dsf324df",
                "created": "2015-08-05T08:40:51.620Z",
                "name": "Session Bordeau 2014",
                "nbYears": 6,
                "market": "sdf4563sd4f653421dsf324de",
                "products": [
                    0,
                    1,
                    2
                ],
                "members": [
                    "taylor.swift@gmail.com",
                    "nicolas.loyd@gmail.com",
                    "paul.klein@gmail.com",
                    "alwin.vouix@gmail.com"
                ]
            },{
                "_id": "sdf4563sd8ty53421dsf324df",
                "created": "2015-08-05T08:40:51.620Z",
                "name": "Session Nantes 2015",
                "nbYears": 5,
                "market": "sdf4563sd4f653421dsf324de",
                "products": [
                    0,
                    1,
                    2
                ],
                "members": [
                    "taylor.swift@gmail.com",
                    "nicolas.loyd@gmail.com",
                    "paul.klein@gmail.com",
                    "alwin.vouix@gmail.com"
                ]
            }
            
            
            ]

## Decisions [/decisions/]

### Create a decision [POST]

+ Request (application/json)

        {
            "team_id" : "idofTeam"
            "decisions" : [{      
                "year" : 1,
                "prime" : 1000.0,
                "nbSeller": 4,
                "paymentDelay": "30",
                "nbMachine": 4,
                "marketingCost" : 1000
             }]
            "productDecisions": [{
                "productId":"idOfProduct",
                "stock" : 2346,
                "pvttc"  : 234.0,
                "pvht" : 265.0,
                "quantity":40,
                "marketing": 1000
            }]
        }

+ Response 201 (application/json)


### Get all  decisions [GET]

+ Response 201 (application/json)

        {
            [{
                "team_id" : "idofTeam"
                "decisions" : [{      
                    "year" : 1,
                    "prime" : 1000.0,
                    "nbSeller": 4,
                    "paymentDelay": "30",
                    "nbMachine": 4,
                    "marketingCost" : 1000
                 }]
                "productDecisions": [{
                    "productId":"idOfProduct",
                    "stock" : 2346,
                    "pvttc"  : 234.0,
                    "pvht" : 265.0,
                    "quantity":40,
                    "marketing": 1000
                }]
            }}
        }



## Decisions [/decisions/:id]

### Get a decision [GET]

+ Response 201 (application/json)

        {
            "team_id" : "idofTeam"
            "decisions" : [{      
                "year" : 1,
                "prime" : 1000.0,
                "nbSeller": 4,
                "paymentDelay": "30 fdm",
                "nbMachine": 4,
                "marketingCost" : 1000
             }]
            "productDecisions": [{
                "productId":"idOfProduct",
                "stock" : 2346,
                "pvttc"  : 234.0,
                "pvht" : 265.0,
                "quantity":40,
                "marketing": 1000
            }]
        }


## Results [/results]

### Create a results [POST]

+ Request (application/json)

        {
           "teamId": "563b607089621b481d968aa3",
            "year": 2,
            "productCapacity": 1234,
            "marketShare": 1234,
            "stock": 45366,
            "sale": {
                "proposition": 1000,
                "potential": 900,
                "real": 1234
            },
            "turnover": 12345,
            "salePrice": 1234567,
            "result": {
                "commercial": 123456,
                "exercice": 123456
            }
        }

+ Response 201 (application/json)

### Get all results [GET]

+ Response 201 (application/json)

            {[
                {
               "teamId": "563b607089621b481d968aa3",
                "year": 2,
                "productCapacity": 1234,
                "marketShare": 1234,
                "stock": 45366,
                "sale": {
                    "proposition": 1000,
                    "potential": 900,
                    "real": 1234
                },
                "turnover": 12345,
                "salePrice": 1234567,
                "result": {
                    "commercial": 123456,
                    "exercice": 123456
                }
            },
                {
               "teamId": "563b607089621b481d968aa3",
                "year": 2,
                "productCapacity": 1234,
                "marketShare": 1234,
                "stock": 45366,
                "sale": {
                    "proposition": 1000,
                    "potential": 900,
                    "real": 1234
                },
                "turnover": 12345,
                "salePrice": 1234567,
                "result": {
                    "commercial": 123456,
                    "exercice": 123456
                }
            }
            ]}

## Results [/results/:id]

### Get results by id [GET]

+ Response 201 (application/json)

        {
           "teamId": "563b607089621b481d968aa3",
            "year": 2,
            "productCapacity": 1234,
            "marketShare": 1234,
            "stock": 45366,
            "sale": {
                "proposition": 1000,
                "potential": 900,
                "real": 1234
            },
            "turnover": 12345,
            "salePrice": 1234567,
            "result": {
                "commercial": 123456,
                "exercice": 123456
            }
        }

### Update results by id [PUT]

+ Request (application/json)

        {
           "teamId": "563b607089621b481d968aa3",
            "year": 4,
            "productCapacity": 0000,
            "marketShare": 1234,
            "stock": 45366,
            "sale": {
                "proposition": 1000,
                "potential": 900,
                "real": 1234
            },
            "turnover": 12345,
            "salePrice": 1234567,
            "result": {
                "commercial": 123456,
                "exercice": 123456
            }
        }
        
+ Response 201 (application/json)

## Results [/team/:teamId/results]

### Get results by a team id [GET]

+ Response 201 (application/json)

        [{
           "teamId": "563b607089621b481d968aa3",
            "year": 2,
            "productCapacity": 1234,
            "marketShare": 1234,
            "stock": 45366,
            "sale": {
                "proposition": 1000,
                "potential": 900,
                "real": 1234
            },
            "turnover": 12345,
            "salePrice": 1234567,
            "result": {
                "commercial": 123456,
                "exercice": 123456
            }
        }}


