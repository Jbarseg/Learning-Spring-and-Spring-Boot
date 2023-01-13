## Controller

**What is a Controller?** In the Spring Framework, a controller is a component that handles HTTP requests and returns an appropriate response. Controllers are typically used to handle user input, retrieve data from the model, and return a view (such as a HTML page) to the user. They are responsible for defining the logic that governs the behavior of the application. Controllers are annotated with the @Controller annotation and can handle requests using methods annotated with @RequestMapping.

## **Java Controller Classes**

As you can see we have to use the Annotation @Controller to define what classes our controllers, adittionally we use the @RequestMapping to handle requests.

```

package com.jbarseg.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerMVC {

	@RequestMapping
	public String showPage(){
		return "examplePage";
	}

}


```
```
package com.jbarseg.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormsController {

	@RequestMapping("/showForm")
	public String showForm(){
		return "FirstFormTest";

	}
	@RequestMapping("/processForm")
	public String processForm(){
		return "FirstProcessFormTest";
	}

}


```

## **Java Controller JSP Files**

```

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Example Page using Spring and MVC</h1>

<a href="showForm">Go to the Form</a>

</body>
</html>

```
```

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="processForm" method = "get">
		<input type = "text" name "name">
		<input type = "submit">
	</form>

</body>
</html>

```
```

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hola ${param.name} }. This is part of the First MVC Controller.

</body>
</html>

```