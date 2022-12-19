<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style type="text/css">

.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

th {
	background: SteelBlue;
	color: white;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
	}
	
	
       @import url('https://fonts.googleapis.com/css2?family=Crimson+Text&display=swap');
        body{
            margin: 0px;
              padding: 0px;
              box-sizing: border-box;
              font-family: 'Lora', serif;
              background-color: rgba(212, 192, 245, 0.24);

        }
        
        .container{
        width:80%;
        margin: auto;
        padding-left:20px;
        padding-right: 20px; 
        margin-top: 25px;
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
     
     #arrangeList{
        
        margin: auto;
        display: flex;
        align-content:center; 

        flex-direction: column;
        justify-content: center;
        display: grid;
        text-align: center;
     }
     
      #navbar>a{
            color: #d4ff00;
        }
     
     #text-center{
        color: #112ed4;
            text-shadow: 2px 0 0px #800040, 3px 2px 0px rgba(77,0,38,0.5), 3px 0 3px #FF002B, 5px 0 3px #800015, 6px 2px 3px rgba(77,0,13,0.5), 6px 0 9px #FF5500, 8px 0 9px #802A00, 9px 2px 9px rgba(77,25,0,0.5), 9px 0 18px #FFD500, 11px 0 18px #806A00, 12px 2px 18px rgba(77,66,0,0.5), 12px 0 30px #D4FF00, 14px 0 30px #6A8000, 15px 2px 30px rgba(64,77,0,0.5), 15px 0 45px #80FF00, 17px 0 45px #408000, 17px 2px 45px rgba(38,77,0,0.5);
            position: relative;

            text-shadow: 0px 15px 5px rgba(0,0,0,0.1),
                 10px 20px 5px rgba(0,0,0,0.05),
                 -10px 20px 5px rgba(0,0,0,0.05);
     
     }
}</style>
<meta charset="ISO-8859-1">
<title>EMS</title>
</head>
<body>

        
    <div id="navbar"> 
        <div><img src="https://github.com/sudarshanmane/Hotstar/blob/main/Screenshot%20(2023).png?raw=true" alt=""></div>
        <a href="/Employee-Management-System"><div><h1>Employee Management System</h1></div></a>
    </div>


	<div id="arrangeList">
	   <h1 id="text-center"> ${message } </h1>
	<c:if test="${!empty employees}">
	
		<table class="tg">
			<tr>
				<th width="80">Id</th>
				<th width="120">Name</th>
				<th width="120">LastName</th>
				<th width="120">Department</th>
				<th width="120">Mobile</th>
				<th width="120">Email</th>
				<th width="120">Address</th>
				<th width="120">Salary</th>
			</tr>
	
			<c:forEach items="${employees}" var="emp">
				<tr>			
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.lastName}</td>
					<td>${emp.department}</td>
					<td>${emp.mobile}</td>
					<td>${emp.email}</td>
					<td>${emp.address}</td>
					<td>${emp.salary}</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>>
	
	
	<div id="home">
      <a id="ancher" href="http://localhost:8080/Employee-Management-System">  <h5>
             Return to Home Page
        </h5>
        </a>
    </div>
  
    
</body>
</html>