<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="metier.livers" %>
    <%@ page import="dao.LivresDaoimpli" %>
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Livers</title>
    <link href="/index.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style >
    @charset "UTF-8";
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@800&family=Poetsen+One&family=Rubik:ital,wght@0,300..900;1,300..900&display=swap');
*{
    margin: 0;
    padding: 0;
      font-family: "Poetsen One", sans-serif;
  font-weight: 400;
  font-style: normal;
}

.background{
    background-color: rgb(248, 245, 240);
    position: absolute;
    width: 100%;
    height: 100%;
    z-index: -1;
    position: fixed;
}
.background img{
    transform: scaleX(-1);
    max-width: 687px;
    height: 100%;
    position: absolute;
    right: 0;
    opacity: 0.14;
}

.custom-shape-divider-bottom-1714556739 {
    position: absolute;
    width: 100%;
    overflow: hidden;
    line-height: 0;
    transform: rotate(90deg);
    top: 50px;
    right: 36%;
}

.custom-shape-divider-bottom-1714556739 svg {
    position: relative;
    display: block;
    width: calc(100% + 1.3px);
    height: 69px;
}

.custom-shape-divider-bottom-1714556739 .shape-fill {
    fill: rgb(248, 245, 240);
}

.search {
    position: absolute;
    left: 17%;
    top: 5%;
    width: 80%;
    display: flex;
    transform: scaleX(1);

  }
  
  .search__input {
    font-family: inherit;
    font-size: inherit;
    background-color: #ffffff;
    border: none;
    color: #646464;
    padding: 0.7rem 1rem;
    border-radius: 30px;
    width: 17em;
    transition: all ease-in-out .2s;
    margin-right: -2rem;
    box-shadow: 0 0 1em #0000000b;
  }
  
  .search__input:hover, .search__input:focus {
    box-shadow: 0 0 1em #0000002a;
  }
  
  .search__input:focus {
    outline: none;
    background-color: #f0eeee53;
  }
  
  .search__input::-webkit-input-placeholder {
    font-weight: 100;
    color: #ccc;
  }
  
  .search__input:focus + .search__button {
    background-color: #f0eeee53;
  }
  
  .search__button {
    border: none;
    background-color: transparent;
    margin-top: .1em;
    transition: all ease-in-out .2s;
  }
  
  .search__button:hover {
    cursor: pointer;
  }
  
  .search__icon {
    height: 1.3em;
    width: 1.3em;
    fill: #b4b4b4;
  }

  .Livres{
    position: absolute;
    left: 255px;
    top: 600px;
    width: 80%;
    height: 100%;
    display: flex;
    flex-wrap: wrap;
    background-color: white;
    border-radius: 30px;
  flex-direction: column;
  align-items: flex-end;
  justify-content: space-evenly;
  }

  .livre{
  	display: block;
    height: 316px;
    border-radius: 14px;
    align-content: space-around;
    transition: all ease-in-out .2s;
    cursor: pointer;
    display: flex;
    flex-direction: column;
  }
  .livre:hover{
    background-color: white;
  }
 
	.image{
    display: flex;
    justify-content: space-evenly;

	}
  .image img{
    width: 200px;
    height: 305px;
    
    position:absolute;
    border-radius: 14px;
    top:-170px;
  }
  .titre{
    position: absolute;
    top:-56px;
    left: 291px;
    display: flex;
    flex-direction: column;
  
  }
  
  .titre p{
    font-size: 3rem;
  }
  .dicsription{
    width: 76%;
    height: 100%;

  }
  .info{
    display: flex;
    gap: 30px;
    font-size: 1.5rem;
    margin: 40px;
  }
  .button{
      width: 220px;
      height: 80px;
      border: none;
      outline: none;
      font-size: 22px;
      border-radius: 40px;
      box-shadow: 0 6px 20px -5px rgba(0,0,0,0.4);
      overflow: hidden;
      cursor: pointer;
  }
  input{
    width: 100%;
      height: 80px;
      border: none;
      outline: none;
      background: #2f2f2f;
      color: #fff;
      text-align: center;
  }
  
  .container-HorizontalScroll {
    position: relative;
    width: 75%;
    overflow-x: auto; 
    white-space: nowrap;
    margin-left: 20%;
    padding: 20px 0 0 0;
  }

  .container-HorizontalScroll::-webkit-scrollbar {
    display: none;
  }

  .item {
    display: inline-block;
    text-align: center;
  }

/* control cover size */
  .book-cover{
    width: 120px;
    height: 180px;
  }

  .book-cover img{
    box-shadow: 0 0 1em #0000002a;
    width: 100%;
    height: 100%;
    border-radius: 30px;
  }

  .item p{
    font-size: 8px;
  }


  .book{
    display: flex;
    align-items: center;
    flex-direction: column;
  }
