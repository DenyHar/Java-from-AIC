<%--
  Created by IntelliJ IDEA.
  User: Victoria
  Date: 15.01.2025
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>HP Inc.</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <style>
    body {
      font-family: "Segoe UI", serif;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">General info</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="news-servlet">Recent news</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="laptops-servlet">Models</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">Index</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row mt-2">
    <div class="col">
      <img alt="Headquarters in Palo Alto, California" src="pics/HP_Headquarters_Palo_Alto.jpg" style="float: left; width: 375px; height: auto; margin: 10px 40px;">
      <div>
        <h1>HP</h1>
        <p><b>Country:</b> United States</p>
        <p><b>Number of employees:</b> 58 thousand people</p>
        <p>
          <b>Short description:</b><br>
            HP Inc. is an American multinational information technology company with its headquarters in Palo Alto, California, that develops personal computers (PCs), printers and related supplies, as well as 3D printing services.<br>
            It is the world's second-largest personal computer vendor by unit sales after Lenovo and ahead of Dell as of 2024.<br>
            HP Inc. was founded in 2015 when the original Hewlett-Packard Company split into two companies.
            The old company's enterprise product and business services divisions were spun-off into a new publicly traded company, Hewlett Packard Enterprise.
            Hewlett-Packard then renamed itself as HP Inc. and retained the personal computer and printer services divisions of its predecessor, serving as the legal successor of the original company that was founded in 1939.
            HP is listed on the New York Stock Exchange and is a constituent of the S&P 500 Index. In the 2023 Fortune 500 list, HP is ranked 63rd-largest United States corporation by total revenue.<br>
        </p>
      </div>
    </div>
  </div>
</div>
</body>
</html>
