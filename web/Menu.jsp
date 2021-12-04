<%-- 
    Document   : Menu
    Created on : Jul 6, 2021, 11:19:51 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="HomeControl">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <c:if test="${sessionScope.acc.isAdmin==1}">
                        <li class="nav-item">
                            <a class="nav-link" href="ManagerControl">Manager Product</a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.acc!=null}">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Hello ${sessionScope.acc.username}</a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.acc!=null}">
                        <li class="nav-item">
                            <a class="nav-link" href="LogOutControl">Logout</a>
                        </li>
                    </c:if>
                          <c:if test="${sessionScope.acc==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="LoginformControl">Login</a>
                        </li>
                          </c:if>
                    </ul>

                    <form action="SearchControl" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="ViewCartControl">
                            <i class="fa fa-shopping-cart"></i> Cart
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Shop Quần Áo Nam Nữ</h1>
                <p class="lead text-muted mb-0">Thời trang và hơn thế nữa</p>
            </div>
        </section>
      