.book p {
  margin: 0;
  padding: 0;
}
  #item-title-book{
    margin-top: 10px;
    width: 185px;
    font-family: "Roboto", sans-serif;
    font-style: normal;
    font-size: 12px;
    overflow:hidden;
    text-overflow: ellipsis;
  }

  .checked {
    color: orange;
  }


  .star{
    font-size: 11px;
  }

  .writer{
    color: #BFBFBF;

  }
  .Last{
  margin: 0 0 0 20%;
  padding: 10px 0 0 0;
  width: 75%;
  }
  .Last p{
    font-size:1.5rem;
  }
  
  
     .sidebar {
    width: 200px;
    height: 100%;
    /* Gradient background with cooler colors */
    background: linear-gradient(to bottom, #6dd5ed, #2193b0);
    color: white; /* Adjust the text color for better contrast */
    position: fixed;
    left: 0;
    top: 0;
    overflow: auto;
    padding-top: 20px;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.2); /* Add shadow for depth */
    z-index: 1000; /* Ensure sidebar is above other elements */
}

    .sidebar-logo {
        display: flex;
        align-items: center;
        padding: 0 20px;
        color: #fff;
    }

    .sidebar-logo img {
        max-width: 50px;
        max-height: 50px;
        margin-right: 10px;
    }

    .sidebar-username {
        margin-bottom: 30px;
        padding: 0 20px;
        color: #fff;
    }

    .sidebar-link {
        display: flex;
        align-items: center;
        padding: 10px 20px;
        color: #ddd;
        text-decoration: none;
        font-size: 18px;
    }

    .sidebar-link:hover {
        background: #575757;
        color: white;
    }

    .sidebar-link .fas {
        margin-right: 10px;
    }

    .sidebar-logout {
        position: absolute;
        bottom: 20px;
        width: 100%;
        text-align: center;
    }

    .logout-button {
        padding: 10px 20px;
        background: #d9534f;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
    }

    .logout-button:hover {
        background: #c9302c;
       color: white;
    }
  </style>
</head>
<body>
    
    <div class="sidebar">
        <a href="#" class="sidebar-link"><i class="fas fa-home"></i>Home</a>
        <a href="#" class="sidebar-link"><i class="fas fa-book"></i>Emprunter</a>
        <a href="#" class="sidebar-link"><i class="fas fa-heart"></i>Liste de souhaits</a>
        <a href="#" class="sidebar-link"><i class="fas fa-history"></i>Historique</a>
        <div class="sidebar-logout">
            <a href="/lage/" class="logout-button" >Log Out</a>
        </div>
    </div>
    
    <!-- <div class="custom-shape-divider-bottom-1714556739">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M1200,0H0V120H281.94C572.9,116.24,602.45,3.86,602.45,3.86h0S632,116.24,923,120h277Z" class="shape-fill"></path>
        </svg>
    </div> -->


    <div class="containe">
        <div class="background">
            <img src="https://mrkzgulfup.com/uploads/171466215535451.png" alt="booksback">
        </div>
        
         <% String idParam = request.getParameter("id"); %>
    <% if (idParam != null && !idParam.isEmpty()) { %>
        <% int id = Integer.parseInt(idParam); %>
        <% LivresDaoimpli dao = new LivresDaoimpli(); %>
        <% livers livre = dao.getLivres(id); %>
        <% if (livre != null) { %>
        <div class="Livres">
        
            <div class="livre">
                <div class="image">
                    <img src="<%= livre.getImage() %>" alt="cover">
                </div>  
                <div class="titre">
                    <p><%= livre.getTitre() %></p>
                </div>
                <button class="button">
                    <input class="styled" type="button" value="Emprunt" />
                </div>
                <div class="dicsription">
                    <div class="info">
                        <p><%= livre.getLauteur() %></p>
                        <p><%= livre.getLannéepublication() %></p>
                    </div>
                    <hr>
                    <p><%= livre.getDescription() %> </p>
                        <hr>
                        <div class="Ratings">
                            Ratings & Reviews
                            
                        </div>
                    </div>
                
            </div>

            <% } else { %>
            <p>Aucun Livre.</p>
        <% } %>
    <% } else { %>
        <p>Aucun ID.</p>
    <% } %>

        </div>
     <section class="section-5 Bestselling-books-section">
     <div class="Last">
<p>Derniers 10 livres</p><hr>
</div>
            <div class="container-HorizontalScroll" id="container-HorizontalScroll_id">
            
    <% List<livers> li = (List<livers>)request.getAttribute("Last"); %>
 <% for(livers livre : li) { %>
                 <div class="item">
                    <div class="book" onclick="redirectToNewPage('<%= livre.getId_livre() %>')"">
                        <div class="book-cover">
                            <img src="<%= livre.getImage() %>">
                        </div>
                        <p id="item-title-book"><%= livre.getTitre() %></p>
                        <div class="stars-rating">
                            <span class="star fa fa-star checked"></span>
                            <span class="star fa fa-star checked"></span>
                            <span class="star fa fa-star checked"></span>
                            <span class="star fa fa-star checked"></span>
                            <span class="star fa fa-star"></span>
                        </div>
                        <p class="writer"><%= livre.getLauteur() %></p>
                    </div>
                </div>
<% } %>
            </div>
               <div class="Last">
<hr>
</div>
     </section>
</body>
<script>
    function redirectToNewPage(id) {
        window.location.href = "Information?id=" + id;
    };
    </script>


</html>