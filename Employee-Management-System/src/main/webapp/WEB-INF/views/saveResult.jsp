<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

   <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<style type="text/css">


       @import url('https://fonts.googleapis.com/css2?family=Crimson+Text&display=swap');
        body{
            margin: 0px;
              padding: 0px;
              box-sizing: border-box;
              font-family: 'Lora', serif;
              background-color: rgba(212, 192, 245, 0.24);

        }
        #navbar{
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: space-around;
            text-shadow: 2px 0 0px #800040;
            color: #c4e22c;
            /* border: 1px solid black; */
            background-color: white;
            box-shadow: 0px 4px 17px 3px rgba(118,98,245,0.81);
            text-shadow: 2px 0 0px #800040, 3px 2px 0px rgba(77,0,38,0.5), 3px 0 3px #FF002B, 5px 0 3px #800015, 6px 2px 3px rgba(77,0,13,0.5), 6px 0 9px #f8ad88, 8px 0 9px #802A00, 9px 2px 9px rgba(77,25,0,0.5), 9px 0 18px #FFD500, 11px 0 18px #806A00, 12px 2px 18px rgba(77,66,0,0.5), 12px 0 30px #D4FF00, 14px 0 30px #6A8000, 15px 2px 30px rgba(64,77,0,0.5), 15px 0 45px #80FF00, 17px 0 45px #408000, 17px 2px 45px rgba(38,77,0,0.5);


      }
        #navbar>div:first-child{
            width: 150px;-shadow: rgba(139, 194, 217, 0.35) 0px 5px 15px;;
            border-radius: 10px;
            box-shadow: rgba(188, 226, 65, 0.35) 0px 5px 15px;
        }

        #navbar>div:first-child>img{
            width: 100%;
            border-radius: 10px;
            height: 100%;
        }
        
         #one{
            padding-top: 10px;
            padding-bottom: 10px;
            padding-left: 10px;
            padding-right: 10px;
            margin-left: 300px;
            margin-right : 300px ;
            box-shadow: 0px 4px 17px 3px rgba(118,98,245,0.81);
            border-radius: 10px;
            margin-top: 50px;
            text-align: center;
            
        }
        
        #home{
            align-items: center;
            display: flex;
            justify-content: center;
            width: 200px;
            margin: auto;
            color: #d4ff00;
            border-radius: 5px;
            margin-top: 20px;
            background-color: black;
            text-shadow:  rgba(168, 24, 170, 0.45);
            border-radius: 10px;    
            margin-bottom: 20px 
        }

        #home:hover{
            text-decoration: none;
            background-color: #b464ed;
        }
        #ancher{
            color: #d4ff00;
            align-items: center;
            display: flex;
            text-align: center;

        }

        a{
            text-decoration: none;
        }
        
        #exampleInputEmail1{
        margin-top: 10px;
        width: 80%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: space-around;
        margin-left: 10%
        }
        
           
    #navbar>a{
            color: #d4ff00;
        }
        
        h4{
        color: #112ed4;
            text-shadow: 2px 0 0px #800040, 3px 2px 0px rgba(77,0,38,0.5), 3px 0 3px #FF002B, 5px 0 3px #800015, 6px 2px 3px rgba(77,0,13,0.5), 6px 0 9px #FF5500, 8px 0 9px #802A00, 9px 2px 9px rgba(77,25,0,0.5), 9px 0 18px #FFD500, 11px 0 18px #806A00, 12px 2px 18px rgba(77,66,0,0.5), 12px 0 30px #D4FF00, 14px 0 30px #6A8000, 15px 2px 30px rgba(64,77,0,0.5), 15px 0 45px #80FF00, 17px 0 45px #408000, 17px 2px 45px rgba(38,77,0,0.5);
            position: relative;

            text-shadow: 0px 15px 5px rgba(0,0,0,0.1),
                 10px 20px 5px rgba(0,0,0,0.05),
                 -10px 20px 5px rgba(0,0,0,0.05);
     }
      
</style>

</head>
<body>
        
 
        
    <div id="navbar"> 
        <div><img src="https://github.com/sudarshanmane/Hotstar/blob/main/Screenshot%20(2023).png?raw=true" alt=""></div>
        <a href="/Employee-Management-System"><div><h1>Employee Management System</h1></div></a>
    </div>    
    
    
    
    <%
    String message = (String) request.getAttribute("message");
    String message1 = (String) request.getAttribute("message1");
    %>
    
    
    <div id="one">
    
    <h4> <%=message %></h4>
    
    </div>

    
    
  
<div id="home">
      <a id="ancher" href="http://localhost:8080/Employee-Management-System">  <h5>
             Return to Home Page
        </h5>
        </a>
    </div>
     
</body>
</html>